package platform.ui.widget.model;

import java.util.ArrayList;

import javax.swing.AbstractListModel;

import platform.ui.widget.bean.QTableTreeItem;

public class QTableTreeModel extends AbstractListModel {
	private static final long serialVersionUID = -1763244150717694103L;

	ArrayList<QTableTreeItem> items = new ArrayList<QTableTreeItem>();

	@Override
	public Object getElementAt(int index) {
		return items.get(index);
	}

	@Override
	public int getSize() {
		return items.size();
	}

	public void addElement(QTableTreeItem item) {

		int index = items.size();
		items.add(item);
		fireIntervalAdded(this, index, index);
	}

	public void addElement(int index, QTableTreeItem item) {
		items.add(index, item);
		fireIntervalAdded(this, index, index);
	}

	public boolean removeElement(QTableTreeItem item) {
		int index = indexOf(item);
		boolean rv = items.remove(item);
		if (index >= 0) {
			fireIntervalRemoved(this, index, index);
		}
		return rv;
	}

	public boolean removeElement(int index) {
		QTableTreeItem item = items.remove(index);
		if (item != null) {
			fireIntervalRemoved(this, index, index);
		}
		return item != null;
	}

	public int indexOf(QTableTreeItem o) {
		return items.indexOf(o);
	}
}
