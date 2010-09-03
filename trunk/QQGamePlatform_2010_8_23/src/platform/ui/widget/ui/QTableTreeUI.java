package platform.ui.widget.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import platform.adapter.QTableTreeMouseAdapter;
import platform.tools.ImageTools;
import platform.ui.widget.bean.QTableTreeItem;
import platform.ui.widget.model.QTableTreeModel;

public class QTableTreeUI extends JList {

	private static final long serialVersionUID = 234963439260527147L;

	private QTableTreeMouseAdapter mouseAdapter = new QTableTreeMouseAdapter(this);

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

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		jf.setSize(500, 500);

		JPanel panel = new JPanel();
		panel.setBackground(Color.red);
		final QTableTreeModel tableTreeModel = new QTableTreeModel();

		QTableTreeUI tableTreeUI = new QTableTreeUI(tableTreeModel);

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
