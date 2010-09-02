package platform.ui.widget.ui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import platform.tools.ImageFactory;
import platform.ui.widget.bean.QTableTreeItem;

public class QTableTreeItemUI extends JButton {
	private static final long serialVersionUID = -1218664142186173889L;

	public static Color ITEM_NONE = new Color(0x000000);
	public static Color ITEM_SELECT = new Color(0xFF0000);
	public static Color ITEM_ROLLOVER = new Color(0xFFFF00);

	private static int UNIT_SPANE_WIDTH = 20;

	private QTableTreeItem item;

	private JLabel spanLabel;
	private JLabel expandOpenIcon;
	private JLabel expandCloseIcon;
	private JLabel nameLabel;

	public QTableTreeItemUI(QTableTreeItem item) {
		super();

		this.item = item;
		setLayout(null);
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
	}

	public void buildUI() {
		add(getSpanLabel());
		add(getExpandOpenIcon());
		add(getExpandCloseIcon());
		add(getNameLabel());

		if (item.getChilds().size() == 0) {
			getExpandOpenIcon().setVisible(false);
			getExpandCloseIcon().setVisible(false);
		}
	}

	public JLabel getSpanLabel() {
		if (spanLabel == null) {
			spanLabel = new JLabel();

			resetSpanLabel();
		}
		return spanLabel;
	}

	public void resetSpanLabel() {
		getSpanLabel().setBounds(0, 0, (item.getLevel() - 1) * UNIT_SPANE_WIDTH, getHeight());
	}

	public JLabel getExpandOpenIcon() {
		if (expandOpenIcon == null) {
			expandOpenIcon = new JLabel(new ImageIcon(ImageFactory.getExpandOpenImage()));

			resetExpandOpenIcon();
		}
		return expandOpenIcon;
	}

	public void resetExpandOpenIcon() {
		getExpandOpenIcon().setBounds(getSpanLabel().getWidth(), 2, 16, 16);
	}

	public JLabel getExpandCloseIcon() {
		if (expandCloseIcon == null) {
			expandCloseIcon = new JLabel(new ImageIcon(ImageFactory.getExpandCloseImage()));

			resetExpandCloseIcon();
		}
		return expandCloseIcon;
	}

	public void resetExpandCloseIcon() {
		getExpandCloseIcon().setBounds(getSpanLabel().getWidth(), 2, 16, 16);
	}

	public JLabel getNameLabel() {
		if (nameLabel == null) {
			nameLabel = new JLabel(item.getShowName());

			resetNameLabel();
		}
		return nameLabel;
	}

	public void resetNameLabel() {
		getNameLabel().setBounds(getSpanLabel().getWidth() + getExpandOpenIcon().getWidth(), 0,
				getWidth() - getSpanLabel().getWidth() - getExpandOpenIcon().getWidth(), getHeight());
	}
}
