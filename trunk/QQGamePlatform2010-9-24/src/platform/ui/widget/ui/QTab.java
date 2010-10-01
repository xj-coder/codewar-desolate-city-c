package platform.ui.widget.ui;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;

import javax.swing.DefaultButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import platform.define.Define;
import platform.tools.ImageFactory;

public class QTab extends JButton {

	private static final long serialVersionUID = 8986746139319645453L;

	public static int DEFAULT_WIDTH = 60;
	public static int DEFAULT_HEIGHT = 24;
	public static int ICON_WIDTH = 30;

	private String title;
	private Image titleImage;

	private ImageIcon[] images = null;

	public QTab(String title, Image titleIcon) {
		this.title = title;
		this.titleImage = titleIcon;

		// setModel(new QTabButtonModel());

		setRolloverEnabled(true);
		setEnabled(true);
		setBorderPainted(false);
		setFocusPainted(false);
		setContentAreaFilled(false);
		setDoubleBuffered(true);

		setOpaque(false);
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		// #begin 【初始化背景图片】
		if (images == null) {
			images = new ImageIcon[3];
			MediaTracker mt = new MediaTracker(this);

			images[0] = new ImageIcon(ImageFactory.getIndexTabBackground(
					DEFAULT_WIDTH, DEFAULT_HEIGHT));
			mt.addImage(images[0].getImage(), 0);

			images[1] = new ImageIcon(ImageFactory
					.getIndexTabBackgroundRollover(DEFAULT_WIDTH,
							DEFAULT_HEIGHT));
			mt.addImage(images[1].getImage(), 1);

			images[2] = new ImageIcon(
					ImageFactory.getIndexTabBackgroundPressed(DEFAULT_WIDTH,
							DEFAULT_HEIGHT));
			mt.addImage(images[2].getImage(), 2);

			try {
				mt.waitForAll();
			} catch (Exception exe) {
				exe.printStackTrace();
			}

			setIcon(images[0]);
			setRolloverIcon(images[1]);
			setPressedIcon(images[2]);
		}
		// #end 【初始化背景图片】
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		System.out.println("paint Qtab button");

		int _width = 0;

		g.setFont(Define.DEFAULT_FONT);
		FontMetrics fontMetrics = getGraphics().getFontMetrics();
		int strWidth = fontMetrics.stringWidth(this.title);

		_width = strWidth + ICON_WIDTH;

		setSize(_width, DEFAULT_HEIGHT);

		// 将title画到按钮上
		if (getTitle() != null && !getTitle().trim().equals("")) {
			int _y = getHeight() / 2 + fontMetrics.getHeight() / 2 - 3;
			g.drawString(getTitle(), getTitleIcon().getWidth(null) + 10, _y);
		}
		if (getTitleIcon() != null) {
			g.drawImage(getTitleIcon(), 5, 5, getTitleIcon().getWidth(null),
					getTitleIcon().getHeight(null), null);
		}
	}

	// #begin getter and setter
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Image getTitleIcon() {
		return titleImage;
	}

	public void setTitleIcon(Image titleIcon) {
		this.titleImage = titleIcon;
	}

	// #end getter and setter

	public class QTabButtonModel extends DefaultButtonModel {

		private static final long serialVersionUID = 7572437497803246159L;

		@Override
		public void setRollover(boolean b) {
			if (images == null) {
				return;
			}
			if (b) {
				setIcon(images[1]);
			} else {
				setIcon(images[0]);
			}
			repaint();
		}

		@Override
		public void setPressed(boolean b) {
			if (images == null) {
				return;
			}
			if (b) {
				setIcon(images[2]);
			} else {
				setIcon(images[0]);
			}
			repaint();
		}
	}
}
