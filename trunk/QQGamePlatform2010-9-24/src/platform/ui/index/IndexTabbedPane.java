package platform.ui.index;

/**
 * 自定义选项卡组件
 */
import java.util.ArrayList;

import javax.swing.JTabbedPane;

import platform.bean.GameBean;
import platform.bean.PlayerBean;
import platform.ui.index.page.IndexPage;
import platform.ui.index.page.RoomPage;

public class IndexTabbedPane extends JTabbedPane {

	private static final long serialVersionUID = -7604196421802833735L;

	private IndexPage indexPage;
	private ArrayList<RoomPage> roomPages = new ArrayList<RoomPage>();

	public IndexTabbedPane() {
		setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

		openIndexTab();
	}

	/**
	 * 打开首页Tab
	 */
	public void openIndexTab() {
		addTab(getIndexPageTab().getTitle(), getIndexPageTab().getTitleIcon(), getIndexPageTab());
		addTab(getIndexPageTab().getTitle(), new IndexPage().getTitleIcon(), new IndexPage());
		addTab(getIndexPageTab().getTitle(), new IndexPage().getTitleIcon(), new IndexPage());
		addTab(getIndexPageTab().getTitle(), new IndexPage().getTitleIcon(), new IndexPage());
		addTab(getIndexPageTab().getTitle(), new IndexPage().getTitleIcon(), new IndexPage());
		addTab(getIndexPageTab().getTitle(), new IndexPage().getTitleIcon(), new IndexPage());
		addTab(getIndexPageTab().getTitle(), new IndexPage().getTitleIcon(), new IndexPage());
		// addTab(getIndexPageTab().getTitle(), new IndexPage().getTitleIcon(),
		// new IndexPage());
		// addTab(getIndexPageTab().getTitle(), new IndexPage().getTitleIcon(),
		// new IndexPage());
		// addTab(getIndexPageTab().getTitle(), new IndexPage().getTitleIcon(),
		// new IndexPage());
		// addTab(getIndexPageTab().getTitle(), new IndexPage().getTitleIcon(),
		// new IndexPage());
		// addTab(getIndexPageTab().getTitle(), new IndexPage().getTitleIcon(),
		// new IndexPage());
		// addTab(getIndexPageTab().getTitle(), new IndexPage().getTitleIcon(),
		// new IndexPage());
		// addTab(getIndexPageTab().getTitle(), new IndexPage().getTitleIcon(),
		// new IndexPage());
		// addTab(getIndexPageTab().getTitle(), new IndexPage().getTitleIcon(),
		// new IndexPage());
		// addTab(getIndexPageTab().getTitle(), new IndexPage().getTitleIcon(),
		// new IndexPage());
		// addTab(getIndexPageTab().getTitle(), new IndexPage().getTitleIcon(),
		// new IndexPage());
		// addTab(getIndexPageTab().getTitle(), new IndexPage().getTitleIcon(),
		// new IndexPage());
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
		if (indexPage == null) {
			indexPage = new IndexPage();
		}
		return indexPage;
	}

	public void setIndexPageTab(IndexPage indexPageTab) {
		this.indexPage = indexPageTab;
	}
}
