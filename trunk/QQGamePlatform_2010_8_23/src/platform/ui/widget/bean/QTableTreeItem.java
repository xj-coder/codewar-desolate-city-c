package platform.ui.widget.bean;

import java.util.ArrayList;

public class QTableTreeItem {
	private String showName;// 显示名
	private boolean isExpand;// 是否展开
	private boolean isInstall;// 是否安装
	private int level;// 所在的层级
	private boolean isRollover;// 鼠标是否在上面
	private boolean isSelect;// 是否选择
	private ArrayList<QTableTreeItem> childs = new ArrayList<QTableTreeItem>();// 子节点

	public QTableTreeItem() {
	}

	public QTableTreeItem(String showName, boolean isExpand, boolean isInstall, int level) {
		super();
		this.showName = showName;
		this.isExpand = isExpand;
		this.isInstall = isInstall;
		this.level = level;
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

	public boolean isInstall() {
		return isInstall;
	}

	public void setInstall(boolean isInstall) {
		this.isInstall = isInstall;
	}

	public ArrayList<QTableTreeItem> getChilds() {
		return childs;
	}

	public void setChilds(ArrayList<QTableTreeItem> childs) {
		this.childs = childs;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
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

}
