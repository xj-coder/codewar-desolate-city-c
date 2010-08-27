package platform.ui.index;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import platform.define.Define;
import platform.tools.ImageFactory;
import platform.tools.ImageTools;
import platform.ui.widget.WidgetFactory;

@SuppressWarnings("serial")
public class IndexDirTreeUI extends JPanel {

	// #begin【左侧目录树界面元素】
	private JLabel dir_bg_up_left_label;
	private JLabel dir_bg_up_center_label;
	private JLabel dir_bg_up_right_label;
	private JLabel dir_bg_left_label;
	private JLabel dir_bg_center_label;
	private JLabel dir_bg_right_label;
	private JLabel dir_bg_down_left_label;
	private JLabel dir_bg_down_center_label;
	private JLabel dir_bg_down_right_label;

	private JLabel dir_show_online_players_label;

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

	// #end【左侧目录树】

	private IndexUI indexUI;

	public IndexDirTreeUI(IndexUI indexUI) {
		this.indexUI = indexUI;
		setLayout(null);

		setOpaque(false);
	}

	public void showUI() {
		// 左侧目录树[按钮]
		add(getDir_lock_button(), new Integer(Integer.MIN_VALUE));
		add(getDir_unlock_button(), new Integer(Integer.MIN_VALUE));
		add(getSearch_list_button(), new Integer(Integer.MIN_VALUE));
		add(getSearch_enter_button(), new Integer(Integer.MIN_VALUE));

		// 左侧目录树[背景]
		add(getDir_show_online_players_label(), new Integer(Integer.MIN_VALUE));
		add(getDir_search_bg_left_label(), new Integer(Integer.MIN_VALUE));
		add(getDir_search_bg_center_label(), new Integer(Integer.MIN_VALUE));
		add(getDir_search_bg_right_label(), new Integer(Integer.MIN_VALUE));
		add(getDir_bg_up_left_label(), new Integer(Integer.MIN_VALUE));
		add(getDir_bg_up_center_label(), new Integer(Integer.MIN_VALUE));
		add(getDir_bg_up_right_label(), new Integer(Integer.MIN_VALUE));
		add(getDir_bg_left_label(), new Integer(Integer.MIN_VALUE));
		add(getDir_bg_center_label(), new Integer(Integer.MIN_VALUE));
		add(getDir_bg_right_label(), new Integer(Integer.MIN_VALUE));
		add(getDir_bg_down_left_label(), new Integer(Integer.MIN_VALUE));
		add(getDir_bg_down_center_label(), new Integer(Integer.MIN_VALUE));
		add(getDir_bg_down_right_label(), new Integer(Integer.MIN_VALUE));

		setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
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
	}

	public void resetAllComponents() {
		resetDir_bg_left_label();
		resetDir_bg_center_label();
		resetDir_bg_right_label();
		resetDir_bg_down_left_label();
		resetDir_bg_down_center_label();
		resetDir_bg_down_right_label();
		resetDir_bg_up_left_label();
		resetDir_bg_up_center_label();
		resetDir_bg_up_right_label();
	}

	// #begin【左侧目录树Label元素】
	public JLabel getDir_bg_up_left_label() {
		if (dir_bg_up_left_label == null) {
			dir_bg_up_left_label = new JLabel(new ImageIcon(ImageFactory.getIndexDirBgUpLeftImage().getScaledInstance(15, 58, Image.SCALE_DEFAULT)));
			resetDir_bg_up_left_label();
		}
		return dir_bg_up_left_label;
	}

	public void resetDir_bg_up_left_label() {
		getDir_bg_up_left_label().setBounds(0, 0, 15, 58);
	}

	public JLabel getDir_bg_up_center_label() {
		if (dir_bg_up_center_label == null) {
			dir_bg_up_center_label = new JLabel(new ImageIcon(ImageFactory.getIndexDirBgUpCenterImage().getScaledInstance(284, 58, Image.SCALE_DEFAULT)));
			resetDir_bg_up_center_label();
		}
		return dir_bg_up_center_label;
	}

	public void resetDir_bg_up_center_label() {
		getDir_bg_up_center_label().setBounds(15, 0, 284, 58);
	}

	public JLabel getDir_bg_up_right_label() {
		if (dir_bg_up_right_label == null) {
			dir_bg_up_right_label = new JLabel(new ImageIcon(ImageFactory.getIndexDirBgUpRightImage().getScaledInstance(15, 58, Image.SCALE_DEFAULT)));
			resetDir_bg_up_right_label();
		}
		return dir_bg_up_right_label;
	}

	public void resetDir_bg_up_right_label() {
		getDir_bg_up_right_label().setBounds(299, 0, 15, 58);
	}

	public JLabel getDir_bg_left_label() {
		if (dir_bg_left_label == null) {
			dir_bg_left_label = new JLabel(new ImageIcon(ImageFactory.getIndexDirBgLeftImage()
					.getScaledInstance(13, getHeight() - 15 - 12, Image.SCALE_DEFAULT)));
			resetDir_bg_left_label();
		}
		return dir_bg_left_label;
	}

	public void resetDir_bg_left_label() {
		getDir_bg_left_label().setBounds(0, 15, 13, getHeight() - 15 - 12);
	}

	public JLabel getDir_bg_center_label() {
		if (dir_bg_center_label == null) {
			dir_bg_center_label = new JLabel(new ImageIcon(ImageFactory.getIndexDirBgCenterImage().getScaledInstance(getWidth() - 24, getHeight() - 58 - 12,
					Image.SCALE_DEFAULT)));
			resetDir_bg_center_label();
		}
		return dir_bg_center_label;
	}

	public void resetDir_bg_center_label() {
		getDir_bg_center_label().setBounds(13, 58, getWidth() - 24, getHeight() - 58 - 12);
	}

	public JLabel getDir_bg_right_label() {
		if (dir_bg_right_label == null) {
			dir_bg_right_label = new JLabel(new ImageIcon(ImageFactory.getIndexDirBgRightImage().getScaledInstance(13, getHeight() - 15 - 12,
					Image.SCALE_DEFAULT)));
			resetDir_bg_right_label();
		}
		return dir_bg_right_label;
	}

	public void resetDir_bg_right_label() {
		getDir_bg_right_label().setBounds(301, 15, 13, getHeight() - 15 - 12);
	}

	public JLabel getDir_bg_down_left_label() {
		if (dir_bg_down_left_label == null) {
			dir_bg_down_left_label = new JLabel(new ImageIcon(ImageFactory.getIndexDirBgDownLeftImage().getScaledInstance(12, 12, Image.SCALE_DEFAULT)));
			resetDir_bg_down_left_label();
		}
		return dir_bg_down_left_label;
	}

	public void resetDir_bg_down_left_label() {
		getDir_bg_down_left_label().setBounds(0, getHeight() - 12, 12, 12);
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
		getDir_bg_down_center_label().setBounds(12, getHeight() - 12, 314 - 24, 12);
	}

	public JLabel getDir_bg_down_right_label() {
		if (dir_bg_down_right_label == null) {
			dir_bg_down_right_label = new JLabel(new ImageIcon(ImageFactory.getIndexDirBgDownRightImage().getScaledInstance(12, 12, Image.SCALE_DEFAULT)));
			resetDir_bg_down_right_label();
		}
		return dir_bg_down_right_label;
	}

	public void resetDir_bg_down_right_label() {
		getDir_bg_down_right_label().setBounds(302, getHeight() - 12, 12, 12);
	}

	public JLabel getDir_show_online_players_label() {
		if (dir_show_online_players_label == null) {
			dir_show_online_players_label = new JLabel(IndexParams.NAME_SHOW_ONLINE_PLAYERS);
			dir_show_online_players_label.setFont(Define.DEFAULT_FONT);
			dir_show_online_players_label.setForeground(Color.BLACK);

			resetDir_show_online_players_label();
		}
		return dir_show_online_players_label;
	}

	public void resetDir_show_online_players_label() {
		getDir_show_online_players_label().setBounds(15, 5, 150, 15);
	}

	public JLabel getDir_search_bg_left_label() {
		if (dir_search_bg_left_label == null) {
			dir_search_bg_left_label = new JLabel(new ImageIcon(ImageFactory.getIndexDirSearchBgLeftImage().getScaledInstance(26, 27, Image.SCALE_DEFAULT)));
			resetDir_search_bg_left_label();
		}
		return dir_search_bg_left_label;
	}

	public void resetDir_search_bg_left_label() {
		getDir_search_bg_left_label().setBounds(5, 27, 26, 27);
	}

	public JLabel getDir_search_bg_center_label() {
		if (dir_search_bg_center_label == null) {
			dir_search_bg_center_label = new JLabel(new ImageIcon(ImageFactory.getIndexDirSearchBgCenterImage().getScaledInstance(314 - 26 - 10 - 15, 27,
					Image.SCALE_DEFAULT)));
			resetDir_search_bg_center_label();
		}
		return dir_search_bg_center_label;
	}

	public void resetDir_search_bg_center_label() {
		getDir_search_bg_center_label().setBounds(26 + 10, 28, 314 - 10 - 26 - 15, 25);
	}

	public JLabel getDir_search_bg_right_label() {
		if (dir_search_bg_right_label == null) {
			dir_search_bg_right_label = new JLabel(new ImageIcon(ImageFactory.getIndexDirSearchBgRightImage().getScaledInstance(15, 25, Image.SCALE_DEFAULT)));
			resetDir_search_bg_right_label();
		}
		return dir_search_bg_right_label;
	}

	public void resetDir_search_bg_right_label() {
		getDir_search_bg_right_label().setBounds(314 - 18, 27, 15, 25);
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

	}// #end【左侧目录树Label元素】

	// #begin【左侧目录树button元素】
	public JButton getSearch_list_button() {
		if (search_list_button == null) {
			search_list_button = WidgetFactory.createIndexSearchListButton(8, 5, "", IndexParams.ACTION_SEARCH_LIST, indexUI.getActionAdapter());

			resetSearch_list_button();
		}
		return search_list_button;
	}

	public void resetSearch_list_button() {
		getSearch_list_button().setBounds(38, 39, 8, 5);
	}

	public JButton getSearch_enter_button() {
		if (search_enter_button == null) {
			search_enter_button = WidgetFactory.createIndexSearchEnterButton(10, 10, "", IndexParams.ACTION_SEARCH_ENTER, indexUI.getActionAdapter());

			resetSearch_enter_button();
		}
		return search_enter_button;
	}

	public void resetSearch_enter_button() {
		getSearch_enter_button().setBounds(314 - 25, 37, 10, 10);
	}

	public JButton getDir_lock_button() {
		if (dir_lock_button == null) {
			dir_lock_button = WidgetFactory.createIndexDirLockButton(18, 17, "", IndexParams.ACTION_DIR_LOCK, indexUI.getActionAdapter());

			resetDir_lock_button();
		}
		return dir_lock_button;
	}

	public void resetDir_lock_button() {
		getDir_lock_button().setBounds(314 - 20, 5, 18, 17);
	}

	public JButton getDir_unlock_button() {
		if (dir_unlock_button == null) {
			dir_unlock_button = WidgetFactory.createIndexDirUnLockButton(18, 17, "", IndexParams.ACTION_DIR_UNLOCK, indexUI.getActionAdapter());

			dir_unlock_button.setVisible(false);
			resetDir_unlock_button();
		}
		return dir_unlock_button;
	}

	public void resetDir_unlock_button() {
		getDir_unlock_button().setBounds(314 - 20, 5, 18, 17);
	}// #end【左侧目录树button元素】

}
