package platform.ui.widget.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import platform.ui.widget.bean.QTableTreeItem;

public class QTableTreeMouseAdapter extends MouseAdapter {
	private QTableTree tableTreeUI;

	private int oldIndex = -1;

	public QTableTreeMouseAdapter(QTableTree tableTreeUI) {
		this.tableTreeUI = tableTreeUI;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (tableTreeUI.getModel().getSize() <= 0) {
			return;
		}

		int index = tableTreeUI.locationToIndex(e.getPoint());
		QTableTreeModel treeModel = (QTableTreeModel) tableTreeUI.getModel();
		QTableTreeItem item = (QTableTreeItem) tableTreeUI.getModel().getElementAt(index);

		if (!item.isExpand()) {
			if (item.getChildCount() > 0) {
				for (int i = 0; i < item.getChildCount(); i++) {
					treeModel.addElement(index + 1 + i, item.getItemAt(i));
					// treeModel.addElement(item.getItemAt(i));
					openAll(item.getItemAt(i));
				}
			}
			item.setExpand(!item.isExpand());
		} else {
			if (item.getChildCount() > 0) {
				for (int i = 0; i < item.getChildCount(); i++) {
					// item.getChildCount().get(i).setExpand(!item.getChildCount().get(i).isExpand());
					closeAll(item.getItemAt(i));
					treeModel.removeElement(item.getItemAt(i));
				}
			}
			item.setExpand(!item.isExpand());
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (tableTreeUI.getModel().getSize() <= 0) {
			return;
		}

		((QTableTreeItem) tableTreeUI.getModel().getElementAt(oldIndex)).setRollover(false);

		tableTreeUI.updateUI();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if (tableTreeUI.getModel().getSize() <= 0) {
			return;
		}

		int index = tableTreeUI.locationToIndex(e.getPoint());

		if (oldIndex != index) {
			if (oldIndex == -1) {
				oldIndex = index;
			} else {
				((QTableTreeItem) tableTreeUI.getModel().getElementAt(oldIndex)).setRollover(false);
			}
		}
		((QTableTreeItem) tableTreeUI.getModel().getElementAt(index)).setRollover(true);
		oldIndex = index;

		tableTreeUI.updateUI();
	}

	private void closeAll(QTableTreeItem item) {

		QTableTreeModel treeModel = (QTableTreeModel) tableTreeUI.getModel();

		if (item.isExpand()) {
			if (item.getChildCount() > 0) {
				for (int i = 0; i < item.getChildCount(); i++) {
					closeAll(item.getItemAt(i));
					treeModel.removeElement(item.getItemAt(i));
				}
			}
		}
	}

	private void openAll(QTableTreeItem item) {

		QTableTreeModel treeModel = (QTableTreeModel) tableTreeUI.getModel();
		int index = treeModel.indexOf(item);

		if (item.isExpand()) {
			if (item.getChildCount() > 0) {
				for (int i = 0; i < item.getChildCount(); i++) {
					treeModel.addElement(index + 1 + i, item.getItemAt(i));
					// treeModel.addElement(item.getItemAt(i));
					openAll(item.getItemAt(i));
				}
			}
		}
	}
}
