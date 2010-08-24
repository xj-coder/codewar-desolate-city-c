package platform.ui.widget;

import java.awt.Cursor;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import platform.define.Define;
import platform.tools.ImageFactory;

public class WidgetFactory {
	private static final JPanel panel = new JPanel();

	public static JButton createButton(final String name, final String cmd, final ActionListener listener, final Image[] images) {
		JButton jb = new JButton() {
			private static final long serialVersionUID = 1635827255537514056L;

			@Override
			public void paint(Graphics g) {
				super.paint(g);
				// 将text画到按钮上
				if (getName() != null && !getName().trim().equals("")) {
					FontMetrics fontMetrics = g.getFontMetrics();
					int _y = getHeight() / 2 + fontMetrics.getDescent();
					int _x = getWidth() / 2 - fontMetrics.stringWidth(getName()) / 2;
					g.drawString(getName(), _x, _y);
				}
			}
		};
		jb.setName(name);
		jb.setBorderPainted(false);
		jb.setFocusPainted(false);
		jb.setContentAreaFilled(false);
		jb.setDoubleBuffered(true);

		if (images.length >= 3) {
			jb.setIcon(new ImageIcon(images[0]));
			jb.setRolloverIcon(new ImageIcon(images[1]));
			jb.setPressedIcon(new ImageIcon(images[2]));
		}

		jb.setOpaque(false);
		jb.setFocusable(false);
		jb.setActionCommand(cmd);
		jb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jb.addActionListener(listener);

		return jb;
	}

	public static JButton createLoginCloseButton(final int width, final int height, final String name, final String cmd, final ActionListener listener) {

		Image[] images = new Image[3];
		MediaTracker mt = new MediaTracker(panel);

		images[0] = ImageFactory.getLoginCloseButton().getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[0], 0);

		images[1] = ImageFactory.getLoginCloseButtonRollover().getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[1], 1);

		images[2] = ImageFactory.getLoginCloseButtonPressed().getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[2], 2);
		try {
			mt.waitForAll();
		} catch (Exception exe) {
			exe.printStackTrace();
		}

		return createButton(name, cmd, listener, images);
	}

	public static JButton createHelpButton(final int width, final int height, final String name, final String cmd, final ActionListener listener) {
		Image[] images = new Image[3];
		MediaTracker mt = new MediaTracker(panel);

		images[0] = ImageFactory.getLoginHelpButton().getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[0], 0);

		images[1] = ImageFactory.getLoginHelpButtonRollover().getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[1], 1);

		images[2] = ImageFactory.getLoginHelpButtonPressed().getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[2], 2);
		return createButton(name, cmd, listener, images);
	}

	public static JButton createButton(final int width, final int height, final String name, final String cmd, final ActionListener listener) {
		Image[] images = new Image[3];
		MediaTracker mt = new MediaTracker(panel);

		images[0] = ImageFactory.getButton(width, height);
		mt.addImage(images[0], 0);

		images[1] = ImageFactory.getButtonRollover(width, height);
		mt.addImage(images[1], 1);

		images[2] = ImageFactory.getButtonPressed(width, height);
		mt.addImage(images[2], 2);

		return createButton(name, cmd, listener, images);
	}

	public static JButton createIndexCloseButton(final int width, final int height, final String name, final String cmd, final ActionListener listener) {

		Image[] images = new Image[3];
		MediaTracker mt = new MediaTracker(panel);

		images[0] = ImageFactory.getIndexCloseButton().getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[0], 0);

		images[1] = ImageFactory.getIndexCloseButtonRollover().getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[1], 1);

		images[2] = ImageFactory.getIndexCloseButtonPressed().getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[2], 2);
		try {
			mt.waitForAll();
		} catch (Exception exe) {
			exe.printStackTrace();
		}

		return createButton(name, cmd, listener, images);
	}

	public static JButton createIndexMinButton(final int width, final int height, final String name, final String cmd, final ActionListener listener) {

		Image[] images = new Image[3];
		MediaTracker mt = new MediaTracker(panel);

		images[0] = ImageFactory.getIndexMinButton().getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[0], 0);

		images[1] = ImageFactory.getIndexMinButtonRollover().getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[1], 1);

		images[2] = ImageFactory.getIndexMinButtonPressed().getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[2], 2);
		try {
			mt.waitForAll();
		} catch (Exception exe) {
			exe.printStackTrace();
		}

		return createButton(name, cmd, listener, images);
	}

	public static JButton createIndexMaxButton(final int width, final int height, final String name, final String cmd, final ActionListener listener) {

		Image[] images = new Image[3];
		MediaTracker mt = new MediaTracker(panel);

		images[0] = ImageFactory.getIndexMaxButton().getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[0], 0);

		images[1] = ImageFactory.getIndexMaxButtonRollover().getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[1], 1);

		images[2] = ImageFactory.getIndexMaxButtonPressed().getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[2], 2);
		try {
			mt.waitForAll();
		} catch (Exception exe) {
			exe.printStackTrace();
		}

		return createButton(name, cmd, listener, images);
	}

	public static JButton createIndexRestrButton(final int width, final int height, final String name, final String cmd, final ActionListener listener) {

		Image[] images = new Image[3];
		MediaTracker mt = new MediaTracker(panel);

		images[0] = ImageFactory.getIndexRestrButton().getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[0], 0);

		images[1] = ImageFactory.getIndexRestrButtonRollover().getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[1], 1);

		images[2] = ImageFactory.getIndexRestrButtonPressed().getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[2], 2);
		try {
			mt.waitForAll();
		} catch (Exception exe) {
			exe.printStackTrace();
		}

		return createButton(name, cmd, listener, images);
	}

	public static JButton createIndexChangeFaceButton(final int width, final int height, final String name, final String cmd, final ActionListener listener) {

		Image[] images = new Image[3];
		MediaTracker mt = new MediaTracker(panel);

		images[0] = ImageFactory.getIndexChangeFaceButton().getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[0], 0);

		images[1] = ImageFactory.getIndexChangeFaceButtonRollover().getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[1], 1);

		images[2] = ImageFactory.getIndexChangeFaceButtonPressed().getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[2], 2);
		try {
			mt.waitForAll();
		} catch (Exception exe) {
			exe.printStackTrace();
		}

		return createButton(name, cmd, listener, images);
	}

	public static JButton createIndexMenuButton(final int width, final int height, final String name, final String cmd, final ActionListener listener) {

		Image[] images = new Image[3];
		MediaTracker mt = new MediaTracker(panel);

		images[0] = ImageFactory.getIndexMenuButton().getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[0], 0);

		images[1] = ImageFactory.getIndexMenuButtonRollover().getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[1], 1);

		images[2] = ImageFactory.getIndexMenuButtonPressed().getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[2], 2);
		try {
			mt.waitForAll();
		} catch (Exception exe) {
			exe.printStackTrace();
		}

		return createButton(name, cmd, listener, images);
	}

	public static JButton createLoginAccountInputButton(final int width, final int height, final String name, final String cmd, final ActionListener listener) {

		Image[] images = new Image[3];
		MediaTracker mt = new MediaTracker(panel);

		images[0] = ImageFactory.getLoginAccountInputButton().getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[0], 0);

		images[1] = ImageFactory.getLoginAccountInputButtonRollover().getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[1], 1);

		images[2] = ImageFactory.getLoginAccountInputButtonPressed().getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[2], 2);
		try {
			mt.waitForAll();
		} catch (Exception exe) {
			exe.printStackTrace();
		}

		return createButton(name, cmd, listener, images);
	}

	public static JCheckBox createCheckBox(String text) {
		JCheckBox checkBox = new JCheckBox(text);

		checkBox.setIcon(new ImageIcon(ImageFactory.getCheckBoxImage()));
		checkBox.setDisabledIcon(new ImageIcon(ImageFactory.getDisableCheckBoxImage()));
		checkBox.setSelectedIcon(new ImageIcon(ImageFactory.getCheckedBoxImage()));
		checkBox.setDisabledSelectedIcon(new ImageIcon(ImageFactory.getDisableCheckedBoxImage()));

		checkBox.setFont(Define.DEFAULT_FONT);
		checkBox.setOpaque(false);

		return checkBox;
	}
}
