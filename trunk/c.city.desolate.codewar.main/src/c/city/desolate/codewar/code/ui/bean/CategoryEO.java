package c.city.desolate.codewar.code.ui.bean;

import java.util.ArrayList;
import java.util.List;

public class CategoryEO implements GameTreeElement{
	private String name;
	private int categoryOrder;
	private List<GameTreeElement> games = new ArrayList<GameTreeElement>();
	@Override
	public int getCategoryOrder() {
		return categoryOrder;
	}

	@Override
	public List<GameTreeElement> getChildren() {
		return games;
	}
	
	@Override
	public boolean hasChildren() {
		return true;
	}

	//无效
	@Override
	public String getGID() {
		return null;
	}
	//无效
	@Override
	public String getIndexUrl() {
		return null;
	}

	@Override
	public String getName() {
		return name;
	}
	//无效
	@Override
	public int getOrder() {
		return 0;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCategoryOrder(int categoryOrder) {
		this.categoryOrder = categoryOrder;
	}

	@Override
	public int compareTo(Object o) {
		return categoryOrder - ((CategoryEO)o).getCategoryOrder();
	}
}
