package c.city.desolate.codewar.code.ui.bean;

import java.util.List;

public class GameEO implements GameTreeElement{
	private String name;
	private String GID;
	private String category;
	private int order;
	private String indexUrl;

	//无效
	@Override
	public int getCategoryOrder() {
		return 0;
	}

	//无效
	@Override
	public List<GameTreeElement> getChildren() {
		return null;
	}

	@Override
	public boolean hasChildren() {
		return false;
	}

	@Override
	public String getGID() {
		return GID;
	}

	@Override
	public String getIndexUrl() {
		return indexUrl;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getOrder() {
		return order;
	}


	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setIndex_url(String indexUrl) {
		this.indexUrl = indexUrl;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGID(String gid) {
		GID = gid;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	@Override
	public int compareTo(Object o) {
		return order - ((GameEO)o).getOrder();
	}
	
}
