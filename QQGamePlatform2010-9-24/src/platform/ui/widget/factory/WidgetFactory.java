package platform.ui.widget.factory;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import platform.adapter.TabScrollActionAdapter;
import platform.define.Define;
import platform.tools.ImageFactory;

public class WidgetFactory {
	private static final JPanel panel = new JPanel();

	public static JButton createButton(final String name, final String cmd,
			final ActionListener listener, final Image[] images) {
		JButton jb = new JButton() {
			private static final long serialVersionUID = 1635827255537514056L;

			@Override
			public void paint(Graphics g) {
				super.paint(g);
				// 将text画到按钮上
				if (getName() != null && !getName().trim().equals("")) {
					g.setFont(Define.DEFAULT_FONT);

					FontMetrics fontMetrics = g.getFontMetrics();
					int _y = getHeight() / 2 + fontMetrics.getHeight() / 2 - 3;
					int _x = getWidth() / 2
							- fontMetrics.stringWidth(getName()) / 2;
					g.drawString(getName(), _x, _y);
				}
			}
		};
		if (name != null) {
			jb.setName(name);
		}
		jb.setBorderPainted(false);
		jb.setFocusPainted(false);
		jb.setContentAreaFilled(false);
		jb.setDoubleBuffered(true);

		if (images != null && images.length > 0) {
			if (images.length > 0 && images[0] != null) {
				jb.setIcon(new ImageIcon(images[0]));
			}
			if (images.length > 1 && images[1] != null) {
				jb.setRolloverIcon(new ImageIcon(images[1]));
			}
			if (images.length > 2 && images[2] != null) {
				jb.setPressedIcon(new ImageIcon(images[2]));
			}
		}

		jb.setOpaque(false);
		jb.setFocusable(false);

		if (cmd != null) {
			jb.setActionCommand(cmd);
		}
		if (listener != null) {
			jb.addActionListener(listener);
		}
		jb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		return jb;
	}

	public static JButton createLoginCloseButton(final int width,
			final int height, final String name, final String cmd,
			final ActionListener listener) {

		Image[] images = new Image[3];
		MediaTracker mt = new MediaTracker(panel);

		images[0] = ImageFactory.getLoginCloseButton().getScaledInstance(width,
				height, Image.SCALE_DEFAULT);
		mt.addImage(images[0], 0);

		images[1] = ImageFactory.getLoginCloseButtonRollover()
				.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[1], 1);

		images[2] = ImageFactory.getLoginCloseButtonPressed()
				.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[2], 2);
		try {
			mt.waitForAll();
		} catch (Exception exe) {
			exe.printStackTrace();
		}

		return createButton(name, cmd, listener, images);
	}

	public static JButton createHelpButton(final int width, final int height,
			final String name, final String cmd, final ActionListener listener) {
		Image[] images = new Image[3];
		MediaTracker mt = new MediaTracker(panel);

		images[0] = ImageFactory.getLoginHelpButton().getScaledInstance(width,
				height, Image.SCALE_DEFAULT);
		mt.addImage(images[0], 0);

		images[1] = ImageFactory.getLoginHelpButtonRollover()
				.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[1], 1);

		images[2] = ImageFactory.getLoginHelpButtonPressed().getScaledInstance(
				width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[2], 2);
		return createButton(name, cmd, listener, images);
	}

	public static JButton createButton(final int width, final int height,
			final String name, final String cmd, final ActionListener listener) {
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

	public static JButton createLoginButton(final int width, final int height,
			final String name, final String cmd, final ActionListener listener) {
		Image[] images = new Image[3];
		MediaTracker mt = new MediaTracker(panel);

		images[0] = ImageFactory.getButtonWithBorder(width, height);
		mt.addImage(images[0], 0);

		images[1] = ImageFactory.getButtonRollover(width, height);
		mt.addImage(images[1], 1);

		images[2] = ImageFactory.getButtonPressed(width, height);
		mt.addImage(images[2], 2);

		return createButton(name, cmd, listener, images);
	}

	public static JButton createIndexCloseButton(final int width,
			final int height, final String name, final String cmd,
			final ActionListener listener) {

		Image[] images = new Image[3];
		MediaTracker mt = new MediaTracker(panel);

		images[0] = ImageFactory.getIndexCloseButton().getScaledInstance(width,
				height, Image.SCALE_DEFAULT);
		mt.addImage(images[0], 0);

		images[1] = ImageFactory.getIndexCloseButtonRollover()
				.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[1], 1);

		images[2] = ImageFactory.getIndexCloseButtonPressed()
				.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[2], 2);
		try {
			mt.waitForAll();
		} catch (Exception exe) {
			exe.printStackTrace();
		}

		return createButton(name, cmd, listener, images);
	}

	public static JButton createIndexMinButton(final int width,
			final int height, final String name, final String cmd,
			final ActionListener listener) {

		Image[] images = new Image[3];
		MediaTracker mt = new MediaTracker(panel);

		images[0] = ImageFactory.getIndexMinButton().getScaledInstance(width,
				height, Image.SCALE_DEFAULT);
		mt.addImage(images[0], 0);

		images[1] = ImageFactory.getIndexMinButtonRollover().getScaledInstance(
				width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[1], 1);

		images[2] = ImageFactory.getIndexMinButtonPressed().getScaledInstance(
				width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[2], 2);
		try {
			mt.waitForAll();
		} catch (Exception exe) {
			exe.printStackTrace();
		}

		return createButton(name, cmd, listener, images);
	}

	public static JButton createIndexMaxButton(final int width,
			final int height, final String name, final String cmd,
			final ActionListener listener) {

		Image[] images = new Image[3];
		MediaTracker mt = new MediaTracker(panel);

		images[0] = ImageFactory.getIndexMaxButton().getScaledInstance(width,
				height, Image.SCALE_DEFAULT);
		mt.addImage(images[0], 0);

		images[1] = ImageFactory.getIndexMaxButtonRollover().getScaledInstance(
				width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[1], 1);

		images[2] = ImageFactory.getIndexMaxButtonPressed().getScaledInstance(
				width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[2], 2);
		try {
			mt.waitForAll();
		} catch (Exception exe) {
			exe.printStackTrace();
		}

		return createButton(name, cmd, listener, images);
	}

	public static JButton createIndexRestrButton(final int width,
			final int height, final String name, final String cmd,
			final ActionListener listener) {

		Image[] images = new Image[3];
		MediaTracker mt = new MediaTracker(panel);

		images[0] = ImageFactory.getIndexRestrButton().getScaledInstance(width,
				height, Image.SCALE_DEFAULT);
		mt.addImage(images[0], 0);

		images[1] = ImageFactory.getIndexRestrButtonRollover()
				.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[1], 1);

		images[2] = ImageFactory.getIndexRestrButtonPressed()
				.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[2], 2);
		try {
			mt.waitForAll();
		} catch (Exception exe) {
			exe.printStackTrace();
		}

		return createButton(name, cmd, listener, images);
	}

	public static JButton createIndexChangeFaceButton(final int width,
			final int height, final String name, final String cmd,
			final ActionListener listener) {

		Image[] images = new Image[3];
		MediaTracker mt = new MediaTracker(panel);

		images[0] = ImageFactory.getIndexChangeFaceButton().getScaledInstance(
				width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[0], 0);

		images[1] = ImageFactory.getIndexChangeFaceButtonRollover()
				.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[1], 1);

		images[2] = ImageFactory.getIndexChangeFaceButtonPressed()
				.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[2], 2);
		try {
			mt.waitForAll();
		} catch (Exception exe) {
			exe.printStackTrace();
		}

		return createButton(name, cmd, listener, images);
	}

	public static JButton createIndexMenuButton(final int width,
			final int height, final String name, final String cmd,
			final ActionListener listener) {

		Image[] images = new Image[3];
		MediaTracker mt = new MediaTracker(panel);

		images[0] = ImageFactory.getIndexMenuButton().getScaledInstance(width,
				height, Image.SCALE_DEFAULT);
		mt.addImage(images[0], 0);

		images[1] = ImageFactory.getIndexMenuButtonRollover()
				.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[1], 1);

		images[2] = ImageFactory.getIndexMenuButtonPressed().getScaledInstance(
				width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[2], 2);
		try {
			mt.waitForAll();
		} catch (Exception exe) {
			exe.printStackTrace();
		}

		return createButton(name, cmd, listener, images);
	}

	public static JButton createLoginAccountInputButton(final int width,
			final int height, final String name, final String cmd,
			final ActionListener listener) {

		Image[] images = new Image[3];
		MediaTracker mt = new MediaTracker(panel);

		images[0] = ImageFactory.getLoginAccountInputButton()
				.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[0], 0);

		images[1] = ImageFactory.getLoginAccountInputButtonRollover()
				.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[1], 1);

		images[2] = ImageFactory.getLoginAccountInputButtonPressed()
				.getScaledInstance(width, height, Image.SCALE_DEFAULT);
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
		checkBox.setDisabledIcon(new ImageIcon(ImageFactory
				.getDisableCheckBoxImage()));
		checkBox.setSelectedIcon(new ImageIcon(ImageFactory
				.getCheckedBoxImage()));
		checkBox.setDisabledSelectedIcon(new ImageIcon(ImageFactory
				.getDisableCheckedBoxImage()));

		checkBox.setFont(Define.DEFAULT_FONT);
		checkBox.setOpaque(false);

		return checkBox;
	}

	public static JButton createIndexSearchListButton(final int width,
			final int height, final String name, final String cmd,
			final ActionListener listener) {
		Image[] images = new Image[3];
		MediaTracker mt = new MediaTracker(panel);

		images[0] = ImageFactory.getIndexSearchListButton().getScaledInstance(
				width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[0], 0);

		images[1] = ImageFactory.getIndexSearchListButtonRollover()
				.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[1], 1);

		images[2] = ImageFactory.getIndexSearchListButtonPressed()
				.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[2], 2);
		try {
			mt.waitForAll();
		} catch (Exception exe) {
			exe.printStackTrace();
		}

		return createButton(name, cmd, listener, images);
	}

	public static JButton createIndexSearchEnterButton(final int width,
			final int height, final String name, final String cmd,
			final ActionListener listener) {
		Image[] images = new Image[3];
		MediaTracker mt = new MediaTracker(panel);

		images[0] = ImageFactory.getIndexSearchEnterButton().getScaledInstance(
				width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[0], 0);

		images[1] = ImageFactory.getIndexSearchEnterButtonRollover()
				.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[1], 1);

		images[2] = ImageFactory.getIndexSearchEnterButtonPressed()
				.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[2], 2);
		try {
			mt.waitForAll();
		} catch (Exception exe) {
			exe.printStackTrace();
		}

		return createButton(name, cmd, listener, images);
	}

	public static JButton createIndexDirLockButton(final int width,
			final int height, final String name, final String cmd,
			final ActionListener listener) {
		Image[] images = new Image[3];
		MediaTracker mt = new MediaTracker(panel);

		images[0] = ImageFactory.getIndexDirLockButton().getScaledInstance(
				width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[0], 0);

		images[1] = ImageFactory.getIndexDirLockButtonRollover()
				.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[1], 1);

		images[2] = ImageFactory.getIndexDirLockButtonPressed()
				.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[2], 2);
		try {
			mt.waitForAll();
		} catch (Exception exe) {
			exe.printStackTrace();
		}

		return createButton(name, cmd, listener, images);
	}

	public static JButton createIndexDirUnLockButton(final int width,
			final int height, final String name, final String cmd,
			final ActionListener listener) {
		Image[] images = new Image[3];
		MediaTracker mt = new MediaTracker(panel);

		images[0] = ImageFactory.getIndexDirUnLockButton().getScaledInstance(
				width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[0], 0);

		images[1] = ImageFactory.getIndexDirUnLockButtonRollover()
				.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[1], 1);

		images[2] = ImageFactory.getIndexDirUnLockButtonPressed()
				.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[2], 2);
		try {
			mt.waitForAll();
		} catch (Exception exe) {
			exe.printStackTrace();
		}

		return createButton(name, cmd, listener, images);
	}

	public static JButton createIndexTabButton(final int width,
			final int height, final String name, final String cmd,
			final ActionListener listener) {
		Image[] images = new Image[3];
		MediaTracker mt = new MediaTracker(panel);

		images[0] = ImageFactory.getIndexTabBackground(width, height);
		mt.addImage(images[0], 0);

		images[1] = ImageFactory.getIndexTabBackgroundRollover(width, height);
		mt.addImage(images[1], 1);

		images[2] = ImageFactory.getIndexTabBackgroundPressed(width, height);
		mt.addImage(images[2], 2);

		try {
			mt.waitForAll();
		} catch (Exception exe) {
			exe.printStackTrace();
		}

		return createButton(name, cmd, listener, images);
	}

	public static JButton createIndexLeftSplitterButton(final int width,
			final int height, final String name, final String cmd,
			final ActionListener listener) {
		Image[] images = new Image[4];
		MediaTracker mt = new MediaTracker(panel);

		images[0] = ImageFactory.getIndexLeftSplitterButton()
				.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[0], 0);

		images[1] = ImageFactory.getIndexLeftSplitterButtonRollover()
				.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[1], 1);

		images[2] = ImageFactory.getIndexLeftSplitterButtonPressed()
				.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[2], 2);

		images[3] = ImageFactory.getIndexLeftSplitterButtonDisable()
				.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[3], 3);
		try {
			mt.waitForAll();
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		final JButton button = createButton(name, cmd, listener, images);
		button.setDisabledIcon(new ImageIcon(images[3]));

		button.addAncestorListener(new AncestorListener() {
			private boolean isAdded = false;

			@Override
			public void ancestorRemoved(AncestorEvent event) {

			}

			@Override
			public void ancestorMoved(AncestorEvent event) {

			}

			@Override
			public void ancestorAdded(AncestorEvent event) {
				if (isAdded)
					return;
				button.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						Component comp = SwingUtilities.getRoot(button);
						if (comp != null && comp instanceof JFrame) {
							comp.setCursor(new Cursor(Cursor.HAND_CURSOR));
						}
					}

					@Override
					public void mouseExited(MouseEvent e) {
						Component comp = SwingUtilities.getRoot(button);
						if (comp != null && comp instanceof JFrame) {
							comp.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
						}
					}
				});
				isAdded = true;
			}
		});
		return button;
	}

	public static JButton createIndexRightSplitterButton(final int width,
			final int height, final String name, final String cmd,
			final ActionListener listener) {
		Image[] images = new Image[4];
		MediaTracker mt = new MediaTracker(panel);

		images[0] = ImageFactory.getIndexRightSplitterButton()
				.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[0], 0);

		images[1] = ImageFactory.getIndexRightSplitterButtonRollover()
				.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[1], 1);

		images[2] = ImageFactory.getIndexRightSplitterButtonPressed()
				.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[2], 2);

		images[3] = ImageFactory.getIndexRightSplitterButtonDisable()
				.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		mt.addImage(images[3], 3);
		try {
			mt.waitForAll();
		} catch (Exception exe) {
			exe.printStackTrace();
		}
		final JButton button = createButton(name, cmd, listener, images);
		button.setDisabledIcon(new ImageIcon(images[3]));
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));

		button.addAncestorListener(new AncestorListener() {
			private boolean isAdded = false;

			@Override
			public void ancestorRemoved(AncestorEvent event) {

			}

			@Override
			public void ancestorMoved(AncestorEvent event) {

			}

			@Override
			public void ancestorAdded(AncestorEvent event) {
				if (isAdded)
					return;
				button.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						Component comp = SwingUtilities.getRoot(button);
						if (comp != null && comp instanceof JFrame) {
							comp.setCursor(new Cursor(Cursor.HAND_CURSOR));
						}
					}

					@Override
					public void mouseExited(MouseEvent e) {
						Component comp = SwingUtilities.getRoot(button);
						if (comp != null && comp instanceof JFrame) {
							comp.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
						}
					}
				});
				isAdded = true;
			}
		});
		return button;
	}

	public static JButton createIndexTabScrollLeftButton(final int width,
			final int height, final String name, final String cmd,
			final TabScrollActionAdapter listener) {
		Image[] images = new Image[3];
		MediaTracker mt = new MediaTracker(panel);

		images[0] = ImageFactory.getIndexTabScrollLeftButton(width, height);
		mt.addImage(images[0], 0);

		images[1] = ImageFactory.getIndexTabScrollLeftButtonRollover(width,
				height);
		mt.addImage(images[1], 1);

		images[2] = ImageFactory.getIndexTabScrollLeftButtonPressed(width,
				height);
		mt.addImage(images[2], 2);

		try {
			mt.waitForAll();
		} catch (Exception exe) {
			exe.printStackTrace();
		}

		return createButton(name, cmd, listener, images);
	}

	public static JButton createIndexTabScrollLeftDisableButton(
			final int width, final int height, final String name,
			final String cmd, final TabScrollActionAdapter listener) {
		Image[] images = new Image[1];
		MediaTracker mt = new MediaTracker(panel);

		images[0] = ImageFactory.getIndexTabScrollLeftDisableButton(width,
				height);
		mt.addImage(images[0], 0);

		try {
			mt.waitForAll();
		} catch (Exception exe) {
			exe.printStackTrace();
		}

		return createButton(name, cmd, listener, images);
	}

	public static JButton createIndexTabScrollRightButton(final int width,
			final int height, final String name, final String cmd,
			final TabScrollActionAdapter listener) {
		Image[] images = new Image[3];
		MediaTracker mt = new MediaTracker(panel);

		images[0] = ImageFactory.getIndexTabScrollRightButton(width, height);
		mt.addImage(images[0], 0);

		images[1] = ImageFactory.getIndexTabScrollRightButtonRollover(width,
				height);
		mt.addImage(images[1], 1);

		images[2] = ImageFactory.getIndexTabScrollRightButtonPressed(width,
				height);
		mt.addImage(images[2], 2);

		try {
			mt.waitForAll();
		} catch (Exception exe) {
			exe.printStackTrace();
		}

		return createButton(name, cmd, listener, images);
	}

	public static JButton createIndexTabScrollRightDisableButton(
			final int width, final int height, final String name,
			final String cmd, final TabScrollActionAdapter listener) {
		Image[] images = new Image[1];
		MediaTracker mt = new MediaTracker(panel);

		images[0] = ImageFactory.getIndexTabScrollRightDisableButton(width,
				height);
		mt.addImage(images[0], 0);

		try {
			mt.waitForAll();
		} catch (Exception exe) {
			exe.printStackTrace();
		}

		return createButton(name, cmd, listener, images);
	}
}
