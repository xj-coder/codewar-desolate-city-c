package platform.tools;

import java.awt.Insets;

import javax.swing.UIManager;

public class LookAndFeel {

	public static void installDefaultLookAndFeel() {
		UIManager.put("TabbedPane.contentBorderInsets", new Insets(0, 0, 0, 0));
	}
}
