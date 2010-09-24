package platform.action;

import platform.ui.widget.bean.QTableTreeItem;
import platform.ui.widget.model.QTableTreeModel;
import platform.ui.widget.ui.QTableTreeUI;

public class IndexAction {

	/**
	 * 从服务器载入游戏列表，并更新到树上
	 * 
	 * @param tree
	 */
	public void loadGameDirTree(final QTableTreeUI tree) {
		QTableTreeModel tableTreeModel = null;
		if (tree.getModel() instanceof QTableTreeModel) {
			tableTreeModel = (QTableTreeModel) tree.getModel();
		}

		QTableTreeItem t1 = new QTableTreeItem("1111", false, false, 1);
		QTableTreeItem t2 = new QTableTreeItem("2222", true, false, 2);
		t1.getChilds().add(t2);

		QTableTreeItem t3 = new QTableTreeItem("3333", false, false, 1);
		QTableTreeItem t4 = new QTableTreeItem("4444", true, false, 2);
		QTableTreeItem t5 = new QTableTreeItem("5555", false, false, 3);
		QTableTreeItem t6 = new QTableTreeItem("6666", true, false, 2);
		QTableTreeItem t7 = new QTableTreeItem("7777", false, false, 3);
		QTableTreeItem t8 = new QTableTreeItem("8888", false, false, 4);
		t3.getChilds().add(t4);
		t3.getChilds().add(t6);
		t6.getChilds().add(t7);
		t7.getChilds().add(t8);
		t4.getChilds().add(t5);

		tableTreeModel.addElement(t1);
		// tableTreeModel.addElement(t2);
		tableTreeModel.addElement(t3);
	}
}
