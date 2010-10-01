package platform.ui.widget.ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JToggleButton.ToggleButtonModel;
import javax.swing.border.LineBorder;

import platform.adapter.TabScrollActionAdapter;
import platform.define.Define;
import platform.tools.ImageFactory;
import platform.ui.index.IndexParams;
import platform.ui.widget.WidgetFactory;

public class QTabbedPane extends JComponent {

	private static final long serialVersionUID = 8354993849857384370L;

	public static int DEFAULT_WIDTH = 60;
	public static int DEFAULT_HEIGHT = 24;
	public static int ICON_WIDTH = 25;

	private ArrayList<JButton> tabs = new ArrayList<JButton>();
	private ArrayList<JPanel> panes = new ArrayList<JPanel>();

	private JPanel conterPanel = new JPanel();

	private int beginIndex = 0;// 开始tab（包含）
	private int endIndex = 0;// 结束tab（不包含）
	private int selectIndex = 0;

	private boolean isMoveToSelected = false;

	private JButton scrollLeft;
	private JButton scrollLeft_disable;
	private JButton scrollRight;
	private JButton scrollRight_disable;

	private TabScrollActionAdapter scrollActionAdapter = new TabScrollActionAdapter(this);

	public QTabbedPane() {
		super();

		setLayout(null);

		conterPanel.setLayout(new CardLayout());

		add(conterPanel);
	}

	public void addTab(String title, Image titleImage, JPanel pane, int index) {
		JButton tab = createTabButton(title, titleImage);
		pane.setBorder(new LineBorder(new Color(0x3eb2e2)));

		selectIndex = index;
		isMoveToSelected = true;

		tabs.add(index, tab);
		panes.add(index, pane);

		conterPanel.add(pane, tab.hashCode() + "");

		repaint();

	}

	public void addTab(String title, Image titleImage, JPanel pane) {
		addTab(title, titleImage, pane, tabs.size());
	}

	@Override
	public void paint(Graphics g) {

		if (tabs.size() == 0 || panes.size() == 0) {
			super.paint(g);
			return;
		}

		for (int i = 0; i < tabs.size(); i++) {
			remove(tabs.get(i));
		}
		((CardLayout) conterPanel.getLayout()).show(conterPanel, tabs.get(selectIndex).hashCode() + "");

		validate();
		// remove(panes.get(oldSelectIndex));

		// 移动到当前选择tab
		int _width = 0;// 所有tab总宽度
		if (isMoveToSelected) {
			for (int i = selectIndex; i >= 0; i--) {
				// _width = _width + tabs.get(i).getWidth();
				_width = _width + tabs.get(i).getWidth();
				if (_width > getWidth() - 50 && beginIndex == 0) {
					beginIndex = i + 1;
				}
			}

			isMoveToSelected = false;
		}

		_width = 0;
		endIndex = tabs.size();
		for (int i = beginIndex; i < tabs.size(); i++) {
			_width = _width + tabs.get(i).getWidth();
			if (_width > getWidth() - 45 && endIndex == tabs.size()) {
				endIndex = i;
			}
		}

		for (int i = 0; i < tabs.size(); i++) {
			_width = _width + tabs.get(i).getWidth();
		}

		if (_width > getWidth()) {
			if (beginIndex > 0) {
				add(getScrollLeft());
				getScrollLeft().setVisible(true);
				getScrollLeft_disable().setVisible(false);
			} else {
				add(getScrollLeft_disable());
				getScrollLeft_disable().setVisible(true);
				getScrollLeft().setVisible(false);
			}
			if (endIndex == tabs.size()) {
				add(getScrollRight_disable());
				getScrollRight_disable().setVisible(true);
				getScrollRight().setVisible(false);
			} else {
				add(getScrollRight());
				getScrollRight().setVisible(true);
				getScrollRight_disable().setVisible(false);
			}
		}

		int _x = 0;
		for (int i = beginIndex; i < selectIndex; i++) {
			_x = _x + tabs.get(i).getWidth();
		}

		if (selectIndex >= beginIndex && selectIndex < endIndex) {
			add(tabs.get(selectIndex));
			tabs.get(selectIndex).setLocation(_x, 0);
		}

		conterPanel.setBounds(0, tabs.get(selectIndex).getHeight() - 1, getWidth(), getHeight()
				- tabs.get(selectIndex).getHeight());

		_x = 0;

		for (int i = beginIndex; i < tabs.size(); i++) {
			if (i == endIndex) {
				break;
			}

			if (i == selectIndex) {
				_x = _x + tabs.get(i).getWidth();
				continue;
			}

			add(tabs.get(i));
			tabs.get(i).setLocation(_x, 0);

			_x = _x + tabs.get(i).getWidth();
		}

		super.paint(g);
	}

	private JButton createTabButton(final String title, final Image titleImage) {

		class QTabButtonMouseAdapter extends MouseAdapter {

			@Override
			public void mouseEntered(MouseEvent e) {
				Object obj = e.getSource();
				if (obj != null && obj instanceof JButton) {
					if (!((JButton) obj).isSelected()) {
						((JButton) obj).setIcon(new ImageIcon(ImageFactory.getIndexTabBackgroundRollover(
								((JButton) obj).getWidth(), DEFAULT_HEIGHT)));
					}
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Object obj = e.getSource();
				if (obj != null && obj instanceof JButton) {
					if (!((JButton) obj).isSelected()) {
						((JButton) obj).setIcon(new ImageIcon(ImageFactory.getIndexTabBackground(((JButton) obj)
								.getWidth(), DEFAULT_HEIGHT)));
					}
				}
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Object obj = e.getSource();
				if (obj != null && obj instanceof JButton) {
					selectIndex = tabs.indexOf(obj);
					((JButton) obj).setSelected(true);
					((JButton) obj).setIcon(new ImageIcon(ImageFactory.getIndexTabBackgroundPressed(((JButton) obj)
							.getWidth(), DEFAULT_HEIGHT)));
					for (int i = 0; i < tabs.size(); i++) {
						if (!tabs.get(i).equals(obj)) {
							tabs.get(i).setSelected(false);
							tabs.get(i).setIcon(
									new ImageIcon(ImageFactory.getIndexTabBackground(tabs.get(i).getWidth(),
											DEFAULT_HEIGHT)));
						}
					}
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
					g.drawImage(titleImage, 5, 5, titleImage.getWidth(null), titleImage.getHeight(null), null);
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
		tab.setFocusable(false);

		int _width = title.length() * 13 + ICON_WIDTH;
		tab.setIcon(new ImageIcon(ImageFactory.getIndexTabBackground(_width, DEFAULT_HEIGHT)));
		tab.setSize(_width, DEFAULT_HEIGHT);

		tab.addMouseListener(tabButtonMouseAdapter);
		tab.addMouseMotionListener(tabButtonMouseAdapter);
		return tab;
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
			scrollRight_disable = WidgetFactory.createIndexTabScrollRightDisableButton(15, 15, null, null,
					scrollActionAdapter);

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
			scrollLeft = WidgetFactory.createIndexTabScrollLeftButton(15, 15, null, IndexParams.ACTION_TAB_SCROLL_LEFT,
					scrollActionAdapter);

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
			scrollLeft_disable = WidgetFactory.createIndexTabScrollLeftDisableButton(15, 15, null, null,
					scrollActionAdapter);

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
