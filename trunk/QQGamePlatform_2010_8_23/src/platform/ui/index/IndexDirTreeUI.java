package platform.ui.index;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

import platform.action.IndexAction;
import platform.define.Define;
import platform.tools.ImageFactory;
import platform.tools.ImageTools;
import platform.ui.widget.WidgetFactory;
import platform.ui.widget.model.QTableTreeModel;
import platform.ui.widget.ui.ImagePanelUI;
import platform.ui.widget.ui.IndexSearchResultBox;
import platform.ui.widget.ui.QTableTreeItemUI;
import platform.ui.widget.ui.QTableTreeUI;

@SuppressWarnings("serial")
public class IndexDirTreeUI extends JPanel {

	// #begin【Label元素】
	private ImagePanelUI dir_bg_up_left_image_panel;
	private ImagePanelUI dir_bg_up_center_image_panel;
	private ImagePanelUI dir_bg_up_right_image_panel;
	private ImagePanelUI dir_bg_left_image_panel;
	private ImagePanelUI dir_bg_center_image_panel;
	private ImagePanelUI dir_bg_right_image_panel;
	private ImagePanelUI dir_bg_down_left_image_panel;
	private ImagePanelUI dir_bg_down_center_image_panel;
	private ImagePanelUI dir_bg_down_right_image_panel;

	private JLabel dir_show_online_players_label;

	private ImagePanelUI dir_search_bg_left_image_panel;
	private ImagePanelUI dir_search_bg_center_image_panel;
	private ImagePanelUI dir_search_bg_right_image_panel;
	// #end【Label元素】

	// #begin【Button元素】
	private JButton search_list_button;
	private JButton search_enter_button;
	private JButton dir_lock_button;
	private JButton dir_unlock_button;
	// #end【Button元素】

	private JTextField search_field;// 搜索输入框
	private IndexSearchResultBox searchResultBox;// 搜索结果显示框

	private IndexUI indexUI;// 父元素

	private JScrollPane treeScrollPane;// 目录树滚动界面
	private QTableTreeUI tree;// 目录树UI
	private QTableTreeModel treeModel;// 目录树模型

	public IndexDirTreeUI(IndexUI indexUI) {
		this.indexUI = indexUI;
		setLayout(null);

		setOpaque(false);
	}

	/**
	 * 显示窗体
	 */
	public void showUI() {
		add(getSearchResultBox(), new Integer(Integer.MIN_VALUE));// 搜索结果框

		add(getTreeScrollPane(), new Integer(Integer.MIN_VALUE));// 滚动界面

		// Field元素
		add(getSearch_field(), new Integer(Integer.MIN_VALUE));
		// 按钮元素
		add(getDir_lock_button(), new Integer(Integer.MIN_VALUE));
		add(getDir_unlock_button(), new Integer(Integer.MIN_VALUE));
		add(getSearch_list_button(), new Integer(Integer.MIN_VALUE));
		add(getSearch_enter_button(), new Integer(Integer.MIN_VALUE));

		// Label元素
		add(getDir_show_online_players_image_panel(), new Integer(
				Integer.MIN_VALUE));
		add(getDir_search_bg_left_image_panel(), new Integer(Integer.MIN_VALUE));
		add(getDir_search_bg_center_image_panel(), new Integer(
				Integer.MIN_VALUE));
		add(getDir_search_bg_right_image_panel(),
				new Integer(Integer.MIN_VALUE));
		add(getDir_bg_up_left_image_panel(), new Integer(Integer.MIN_VALUE));
		add(getDir_bg_up_center_image_panel(), new Integer(Integer.MIN_VALUE));
		add(getDir_bg_up_right_image_panel(), new Integer(Integer.MIN_VALUE));
		add(getDir_bg_left_image_panel(), new Integer(Integer.MIN_VALUE));
		add(getDir_bg_center_image_panel(), new Integer(Integer.MIN_VALUE));
		add(getDir_bg_right_image_panel(), new Integer(Integer.MIN_VALUE));
		add(getDir_bg_down_left_image_panel(), new Integer(Integer.MIN_VALUE));
		add(getDir_bg_down_center_image_panel(), new Integer(Integer.MIN_VALUE));
		add(getDir_bg_down_right_image_panel(), new Integer(Integer.MIN_VALUE));

	}

	// #begin【双缓冲技术】
	@Override
	public void paint(Graphics g) {
		System.out.println("paint IndexDirTreeUI");
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
		resetDir_bg_left_image_panel();
		resetDir_bg_right_image_panel();
		resetDir_bg_center_image_panel();
		resetDir_bg_down_left_image_panel();
		resetDir_bg_down_right_image_panel();
		resetDir_bg_down_center_image_panel();
		resetDir_bg_up_left_image_panel();
		resetDir_bg_up_right_image_panel();
		resetDir_bg_up_center_image_panel();

		resetTreeScrollPane();
		resetSearchResultBox();
	}

	// #begin【Label元素】
	public ImagePanelUI getDir_bg_up_left_image_panel() {
		if (dir_bg_up_left_image_panel == null) {
			dir_bg_up_left_image_panel = new ImagePanelUI(ImageFactory
					.getIndexDirBgUpLeftImage().getScaledInstance(15, 58,
							Image.SCALE_DEFAULT));

			resetDir_bg_up_left_image_panel();
		}
		return dir_bg_up_left_image_panel;
	}

	public void resetDir_bg_up_left_image_panel() {
		getDir_bg_up_left_image_panel().setBounds(0, 0, 15, 58);
	}

	public ImagePanelUI getDir_bg_up_right_image_panel() {
		if (dir_bg_up_right_image_panel == null) {
			dir_bg_up_right_image_panel = new ImagePanelUI(ImageFactory
					.getIndexDirBgUpRightImage().getScaledInstance(15, 58,
							Image.SCALE_DEFAULT));

			resetDir_bg_up_right_image_panel();
		}
		return dir_bg_up_right_image_panel;
	}

	public void resetDir_bg_up_right_image_panel() {
		getDir_bg_up_right_image_panel().setBounds(getWidth() - 15, 0, 15, 58);
	}

	public ImagePanelUI getDir_bg_up_center_image_panel() {
		if (dir_bg_up_center_image_panel == null) {
			dir_bg_up_center_image_panel = new ImagePanelUI(ImageFactory
					.getIndexDirBgUpCenterImage().getScaledInstance(
							getWidth()
									- getDir_bg_up_left_image_panel()
											.getWidth()
									- getDir_bg_up_right_image_panel()
											.getWidth(), 58,
							Image.SCALE_DEFAULT));

			resetDir_bg_up_center_image_panel();
		}
		return dir_bg_up_center_image_panel;
	}

	public void resetDir_bg_up_center_image_panel() {
		getDir_bg_up_center_image_panel().setBounds(
				15,
				0,
				getWidth() - getDir_bg_up_left_image_panel().getWidth()
						- getDir_bg_up_right_image_panel().getWidth(), 58);
	}

	public ImagePanelUI getDir_bg_down_left_image_panel() {
		if (dir_bg_down_left_image_panel == null) {
			dir_bg_down_left_image_panel = new ImagePanelUI(ImageFactory
					.getIndexDirBgDownLeftImage().getScaledInstance(12, 12,
							Image.SCALE_DEFAULT));
			resetDir_bg_down_left_image_panel();
		}
		return dir_bg_down_left_image_panel;
	}

	public void resetDir_bg_down_left_image_panel() {
		getDir_bg_down_left_image_panel()
				.setBounds(0, getHeight() - 12, 12, 12);
	}

	public ImagePanelUI getDir_bg_down_right_image_panel() {
		if (dir_bg_down_right_image_panel == null) {
			dir_bg_down_right_image_panel = new ImagePanelUI(ImageFactory
					.getIndexDirBgDownRightImage().getScaledInstance(12, 12,
							Image.SCALE_DEFAULT));
			resetDir_bg_down_right_image_panel();
		}
		return dir_bg_down_right_image_panel;
	}

	public void resetDir_bg_down_right_image_panel() {
		getDir_bg_down_right_image_panel().setBounds(getWidth() - 12,
				getHeight() - 12, 12, 12);
	}

	public ImagePanelUI getDir_bg_down_center_image_panel() {
		if (dir_bg_down_center_image_panel == null) {
			dir_bg_down_center_image_panel = new ImagePanelUI(ImageFactory
					.getIndexDirBgDownCenterImage().getScaledInstance(
							getWidth()
									- getDir_bg_down_left_image_panel()
											.getWidth()
									- getDir_bg_down_right_image_panel()
											.getWidth(), 12,
							Image.SCALE_DEFAULT));
			resetDir_bg_down_center_image_panel();
		}
		return dir_bg_down_center_image_panel;
	}

	public void resetDir_bg_down_center_image_panel() {
		getDir_bg_down_center_image_panel().setBounds(
				12,
				getHeight() - 12,
				getWidth() - getDir_bg_down_left_image_panel().getWidth()
						- getDir_bg_down_right_image_panel().getWidth(), 12);
	}

	public ImagePanelUI getDir_bg_left_image_panel() {
		if (dir_bg_left_image_panel == null) {
			dir_bg_left_image_panel = new ImagePanelUI(ImageFactory
					.getIndexDirBgLeftImage().getScaledInstance(
							13,
							getHeight()
									- getDir_bg_up_left_image_panel()
											.getHeight()
									- getDir_bg_down_left_image_panel()
											.getHeight(), Image.SCALE_DEFAULT));
			resetDir_bg_left_image_panel();
		}
		return dir_bg_left_image_panel;
	}

	public void resetDir_bg_left_image_panel() {
		getDir_bg_left_image_panel().setBounds(
				0,
				getDir_bg_up_left_image_panel().getHeight(),
				13,
				getHeight() - getDir_bg_up_left_image_panel().getHeight()
						- getDir_bg_down_left_image_panel().getHeight());
	}

	public ImagePanelUI getDir_bg_right_image_panel() {
		if (dir_bg_right_image_panel == null) {
			dir_bg_right_image_panel = new ImagePanelUI(ImageFactory
					.getIndexDirBgRightImage().getScaledInstance(
							13,
							getHeight()
									- getDir_bg_up_right_image_panel()
											.getHeight()
									- getDir_bg_down_right_image_panel()
											.getHeight(), Image.SCALE_DEFAULT));
			resetDir_bg_right_image_panel();
		}
		return dir_bg_right_image_panel;
	}

	public void resetDir_bg_right_image_panel() {
		getDir_bg_right_image_panel().setBounds(
				getWidth() - 13,
				getDir_bg_up_right_image_panel().getHeight(),
				13,
				getHeight() - getDir_bg_up_right_image_panel().getHeight()
						- getDir_bg_down_right_image_panel().getHeight());
	}

	public ImagePanelUI getDir_bg_center_image_panel() {
		if (dir_bg_center_image_panel == null) {
			dir_bg_center_image_panel = new ImagePanelUI(ImageFactory
					.getIndexDirBgCenterImage().getScaledInstance(
							getWidth()
									- getDir_bg_left_image_panel().getWidth()
									- getDir_bg_right_image_panel().getWidth(),
							getHeight()
									- getDir_bg_up_center_image_panel()
											.getHeight()
									- getDir_bg_down_center_image_panel()
											.getHeight(), Image.SCALE_DEFAULT));
			resetDir_bg_center_image_panel();
		}
		return dir_bg_center_image_panel;
	}

	public void resetDir_bg_center_image_panel() {
		getDir_bg_center_image_panel().setBounds(
				13,
				getDir_bg_up_center_image_panel().getHeight(),
				getWidth() - getDir_bg_left_image_panel().getWidth()
						- getDir_bg_right_image_panel().getWidth(),
				getHeight() - getDir_bg_up_center_image_panel().getHeight()
						- getDir_bg_down_center_image_panel().getHeight());
	}

	public JLabel getDir_show_online_players_image_panel() {
		if (dir_show_online_players_label == null) {
			dir_show_online_players_label = new JLabel(
					IndexParams.NAME_SHOW_ONLINE_PLAYERS);
			dir_show_online_players_label.setFont(Define.DEFAULT_FONT);

			resetDir_show_online_players_image_panel();
		}
		return dir_show_online_players_label;
	}

	public void resetDir_show_online_players_image_panel() {
		getDir_show_online_players_image_panel().setBounds(15, 5, 150, 15);
	}

	public ImagePanelUI getDir_search_bg_left_image_panel() {
		if (dir_search_bg_left_image_panel == null) {
			dir_search_bg_left_image_panel = new ImagePanelUI(ImageFactory
					.getIndexDirSearchBgLeftImage().getScaledInstance(26, 27,
							Image.SCALE_DEFAULT));
			resetDir_search_bg_left_image_panel();
		}
		return dir_search_bg_left_image_panel;
	}

	public void resetDir_search_bg_left_image_panel() {
		getDir_search_bg_left_image_panel().setBounds(5, 27, 26, 27);
	}

	public ImagePanelUI getDir_search_bg_right_image_panel() {
		if (dir_search_bg_right_image_panel == null) {
			dir_search_bg_right_image_panel = new ImagePanelUI(ImageFactory
					.getIndexDirSearchBgRightImage().getScaledInstance(15, 25,
							Image.SCALE_DEFAULT));
			resetDir_search_bg_right_image_panel();
		}
		return dir_search_bg_right_image_panel;
	}

	public void resetDir_search_bg_right_image_panel() {
		getDir_search_bg_right_image_panel().setBounds(getWidth() - 15, 27, 15,
				25);
	}

	public ImagePanelUI getDir_search_bg_center_image_panel() {
		if (dir_search_bg_center_image_panel == null) {
			dir_search_bg_center_image_panel = new ImagePanelUI(ImageFactory
					.getIndexDirSearchBgCenterImage().getScaledInstance(
							getWidth()
									- getDir_search_bg_left_image_panel()
											.getWidth() - 10 - 15, 27,
							Image.SCALE_DEFAULT));
			resetDir_search_bg_center_image_panel();
		}
		return dir_search_bg_center_image_panel;
	}

	public void resetDir_search_bg_center_image_panel() {
		getDir_search_bg_center_image_panel().setBounds(
				getDir_search_bg_left_image_panel().getWidth() + 10,
				27,
				getWidth() - getDir_search_bg_left_image_panel().getWidth()
						- 10 - 15, 27);
	}// #end【Label元素】

	// #begin【button元素】
	public JButton getSearch_list_button() {
		if (search_list_button == null) {
			search_list_button = WidgetFactory.createIndexSearchListButton(8,
					5, "", IndexParams.ACTION_SEARCH_LIST, indexUI
							.getActionAdapter());
			search_list_button.setFocusable(true);

			resetSearch_list_button();
		}
		return search_list_button;
	}

	public void resetSearch_list_button() {
		getSearch_list_button().setBounds(35, 39, 8, 5);
	}

	public JButton getSearch_enter_button() {
		if (search_enter_button == null) {
			search_enter_button = WidgetFactory.createIndexSearchEnterButton(
					10, 10, "", IndexParams.ACTION_SEARCH_ENTER, indexUI
							.getActionAdapter());
			search_enter_button.setFocusable(true);

			resetSearch_enter_button();
		}
		return search_enter_button;
	}

	public void resetSearch_enter_button() {
		getSearch_enter_button().setBounds(getWidth() - 25, 37, 10, 10);
	}

	public JButton getDir_lock_button() {
		if (dir_lock_button == null) {
			dir_lock_button = WidgetFactory
					.createIndexDirLockButton(18, 17, "",
							IndexParams.ACTION_DIR_LOCK, indexUI
									.getActionAdapter());
			dir_lock_button.setVisible(false);
			getDir_lock_button().setFocusable(true);

			resetDir_lock_button();
		}
		return dir_lock_button;
	}

	public void resetDir_lock_button() {
		getDir_lock_button().setBounds(getWidth() - 20, 5, 18, 17);
	}

	public JButton getDir_unlock_button() {
		if (dir_unlock_button == null) {
			dir_unlock_button = WidgetFactory.createIndexDirUnLockButton(18,
					17, "", IndexParams.ACTION_DIR_UNLOCK, indexUI
							.getActionAdapter());
			getDir_unlock_button().setFocusable(true);

			resetDir_unlock_button();
		}
		return dir_unlock_button;
	}

	public void resetDir_unlock_button() {
		getDir_unlock_button().setBounds(getWidth() - 20, 5, 18, 17);
	}// #end【button元素】

	// #begin 【QTableTree元素】
	public QTableTreeModel getTreeModel() {
		if (treeModel == null) {
			treeModel = new QTableTreeModel();
			treeModel.addListDataListener(new ListDataListener() {

				@Override
				public void intervalRemoved(ListDataEvent e) {
					resetTreeScrollPane();
				}

				@Override
				public void intervalAdded(ListDataEvent e) {
					resetTreeScrollPane();
				}

				@Override
				public void contentsChanged(ListDataEvent e) {
				}
			});

			new IndexAction().loadGameDirTree(treeModel);
		}
		return treeModel;
	}

	public JScrollPane getTreeScrollPane() {
		if (treeScrollPane == null) {
			treeScrollPane = new JScrollPane(getTree());
			treeScrollPane.setBorder(null);

			resetTreeScrollPane();
		}
		return treeScrollPane;
	}

	public void resetTreeScrollPane() {
		int _height = getTree().getModel().getSize()
				* QTableTreeItemUI.UNIT_HEIGHT < getHeight()
				- getDir_bg_up_center_image_panel().getHeight() - 5 ? getTree()
				.getModel().getSize()
				* QTableTreeItemUI.UNIT_HEIGHT : getHeight()
				- getDir_bg_up_center_image_panel().getHeight() - 5;

		getTreeScrollPane().setBounds(5, 58, getWidth() - 10, _height + 5);
	}

	public QTableTreeUI getTree() {
		if (tree == null) {
			tree = new QTableTreeUI(getTreeModel());
			tree.setAutoscrolls(true);

			resetTree();
		}
		return tree;
	}

	public void resetTree() {
		getTree().setBounds(5, 58, getWidth() - 10,
				QTableTreeItemUI.UNIT_HEIGHT);
	}

	// #end 【QTableTree元素】

	// #begin 【Field元素】
	public JTextField getSearch_field() {
		if (search_field == null) {
			search_field = new JTextField(50);
			search_field.setBorder(null);
			search_field.setFocusable(true);

			search_field.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					indexUI.setCursor(new Cursor(Cursor.TEXT_CURSOR));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					indexUI.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			});

			search_field.addFocusListener(new FocusListener() {

				@Override
				public void focusLost(FocusEvent e) {
					if (search_field.getText().equals("")) {
						search_field
								.setText(IndexParams.SEARCH_FIELD_DEFAULT_CONTEXT);
						search_field.setForeground(Color.GRAY);
					}
					getSearchResultBox().setVisible(false);
				}

				@Override
				public void focusGained(FocusEvent e) {
					if (search_field.getText().equals(
							IndexParams.SEARCH_FIELD_DEFAULT_CONTEXT)) {
						search_field.setText("");
						search_field.setForeground(Color.BLACK);
					}
					getSearchResultBox().setVisible(true);
				}
			});

			search_field.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					System.out.println(search_field.getText());
				}
			});

			resetSearch_field();
		}
		return search_field;
	}

	public void resetSearch_field() {
		getSearch_field().setBounds(
				getDir_search_bg_center_image_panel().getX() + 10,
				getDir_search_bg_center_image_panel().getY() + 5,
				getDir_search_bg_center_image_panel().getWidth() - 20,
				getDir_search_bg_center_image_panel().getHeight() - 10);
	}

	// #end 【Field元素】

	public IndexSearchResultBox getSearchResultBox() {
		if (searchResultBox == null) {
			searchResultBox = new IndexSearchResultBox();

			resetSearchResultBox();
			getSearchResultBox().showUI();

			getSearchResultBox().setVisible(false);
		}
		return searchResultBox;
	}

	public void resetSearchResultBox() {
		int _height = getSearchResultBox().getListModel().getSize()
				* getSearchResultBox().getListResult().getFixedCellHeight();

		getSearchResultBox().setBounds(
				4,
				50,
				295,
				_height
						+ getSearchResultBox().getDir_list_info_label()
								.getHeight() + 10);

	}
}
