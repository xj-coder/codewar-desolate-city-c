package c.city.desolate.client.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import org.jdesktop.swingx.JXButton;
import org.jdesktop.swingx.JXFrame;
import org.jdesktop.swingx.JXPanel;

import c.city.desolate.client.compilate.AbstractCompilate;
import c.city.desolate.client.error.GameException;
import c.city.desolate.client.ides.AbstractIDE;
import c.city.desolate.client.properties.ViewProperties;

/**
 * 主界面
 * 
 * @author Desolate.City.C
 */
@SuppressWarnings( { "serial" })
public class MainView extends JXFrame {
	public static String LANGUAGE = "Java";// 语言模式
	public static String IDEMODEL = "Default";// 语言模式
	public static String GAMENO = "DCC_FiveChess_001";// 游戏编号

	private Game gameView;// 游戏界面
	private AbstractIDE IDE = Code.ide;// 代码界面
	private AbstractCompilate compilate = Code.compilate;// 编译器

	private JXPanel mainPanel;// 主界面
	private JXPanel toolBarPanel;// 工具栏界面

	// private JXStatusBar statusBar;// 状态栏

	public MainView() {
		initialization();
		showMe();
	}

	private void showMe() {
		this.setContentPane(mainPanel);
		this.setSize(ViewProperties.MAINVIEW_DIMENSION);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);

		// 显示初始代码
		compilate.initialization();
	}

	private void initialization() {
		toolBarPanel = getToolBarPanel();
		gameView = getGameView();
		mainPanel = getMainPanel();
	}

	private Game getGameView() {
		if (null == gameView)
			try {
				gameView = Game.getGame();
			} catch (GameException e) {
				e.printStackTrace();
			}
		return gameView;
	}

	private JXPanel getMainPanel() {
		if (null == mainPanel) {
			JXPanel conterPanel = new JXPanel(new BorderLayout());
			conterPanel.add(gameView, BorderLayout.WEST);
			conterPanel.add(IDE, BorderLayout.CENTER);

			mainPanel = new JXPanel(new BorderLayout(), true);
			mainPanel.add(toolBarPanel, BorderLayout.NORTH);
			mainPanel.add(conterPanel, BorderLayout.CENTER);
		}
		return mainPanel;
	}

	private JXPanel getToolBarPanel() {
		if (null == toolBarPanel) {
			toolBarPanel = new JXPanel(new FlowLayout(FlowLayout.LEFT,
					ViewProperties.MAINVIEW_TOOLBAR_HGAP,
					ViewProperties.MAINVIEW_TOOLBAR_VGAP));
			// Test
			toolBarPanel.add(new JXButton("配置"));
			toolBarPanel.add(new JXButton("退出"));
		}
		return toolBarPanel;
	}
}
