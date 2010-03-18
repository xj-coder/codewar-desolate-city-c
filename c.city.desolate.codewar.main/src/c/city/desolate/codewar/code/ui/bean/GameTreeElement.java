package c.city.desolate.codewar.code.ui.bean;

import java.util.List;

public interface GameTreeElement extends Comparable{
	public String getName();
	public String getGID();
	public String getIndexUrl();
	public int getOrder();
	public int getCategoryOrder();
	public List<GameTreeElement> getChildren();
	public boolean hasChildren();
}
