package platform.ui.widget;

import java.awt.Cursor;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import platform.define.Define;

public class URLLabel extends JLabel {
	private static final long serialVersionUID = 3517076967172024352L;

	private String show_text;
	private URL url;

	public URLLabel() {
		super();
	}

	public URLLabel(String show_text) {
		super();
		this.show_text = show_text;

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Graphics g = getGraphics();
				g.setFont(Define.DEFAULT_FONT);
				FontMetrics fontMetrics = g.getFontMetrics();
				int _y = getHeight() - fontMetrics.getDescent() - 5;
				int _x = 3;
				int _x_ = _x + fontMetrics.stringWidth(getShow_text());

				g.setColor(URLLabel.this.getForeground());
				g.drawLine(_x, _y, _x_, _y);
				SwingUtilities.getRoot(URLLabel.this).setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				super.mouseExited(e);
				repaint();
				SwingUtilities.getRoot(URLLabel.this).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mouseClicked(MouseEvent event) {
				if (url != null) {

					// 使用默认浏览器打开网页（Windows XP下有效）
					try {
						Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url.toString());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setFont(Define.DEFAULT_FONT);
		FontMetrics fontMetrics = g.getFontMetrics();
		int _y = getHeight() - fontMetrics.getDescent() - 5;
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
