package platform.ui.widget.bean;

import java.util.Vector;

import javax.swing.JComponent;

public class QTableTreeItem extends JComponent {
	private static final long serialVersionUID = -1329277543951092617L;

	private String showName;// 显示名
	private boolean isExpand;// 是否展开
	private int level;// 所在层次
	private int order;// 排序
	private boolean isRollover;// 鼠标是否在上面
	private boolean isSelect;// 是否选择
	private Vector<QTableTreeItem> childs = new Vector<QTableTreeItem>();// 子节点

	private Object userObject;

	public QTableTreeItem() {
	}

	public QTableTreeItem(Object userObject, boolean isExpand, int order) {
		super();
		this.userObject = userObject;
		this.showName = userObject.toString();
		this.isExpand = isExpand;
		this.order = order;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public boolean isExpand() {
		return isExpand;
	}

	public void setExpand(boolean isExpand) {
		this.isExpand = isExpand;
	}

	public void addQTableTreeItem(QTableTreeItem item) {
		item.setLevel(getLevel() == 0 ? 0 : (getLevel() + 1));

		boolean added = false;
		for (int i = 0; i < childs.size(); i++) {
			if (childs.get(i).getOrder() > item.getOrder()) {
				childs.add(i, item);
				added = true;
				break;
			}
		}
		if (!added) {
			childs.add(item);
		}

	}

	public int getChildCount() {
		return childs.size();
	}

	public QTableTreeItem getItemAt(int index) {
		return childs.get(index);
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int level) {
		this.order = level;
	}

	public boolean isRollover() {
		return isRollover;
	}

	public void setRollover(boolean isRollover) {
		this.isRollover = isRollover;
	}

	public boolean isSelect() {
		return isSelect;
	}

	public void setSelect(boolean isSelect) {
		this.isSelect = isSelect;
	}

	public Object getUserObject() {
		return userObject;
	}

	public void setUserObject(Object userObject) {
		this.userObject = userObject;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;

		for (int i = 0; i < getChildCount(); i++) {
			getItemAt(i).setLevel(
					(getItemAt(i).getLevel() == 0 ? 1 : getItemAt(i).getLevel()) + getLevel());
		}
	}

}
