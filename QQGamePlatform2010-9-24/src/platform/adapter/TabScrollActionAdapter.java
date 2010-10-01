package platform.adapter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import platform.ui.index.IndexParams;
import platform.ui.widget.ui.QTabbedPane;

public class TabScrollActionAdapter implements ActionListener {
	private QTabbedPane tabbedPane;

	public TabScrollActionAdapter(QTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(IndexParams.ACTION_TAB_SCROLL_LEFT)) {
			tabbedPane.setBeginIndex(tabbedPane.getBeginIndex() - 1);
			tabbedPane.repaint();
		} else if (e.getActionCommand().equals(
				IndexParams.ACTION_TAB_SCROLL_RIGHT)) {
			tabbedPane.setBeginIndex(tabbedPane.getBeginIndex() + 1);
			tabbedPane.repaint();
		}
	}
}