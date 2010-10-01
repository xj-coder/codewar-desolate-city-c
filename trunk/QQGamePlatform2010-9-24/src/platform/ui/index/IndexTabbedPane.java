package platform.ui.index;

/**
 * 自定义选项卡组件
 */
import java.awt.Color;
import java.util.ArrayList;

import platform.bean.GameBean;
import platform.bean.PlayerBean;
import platform.ui.index.page.IndexPage;
import platform.ui.index.page.RoomPage;
import platform.ui.widget.ui.QTabbedPane;

public class IndexTabbedPane extends QTabbedPane {

	private static final long serialVersionUID = -7604196421802833735L;

	private IndexPage indexPage;
	private final ArrayList<RoomPage> roomPages = new ArrayList<RoomPage>();

	public IndexTabbedPane() {
		super();
	}

	/**
	 * 打开首页Tab
	 */
	public void openIndexTab() {
		// addTab(getIndexPageTab().getTitle(),
		// getIndexPageTab().getTitleImage(),
		// getIndexPageTab());
		IndexPage indexPage1 = new IndexPage();
		indexPage1.setBackground(Color.red);
		addTab("游戏大厅", getIndexPageTab().getTitleImage(), indexPage1);
		IndexPage indexPage2 = new IndexPage();
		indexPage2.setBackground(Color.gray);
		addTab("欢乐斗地主", getIndexPageTab().getTitleImage(), indexPage2);
		IndexPage indexPage3 = new IndexPage();
		indexPage3.setBackground(Color.green);
		addTab("欢乐斗地主", getIndexPageTab().getTitleImage(), indexPage3);
		IndexPage indexPage4 = new IndexPage();
		indexPage4.setBackground(Color.black);
		addTab("五子棋", getIndexPageTab().getTitleImage(), indexPage4);
		IndexPage indexPage5 = new IndexPage();
		indexPage5.setBackground(Color.blue);
		addTab("五子棋", getIndexPageTab().getTitleImage(), indexPage5);
		IndexPage indexPage6 = new IndexPage();
		indexPage6.setBackground(Color.yellow);
		addTab("QQ龙珠", getIndexPageTab().getTitleImage(), indexPage6);
		IndexPage indexPage7 = new IndexPage();
		indexPage7.setBackground(Color.cyan);
		addTab("QQ龙珠", getIndexPageTab().getTitleImage(), indexPage7);
		IndexPage indexPage8 = new IndexPage();
		indexPage8.setBackground(Color.orange);
		addTab("火拼俄罗斯", getIndexPageTab().getTitleImage(), indexPage8);
		IndexPage indexPage9 = new IndexPage();
		indexPage9.setBackground(Color.pink);
		addTab("火拼俄罗斯", getIndexPageTab().getTitleImage(), indexPage9);
		IndexPage indexPage10 = new IndexPage();
		indexPage10.setBackground(Color.darkGray);
		addTab("火拼泡泡龙", getIndexPageTab().getTitleImage(), indexPage10);
		IndexPage indexPage11 = new IndexPage();
		indexPage11.setBackground(Color.white);
		addTab("火拼泡泡龙", getIndexPageTab().getTitleImage(), indexPage11);
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
