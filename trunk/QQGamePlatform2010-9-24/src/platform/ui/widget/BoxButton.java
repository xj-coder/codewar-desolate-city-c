package platform.ui.widget;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import platform.ui.widget.factory.WidgetFactory;

/**
 * 具有下拉样式的按钮
 * 
 * @author DesolateCity
 * 
 */

public class BoxButton extends JComponent implements ActionListener {
	private static final long serialVersionUID = -724492980738037470L;

	protected JButton button;

	protected JMenuBar menuBar;

	protected JPopupMenu popupMenu = new JPopupMenu();

	private GridLayout gridLayout = new GridLayout(1, 1);

	private Vector<JButton> items = new Vector<JButton>();

	protected JButton arrow;

	public BoxButton(JButton button) {
		this.button = button;

		arrow = WidgetFactory.createToolBarDownButton(16, 25, "", "", this);
		Insets insets = arrow.getMargin();
		arrow.setMargin(new Insets(insets.top, 1, insets.bottom, 1));
		arrow.addActionListener(this);

		popupMenu.setLayout(gridLayout);

		setupLayout();
	}

	protected void setupLayout() {
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		setLayout(gbl);

		c.weightx = 1.0;
		c.weighty = 1.0;
		c.gridx = 0;
		c.gridy = 0;
		c.fill = GridBagConstraints.BOTH;
		gbl.setConstraints(button, c);
		add(button);

		c.weightx = 0;
		c.gridx++;
		gbl.setConstraints(arrow, c);
		add(arrow);
	}

	public void addItems(final JButton item) {
		items.add(item);

		gridLayout.setRows(items.size());
		popupMenu.add(item);

		item.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				popupMenu.setVisible(false);
			}
		});
	}

	public void removeItem(JMenuItem item) {
		items.remove(item);
		popupMenu.remove(item);
	}

	public JButton removeItem(int index) {
		JButton item = items.remove(index);
		popupMenu.remove(item);
		return item;
	}

	public int getItemCount() {
		return items.size();
	}

	public JButton getItemAt(int index) {
		return items.get(index);
	}

	public void actionPerformed(ActionEvent evt) {
		popupMenu.show(button, button.getX(), button.getY() + button.getHeight());
	}
}
