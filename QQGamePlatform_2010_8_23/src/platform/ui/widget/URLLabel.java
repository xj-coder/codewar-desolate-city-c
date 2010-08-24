package platform.ui.widget;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.net.URL;

import javax.swing.JLabel;

import platform.define.Define;

public class URLLabel extends JLabel {
	private static final long serialVersionUID = 3517076967172024352L;

	private String show_text;
	private URL url;

	public URLLabel() {
		super();
	}

	public URLLabel(String text) {
		super();
		this.show_text = text;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setFont(Define.DEFAULT_FONT);
		FontMetrics fontMetrics = g.getFontMetrics();
		int _y = this.getHeight() - fontMetrics.getDescent() - 5;
		int _x = 3;
		g.drawString(show_text, _x, _y);
		// g.drawLine(0, _y, _x, _y);
	}

	public String getShow_text() {
		return show_text;
	}

	public void setShow_text(String showText) {
		show_text = showText;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

}
