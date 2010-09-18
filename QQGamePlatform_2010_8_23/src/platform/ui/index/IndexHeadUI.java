package platform.ui.index;

import java.awt.Cursor;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import platform.define.Define;
import platform.tools.ImageFactory;
import platform.tools.ImageTools;
import platform.ui.widget.WidgetFactory;
import platform.ui.widget.ui.URLLabelUI;

public class IndexHeadUI extends JPanel {

	private static final long serialVersionUID = 2229808502441513661L;

	// #begin【Label元素】
	private JLabel title_label;
	private JLabel icon_label;
	private JLabel head_pic_border_label;
	// #end【Label元素】

	// #begin【URLLabel元素】
	private URLLabelUI player_info_urllabel;
	// #end【URLLabel元素】

	// #begin【Button元素】
	private JButton close_button;
	private JButton min_button;
	private JButton max_button;
	private JButton restr_button;
	private JButton change_face_button;
	private JButton menu_button;
	// #end【Button元素】

	private IndexUI indexUI;

	public IndexHeadUI(IndexUI indexUI) {
		this.indexUI = indexUI;
		setLayout(null);

		setOpaque(false);// 透明
	}

	/**
	 * 显示窗体
	 */
	public void showUI() {
		// Label元素
		add(getIcon_label(), new Integer(Integer.MIN_VALUE));
		add(getTitle_label(), new Integer(Integer.MIN_VALUE));
		add(getHead_pic_border_label(), new Integer(Integer.MIN_VALUE));
		add(getPlayer_info_urllabel(), new Integer(Integer.MIN_VALUE));

		// 按钮元素
		add(getClose_button(), new Integer(Integer.MIN_VALUE));
		add(getMin_button(), new Integer(Integer.MIN_VALUE));
		add(getMax_button(), new Integer(Integer.MIN_VALUE));
		add(getRestr_button(), new Integer(Integer.MIN_VALUE));
		add(getMenu_button(), new Integer(Integer.MIN_VALUE));
		add(getChange_face_button(), new Integer(Integer.MIN_VALUE));

		setVisible(true);
	}

	// #begin【双缓冲技术】
	@Override
	public void paint(Graphics g) {
		System.out.println("paint IndexHeadUI");
		update(g);
	}

	@Override
	public void update(Graphics g) {
		Image screen = ImageTools.createImage(getWidth(), getHeight(), true);// 双缓冲
		Graphics graphics = screen.getGraphics();

		resetAllComponents();

		super.paint(graphics);

		g.drawImage(screen, 0, 0, null);// 最后个参数一定要用null，这样可以防止drawImage调用update方法
		g.dispose();
	}// #end【双缓冲技术】

	/**
	 * 作用:重新排列所有相对位置的元素 <BR>
	 * 
	 * 调用情况:当整个窗体发生大小变化时
	 */
	public void resetAllComponents() {
		resetClose_button();
		resetRestr_button();
		resetMax_button();
		resetMin_button();
		resetChange_face_button();
		resetMenu_button();
	}

	// #begin【Label元素】
	public JLabel getTitle_label() {
		if (title_label == null) {
			title_label = new JLabel(new ImageIcon(ImageFactory.getIndexTitleImage().getScaledInstance(75, 12, Image.SCALE_DEFAULT)));
			resetTitle_label();
		}
		return title_label;
	}

	public void resetTitle_label() {
		getTitle_label().setBounds(30, 10, 75, 12);
	}

	public JLabel getIcon_label() {
		if (icon_label == null) {
			icon_label = new JLabel(new ImageIcon(ImageFactory.getIndexIconImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT)));
			resetIcon_label();
		}
		return icon_label;
	}

	public void resetIcon_label() {
		getIcon_label().setBounds(7, 7, 16, 16);
	}

	public JLabel getHead_pic_border_label() {
		if (head_pic_border_label == null) {
			head_pic_border_label = new JLabel(new ImageIcon(ImageFactory.getIndexHeadPicBorderImage().getScaledInstance(52, 46, Image.SCALE_DEFAULT)));

			MouseAdapter adapter = new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					getHead_pic_border_label().setIcon(
							new ImageIcon(ImageFactory.getIndexHeadPicBorderHighLightImage().getScaledInstance(52, 46, Image.SCALE_DEFAULT)));
					setCursor(new Cursor(Cursor.HAND_CURSOR));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					getHead_pic_border_label().setIcon(new ImageIcon(ImageFactory.getIndexHeadPicBorderImage().getScaledInstance(52, 46, Image.SCALE_DEFAULT)));
					setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			};
			head_pic_border_label.addMouseListener(adapter);
			head_pic_border_label.addMouseMotionListener(adapter);

			resetHead_pic_border_label();
		}
		return head_pic_border_label;
	}

	public void resetHead_pic_border_label() {
		getHead_pic_border_label().setBounds(10, 35, 52, 45);
	}// #end【label元素】

	// #begin【URLlabel元素】
	public URLLabelUI getPlayer_info_urllabel() {
		if (player_info_urllabel == null) {
			player_info_urllabel = new URLLabelUI("荒城:左手程序。。右手诗");

			resetPlayer_info_urllabel();
		}
		return player_info_urllabel;
	}

	public void resetPlayer_info_urllabel() {
		FontMetrics fontMetrics = getPlayer_info_urllabel().getFontMetrics(Define.DEFAULT_FONT);
		int _width = fontMetrics.stringWidth(getPlayer_info_urllabel().getShow_text());

		getPlayer_info_urllabel().setBounds(getHead_pic_border_label().getX() + getHead_pic_border_label().getWidth() + 10,
				getHead_pic_border_label().getY() + 5, _width + 5, 20);
	}// #end【URLlabel元素】

	// #begin【button元素】
	public JButton getClose_button() {
		if (close_button == null) {
			close_button = WidgetFactory.createIndexCloseButton(37, 22, "", IndexParams.ACTION_CLOSE, indexUI.getActionAdapter());
			resetClose_button();
		}
		return close_button;
	}

	public void resetClose_button() {
		getClose_button().setBounds(getWidth() - 37 - 5, 0, 37, 22);
	}

	public JButton getMin_button() {
		if (min_button == null) {
			min_button = WidgetFactory.createIndexMinButton(35, 22, "", IndexParams.ACTION_MIN, indexUI.getActionAdapter());
			resetMin_button();
		}
		return min_button;
	}

	public void resetMin_button() {
		getMin_button().setBounds(getWidth() - 35 * 3 - 5, 0, 35, 22);
	}

	public JButton getRestr_button() {
		if (restr_button == null) {
			restr_button = WidgetFactory.createIndexRestrButton(35, 22, "", IndexParams.ACTION_RESTR, indexUI.getActionAdapter());
			resetRestr_button();
		}
		return restr_button;
	}

	public void resetRestr_button() {
		getRestr_button().setBounds(getWidth() - 35 * 2 - 5, 0, 35, 22);
	}

	public JButton getMax_button() {
		if (max_button == null) {
			max_button = WidgetFactory.createIndexMaxButton(35, 22, "", IndexParams.ACTION_MAX, indexUI.getActionAdapter());
			resetMax_button();
			getMax_button().setVisible(false);
		}
		return max_button;
	}

	public void resetMax_button() {
		getMax_button().setBounds(getWidth() - 35 * 2 - 5, 0, 35, 22);
	}

	public JButton getChange_face_button() {
		if (change_face_button == null) {
			change_face_button = WidgetFactory.createIndexChangeFaceButton(40, 14, "", IndexParams.ACTION_CHANGE_FACE, indexUI.getActionAdapter());

			resetChange_face_button();
		}
		return change_face_button;
	}

	public void resetChange_face_button() {
		getChange_face_button().setBounds(getMenu_button().getX() - getChange_face_button().getWidth() - 10, 5, 40, 14);
	}

	public JButton getMenu_button() {
		if (menu_button == null) {
			menu_button = WidgetFactory.createIndexMenuButton(40, 14, "", IndexParams.ACTION_MENU, indexUI.getActionAdapter());

			resetMenu_button();
		}
		return menu_button;
	}

	public void resetMenu_button() {
		getMenu_button().setBounds(getMin_button().getX() - getMenu_button().getWidth() - 10, 5, 40, 14);
	}// #end【button元素】

}
