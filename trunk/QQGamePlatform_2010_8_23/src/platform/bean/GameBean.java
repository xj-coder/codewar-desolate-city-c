package platform.bean;

import javax.swing.Icon;

public class GameBean {
	private String id;// 游戏唯一标示
	private String name;// 游戏名
	private int max_player;// 游戏最大人数
	private int min_player;// 游戏最小人数
	private String main_class;// 游戏入口类
	private Icon game_icon;// 游戏图标
	private Icon wait_game_icon;// 游戏等待图标
	private Icon begin_game_icon;// 游戏开始图标

	private String category;// 游戏分类
	private String index_url;// 游戏主页地址
	private String download_url;// 游戏jar下载地址

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMax_player() {
		return max_player;
	}

	public void setMax_player(int maxPlayer) {
		max_player = maxPlayer;
	}

	public int getMin_player() {
		return min_player;
	}

	public void setMin_player(int minPlayer) {
		min_player = minPlayer;
	}

	public String getMain_class() {
		return main_class;
	}

	public void setMain_class(String mainClass) {
		main_class = mainClass;
	}

	public Icon getGame_icon() {
		return game_icon;
	}

	public void setGame_icon(Icon gameIcon) {
		game_icon = gameIcon;
	}

	public Icon getWait_game_icon() {
		return wait_game_icon;
	}

	public void setWait_game_icon(Icon waitGameIcon) {
		wait_game_icon = waitGameIcon;
	}

	public Icon getBegin_game_icon() {
		return begin_game_icon;
	}

	public void setBegin_game_icon(Icon beginGameIcon) {
		begin_game_icon = beginGameIcon;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getIndex_url() {
		return index_url;
	}

	public void setIndex_url(String indexUrl) {
		index_url = indexUrl;
	}

	public String getDownload_url() {
		return download_url;
	}

	public void setDownload_url(String downloadUrl) {
		download_url = downloadUrl;
	}

}
