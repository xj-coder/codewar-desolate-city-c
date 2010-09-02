package platform.ui.widget.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import platform.ui.widget.bean.QTableTreeItem;
import platform.ui.widget.model.QTableTreeModel;

public class QTableTreeUI extends JList {

	private static final long serialVersionUID = 234963439260527147L;

	public QTableTreeUI(QTableTreeModel model) {
		super(model);
		setFixedCellWidth(196);
		setFixedCellHeight(20);
		setCellRenderer(new ListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
				QTableTreeItem item = (QTableTreeItem) value;

				if (isSelected) {
					item.setSelect(true);
				} else {
					item.setSelect(false);
				}

				QTableTreeItemUI itemUI = new QTableTreeItemUI(item);

				itemUI.setSize(196, 20);

				itemUI.buildUI();
				return itemUI;
			}
		});
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = locationToIndex(e.getPoint());
				QTableTreeItem item = (QTableTreeItem) getModel().getElementAt(index);
				item.setExpand(!item.isExpand());

				if (!item.isExpand()) {
					closeAll(item);
				} else {
					openAll(item);
				}

			}
		});
		addMouseMotionListener(new MouseAdapter() {
			int oldIndex = -1;

			@Override
			public void mouseMoved(MouseEvent e) {
				int index = locationToIndex(e.getPoint());

				if (oldIndex != index) {
					if (oldIndex == -1) {
						oldIndex = index;
					} else {
						((QTableTreeItem) getModel().getElementAt(oldIndex)).setRollover(false);
					}
				}
				((QTableTreeItem) getModel().getElementAt(index)).setRollover(true);
				oldIndex = index;

				updateUI();
			}
		});
	}

	private void closeAll(QTableTreeItem item) {

		QTableTreeModel treeModel = (QTableTreeModel) getModel();

		if (!item.isExpand()) {
			if (item.getChilds().size() > 0) {
				for (int i = 0; i < item.getChilds().size(); i++) {
					closeAll(item.getChilds().get(i));
					treeModel.removeElement(item.getChilds().get(i));
				}
			}
		}
	}

	private void openAll(QTableTreeItem item) {

		QTableTreeModel treeModel = (QTableTreeModel) getModel();
		int index = treeModel.indexOf(item);

		if (item.isExpand()) {
			if (item.getChilds().size() > 0) {
				for (int i = 0; i < item.getChilds().size(); i++) {
					treeModel.addElement(index + 1, item.getChilds().get(i));
					openAll(item.getChilds().get(i));
				}
			}
		}
	}

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		jf.setSize(500, 500);

		JPanel panel = new JPanel();
		panel.setBackground(Color.red);
		final QTableTreeModel tableTreeModel = new QTableTreeModel();

		QTableTreeUI tableTreeUI = new QTableTreeUI(tableTreeModel);

		QTableTreeItem t1 = new QTableTreeItem("1111", false, false, 1);
		QTableTreeItem t2 = new QTableTreeItem("2222", false, false, 2);
		t1.getChilds().add(t2);
		QTableTreeItem t3 = new QTableTreeItem("3333", false, false, 1);
		QTableTreeItem t4 = new QTableTreeItem("4444", false, false, 2);
		QTableTreeItem t5 = new QTableTreeItem("5555", false, false, 3);
		t3.getChilds().add(t4);
		t4.getChilds().add(t5);

		tableTreeModel.addElement(t1);
		// tableTreeModel.addElement(t2);
		tableTreeModel.addElement(t3);
		// tableTreeModel.addElement(t4);
		// tableTreeModel.addElement(t5);

		JButton addItem = new JButton("ADD");
		addItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tableTreeModel.addElement(new QTableTreeItem());
			}
		});

		JButton delItem = new JButton("DEL");
		delItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tableTreeModel.removeElement(0);
			}
		});

		panel.add(tableTreeUI);
		panel.add(addItem);
		panel.add(delItem);

		jf.setContentPane(panel);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
}
