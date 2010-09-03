package platform.adapter;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import platform.tools.Tools;
import platform.ui.index.IndexParams;
import platform.ui.index.IndexUI;

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
			indexUI.setExtendedState(Frame.ICONIFIED);
		} else if (event.getActionCommand().equals(IndexParams.ACTION_MAX)) {
			indexUI.getHeadUI().getRestr_button().setVisible(true);
			indexUI.getHeadUI().getMax_button().setVisible(false);
			indexUI.setMax(true);
			Dimension screenSize = Tools.getScreenSize();
			Insets screenInsets = Toolkit.getDefaultToolkit().getScreenInsets(indexUI.getGraphicsConfiguration());
			indexUI.setSize(screenSize.width - screenInsets.left - screenInsets.right, screenSize.height - screenInsets.top - screenInsets.bottom);
			indexUI.setLocation(0, 0);

			indexUI.removeMouseListener(indexUI.getDragAdapter());
			indexUI.removeMouseMotionListener(indexUI.getDragAdapter());
		} else if (event.getActionCommand().equals(IndexParams.ACTION_RESTR)) {
			indexUI.getHeadUI().getRestr_button().setVisible(false);
			indexUI.getHeadUI().getMax_button().setVisible(true);
			indexUI.setMax(false);
			indexUI.setSize(indexUI.getHistorySize());

			indexUI.addMouseListener(indexUI.getDragAdapter());
			indexUI.addMouseMotionListener(indexUI.getDragAdapter());
		} else if (event.getActionCommand().equals(IndexParams.ACTION_DIR_LOCK)) {
			indexUI.getDirTreeUI().getSearch_field().setFocusable(false);
			indexUI.getDirTreeUI().getDir_unlock_button().setVisible(true);
			indexUI.getDirTreeUI().getDir_lock_button().setVisible(false);
			indexUI.getSearch_left_splitter_button().setEnabled(true);
			indexUI.getDirTreeUI().getSearch_field().setFocusable(true);
		} else if (event.getActionCommand().equals(IndexParams.ACTION_DIR_UNLOCK)) {
			indexUI.getDirTreeUI().getSearch_field().setFocusable(false);
			indexUI.getDirTreeUI().getDir_unlock_button().setVisible(false);
			indexUI.getDirTreeUI().getDir_lock_button().setVisible(true);
			indexUI.getSearch_left_splitter_button().setEnabled(false);
			indexUI.getDirTreeUI().getSearch_field().setFocusable(true);
		} else if (event.getActionCommand().equals(IndexParams.ACTION_SHOW_SEARCH_DI)) {
			indexUI.getSearch_left_splitter_button().setVisible(true);
			indexUI.getSearch_right_splitter_button().setVisible(false);
			indexUI.getDirTreeUI().setVisible(true);
			indexUI.resetTabbedPane();
		} else if (event.getActionCommand().equals(IndexParams.ACTION_HIDE_SEARCH_DIR)) {
			indexUI.getSearch_left_splitter_button().setVisible(false);
			indexUI.getSearch_right_splitter_button().setVisible(true);
			indexUI.getDirTreeUI().setVisible(false);
			indexUI.maxTabbedPane();
		}
	}

}
