package platform.adapter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import platform.bean.GameBean;
import platform.ui.index.IndexUI;
import platform.ui.widget.bean.QTableTreeItem;

public class IndexDirTreeAdapter extends MouseAdapter {

	private IndexUI indexUI;

	public IndexDirTreeAdapter(IndexUI indexUI) {
		this.indexUI = indexUI;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int index = indexUI.getDirTreeUI().getTree().locationToIndex(e.getPoint());

		QTableTreeItem item = (QTableTreeItem) indexUI.getDirTreeUI().getTree().getModel()
				.getElementAt(index);

		if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {
			Object obj = item.getUserObject();
			if (obj instanceof GameBean) {
				indexUI.getTabbedPane().openGameRoomTab((GameBean) obj);
			}
		}

		super.mouseClicked(e);
	}
}
