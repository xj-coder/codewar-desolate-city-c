package platform.ui.index;

/**
 * 自定义选项卡组件
 */
import java.util.ArrayList;

import javax.swing.JTabbedPane;

import platform.bean.GameBean;
import platform.bean.PlayerBean;
import platform.ui.index.page.RoomPage;
import platform.ui.index.page.IndexPage;

public class IndexTabbedPane extends JTabbedPane {

	private static final long serialVersionUID = -7604196421802833735L;

	private IndexPage indexPageTab;
	private ArrayList<RoomPage> gameRoomTabs = new ArrayList<RoomPage>();

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

	public IndexPage getIndexPageTab() {
		if (indexPageTab == null) {
			indexPageTab = new IndexPage();
		}
		return indexPageTab;
	}

	public void setIndexPageTab(IndexPage indexPageTab) {
		this.indexPageTab = indexPageTab;
	}
}
