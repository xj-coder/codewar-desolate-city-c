package platform.ui.index.page;

import java.awt.Color;
import java.awt.Image;

import javax.swing.JPanel;

import platform.tools.ImageFactory;

public class IndexPage extends JPanel {

	private static final long serialVersionUID = -5290158585413109951L;

	private Image titleImage;
	private String title = "游戏大厅";

	public IndexPage() {
	}

	public IndexPage(String title, Image titleImage) {
		this.title = title;
		this.titleImage = titleImage;

		setBackground(Color.white);
	}

	public Image getTitleImage() {
		titleImage = ImageFactory.getIndexPageTabTitleIcon().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		return titleImage;
	}

	public String getTitle() {
		return title;
	}
}
