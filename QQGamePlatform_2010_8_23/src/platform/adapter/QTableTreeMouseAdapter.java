package platform.adapter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import platform.ui.widget.bean.QTableTreeItem;
import platform.ui.widget.model.QTableTreeModel;
import platform.ui.widget.ui.QTableTreeUI;

public class QTableTreeMouseAdapter extends MouseAdapter {
	private QTableTreeUI tableTreeUI;

	private int oldIndex = -1;

	public QTableTreeMouseAdapter(QTableTreeUI tableTreeUI) {
		this.tableTreeUI = tableTreeUI;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int index = tableTreeUI.locationToIndex(e.getPoint());
		QTableTreeModel treeModel = (QTableTreeModel) tableTreeUI.getModel();
		QTableTreeItem item = (QTableTreeItem) tableTreeUI.getModel().getElementAt(index);

		if (!item.isExpand()) {
			if (item.getChilds().size() > 0) {
				for (int i = 0; i < item.getChilds().size(); i++) {
					treeModel.addElement(index + 1, item.getChilds().get(i));
					// item.getChilds().get(i).setExpand(!item.getChilds().get(i).isExpand());
					openAll(item.getChilds().get(i));
				}
			}
			item.setExpand(!item.isExpand());
		} else {
			if (item.getChilds().size() > 0) {
				for (int i = 0; i < item.getChilds().size(); i++) {
					// item.getChilds().get(i).setExpand(!item.getChilds().get(i).isExpand());
					closeAll(item.getChilds().get(i));
					treeModel.removeElement(item.getChilds().get(i));
				}
			}
			item.setExpand(!item.isExpand());
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		((QTableTreeItem) tableTreeUI.getModel().getElementAt(oldIndex)).setRollover(false);

		tableTreeUI.updateUI();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
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
			if (item.getChilds().size() > 0) {
				for (int i = 0; i < item.getChilds().size(); i++) {
					closeAll(item.getChilds().get(i));
					// item.getChilds().get(i).setExpand(!item.getChilds().get(i).isExpand());
					treeModel.removeElement(item.getChilds().get(i));
				}
			}
		}
	}

	private void openAll(QTableTreeItem item) {

		QTableTreeModel treeModel = (QTableTreeModel) tableTreeUI.getModel();
		int index = treeModel.indexOf(item);

		if (item.isExpand()) {
			if (item.getChilds().size() > 0) {
				for (int i = 0; i < item.getChilds().size(); i++) {
					treeModel.addElement(index + 1, item.getChilds().get(i));
					openAll(item.getChilds().get(i));
					// item.getChilds().get(i).setExpand(!item.getChilds().get(i).isExpand());
				}
			}
		}
	}
}
