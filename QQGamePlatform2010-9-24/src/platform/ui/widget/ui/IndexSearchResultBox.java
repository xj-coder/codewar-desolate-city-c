package platform.ui.widget.ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListModel;

import platform.tools.ImageFactory;
import platform.tools.ImageTools;
import platform.ui.index.IndexParams;

public class IndexSearchResultBox extends JComponent {

	private static final long serialVersionUID = 7252634123532480781L;

	// #begin 【Lable元素】
	private JLabel dir_list_bg_up_left_label;
	private JLabel dir_list_bg_up_center_label;
	private JLabel dir_list_bg_up_right_label;
	private JLabel dir_list_bg_left_label;
	private JLabel dir_list_bg_center_label;
	private JLabel dir_list_bg_right_label;
	private JLabel dir_list_bg_down_left_label;
	private JLabel dir_list_bg_down_center_label;
	private JLabel dir_list_bg_down_right_label;

	private JLabel dir_list_info_label;
	// #end 【Lable元素】

	private JList listResult;
	private ListModel listModel;

	public IndexSearchResultBox() {
		setLayout(null);

		setOpaque(false);
	}

	/**
	 * 显示窗体
	 */
	public void showUI() {
		add(getListResult(), new Integer(Integer.MIN_VALUE));

		// Label元素
		add(getDir_list_info_label(), new Integer(Integer.MIN_VALUE));
		add(getDir_list_bg_up_left_label(), new Integer(Integer.MIN_VALUE));
		add(getDir_list_bg_up_center_label(), new Integer(Integer.MIN_VALUE));
		add(getDir_list_bg_up_right_label(), new Integer(Integer.MIN_VALUE));
		add(getDir_list_bg_center_label(), new Integer(Integer.MIN_VALUE));
		add(getDir_list_bg_left_label(), new Integer(Integer.MIN_VALUE));
		add(getDir_list_bg_right_label(), new Integer(Integer.MIN_VALUE));
		add(getDir_list_bg_down_left_label(), new Integer(Integer.MIN_VALUE));
		add(getDir_list_bg_down_center_label(), new Integer(Integer.MIN_VALUE));
		add(getDir_list_bg_down_right_label(), new Integer(Integer.MIN_VALUE));

	}

	// #begin【双缓冲技术】
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
	} // #end【双缓冲技术】

	/**
	 * 作用:重新排列所有相对位置的元素 <BR>
	 * 
	 * 调用情况:当整个窗体发生大小变化时
	 */
	public void resetAllComponents() {
		resetDir_list_bg_up_left_label();
		resetDir_list_bg_up_center_label();
		resetDir_list_bg_up_right_label();
		resetDir_list_bg_left_label();
		resetDir_list_bg_center_label();
		resetDir_list_bg_right_label();
		resetDir_list_bg_down_left_label();
		resetDir_list_bg_down_center_label();
		resetDir_list_bg_down_right_label();

		resetDir_list_info_label();
		resetListResult();
	}

	// #begin 【Label元素】
	public JLabel getDir_list_bg_up_left_label() {
		if (dir_list_bg_up_left_label == null) {
			dir_list_bg_up_left_label = new JLabel(new ImageIcon(ImageFactory.getIndexDirListBgUpLeftImage().getScaledInstance(4, 5, Image.SCALE_DEFAULT)));
			resetDir_list_bg_up_left_label();
		}
		return dir_list_bg_up_left_label;
	}

	public void resetDir_list_bg_up_left_label() {
		getDir_list_bg_up_left_label().setBounds(0, 0, 4, 5);
	}

	public JLabel getDir_list_bg_up_center_label() {
		if (dir_list_bg_up_center_label == null) {
			dir_list_bg_up_center_label = new JLabel(new ImageIcon(ImageFactory.getIndexDirListBgUpCenterImage().getScaledInstance(getWidth() - 8, 5,
					Image.SCALE_DEFAULT)));

			resetDir_list_bg_up_center_label();
		}
		return dir_list_bg_up_center_label;
	}

	public void resetDir_list_bg_up_center_label() {
		getDir_list_bg_up_center_label().setBounds(4, 0, getWidth() - 8, 5);
	}

	public JLabel getDir_list_bg_up_right_label() {
		if (dir_list_bg_up_right_label == null) {
			dir_list_bg_up_right_label = new JLabel(new ImageIcon(ImageFactory.getIndexDirListBgUpRightImage().getScaledInstance(4, 5, Image.SCALE_DEFAULT)));
			resetDir_list_bg_up_right_label();
		}
		return dir_list_bg_up_right_label;
	}

	public void resetDir_list_bg_up_right_label() {
		getDir_list_bg_up_right_label().setBounds(getWidth() - 4, 0, 4, 5);
	}

	public JLabel getDir_list_bg_left_label() {
		if (dir_list_bg_left_label == null) {
			dir_list_bg_left_label = new JLabel(new ImageIcon(ImageFactory.getIndexDirListBgLeftImage().getScaledInstance(15, getHeight() - 10,
					Image.SCALE_DEFAULT)));

			resetDir_list_bg_left_label();
		}
		return dir_list_bg_left_label;
	}

	public void resetDir_list_bg_left_label() {
		getDir_list_bg_left_label().setBounds(0, 5, 15, getHeight() - 10);
	}

	public JLabel getDir_list_bg_center_label() {
		if (dir_list_bg_center_label == null) {
			dir_list_bg_center_label = new JLabel(new ImageIcon(ImageFactory.getIndexDirBgCenterImage().getScaledInstance(getWidth() - 10, getHeight() - 10,
					Image.SCALE_DEFAULT)));

			resetDir_list_bg_center_label();
		}
		return dir_list_bg_center_label;
	}

	public void resetDir_list_bg_center_label() {
		getDir_list_bg_center_label().setBounds(5, 5, getWidth() - 10, getHeight() - 10);
	}

	public JLabel getDir_list_bg_right_label() {
		if (dir_list_bg_right_label == null) {
			dir_list_bg_right_label = new JLabel(new ImageIcon(ImageFactory.getIndexDirListBgRightImage().getScaledInstance(15, getHeight() - 10,
					Image.SCALE_DEFAULT)));
			resetDir_list_bg_right_label();
		}
		return dir_list_bg_right_label;
	}

	public void resetDir_list_bg_right_label() {
		getDir_list_bg_right_label().setBounds(getWidth() - 15, 5, 15, getHeight() - 10);
	}

	public JLabel getDir_list_bg_down_left_label() {
		if (dir_list_bg_down_left_label == null) {
			dir_list_bg_down_left_label = new JLabel(new ImageIcon(ImageFactory.getIndexDirListBgDownLeftImage().getScaledInstance(4, 5, Image.SCALE_DEFAULT)));
			resetDir_list_bg_down_left_label();
		}
		return dir_list_bg_down_left_label;
	}

	public void resetDir_list_bg_down_left_label() {
		getDir_list_bg_down_left_label().setBounds(0, getHeight() - 5, 4, 5);
	}

	public JLabel getDir_list_bg_down_center_label() {
		if (dir_list_bg_down_center_label == null) {
			dir_list_bg_down_center_label = new JLabel(new ImageIcon(ImageFactory.getIndexDirListBgDownCenterImage().getScaledInstance(getWidth() - 8, 5,
					Image.SCALE_DEFAULT)));
			resetDir_list_bg_down_center_label();
		}
		return dir_list_bg_down_center_label;
	}

	public void resetDir_list_bg_down_center_label() {
		getDir_list_bg_down_center_label().setBounds(4, getHeight() - 5, getWidth() - 8, 5);
	}

	public JLabel getDir_list_bg_down_right_label() {
		if (dir_list_bg_down_right_label == null) {
			dir_list_bg_down_right_label = new JLabel(
					new ImageIcon(ImageFactory.getIndexDirListBgDownRightImage().getScaledInstance(4, 5, Image.SCALE_DEFAULT)));
			resetDir_list_bg_down_right_label();
		}
		return dir_list_bg_down_right_label;
	}

	public void resetDir_list_bg_down_right_label() {
		getDir_list_bg_down_right_label().setBounds(getWidth() - 4, getHeight() - 5, 4, 5);
	}

	public JLabel getDir_list_info_label() {
		if (dir_list_info_label == null) {
			dir_list_info_label = new JLabel(IndexParams.SEARCH_RESULT_INFO_CONTEXT);

			resetDir_list_info_label();
		}
		return dir_list_info_label;
	}

	public void resetDir_list_info_label() {
		getDir_list_info_label().setBounds(6, 5, getWidth() - 8, 15);
	}

	// #end 【Label元素】

	// #begin List模型
	public ListModel getListModel() {
		if (listModel == null) {
			listModel = new DefaultListModel();
		}
		return listModel;
	}// #end List模型

	public JList getListResult() {
		if (listResult == null) {
			listResult = new JList(getListModel());
			listResult.setFixedCellHeight(20);
			listResult.setFixedCellWidth(295);

			resetListResult();
		}
		return listResult;
	}

	public void resetListResult() {
		int _height = getListModel().getSize() * getListResult().getFixedCellHeight();

		getListResult().setBounds(4, getDir_list_info_label().getY() + getDir_list_info_label().getHeight(), getWidth() - 10, _height);
	}
}
