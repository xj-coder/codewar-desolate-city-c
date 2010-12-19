package platform.ui.widget;

import java.awt.BasicStroke;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JToggleButton.ToggleButtonModel;

import platform.adapter.TabScrollActionAdapter;
import platform.define.Define;
import platform.tools.ImageFactory;
import platform.ui.index.IndexParams;
import platform.ui.widget.factory.WidgetFactory;

public class QTabbedPane extends JComponent {

	private static final long serialVersionUID = 8354993849857384370L;

	private Color border_color = new Color(0x3eb2e2);

	public static int DEFAULT_WIDTH = 60;
	public static int DEFAULT_HEIGHT = 24;
	public static int ICON_WIDTH = 25;

	private ArrayList<JButton> tabs = new ArrayList<JButton>();
	private ArrayList<JPanel> panes = new ArrayList<JPanel>();

	private JPanel conterPanel;// 中心内容面板

	private int beginIndex = 0;// 开始tab（包含）
	private int endIndex = 0;// 结束tab（不包含）
	private int selectIndex = -1;// 当前选择tab

	private boolean isMoveToSelected = false;

	private JButton scrollLeft;
	private JButton scrollLeft_disable;
	private JButton scrollRight;
	private JButton scrollRight_disable;

	private TabScrollActionAdapter scrollActionAdapter = new TabScrollActionAdapter(this);

	public QTabbedPane() {
		super();
		isMoveToSelected = true;// 移动到当前选择的tab

		setLayout(null);

		add(getConterPanel());
		add(getScrollLeft());
		add(getScrollLeft_disable());
		add(getScrollRight_disable());
		add(getScrollRight());
	}

	public void addTab(String title, Image titleImage, JPanel pane, int index) {
		JButton tab = createTabButton(title, titleImage);

		// 还原上次选择的tab.
		if (selectIndex != -1) {
			tabs.get(selectIndex).setSelected(false);
			tabs.get(selectIndex).setIcon(
					new ImageIcon(ImageFactory.getIndexTabBackground(tabs.get(selectIndex)
							.getWidth(), DEFAULT_HEIGHT)));
		}
		// 设置自己为选择tab,更改Icon
		tab.setSelected(true);
		tab.setIcon(new ImageIcon(ImageFactory.getIndexTabBackgroundPressed(tab.getWidth(),
				DEFAULT_HEIGHT)));

		isMoveToSelected = true;// 移动到当前选择的tab
		beginIndex = 0;// 初始化beginIndex
		selectIndex = index;

		tabs.add(index, tab);
		panes.add(index, pane);

		getConterPanel().add(pane, tab.hashCode() + "");

		repaint();
	}

	public void addTab(String title, Image titleImage, JPanel pane) {
		addTab(title, titleImage, pane, tabs.size());
	}

	public void closeTab(int index) {
		JButton tab = tabs.remove(index);
		panes.remove(index);

		remove(tab);

		if (selectIndex == index) {
			selectIndex = index - 1;
		}
		if (beginIndex == index) {
			beginIndex = index - 1;
		}
		repaint();
	}

	public void closeTab(JPanel pane) {
		int index = panes.indexOf(pane);

		JButton tab = tabs.remove(index);
		panes.remove(index);

		remove(tab);

		if (selectIndex == index) {
			selectIndex = index - 1;

			tabs.get(selectIndex).setSelected(true);
			tabs.get(selectIndex).setIcon(
					new ImageIcon(ImageFactory.getIndexTabBackgroundPressed(tabs.get(selectIndex)
							.getWidth(), DEFAULT_HEIGHT)));
		}
		if (beginIndex == index) {
			beginIndex = index - 1;
		}
		repaint();
	}

	@Override
	public void paint(Graphics g) {

		if (tabs.size() == 0 || panes.size() == 0) {
			super.paint(g);
			return;
		}

		// 移除所有tab
		for (int i = 0; i < tabs.size(); i++) {
			remove(tabs.get(i));
		}
		validate();

		// 将当前选择的pane显示在最前面
		((CardLayout) getConterPanel().getLayout()).show(getConterPanel(), tabs.get(selectIndex)
				.hashCode()
				+ "");

		// 移动到当前选择tab,根据selectIndex计算出beginIndex
		int _width = 0;// 所有tab总宽度
		if (isMoveToSelected) {
			for (int i = selectIndex; i >= 0; i--) {
				_width = _width + tabs.get(i).getWidth();
				if (_width > getWidth() - 50 && beginIndex == 0) {
					beginIndex = i + 1;
				}
			}
			isMoveToSelected = false;
		}

		// 根据beginIndex计算出endIndex
		_width = 0;
		endIndex = tabs.size();
		for (int i = beginIndex; i < tabs.size(); i++) {
			_width = _width + tabs.get(i).getWidth();
			if (_width > getWidth() - 50 && endIndex == tabs.size()) {
				endIndex = i;
				break;
			}
		}

		// 计算所有tab的宽度和
		for (int i = 0; i < tabs.size(); i++) {
			_width = _width + tabs.get(i).getWidth();
		}

		// 如果tab的宽度和大于总宽度,显示左右滚动按钮
		if (_width > getWidth()) {
			if (beginIndex > 0) {
				getScrollLeft().setVisible(true);
				getScrollLeft_disable().setVisible(false);
				resetScrollLeft();
				resetScrollLeft_dispble();
			} else {
				getScrollLeft_disable().setVisible(true);
				getScrollLeft().setVisible(false);
				resetScrollLeft();
				resetScrollLeft_dispble();
			}
			if (endIndex == tabs.size()) {
				getScrollRight_disable().setVisible(true);
				getScrollRight().setVisible(false);
				resetScrollRight();
				resetScrollRight_disable();
			} else {
				getScrollRight().setVisible(true);
				getScrollRight_disable().setVisible(false);
				resetScrollRight();
				resetScrollRight_disable();
			}
		}

		// 计算出当前选择tab的位置
		int x = 0;
		for (int i = beginIndex; i < selectIndex; i++) {
			x = x + tabs.get(i).getWidth();
		}
		// 先显示当前选择的tab
		if (selectIndex >= beginIndex && selectIndex < endIndex) {
			add(tabs.get(selectIndex));
			tabs.get(selectIndex).setLocation(x, 0);
		}
		// 设置conterPanel的位置
		getConterPanel().setBounds(0, tabs.get(selectIndex).getHeight() - 0, getWidth(),
				getHeight() - tabs.get(selectIndex).getHeight());

		// 计算出每个tab(beginIndex到endIndex之间,并排除当前选择的)的位置,并显示它.
		x = 0;
		for (int i = beginIndex; i < tabs.size(); i++) {
			if (i == endIndex) {
				break;
			}

			if (i == selectIndex) {
				x = x + tabs.get(i).getWidth();
				continue;
			}

			add(tabs.get(i));
			tabs.get(i).setLocation(x, 0);

			x = x + tabs.get(i).getWidth();
		}

		super.paint(g);
		// 画conterPanel边框
		int _x = getConterPanel().getX();
		int _y = getConterPanel().getY();
		int _w = getConterPanel().getWidth();
		int _h = getConterPanel().getHeight();

		Graphics2D g2 = (Graphics2D) g;
		Color tmp = g2.getColor();
		g2.setColor(border_color);
		g2.setStroke(new BasicStroke(1.2f));
		g2.drawLine(_x, _y, _x, _y + _h);// left
		g2.drawLine(_x + _w - 1, _y, _x + _w - 1, _y + _h);// right

		if (selectIndex >= beginIndex && selectIndex < endIndex) {
			g2.drawLine(_x, _y, _x + tabs.get(selectIndex).getX(), _y);// up1
			g2.drawLine(_x + tabs.get(selectIndex).getX() + tabs.get(selectIndex).getWidth() - 1,
					_y, _x + _w - 1, _y);// up2
		} else {
			g2.drawLine(_x, _y, _x + _w, _y);// up
		}

		g2.drawLine(_x, _y + _h - 1, _x + _w - 1, _y + _h - 1);// down
		g2.setColor(tmp);
	}

	private JButton createTabButton(final String title, final Image titleImage) {

		class QTabButtonMouseAdapter extends MouseAdapter {

			@Override
			public void mouseEntered(MouseEvent e) {
				Object obj = e.getSource();
				if (obj != null && obj instanceof JButton) {
					if (!((JButton) obj).isSelected()) {
						((JButton) obj).setIcon(new ImageIcon(ImageFactory
								.getIndexTabBackgroundRollover(((JButton) obj).getWidth(),
										DEFAULT_HEIGHT)));
					}
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Object obj = e.getSource();
				if (obj != null && obj instanceof JButton) {
					if (!((JButton) obj).isSelected()) {
						((JButton) obj).setIcon(new ImageIcon(ImageFactory.getIndexTabBackground(
								((JButton) obj).getWidth(), DEFAULT_HEIGHT)));
					}
				}
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Object obj = e.getSource();
				if (obj != null && obj instanceof JButton) {
					// 还原上次选择的tab.
					if (selectIndex != -1) {
						tabs.get(selectIndex).setSelected(false);
						tabs.get(selectIndex).setIcon(
								new ImageIcon(ImageFactory.getIndexTabBackground(tabs.get(
										selectIndex).getWidth(), DEFAULT_HEIGHT)));
					}

					// 设置自己为选择tab,更改Icon
					selectIndex = tabs.indexOf(obj);
					((JButton) obj).setSelected(true);
					((JButton) obj).setIcon(new ImageIcon(ImageFactory
							.getIndexTabBackgroundPressed(((JButton) obj).getWidth(),
									DEFAULT_HEIGHT)));
				}
			}
		}

		QTabButtonMouseAdapter tabButtonMouseAdapter = new QTabButtonMouseAdapter();

		JButton tab = new JButton() {

			private static final long serialVersionUID = 6333672071745515181L;

			@Override
			public void paint(Graphics g) {
				System.out.println("paint tab");
				super.paint(g);

				// int _width = 0;
				//
				g.setFont(Define.DEFAULT_FONT);
				FontMetrics fontMetrics = getGraphics().getFontMetrics();
				// int strWidth = fontMetrics.stringWidth(title);
				//
				// _width = strWidth + ICON_WIDTH;
				//
				// setSize(_width, DEFAULT_HEIGHT);

				// 将title画到按钮上
				if (title != null && !title.trim().equals("")) {
					int _y = getHeight() / 2 + fontMetrics.getHeight() / 2 - 3;
					g.drawString(title, ICON_WIDTH, _y);
				}

				if (titleImage != null) {
					g.drawImage(titleImage, 5, 5, titleImage.getWidth(null), titleImage
							.getHeight(null), null);
				}

				if (getIcon() == null) {
				}
			}
		};

		tab.setName(title);
		tab.setModel(new ToggleButtonModel());

		tab.setRolloverEnabled(true);

		tab.setBorderPainted(false);
		tab.setFocusPainted(false);
		tab.setContentAreaFilled(false);
		tab.setDoubleBuffered(true);

		tab.setOpaque(false);
		tab.setFocusable(true);

		int _width = title.length() * 13 + ICON_WIDTH;
		tab.setIcon(new ImageIcon(ImageFactory.getIndexTabBackground(_width, DEFAULT_HEIGHT)));
		tab.setSize(_width, DEFAULT_HEIGHT);

		tab.addMouseListener(tabButtonMouseAdapter);
		tab.addMouseMotionListener(tabButtonMouseAdapter);
		return tab;
	}

	public JPanel getConterPanel() {
		if (conterPanel == null) {
			conterPanel = new JPanel();

			conterPanel.setBorder(null);
			conterPanel.setAlignmentX(0);
			conterPanel.setAlignmentY(0);
			conterPanel.setLayout(new CardLayout());

		}
		return conterPanel;
	}

	public JButton getScrollRight() {
		if (scrollRight == null) {
			scrollRight = WidgetFactory.createIndexTabScrollRightButton(15, 15, null,
					IndexParams.ACTION_TAB_SCROLL_RIGHT, scrollActionAdapter);

			scrollRight.setVisible(false);

			resetScrollRight();
		}
		return scrollRight;
	}

	public void resetScrollRight() {
		getScrollRight().setBounds(getWidth() - 20, 5, 15, 15);
	}

	public JButton getScrollRight_disable() {
		if (scrollRight_disable == null) {
			scrollRight_disable = WidgetFactory.createIndexTabScrollRightDisableButton(15, 15,
					null, null, scrollActionAdapter);

			scrollRight_disable.setVisible(false);

			resetScrollRight_disable();
		}
		return scrollRight_disable;
	}

	public void resetScrollRight_disable() {
		getScrollRight_disable().setBounds(getWidth() - 20, 5, 15, 15);
	}

	public JButton getScrollLeft() {
		if (scrollLeft == null) {
			scrollLeft = WidgetFactory.createIndexTabScrollLeftButton(15, 15, null,
					IndexParams.ACTION_TAB_SCROLL_LEFT, scrollActionAdapter);

			scrollLeft.setVisible(false);

			resetScrollLeft();
		}
		return scrollLeft;
	}

	public void resetScrollLeft() {
		getScrollLeft().setBounds(getScrollRight().getX() - 20, 5, 15, 15);
	}

	public JButton getScrollLeft_disable() {
		if (scrollLeft_disable == null) {
			scrollLeft_disable = WidgetFactory.createIndexTabScrollLeftDisableButton(15, 15, null,
					null, scrollActionAdapter);

			scrollLeft_disable.setVisible(false);

			resetScrollLeft_dispble();
		}
		return scrollLeft_disable;
	}

	public void resetScrollLeft_dispble() {
		getScrollLeft_disable().setBounds(getScrollRight().getX() - 20, 5, 15, 15);
	}

	// #begin [setter and getter]
	public int getSelectIndex() {
		return selectIndex;
	}

	public void setSelectIndex(int selectIndex) {
		this.selectIndex = selectIndex;
	}

	public int getBeginIndex() {
		return beginIndex;
	}

	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}
	// #end [setter and getter]

}
