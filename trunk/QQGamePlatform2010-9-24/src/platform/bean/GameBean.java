package platform.bean;

public class GameBean {
	private String gid;// 游戏唯一标示
	private String show_name;// 游戏名
	private String max_player;// 游戏最大人数
	private String min_player;// 游戏最小人数
	private String order;// 游戏排序
	private String category;// 游戏分类
	private String index_url;// 游戏主页地址
	private String download_url;// 游戏jar下载地址

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getShow_name() {
		return show_name;
	}

	public void setShow_name(String showName) {
		show_name = showName;
	}

	public String getMax_player() {
		return max_player;
	}

	public void setMax_player(String maxPlayer) {
		max_player = maxPlayer;
	}

	public String getMin_player() {
		return min_player;
	}

	public void setMin_player(String minPlayer) {
		min_player = minPlayer;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
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

	@Override
	public String toString() {
		return show_name;
	}

}
