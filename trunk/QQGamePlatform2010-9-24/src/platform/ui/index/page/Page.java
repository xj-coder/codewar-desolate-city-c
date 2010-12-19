package platform.ui.index.page;

import java.awt.Image;

import javax.swing.JPanel;

public abstract class Page extends JPanel {

	private static final long serialVersionUID = 7895504310235730898L;

	public Page() {
		super();
		setBorder(null);
	}

	abstract public String getTitle();

	abstract public Image getTitleImage();
}
