package platform.ui.widget.ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class ImagePanelUI extends JPanel {
	private static final long serialVersionUID = -8403177356539806944L;
	private Image image;

	public ImagePanelUI(Image img) {
		super();
		image = img;
	}

	@Override
	public void paintComponent(Graphics g1) {
		int x = 0;
		int y = 0;
		Graphics g = g1;
		if (null == image) {
			return;
		}

		g.drawImage(image, x, y, getWidth(), getHeight(), this);
		g = null;
	}
}
