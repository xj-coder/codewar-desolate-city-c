package platform.ui.index;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
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
import platform.define.IndexUIDefine;
import platform.tools.ImageFactory;
import platform.tools.ImageTools;
import platform.tools.Tools;
import platform.ui.widget.WidgetFactory;

import com.sun.awt.AWTUtilities;

public class IndexUI extends JFrame {

	private static final long serialVersionUID = 5192639441087069602L;

	@SuppressWarnings("unused")
	private PlayerBean player;// 用户Bean

	// #begin【背景图Label】
	private JLabel bg_up_left_label;
	private JLabel bg_up_center_label;
	private JLabel bg_up_right_label;
	private JLabel bg_center_label;
	private JLabel bg_right_label;
	private JLabel bg_left_label;
	private JLabel bg_down_center_label;
	private JLabel bg_down_left_label;
	private JLabel bg_down_right_label;
	// #end【背景图Label】

	// #begin【目录树收缩splitter】
	private JButton search_left_splitter_button;
	private JButton search_right_splitter_button;
	// #end【目录树收缩splitter】

	private IndexHeadUI headUI;// 头部
	private IndexDirTreeUI dirTreeUI;// 左侧目录树
	private IndexTabbedPane tabbedPane;// 右侧选项卡组件

	private Dimension historySize = IndexUIDefine.MINIMUM_SIZE;// 用来记录窗体的历史大小,供还原按钮使用

	// #begin【事件监听器】
	private IndexActionAdapter actionAdapter = new IndexActionAdapter(this);// 按钮事件
	private UIMouseDragAdapter dragAdapter = new UIMouseDragAdapter(this);// 鼠标拖动事件
	private UIDoubleClockTitleAdapter doubleClockTitleAdapter = new UIDoubleClockTitleAdapter(this);// 鼠标双击窗体头部事件
	// #end【事件监听器】

	private boolean isMax = true;// 是否最大化

	public IndexUI(PlayerBean player) {
		this.player = player;
		initComponents();
	}

	/**
	 * 设置窗体基本属性,初始化窗体元素
	 */
	private void initComponents() {
		// 设置整个窗体大小
		Dimension screenSize = Tools.getScreenSize();
		Insets screenInsets = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
		setSize(screenSize.width - screenInsets.left - screenInsets.right, screenSize.height - screenInsets.top - screenInsets.bottom);
		setMinimumSize(IndexUIDefine.MINIMUM_SIZE);
		setMaximumSize(new Dimension(screenSize.width - screenInsets.left - screenInsets.right, screenSize.height - screenInsets.top - screenInsets.bottom));

		// 头部
		getLayeredPane().add(getHeadUI(), new Integer(Integer.MIN_VALUE));

		// 左侧目录树
		getLayeredPane().add(getDirTreeUI(), new Integer(Integer.MIN_VALUE));

		// 目录树收缩splitter
		getLayeredPane().add(getSearch_left_splitter_button(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getSearch_right_splitter_button(), new Integer(Integer.MIN_VALUE));

		// 右侧选项卡
		getLayeredPane().add(getTabbedPane(), new Integer(Integer.MIN_VALUE));

		// 背景图
		getLayeredPane().add(getBg_center_label(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getBg_left_label(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getBg_right_label(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getBg_down_center_label(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getBg_down_left_label(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getBg_down_right_label(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getBg_up_center_label(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getBg_up_left_label(), new Integer(Integer.MIN_VALUE));
		getLayeredPane().add(getBg_up_right_label(), new Integer(Integer.MIN_VALUE));

		// 设置ContentPane透明
		((JPanel) getContentPane()).setOpaque(false);

		// 设置无边框
		setUndecorated(true);
		// 设置可改变大小的,在使用了setUndecorated(true)之后,setResizable(true)是无效的,这里使用只是为了说明他是可改变大小的,改变大小的事件处理由自己完成
		setResizable(true);
		// 监听鼠标双击窗体头部事件
		addMouseListener(doubleClockTitleAdapter);
	}

	/**
	 * 显示窗体
	 */
	public void showMe() {
		setVisible(true);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AWTUtilities.setWindowShape(IndexUI.this, new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 12, 12));// 圆角
				// AWTUtilities.setWindowOpacity(IndexUI.this, 0.93f);//窗体透明度
			}
		});
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
	}// #end【双缓冲技术】

	/**
	 * 作用:重新排列所有相对位置的元素 <BR>
	 * 
	 * 调用情况:当整个窗体发生大小变化时
	 */
	public void resetAllComponents() {
		resetBg_up_center_label();
		resetBg_up_right_label();
		resetBg_down_left_label();
		resetBg_down_center_label();
		resetBg_down_right_label();
		resetBg_left_label();
		resetBg_center_label();
		resetBg_right_label();

		resetDirTreeUI();
		resetHeaUI();
		resetTabbedPane();

		resetSearch_left_splitter_button();
		resetSearch_right_splitter_button();
	}

	// #begin【背景label】
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
	}// #end【背景label】

	// #begin【目录树收缩splitter】
	public JButton getSearch_left_splitter_button() {
		if (search_left_splitter_button == null) {
			search_left_splitter_button = WidgetFactory.createIndexLeftSplitterButton(9, 80, "", IndexParams.ACTION_HIDE_SEARCH_DIR, actionAdapter);

			resetSearch_left_splitter_button();
		}
		return search_left_splitter_button;
	}

	public void resetSearch_left_splitter_button() {
		getSearch_left_splitter_button().setBounds(getDirTreeUI().getWidth() + 4, (getHeight() - 100) / 2 - 80 / 2 + 100, 9, 80);
	}

	public JButton getSearch_right_splitter_button() {
		if (search_right_splitter_button == null) {
			search_right_splitter_button = WidgetFactory.createIndexRightSplitterButton(9, 80, "", IndexParams.ACTION_SHOW_SEARCH_DI, actionAdapter);
			search_right_splitter_button.setVisible(false);

			resetSearch_right_splitter_button();
		}
		return search_right_splitter_button;
	}

	public void resetSearch_right_splitter_button() {
		getSearch_right_splitter_button().setBounds(1, (getHeight() - 100) / 2 - 80 / 2 + 100, 9, 80);
	}// #end【目录树收缩splitter】

	// #begin【目录树】
	public IndexDirTreeUI getDirTreeUI() {
		if (dirTreeUI == null) {
			dirTreeUI = new IndexDirTreeUI(this);
			resetDirTreeUI();
			getDirTreeUI().showUI();
		}
		return dirTreeUI;
	}

	public void resetDirTreeUI() {
		getDirTreeUI().setBounds(5, 95, 305, getHeight() - 100);
	}// #end【目录树】

	// #begin【头部】
	public IndexHeadUI getHeadUI() {
		if (headUI == null) {
			headUI = new IndexHeadUI(this);
			resetHeaUI();
			getHeadUI().showUI();
		}
		return headUI;
	}

	public void resetHeaUI() {
		getHeadUI().setBounds(0, 0, getWidth(), 100);
	}// #end【头部】

	// #begin 【选项卡】
	public IndexTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new IndexTabbedPane();

			resetTabbedPane();
		}
		return tabbedPane;
	}

	public void resetTabbedPane() {
		int tmpX = getDirTreeUI().getX() + getDirTreeUI().getWidth() + 10;
		getTabbedPane().setBounds(tmpX, getDirTreeUI().getY(), getWidth() - tmpX - 5, getHeight() - getDirTreeUI().getY() - 5);
	}

	public void maxTabbedPane() {
		getTabbedPane().setBounds(10, getDirTreeUI().getY(), getWidth() - 10 - 5, getHeight() - getDirTreeUI().getY() - 5);
	}

	// #end 【选项卡】

	// #begin【getter and setter】
	public Dimension getHistorySize() {
		return historySize;
	}

	public void setHistorySize(Dimension historySize) {
		this.historySize = historySize;
	}

	public UIMouseDragAdapter getDragAdapter() {
		return dragAdapter;
	}

	public IndexActionAdapter getActionAdapter() {
		return actionAdapter;
	}

	public boolean isMax() {
		return isMax;
	}

	public void setMax(boolean isMax) {
		this.isMax = isMax;
	}// #end【getter and setter】

	// Main test
	public static void main(String[] args) {
		new IndexUI(new PlayerBean()).showMe();
	}
}
