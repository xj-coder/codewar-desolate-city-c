package platform.action;

import platform.ui.widget.bean.QTableTreeItem;
import platform.ui.widget.model.QTableTreeModel;

public class IndexAction {

	public void loadGameDirTree(QTableTreeModel model) {

		// #begin test

		QTableTreeItem t1 = new QTableTreeItem("1111", false, false, 1);
		QTableTreeItem t2 = new QTableTreeItem("2222", true, false, 2);
		t1.getChilds().add(t2);

		QTableTreeItem t3 = new QTableTreeItem("3333", false, false, 1);
		QTableTreeItem t4 = new QTableTreeItem("4444", false, false, 2);
		QTableTreeItem t5 = new QTableTreeItem("5555", false, false, 3);
		QTableTreeItem t6 = new QTableTreeItem("6666", false, false, 2);
		QTableTreeItem t7 = new QTableTreeItem("7777", false, false, 3);
		QTableTreeItem t8 = new QTableTreeItem("8888", false, false, 4);
		t3.getChilds().add(t4);
		t3.getChilds().add(t6);
		t6.getChilds().add(t7);
		t7.getChilds().add(t8);
		t4.getChilds().add(t5);

		model.addElement(t1);
		model.addElement(t3);

		// #end test
	}
}
