package platform.ui.index.page;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import platform.tools.ImageFactory;

public class IndexPage extends JPanel {

	private static final long serialVersionUID = -5290158585413109951L;

	private ImageIcon titleIcon;
	private String title = "游戏大厅";

	public IndexPage() {
		setBackground(Color.white);
	}

	public ImageIcon getTitleIcon() {
		titleIcon = new ImageIcon(ImageFactory.getIndexPageTabTitleIcon()
				.getScaledInstance(16, 16, Image.SCALE_DEFAULT));
		return titleIcon;
	}

	public String getTitle() {
		return title;
	}
}
