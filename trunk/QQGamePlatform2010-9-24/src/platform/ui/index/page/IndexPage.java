package platform.ui.index.page;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import platform.adapter.IndexPageAdapter;
import platform.tools.ImageFactory;
import platform.tools.ImageTools;
import platform.ui.widget.ImageLabel;
import platform.ui.widget.factory.WidgetFactory;

public class IndexPage extends Page {

	private static final long serialVersionUID = -5290158585413109951L;

	private Image titleImage;
	private String title = "游戏大厅";

	private JPanel tool_panel;// 工具栏
	private JPanel centerPanel;// 中心面板

	private JButton back_button;// 后退
	private JButton go_button;// 前进
	private JButton close_button;// 关闭
	private JButton refresh_button;// 刷新
	private JButton index_button;// 首页

	private ImageLabel spliter_label;// 分割线

	private IndexPageAdapter adapter = new IndexPageAdapter(this);

	public IndexPage() {
		super();

		initUI();
	}

	private void initUI() {
		setBackground(Color.white);
		setLayout(null);

		add(getTool_panel());
		add(getCenterPanel());
	}

	// #begin【双缓冲技术】
	@Override
	public void paint(Graphics g) {
		System.out.println("paint IndexPage");
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
		resetTool_panel();
		resetCenterPanel();
	}

	public JPanel getTool_panel() {
		if (tool_panel == null) {
			tool_panel = new JPanel();
			tool_panel.setLayout(null);

			tool_panel.add(getBack_button());
			tool_panel.add(getGo_button());
			tool_panel.add(getClose_button());
			tool_panel.add(getRefresh_button());
			tool_panel.add(getSpliter_label());
			tool_panel.add(getIndex_button());

			resetTool_panel();
		}
		return tool_panel;
	}

	public void resetTool_panel() {
		getTool_panel().setBounds(0, 0, getWidth(), 30);
	}

	public JPanel getCenterPanel() {
		if (centerPanel == null) {
			centerPanel = new JPanel();
			centerPanel.setBackground(Color.blue);

			resetCenterPanel();
		}
		return centerPanel;
	}

	public void resetCenterPanel() {
		getCenterPanel().setBounds(0, getTool_panel().getHeight(), getWidth(),
				getHeight() - getTool_panel().getHeight());
	}

	public JButton getBack_button() {
		if (back_button == null) {
			back_button = WidgetFactory.createIndexPageBackButton(20, 20, "",
					IndexPageParams.ACTION_BACK, adapter);

			back_button.setEnabled(false);

			back_button.setBounds(10, 5, 20, 20);
		}
		return back_button;
	}

	public JButton getGo_button() {
		if (go_button == null) {
			go_button = WidgetFactory.createIndexPageGoButton(20, 20, "",
					IndexPageParams.ACTION_GO, adapter);

			go_button.setBounds(40, 5, 20, 20);
		}
		return go_button;
	}

	public JButton getClose_button() {
		if (close_button == null) {
			close_button = WidgetFactory.createIndexPageCloseButton(20, 20, "",
					IndexPageParams.ACTION_CLOSE, adapter);

			close_button.setBounds(70, 5, 20, 20);
		}
		return close_button;
	}

	public JButton getRefresh_button() {
		if (refresh_button == null) {
			refresh_button = WidgetFactory.createIndexPageRefreshButton(20, 20, "",
					IndexPageParams.ACTION_REFRESH, adapter);

			refresh_button.setBounds(100, 5, 20, 20);
		}
		return refresh_button;
	}

	public JButton getIndex_button() {
		if (index_button == null) {
			index_button = WidgetFactory.createIndexPageIndexButton(20, 20, "",
					IndexPageParams.ACTION_INDEX, adapter);

			index_button.setBounds(150, 5, 20, 20);
		}

		return index_button;
	}

	public ImageLabel getSpliter_label() {
		if (spliter_label == null) {
			spliter_label = new ImageLabel(new ImageIcon(ImageFactory.getIndexPageSpliterImage()
					.getScaledInstance(2, 19, Image.SCALE_DEFAULT)));

			spliter_label.setBounds(133, 5, 5, 20);
		}
		return spliter_label;
	}

	@Override
	public Image getTitleImage() {
		titleImage = ImageFactory.getIndexPageTabTitleIcon().getScaledInstance(16, 16,
				Image.SCALE_DEFAULT);
		return titleImage;
	}

	@Override
	public String getTitle() {
		return title;
	}
}
