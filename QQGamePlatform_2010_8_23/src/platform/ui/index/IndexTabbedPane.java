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
		openIndexTab();
	}

	/**
	 * 打开首页Tab
	 */
	public void openIndexTab() {
		addTab(getIndexPageTab().getTitle(), getIndexPageTab().getTitleIcon(),
				getIndexPageTab());
	}

	/**
	 *打开指定游戏房间Tab
	 */
	public void openGameRoomTab(PlayerBean playerBean, GameBean gameBean) {

	}

	/**
	 *关闭指定游戏房间Tab
	 */
	public boolean closeGameRoomTab(GameBean gameBean) {

		return false;
	}

	public IndexPageTab getIndexPageTab() {
		if (indexPageTab == null) {
			indexPageTab = new IndexPageTab();
		}
		return indexPageTab;
	}

	public void setIndexPageTab(IndexPageTab indexPageTab) {
		this.indexPageTab = indexPageTab;
	}
}
