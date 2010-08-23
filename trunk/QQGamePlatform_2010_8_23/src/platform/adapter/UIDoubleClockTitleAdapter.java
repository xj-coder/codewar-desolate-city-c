package platform.adapter;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import platform.tools.Tools;
import platform.ui.IndexUI;

public class UIDoubleClockTitleAdapter extends MouseAdapter {
	private JFrame UI;

	public UIDoubleClockTitleAdapter(JFrame UI) {
		this.UI = UI;
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		if (event.getY() < 25)
			if (event.getClickCount() == 2) {
				if (UI instanceof IndexUI) {
					if (((IndexUI) UI).isMax()) {
						((IndexUI) UI).getRestr_button().setVisible(false);
						((IndexUI) UI).getMax_button().setVisible(true);
						((IndexUI) UI).setMax(false);
						UI.setSize(((IndexUI) UI).getHistorySize());

						UI.addMouseListener(((IndexUI) UI).getDragAdapter());
						UI.addMouseMotionListener(((IndexUI) UI)
								.getDragAdapter());
					} else {
						((IndexUI) UI).getRestr_button().setVisible(true);
						((IndexUI) UI).getMax_button().setVisible(false);
						((IndexUI) UI).setMax(true);

						Dimension screenSize = Tools.getScreenSize();
						Insets screenInsets = Toolkit.getDefaultToolkit()
								.getScreenInsets(UI.getGraphicsConfiguration());
						UI.setSize(screenSize.width - screenInsets.left
								- screenInsets.right, screenSize.height
								- screenInsets.top - screenInsets.bottom);
						UI.setLocation(0, 0);

						UI.removeMouseListener(((IndexUI) UI).getDragAdapter());
						UI.removeMouseMotionListener(((IndexUI) UI)
								.getDragAdapter());
					}
				}
			}
	}
}
