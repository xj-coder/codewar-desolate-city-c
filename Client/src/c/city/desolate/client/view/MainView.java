package c.city.desolate.client.view;

import static c.city.desolate.client.view.Code.IDE;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import org.jdesktop.swingx.JXButton;
import org.jdesktop.swingx.JXFrame;
import org.jdesktop.swingx.JXPanel;

import c.city.desolate.client.actiom.CodeAction;
import c.city.desolate.client.error.GameException;
import c.city.desolate.client.main.Config;
import c.city.desolate.client.properties.ViewProperties;
import c.city.desolate.client.xml.bean.GameXML;
import c.city.desolate.client.xml.bean.InitSrcXML;
import c.city.desolate.client.xml.parse.GameXMLParse;

/**
 * 主界面
 * 
 * @author Desolate.City.C
 */
@SuppressWarnings( { "serial" })
public class MainView extends JXFrame {
	private Game gameView;// 游戏界面

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
		GameXML gamesXML = GameXMLParse.getGames().get(Config.GAMENO);
		InitSrcXML initSrcXML = gamesXML.getInitSrcs().get(Config.LANGUAGE);
		IDE.iniEditorBox(initSrcXML.getPath());

		IDE.registerReadyBtnActionListener(CodeAction.ready());
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
