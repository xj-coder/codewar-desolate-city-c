package platform.widget;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import platform.tools.ImageFactory;

public class WidgetFactory {

	public static JLabel createCloseButton(int width, int height) {
		JLabel close_button = new JLabel(new ImageIcon(ImageFactory.getLoginCloseButton1().getScaledInstance(width, height, Image.SCALE_DEFAULT)));
		close_button.setName("close_button");
		close_button.setOpaque(false);
		close_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				JLabel label = (JLabel) e.getSource();
				label.setIcon(new ImageIcon(ImageFactory.getLoginCloseButton2().getScaledInstance(40, 22, Image.SCALE_DEFAULT)));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				JLabel label = (JLabel) e.getSource();
				label.setIcon(new ImageIcon(ImageFactory.getLoginCloseButton1().getScaledInstance(40, 22, Image.SCALE_DEFAULT)));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				JLabel label = (JLabel) e.getSource();
				label.setIcon(new ImageIcon(ImageFactory.getLoginCloseButton3().getScaledInstance(40, 22, Image.SCALE_DEFAULT)));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				JLabel label = (JLabel) e.getSource();
				label.setIcon(new ImageIcon(ImageFactory.getLoginCloseButton1().getScaledInstance(40, 22, Image.SCALE_DEFAULT)));
			}
		});
		return close_button;
	}

	public static JLabel createHelpButton(int width, int height) {
		JLabel help_button = new JLabel(new ImageIcon(ImageFactory.getLoginHelpButton1().getScaledInstance(width, height, Image.SCALE_DEFAULT)));
		help_button.setName("help_button");
		help_button.setOpaque(false);
		help_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				JLabel label = (JLabel) e.getSource();
				label.setIcon(new ImageIcon(ImageFactory.getLoginHelpButton2().getScaledInstance(21, 22, Image.SCALE_DEFAULT)));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				JLabel label = (JLabel) e.getSource();
				label.setIcon(new ImageIcon(ImageFactory.getLoginHelpButton1().getScaledInstance(21, 22, Image.SCALE_DEFAULT)));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				JLabel label = (JLabel) e.getSource();
				label.setIcon(new ImageIcon(ImageFactory.getLoginHelpButton3().getScaledInstance(21, 22, Image.SCALE_DEFAULT)));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				JLabel label = (JLabel) e.getSource();
				label.setIcon(new ImageIcon(ImageFactory.getLoginHelpButton1().getScaledInstance(21, 22, Image.SCALE_DEFAULT)));
			}
		});
		return help_button;
	}

	public static JLabel createButton1(final int width, final int height, final boolean isShader) {
		JLabel button = new JLabel(new ImageIcon(ImageFactory.getButtonOut1(width, height, isShader)));
		button.setOpaque(false);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				JLabel label = (JLabel) e.getSource();
				label.setIcon(new ImageIcon(ImageFactory.getButtonOn1(width, height, isShader)));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				JLabel label = (JLabel) e.getSource();
				label.setIcon(new ImageIcon(ImageFactory.getButtonOut1(width, height, isShader)));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				JLabel label = (JLabel) e.getSource();
				label.setIcon(new ImageIcon(ImageFactory.getButtonDown1(width, height, isShader)));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				JLabel label = (JLabel) e.getSource();
				label.setIcon(new ImageIcon(ImageFactory.getButtonOut1(width, height, isShader)));
			}
		});
		return button;
	}

	public static JLabel createButton2(final int width, final int height, final boolean isShader) {
		JLabel button = new JLabel(new ImageIcon(ImageFactory.getButtonOut2(width, height, isShader)));
		button.setOpaque(false);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				JLabel label = (JLabel) e.getSource();
				label.setIcon(new ImageIcon(ImageFactory.getButtonOn1(width, height, isShader)));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				JLabel label = (JLabel) e.getSource();
				label.setIcon(new ImageIcon(ImageFactory.getButtonOut2(width, height, isShader)));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				JLabel label = (JLabel) e.getSource();
				label.setIcon(new ImageIcon(ImageFactory.getButtonDown1(width, height, isShader)));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				JLabel label = (JLabel) e.getSource();
				label.setIcon(new ImageIcon(ImageFactory.getButtonOut2(width, height, isShader)));
			}
		});
		return button;
	}
}
