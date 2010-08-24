package platform.ui;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import platform.adapter.IndexActionAdapter;
import platform.adapter.UIDoubleClockTitleAdapter;
import platform.adapter.UIMouseDragAdapter;
import platform.bean.PlayerBean;
import platform.define.Define;
import platform.define.IndexUIDefine;
import platform.tools.ImageFactory;
import platform.tools.Tools;
import platform.ui.widget.URLLabel;
import platform.ui.widget.WidgetFactory;

import com.sun.awt.AWTUtilities;

public class IndexUI extends JFrame {

	private static final long serialVersionUID = 5192639441087069602L;

	private PlayerBean player;

	// 【头部---------------------------------------------------------------
	private JLabel bg_up_left_label;
	private JLabel bg_up_center_label;
	private JLabel bg_up_right_label;
	private JLabel bg_center_label;
	private JLabel bg_right_label;
	private JLabel bg_left_label;
	private JLabel bg_down_center_label;
	private JLabel bg_down_left_label;
	private JLabel bg_down_right_label;

	private JLabel title_label;
	private JLabel icon_label;
	private JLabel head_pic_border_label;

	private URLLabel player_info_urllabel;

	private JButton close_button;
	private JButton min_button;
	private JButton max_button;
	private JButton restr_button;
	private JButton change_face_button;
	private JButton menu_button;
	// --------------------------------------------------------------头部】

	// 【左侧目录树---------------------------------------------------------------
	private JLabel dir_bg_up_left_label;
	private JLabel dir_bg_up_center_label;
	private JLabel dir_bg_up_right_label;
	private JLabel dir_bg_left_label;
	private JLabel dir_bg_center_label;
	private JLabel dir_bg_right_label;
	private JLabel dir_bg_down_left_label;
	private JLabel dir_bg_down_center_label;
	private JLabel dir_bg_down_right_label;

	private JLabel dir_search_bg_left_label;
	private JLabel dir_search_bg_center_label;
	private JLabel dir_search_bg_right_label;

	private JLabel dir_list_bg_up_left_label;
	private JLabel dir_list_bg_up_center_label;
	private JLabel dir_list_bg_up_right_label;
	private JLabel dir_list_bg_left_label;
	private JLabel dir_list_bg_right_label;
	private JLabel dir_list_bg_down_left_label;
	private JLabel dir_list_bg_down_center_label;
	private JLabel dir_list_bg_down_right_label;

	private JButton search_list_button;
	private JButton search_enter_button;
	private JButton dir_lock_button;
	private JButton dir_unlock_button;

	// --------------------------------------------------------------左侧目录树】

	private Dimension historySize = IndexUIDefine.MINIMUM_SIZE;

	private IndexActionAdapter actionAdapter = new IndexActionAdapter(this);
	private UIMouseDragAdapter dragAdapter = new UIMouseDragAdapter(this);
	private UIDoubleClockTitleAdapter doubleClockTitleAdapter = new UIDoubleClockTitleAdapter(this);

	private boolean isMax = true;

	public IndexUI(PlayerBean player) {
		this.player = player;
		initComponents();
	}

	private void initComponents() {
		// 设置整个窗体大小
		Dimension screenSize = Tools.getScreenSize();
		Insets screenInsets = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
		setSize(screenSize.width - screenInsets.left - screenInsets.right, screenSize.height - screenInsets.top - screenInsets.bottom);
		setMinimumSize(IndexUIDefine.MINIMUM_SIZE);

		getLayeredPane().add(getIcon_label(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getTitle_label(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getChange_face_button(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getPlayer_info_urllabel(), new Integer(Integer.MIN_VALUE));

		getLayeredPane().add(getClose_button(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getMin_button(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getMax_button(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getRestr_button(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getMenu_button(), new Integer(Integer.MIN_VALUE));

		getLayeredPane().add(getHead_pic_border_label(), new Integer(Integer.MIN_VALUE));

		// 左侧目录树
		getLayeredPane().add(getDir_bg_up_left_label(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getDir_bg_up_center_label(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getDir_bg_up_right_label(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getDir_bg_left_label(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getDir_bg_center_label(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getDir_bg_right_label(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getDir_bg_down_left_label(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getDir_bg_down_center_label(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getDir_bg_down_right_label(), new Integer(Integer.MIN_VALUE));

		// 最大背景
		getLayeredPane().add(getBg_center_label(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getBg_left_label(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getBg_right_label(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getBg_down_center_label(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getBg_down_left_label(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getBg_down_right_label(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getBg_up_center_label(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getBg_up_left_label(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getBg_up_right_label(), new Integer(Integer.MIN_VALUE));

		((JPanel) getContentPane()).setOpaque(false);

		// 设置无边框
		setUndecorated(true);
		addMouseListener(doubleClockTitleAdapter);
	}

	public void showMe() {
		setVisible(true);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AWTUtilities.setWindowShape(IndexUI.this, new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 12, 12));
				// AWTUtilities.setWindowOpacity(IndexUI.this, 0.93f);
			}
		});
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		resetAllComponents();

	}

	public void resetAllComponents() {
		resetBg_up_center_label();
		resetBg_up_right_label();
		resetBg_down_left_label();
		resetBg_down_center_label();
		resetBg_down_right_label();
		resetBg_left_label();
		resetBg_center_label();
		resetBg_right_label();

		resetDir_bg_left_label();
		resetDir_bg_center_label();
		resetDir_bg_right_label();
		resetDir_bg_down_left_label();
		resetDir_bg_down_center_label();
		resetDir_bg_down_right_label();
		resetDir_bg_up_left_label();
		resetDir_bg_up_center_label();
		resetDir_bg_up_right_label();

		resetClose_button();
		resetMin_button();
		resetRestr_button();
		resetMax_button();
		resetMenu_button();
		resetChange_face_button();

		resetHead_pic_border_label();
		resetPlayer_info_urllabel();
	}

	// label

	// ------头部
	public JLabel getBg_up_left_label() {
		if (bg_up_left_label == null) {
			bg_up_left_label = new JLabel(new ImageIcon(ImageFactory.getIndexBgUpLeftImage().getScaledInstance(314, 94, Image.SCALE_DEFAULT)));
			resetBg_up_left_label();
		}
		return bg_up_left_label;
	}

	public void resetBg_up_left_label() {
		getBg_up_left_label().setBounds(0, 0, 314, 94);
	}

	public JLabel getBg_up_center_label() {
		if (bg_up_center_label == null) {
			bg_up_center_label = new JLabel(new ImageIcon(ImageFactory.getIndexBgUpCenterImage().getScaledInstance(
					getWidth() - getBg_up_right_label().getWidth() - getBg_up_left_label().getWidth(), 94, Image.SCALE_DEFAULT)));
			resetBg_up_center_label();
		}
		return bg_up_center_label;
	}

	public void resetBg_up_center_label() {
		getBg_up_center_label().setBounds(314, 0, getWidth() - getBg_up_right_label().getWidth() - getBg_up_left_label().getWidth(), 94);
	}

	public JLabel getBg_up_right_label() {
		if (bg_up_right_label == null) {
			bg_up_right_label = new JLabel(new ImageIcon(ImageFactory.getIndexBgUpRightImage().getScaledInstance(8, 94, Image.SCALE_DEFAULT)));
			resetBg_up_right_label();
		}
		return bg_up_right_label;
	}

	public void resetBg_up_right_label() {
		getBg_up_right_label().setBounds(getWidth() - 8, 0, 8, 94);
	}

	public JLabel getBg_down_left_label() {
		if (bg_down_left_label == null) {
			bg_down_left_label = new JLabel(new ImageIcon(ImageFactory.getIndexBgDownLeftImage().getScaledInstance(10, 10, Image.SCALE_DEFAULT)));
			resetBg_down_left_label();
		}
		return bg_down_left_label;
	}

	public void resetBg_down_left_label() {
		getBg_down_left_label().setBounds(0, getHeight() - 10, 10, 10);
	}

	public JLabel getBg_down_center_label() {
		if (bg_down_center_label == null) {
			bg_down_center_label = new JLabel(new ImageIcon(ImageFactory.getIndexBgDownCenterImage()
					.getScaledInstance(getWidth() - 20, 10, Image.SCALE_DEFAULT)));
			resetBg_down_center_label();
		}
		return bg_down_center_label;
	}

	public void resetBg_down_center_label() {
		getBg_down_center_label().setBounds(10, getHeight() - 10, getWidth() - 20, 10);
	}

	public JLabel getBg_down_right_label() {
		if (bg_down_right_label == null) {
			bg_down_right_label = new JLabel(new ImageIcon(ImageFactory.getIndexBgDownRightImage().getScaledInstance(10, 10, Image.SCALE_DEFAULT)));
			resetBg_down_right_label();
		}
		return bg_down_right_label;
	}

	public void resetBg_down_right_label() {
		getBg_down_right_label().setBounds(getWidth() - 10, getHeight() - 10, 10, 10);
	}

	public JLabel getBg_left_label() {
		if (bg_left_label == null) {
			bg_left_label = new JLabel(new ImageIcon(ImageFactory.getIndexBgLeftImage().getScaledInstance(5, getHeight() - 104, Image.SCALE_DEFAULT)));
			resetBg_left_label();
		}
		return bg_left_label;
	}

	public void resetBg_left_label() {
		getBg_left_label().setBounds(0, 94, 5, getHeight() - 104);
	}

	public JLabel getBg_center_label() {
		if (bg_center_label == null) {
			bg_center_label = new JLabel(new ImageIcon(ImageFactory.getIndexBgCenterImage().getScaledInstance(getWidth() - 10, getHeight() - 104,
					Image.SCALE_DEFAULT)));
			resetBg_center_label();
		}
		return bg_center_label;
	}

	public void resetBg_center_label() {
		getBg_center_label().setBounds(5, 94, getWidth() - 10, getHeight() - 104);
	}

	public JLabel getBg_right_label() {
		if (bg_right_label == null) {
			bg_right_label = new JLabel(new ImageIcon(ImageFactory.getIndexBgRightImage().getScaledInstance(5, getHeight() - 104, Image.SCALE_DEFAULT)));
			resetBg_right_label();
		}
		return bg_right_label;
	}

	public void resetBg_right_label() {
		getBg_right_label().setBounds(getWidth() - 5, 94, 5, getHeight() - 104);
	}

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
	}

	// ------左侧目录树
	public JLabel getDir_bg_up_left_label() {
		if (dir_bg_up_left_label == null) {
			dir_bg_up_left_label = new JLabel(new ImageIcon(ImageFactory.getIndexDirBgUpLeftImage().getScaledInstance(15, 58, Image.SCALE_DEFAULT)));
			resetDir_bg_up_left_label();
		}
		return dir_bg_up_left_label;
	}

	public void resetDir_bg_up_left_label() {
		getDir_bg_up_left_label().setBounds(5, 100, 15, 58);
	}

	public JLabel getDir_bg_up_center_label() {
		if (dir_bg_up_center_label == null) {
			dir_bg_up_center_label = new JLabel(new ImageIcon(ImageFactory.getIndexDirBgUpCenterImage().getScaledInstance(284, 58, Image.SCALE_DEFAULT)));
			resetDir_bg_up_center_label();
		}
		return dir_bg_up_center_label;
	}

	public void resetDir_bg_up_center_label() {
		getDir_bg_up_center_label().setBounds(15, 100, 284, 58);
	}

	public JLabel getDir_bg_up_right_label() {
		if (dir_bg_up_right_label == null) {
			dir_bg_up_right_label = new JLabel(new ImageIcon(ImageFactory.getIndexDirBgUpRightImage().getScaledInstance(15, 58, Image.SCALE_DEFAULT)));
			resetDir_bg_up_right_label();
		}
		return dir_bg_up_right_label;
	}

	public void resetDir_bg_up_right_label() {
		getDir_bg_up_right_label().setBounds(299, 100, 15, 58);
	}

	public JLabel getDir_bg_left_label() {
		if (dir_bg_left_label == null) {
			dir_bg_left_label = new JLabel(new ImageIcon(ImageFactory.getIndexDirBgLeftImage().getScaledInstance(13, getHeight() - 100 - 15 - 12,
					Image.SCALE_DEFAULT)));
			resetDir_bg_left_label();
		}
		return dir_bg_left_label;
	}

	public void resetDir_bg_left_label() {
		getDir_bg_left_label().setBounds(5, 115, 13, getHeight() - 100 - 15 - 12);
	}

	public JLabel getDir_bg_center_label() {
		if (dir_bg_center_label == null) {
			dir_bg_center_label = new JLabel(new ImageIcon(ImageFactory.getIndexDirBgCenterImage().getScaledInstance(314 - 24, getHeight() - 100 - 58 - 12,
					Image.SCALE_DEFAULT)));
			resetDir_bg_center_label();
		}
		return dir_bg_center_label;
	}

	public void resetDir_bg_center_label() {
		getDir_bg_center_label().setBounds(18, 158, 314 - 24, getHeight() - 100 - 58 - 12);
	}

	public JLabel getDir_bg_right_label() {
		if (dir_bg_right_label == null) {
			dir_bg_right_label = new JLabel(new ImageIcon(ImageFactory.getIndexDirBgRightImage().getScaledInstance(13, getHeight() - 100 - 15 - 12,
					Image.SCALE_DEFAULT)));
			resetDir_bg_right_label();
		}
		return dir_bg_right_label;
	}

	public void resetDir_bg_right_label() {
		getDir_bg_right_label().setBounds(301, 115, 13, getHeight() - 100 - 15 - 12);
	}

	public JLabel getDir_bg_down_left_label() {
		if (dir_bg_down_left_label == null) {
			dir_bg_down_left_label = new JLabel(new ImageIcon(ImageFactory.getIndexDirBgDownLeftImage().getScaledInstance(12, 12, Image.SCALE_DEFAULT)));
			resetDir_bg_down_left_label();
		}
		return dir_bg_down_left_label;
	}

	public void resetDir_bg_down_left_label() {
		getDir_bg_down_left_label().setBounds(5, getHeight() - 12 - 5, 12, 12);
	}

	public JLabel getDir_bg_down_center_label() {
		if (dir_bg_down_center_label == null) {
			dir_bg_down_center_label = new JLabel(new ImageIcon(ImageFactory.getIndexDirBgDownCenterImage()
					.getScaledInstance(314 - 24, 12, Image.SCALE_DEFAULT)));
			resetDir_bg_down_center_label();
		}
		return dir_bg_down_center_label;
	}

	public void resetDir_bg_down_center_label() {
		getDir_bg_down_center_label().setBounds(12, getHeight() - 12 - 5, 314 - 24, 12);
	}

	public JLabel getDir_bg_down_right_label() {
		if (dir_bg_down_right_label == null) {
			dir_bg_down_right_label = new JLabel(new ImageIcon(ImageFactory.getIndexDirBgDownRightImage().getScaledInstance(12, 12, Image.SCALE_DEFAULT)));
			resetDir_bg_down_right_label();
		}
		return dir_bg_down_right_label;
	}

	public void resetDir_bg_down_right_label() {
		getDir_bg_down_right_label().setBounds(302, getHeight() - 12 - 5, 12, 12);
	}

	public JLabel getDir_search_bg_left_label() {
		if (dir_search_bg_left_label == null) {
			dir_search_bg_left_label = new JLabel(new ImageIcon(ImageFactory.getIndexDirSearchBgLeftImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT)));
			resetDir_search_bg_left_label();
		}
		return dir_search_bg_left_label;
	}

	public void resetDir_search_bg_left_label() {
	}

	public JLabel getDir_search_bg_center_label() {
		if (dir_search_bg_center_label == null) {
			dir_search_bg_center_label = new JLabel(new ImageIcon(ImageFactory.getIndexDirSearchBgCenterImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT)));
			resetDir_search_bg_center_label();
		}
		return dir_search_bg_center_label;
	}

	public void resetDir_search_bg_center_label() {
	}

	public JLabel getDir_search_bg_right_label() {
		if (dir_search_bg_right_label == null) {
			dir_search_bg_right_label = new JLabel(new ImageIcon(ImageFactory.getIndexDirSearchBgRightImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT)));
			resetDir_search_bg_right_label();
		}
		return dir_search_bg_right_label;
	}

	public void resetDir_search_bg_right_label() {
	}

	public JLabel getDir_list_bg_up_left_label() {
		if (dir_list_bg_up_left_label == null) {
			dir_list_bg_up_left_label = new JLabel(new ImageIcon(ImageFactory.getIndexDirListBgUpLeftImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT)));
			resetDir_list_bg_up_left_label();
		}
		return dir_list_bg_up_left_label;
	}

	public void resetDir_list_bg_up_left_label() {
	}

	public JLabel getDir_list_bg_up_center_label() {
		if (dir_list_bg_up_center_label == null) {
			dir_list_bg_up_center_label = new JLabel(
					new ImageIcon(ImageFactory.getIndexDirListBgUpCenterImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT)));
			resetDir_list_bg_up_center_label();
		}
		return dir_list_bg_up_center_label;
	}

	public void resetDir_list_bg_up_center_label() {
	}

	public JLabel getDir_list_bg_up_right_label() {
		if (dir_list_bg_up_right_label == null) {
			dir_list_bg_up_right_label = new JLabel(new ImageIcon(ImageFactory.getIndexDirListBgUpRightImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT)));
			resetDir_list_bg_up_right_label();
		}
		return dir_list_bg_up_right_label;
	}

	public void resetDir_list_bg_up_right_label() {
	}

	public JLabel getDir_list_bg_left_label() {
		if (dir_list_bg_left_label == null) {
			dir_list_bg_left_label = new JLabel(new ImageIcon(ImageFactory.getIndexDirListBgLeftImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT)));
			resetDir_list_bg_left_label();
		}
		return dir_list_bg_left_label;
	}

	public void resetDir_list_bg_left_label() {
	}

	public JLabel getDir_list_bg_right_label() {
		if (dir_list_bg_right_label == null) {
			dir_list_bg_right_label = new JLabel(new ImageIcon(ImageFactory.getIndexDirListBgRightImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT)));
			resetDir_list_bg_right_label();
		}
		return dir_list_bg_right_label;
	}

	public void resetDir_list_bg_right_label() {
	}

	public JLabel getDir_list_bg_down_left_label() {
		if (dir_list_bg_down_left_label == null) {
			dir_list_bg_down_left_label = new JLabel(
					new ImageIcon(ImageFactory.getIndexDirListBgDownLeftImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT)));
			resetDir_list_bg_down_left_label();
		}
		return dir_list_bg_down_left_label;
	}

	public void resetDir_list_bg_down_left_label() {
	}

	public JLabel getDir_list_bg_down_center_label() {
		if (dir_list_bg_down_center_label == null) {
			dir_list_bg_down_center_label = new JLabel(new ImageIcon(ImageFactory.getIndexDirListBgDownCenterImage().getScaledInstance(16, 16,
					Image.SCALE_DEFAULT)));
			resetDir_list_bg_down_center_label();
		}
		return dir_list_bg_down_center_label;
	}

	public void resetDir_list_bg_down_center_label() {
	}

	public JLabel getDir_list_bg_down_right_label() {
		if (dir_list_bg_down_right_label == null) {
			dir_list_bg_down_right_label = new JLabel(new ImageIcon(ImageFactory.getIndexDirListBgDownRightImage().getScaledInstance(16, 16,
					Image.SCALE_DEFAULT)));
			resetDir_list_bg_down_right_label();
		}
		return dir_list_bg_down_right_label;
	}

	public void resetDir_list_bg_down_right_label() {
	}

	// URLlabel
	public URLLabel getPlayer_info_urllabel() {
		if (player_info_urllabel == null) {
			player_info_urllabel = new URLLabel("荒城:左手程序。。右手诗");

			resetPlayer_info_urllabel();
		}
		return player_info_urllabel;
	}

	public void resetPlayer_info_urllabel() {
		FontMetrics fontMetrics = getPlayer_info_urllabel().getFontMetrics(Define.DEFAULT_FONT);
		int _width = fontMetrics.stringWidth(getPlayer_info_urllabel().getShow_text());

		getPlayer_info_urllabel().setBounds(getHead_pic_border_label().getX() + getHead_pic_border_label().getWidth() + 10,
				getHead_pic_border_label().getY() + 5, _width + 5, 20);
	}

	// button
	public JButton getClose_button() {
		if (close_button == null) {
			close_button = WidgetFactory.createIndexCloseButton(37, 22, "", IndexParams.ACTION_CLOSE, actionAdapter);
			resetClose_button();
		}
		return close_button;
	}

	public void resetClose_button() {
		getClose_button().setBounds(getWidth() - 37 - 5, 0, 37, 22);
	}

	public JButton getMin_button() {
		if (min_button == null) {
			min_button = WidgetFactory.createIndexMinButton(35, 22, "", IndexParams.ACTION_MIN, actionAdapter);
			resetMin_button();
		}
		return min_button;
	}

	public void resetMin_button() {
		getMin_button().setBounds(getWidth() - 35 * 3 - 5, 0, 35, 22);
	}

	public JButton getRestr_button() {
		if (restr_button == null) {
			restr_button = WidgetFactory.createIndexRestrButton(35, 22, "", IndexParams.ACTION_RESTR, actionAdapter);
			resetRestr_button();
		}
		return restr_button;
	}

	public void resetRestr_button() {
		getRestr_button().setBounds(getWidth() - 35 * 2 - 5, 0, 35, 22);
	}

	public JButton getMax_button() {
		if (max_button == null) {
			max_button = WidgetFactory.createIndexMaxButton(35, 22, "", IndexParams.ACTION_MAX, actionAdapter);
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
			change_face_button = WidgetFactory.createIndexChangeFaceButton(40, 14, "", IndexParams.ACTION_CHANGE_FACE, actionAdapter);

			resetChange_face_button();
		}
		return change_face_button;
	}

	public void resetChange_face_button() {
		getChange_face_button().setBounds(getMenu_button().getX() - getChange_face_button().getWidth() - 10, 5, 40, 14);
	}

	public JButton getMenu_button() {
		if (menu_button == null) {
			menu_button = WidgetFactory.createIndexMenuButton(40, 14, "", IndexParams.ACTION_MENU, actionAdapter);

			resetMenu_button();
		}
		return menu_button;
	}

	public void resetMenu_button() {
		getMenu_button().setBounds(getMin_button().getX() - getMenu_button().getWidth() - 10, 5, 40, 14);
	}

	public JButton getSearch_list_button() {
		return search_list_button;
	}

	public JButton getSearch_enter_button() {
		return search_enter_button;
	}

	public JButton getDir_lock_button() {
		return dir_lock_button;
	}

	public JButton getDir_unlock_button() {
		return dir_unlock_button;
	}

	// getter and setter
	public Dimension getHistorySize() {
		return historySize;
	}

	public void setHistorySize(Dimension historySize) {
		this.historySize = historySize;
	}

	public UIMouseDragAdapter getDragAdapter() {
		return dragAdapter;
	}

	public boolean isMax() {
		return isMax;
	}

	public void setMax(boolean isMax) {
		this.isMax = isMax;
	}

	// Main test
	public static void main(String[] args) {
		new IndexUI(new PlayerBean()).showMe();
	}
}
