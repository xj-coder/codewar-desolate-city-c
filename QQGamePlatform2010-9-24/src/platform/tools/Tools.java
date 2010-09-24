package platform.tools;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Tools {
	public static Dimension getScreenSize() {
		return Toolkit.getDefaultToolkit().getScreenSize();
	}
}
