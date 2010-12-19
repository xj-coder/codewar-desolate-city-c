package platform.ui.widget.tabletree;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import platform.tools.ImageTools;
import platform.ui.widget.bean.QTableTreeItem;

public class QTableTree extends JList {

	private static final long serialVersionUID = 234963439260527147L;

	private QTableTreeMouseAdapter mouseAdapter = new QTableTreeMouseAdapter();

	public QTableTree(QTableTreeModel model) {
		super(model);
		setFixedCellWidth(196);
		setFixedCellHeight(20);
		setCellRenderer(new ListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList list, Object value, int index,
					boolean isSelected, boolean cellHasFocus) {
				QTableTreeItem item = (QTableTreeItem) value;

				if (isSelected) {
					item.setSelect(true);
				} else {
					item.setSelect(false);
				}

				QTableTreeItemUI itemUI = new QTableTreeItemUI(QTableTree.this, item);

				itemUI.setSize(196, 20);

				itemUI.buildUI();
				return itemUI;
			}
		});

		addMouseListener(mouseAdapter);
		addMouseMotionListener(mouseAdapter);
	}

	// #begin【双缓冲技术】
	@Override
	public void paint(Graphics g) {
		update(g);
	}

	@Override
	public void update(Graphics g) {
		Image screen = ImageTools.createImage(getWidth(), getHeight(), true);// 双缓冲
		Graphics graphics = screen.getGraphics();

		super.paint(graphics);

		g.drawImage(screen, 0, 0, null);// 最后个参数一定要用null，这样可以防止drawImage调用update方法
		g.dispose();
	}// #end【双缓冲技术】

	@Override
	public void updateUI() {
		super.updateUI();
	}

	public void refreshUI() {
		if (getModel().getSize() <= 0) {
			return;
		}

		QTableTreeModel treeModel = (QTableTreeModel) getModel();
		for (int i = 0; i < treeModel.getSize(); i++) {
			QTableTreeItem item = (QTableTreeItem) treeModel.getElementAt(i);
			int index = treeModel.indexOf(item);

			if (item.isExpand()) {
				if (item.getChildCount() > 0) {
					int addCount = 0;
					for (int i1 = 0; i1 < item.getChildCount(); i1++) {
						if (treeModel.indexOf(item.getItemAt(i1)) == -1) {
							System.err.println("add " + item.getItemAt(i1).getUserObject() + " at "
									+ (index + 1 + i1 + addCount));
							treeModel.addElement(index + 1 + i1 + addCount, item.getItemAt(i1));
						}
						addCount = addCount + openAll(item.getItemAt(i1), 0);
					}
				}
			} else {
				if (item.getChildCount() > 0) {
					for (int i1 = 0; i1 < item.getChildCount(); i1++) {
						closeAll(item.getItemAt(i1));
						treeModel.removeElement(item.getItemAt(i1));
					}
				}
			}
		}

		updateUI();
	}

	private void closeAll(QTableTreeItem item) {

		QTableTreeModel treeModel = (QTableTreeModel) getModel();

		if (item.isExpand()) {
			if (item.getChildCount() > 0) {
				for (int i = 0; i < item.getChildCount(); i++) {
					closeAll(item.getItemAt(i));
					treeModel.removeElement(item.getItemAt(i));
				}
			}
		}
	}

	private int openAll(QTableTreeItem item, int addCount) {

		QTableTreeModel treeModel = (QTableTreeModel) getModel();
		int index = treeModel.indexOf(item);

		if (item.isExpand()) {
			if (item.getChildCount() > 0) {
				int _addCount = 0;
				for (int i = 0; i < item.getChildCount(); i++) {
					if (treeModel.indexOf(item.getItemAt(i)) == -1) {
						System.err.println("add " + item.getItemAt(i).getUserObject() + " at "
								+ (index + 1 + i + _addCount) + "-----index=" + index + "------i="
								+ i);
						treeModel.addElement(index + 1 + i + _addCount, item.getItemAt(i));
						addCount++;
					}
					int tmp = openAll(item.getItemAt(i), 0);
					_addCount = _addCount + tmp;
					System.err.println(item.getItemAt(i).getUserObject() + " 积累了 " + _addCount);
					addCount = addCount + tmp;
				}
			}
		}
		return addCount;
	}

	class QTableTreeMouseAdapter extends MouseAdapter {

		private int oldIndex = -1;

		@Override
		public void mouseClicked(MouseEvent e) {
			if (getModel().getSize() <= 0) {
				return;
			}

			int index = locationToIndex(e.getPoint());
			QTableTreeModel treeModel = (QTableTreeModel) getModel();
			QTableTreeItem item = (QTableTreeItem) getModel().getElementAt(index);

			if (!item.isExpand()) {
				if (item.getChildCount() > 0) {
					for (int i = 0; i < item.getChildCount(); i++) {
						treeModel.addElement(index + 1 + i, item.getItemAt(i));
						// treeModel.addElement(item.getItemAt(i));
						openAll(item.getItemAt(i), 0);
					}
				}
				item.setExpand(!item.isExpand());
			} else {
				if (item.getChildCount() > 0) {
					for (int i = 0; i < item.getChildCount(); i++) {
						closeAll(item.getItemAt(i));
						treeModel.removeElement(item.getItemAt(i));
					}
				}
				item.setExpand(!item.isExpand());
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if (getModel().getSize() <= 0) {
				return;
			}

			((QTableTreeItem) getModel().getElementAt(oldIndex)).setRollover(false);

			updateUI();
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			if (getModel().getSize() <= 0) {
				return;
			}

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
	}

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		jf.setSize(500, 500);

		JPanel panel = new JPanel();
		panel.setBackground(Color.red);
		final QTableTreeModel tableTreeModel = new QTableTreeModel();

		QTableTree tableTreeUI = new QTableTree(tableTreeModel);

		QTableTreeItem t1 = new QTableTreeItem("1111", true, 1);
		QTableTreeItem t2 = new QTableTreeItem("2222", true, 7);
		QTableTreeItem t3 = new QTableTreeItem("3333", true, 6);
		QTableTreeItem t4 = new QTableTreeItem("4444", true, 5);
		QTableTreeItem t5 = new QTableTreeItem("5555", true, 4);
		QTableTreeItem t6 = new QTableTreeItem("6666", true, 3);
		QTableTreeItem t7 = new QTableTreeItem("7777", true, 2);
		QTableTreeItem t8 = new QTableTreeItem("8888", true, 1);

		QTableTreeItem p1 = new QTableTreeItem("p1", true, 1);
		QTableTreeItem p2 = new QTableTreeItem("p2", true, 1);
		QTableTreeItem p3 = new QTableTreeItem("p3", true, 2);
		QTableTreeItem p4 = new QTableTreeItem("p4", true, 3);

		QTableTreeItem q1 = new QTableTreeItem("q1", false, 4);
		QTableTreeItem q2 = new QTableTreeItem("q2", true, 2);
		QTableTreeItem q3 = new QTableTreeItem("q3", true, 3);
		QTableTreeItem q4 = new QTableTreeItem("q4", false, 4);

		QTableTreeItem w1 = new QTableTreeItem("w1", true, 1);
		QTableTreeItem w2 = new QTableTreeItem("w2", true, 2);
		QTableTreeItem w3 = new QTableTreeItem("w3", true, 3);
		QTableTreeItem w4 = new QTableTreeItem("w4", true, 4);

		t1.addQTableTreeItem(t4);
		t1.addQTableTreeItem(t5);
		t1.addQTableTreeItem(t6);

		p1.addQTableTreeItem(p2);
		p2.addQTableTreeItem(p3);
		p2.addQTableTreeItem(p4);
		p1.addQTableTreeItem(q1);

		q1.addQTableTreeItem(q2);

		p3.addQTableTreeItem(w1);
		p3.addQTableTreeItem(w2);

		w2.addQTableTreeItem(w3);

		w3.addQTableTreeItem(t2);

		w2.addQTableTreeItem(w4);

		w1.addQTableTreeItem(q3);

		q3.addQTableTreeItem(t3);

		t3.addQTableTreeItem(t7);
		t3.addQTableTreeItem(t8);

		w1.addQTableTreeItem(q4);

		tableTreeModel.addElement(t1);
		tableTreeModel.addElement(p1);
		// tableTreeModel.addElement(t2);
		// tableTreeModel.addElement(t4);
		// tableTreeModel.addElement(t5);

		tableTreeUI.refreshUI();

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
