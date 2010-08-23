package platform.adapter;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import platform.tools.Tools;
import platform.ui.IndexParams;
import platform.ui.IndexUI;

public class IndexActionAdapter implements ActionListener {
	private IndexUI indexUI;

	public IndexActionAdapter(IndexUI indexUI) {
		this.indexUI = indexUI;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals(IndexParams.ACTION_CLOSE)) {
			indexUI.setVisible(false);
			System.exit(0);
		} else if (event.getActionCommand().equals(IndexParams.ACTION_MIN)) {
			indexUI.setExtendedState(JFrame.ICONIFIED);
		} else if (event.getActionCommand().equals(IndexParams.ACTION_MAX)) {
			indexUI.getRestr_button().setVisible(true);
			indexUI.getMax_button().setVisible(false);
			indexUI.setMax(true);
			Dimension screenSize = Tools.getScreenSize();
			Insets screenInsets = Toolkit.getDefaultToolkit().getScreenInsets(
					indexUI.getGraphicsConfiguration());
			indexUI.setSize(screenSize.width - screenInsets.left
					- screenInsets.right, screenSize.height - screenInsets.top
					- screenInsets.bottom);
			indexUI.setLocation(0, 0);

			indexUI.removeMouseListener(indexUI.getDragAdapter());
			indexUI.removeMouseMotionListener(indexUI.getDragAdapter());
		} else if (event.getActionCommand().equals(IndexParams.ACTION_RESTR)) {
			indexUI.getRestr_button().setVisible(false);
			indexUI.getMax_button().setVisible(true);
			indexUI.setMax(false);
			indexUI.setSize(indexUI.getHistorySize());

			indexUI.addMouseListener(indexUI.getDragAdapter());
			indexUI.addMouseMotionListener(indexUI.getDragAdapter());
		}
	}

}
