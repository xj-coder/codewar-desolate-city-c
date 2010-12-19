package platform.ui.widget.tabletree;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import platform.tools.ImageFactory;
import platform.ui.widget.ImageLabel;
import platform.ui.widget.bean.QTableTreeItem;

public class QTableTreeItemUI extends JButton {
	private static final long serialVersionUID = -1218664142186173889L;

	public static Color ITEM_NONE = new Color(0xffffff);
	public static Color ITEM_SELECT = new Color(0x41a4e7);
	public static Color ITEM_ROLLOVER = new Color(0xcbe8fb);
	public static Color ITEM_BORDER = new Color(0xeeeeee);

	public static int UNIT_SPANE_WIDTH = 10;
	public static int UNIT_WIDTH = 196;
	public static int UNIT_HEIGHT = 20;

	private QTableTreeItem item;

	private QTableTree tableTreeUI;

	private ImageLabel spanLabel;
	private ImageLabel expandOpenIcon;
	private ImageLabel expandCloseIcon;
	private ImageLabel iconLabel;
	private ImageLabel nameLabel;

	public QTableTreeItemUI(QTableTree tableTreeUI, QTableTreeItem item) {
		super();

		this.item = item;
		this.tableTreeUI = tableTreeUI;

		setLayout(null);
		setBorder(new LineBorder(ITEM_BORDER));

		if (item.isSelect()) {
			setBackground(ITEM_SELECT);
		} else if (item.isRollover()) {
			setBackground(ITEM_ROLLOVER);
		} else {
			setBackground(ITEM_NONE);
		}

		if (item.isExpand()) {
			getExpandCloseIcon().setVisible(true);
			getExpandOpenIcon().setVisible(false);
		} else {
			getExpandCloseIcon().setVisible(false);
			getExpandOpenIcon().setVisible(true);
		}

		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (getTableTreeUI().getModel().getSize() <= 0) {
					return;
				}

				QTableTreeModel treeModel = (QTableTreeModel) getTableTreeUI().getModel();
				int index = treeModel.indexOf(getItem());
				QTableTreeItem item = (QTableTreeItem) treeModel.getElementAt(index);

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
		});
	}

	public void buildUI() {
		add(getSpanLabel());
		add(getExpandOpenIcon());
		add(getExpandCloseIcon());
		add(getIconLabel());
		add(getNameLabel());

		if (item.getChildCount() == 0) {
			getExpandOpenIcon().setVisible(false);
			getExpandCloseIcon().setVisible(false);
		}
	}

	public ImageLabel getSpanLabel() {
		if (spanLabel == null) {
			spanLabel = new ImageLabel();

			resetSpanLabel();
		}
		return spanLabel;
	}

	public void resetSpanLabel() {
		getSpanLabel().setBounds(0, 0, (item.getLevel() - 1) * UNIT_SPANE_WIDTH, getHeight());
	}

	public ImageLabel getExpandOpenIcon() {
		if (expandOpenIcon == null) {
			expandOpenIcon = new ImageLabel(new ImageIcon(ImageFactory.getExpandOpenImage()));

			resetExpandOpenIcon();
		}
		return expandOpenIcon;
	}

	public void resetExpandOpenIcon() {
		getExpandOpenIcon().setBounds(getSpanLabel().getWidth(), 2, 16, 16);
	}

	public ImageLabel getExpandCloseIcon() {
		if (expandCloseIcon == null) {
			expandCloseIcon = new ImageLabel(new ImageIcon(ImageFactory.getExpandCloseImage()));

			resetExpandCloseIcon();
		}
		return expandCloseIcon;
	}

	public void resetExpandCloseIcon() {
		getExpandCloseIcon().setBounds(getSpanLabel().getWidth(), 2, 16, 16);
	}

	public ImageLabel getIconLabel() {
		if (iconLabel == null) {
			iconLabel = new ImageLabel(new ImageIcon(item.getIcon()));

			resetIconLabel();
		}
		return iconLabel;
	}

	private void resetIconLabel() {
		getIconLabel().setBounds(getSpanLabel().getWidth() + getExpandOpenIcon().getWidth(), 2, 16,
				16);
	}

	public ImageLabel getNameLabel() {
		if (nameLabel == null) {
			nameLabel = new ImageLabel(item.getShowName());

			resetNameLabel();
		}
		return nameLabel;
	}

	public void resetNameLabel() {
		getNameLabel().setBounds(
				getIconLabel().getWidth() + getSpanLabel().getWidth()
						+ getExpandOpenIcon().getWidth(),
				0,
				getWidth() - getIconLabel().getWidth() - getSpanLabel().getWidth()
						- getExpandOpenIcon().getWidth(), getHeight());
	}

	public QTableTree getTableTreeUI() {
		return tableTreeUI;
	}

	public QTableTreeItem getItem() {
		return item;
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
