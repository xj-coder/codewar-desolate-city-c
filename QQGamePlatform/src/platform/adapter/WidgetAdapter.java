package platform.adapter;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import platform.tools.ImageFactory;

public class WidgetAdapter extends MouseAdapter {
	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource() instanceof JLabel) {
			JLabel label = (JLabel) e.getSource();
			if (label.getName() != null) {
				if (label.getName().equals("close_button")) {
					label.setIcon(new ImageIcon(ImageFactory.getLoginCloseButton3().getScaledInstance(40, 22, Image.SCALE_DEFAULT)));
				} else if (label.getName().equals("help_button")) {
					label.setIcon(new ImageIcon(ImageFactory.getLoginHelpButton3().getScaledInstance(21, 22, Image.SCALE_DEFAULT)));
				} else if (label.getName().equals("login_button")) {
					label.setIcon(new ImageIcon(ImageFactory.getLoginHelpButton3().getScaledInstance(21, 22, Image.SCALE_DEFAULT)));
				}
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getSource() instanceof JLabel) {
			JLabel label = (JLabel) e.getSource();
			if (label.getName() != null) {
				if (label.getName().equals("close_button")) {
					label.setIcon(new ImageIcon(ImageFactory.getLoginCloseButton1().getScaledInstance(40, 22, Image.SCALE_DEFAULT)));
				} else if (label.getName().equals("help_button")) {
					label.setIcon(new ImageIcon(ImageFactory.getLoginHelpButton1().getScaledInstance(21, 22, Image.SCALE_DEFAULT)));
				}
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() instanceof JLabel) {
			JLabel label = (JLabel) e.getSource();
			if (label.getName() != null) {
				if (label.getName().equals("close_button")) {
					label.setIcon(new ImageIcon(ImageFactory.getLoginCloseButton2().getScaledInstance(40, 22, Image.SCALE_DEFAULT)));
				} else if (label.getName().equals("help_button")) {
					label.setIcon(new ImageIcon(ImageFactory.getLoginHelpButton2().getScaledInstance(21, 22, Image.SCALE_DEFAULT)));
				}
			}
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() instanceof JLabel) {
			JLabel label = (JLabel) e.getSource();
			if (label.getName() != null) {
				if (label.getName().equals("close_button")) {
					label.setIcon(new ImageIcon(ImageFactory.getLoginCloseButton1().getScaledInstance(40, 22, Image.SCALE_DEFAULT)));
				} else if (label.getName().equals("help_button")) {
					label.setIcon(new ImageIcon(ImageFactory.getLoginHelpButton1().getScaledInstance(21, 22, Image.SCALE_DEFAULT)));
				}
			}
		}
	}

}
