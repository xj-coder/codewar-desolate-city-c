package c.city.desolate.client.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import org.jdesktop.swingx.JXButton;
import org.jdesktop.swingx.JXFrame;
import org.jdesktop.swingx.JXPanel;

import c.city.desolate.client.error.GameException;
import c.city.desolate.client.properties.ViewProperties;

/**
 * 主界面
 * 
 * @author Desolate.City.C
 */
@SuppressWarnings( { "serial" })
public class MainView extends JXFrame {
	private String language = "Java";// 语言模式
	private String gameNo = "DCC_FiveChess_001";// 游戏编号

	private Game gameView;// 游戏界面
	private Code codeView;// 代码界面

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

	}

	private void initialization() {
		toolBarPanel = getToolBarPanel();
		gameView = getGameView();
		codeView = getCodeView();
		mainPanel = getMainPanel();
	}

	private Game getGameView() {
		if (null == gameView)
			try {
				return Game.getGame(gameNo);
			} catch (GameException e) {
				e.printStackTrace();
			}
		return gameView;
	}

	private Code getCodeView() {
		if (null == codeView)
			try {
				return Code.getCode(language);
			} catch (GameException e) {
				e.printStackTrace();
			}
		return codeView;
	}

	private JXPanel getMainPanel() {
		if (null == mainPanel) {
			JXPanel conterPanel = new JXPanel(new BorderLayout());
			conterPanel.add(gameView);
			conterPanel.add(codeView);

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
