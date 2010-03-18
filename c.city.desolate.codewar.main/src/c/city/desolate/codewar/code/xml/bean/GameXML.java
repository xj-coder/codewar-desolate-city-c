package c.city.desolate.codewar.code.xml.bean;

public class GameXML {
	private String name;
	private String GID;
	private String category;
	private int category_order;
	private int order;
	private String index_url;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGID() {
		return GID;
	}
	public void setGID(String gid) {
		GID = gid;
	}
	public String getIndex_url() {
		return index_url;
	}
	public void setIndex_url(String index_url) {
		this.index_url = index_url;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getCategory_order() {
		return category_order;
	}
	public void setCategory_order(int category_order) {
		this.category_order = category_order;
	}
	
}
