package platform.ui.index.page;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import platform.tools.ImageFactory;

public class IndexPageTab extends JPanel {

	private static final long serialVersionUID = -5290158585413109951L;

	private ImageIcon titleIcon;
	private String title = "游戏大厅";

	public ImageIcon getTitleIcon() {
		titleIcon = new ImageIcon(ImageFactory.getIndexPageTabTitleIcon().getScaledInstance(16, 16, Image.SCALE_DEFAULT));
		return titleIcon;
	}

	public String getTitle() {
		return title;
	}
}
