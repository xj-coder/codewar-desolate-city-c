package platform.ui.index;

/**
 * 自定义选项卡组件
 */
import java.util.ArrayList;

import javax.swing.JTabbedPane;

import platform.bean.GameBean;
import platform.bean.PlayerBean;
import platform.ui.index.page.GameRoomTab;
import platform.ui.index.page.IndexPageTab;

public class IndexTabbedPane extends JTabbedPane {

	private static final long serialVersionUID = -7604196421802833735L;

	private IndexPageTab indexPageTab;
	private ArrayList<GameRoomTab> gameRoomTabs = new ArrayList<GameRoomTab>();

	public IndexTabbedPane() {
		setBorder(null);
		openIndexTab();
	}

	/**
	 * 打开首页Tab
	 */
	public void openIndexTab() {
		if (indexPageTab == null) {
			indexPageTab = new IndexPageTab();
			addTab(indexPageTab.getTitle() + "1", indexPageTab.getTitleIcon(), indexPageTab);
		}
	}

	/**
	 *打开指定游戏房间Tab
	 */
	public void openGameRoomTab(PlayerBean playerBean, GameBean gameBean) {

	}
}
