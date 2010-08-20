package platform.adapter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import platform.ui.LoginUI;

public class LoginMouseAdapter extends MouseAdapter {
	private LoginUI loginUI;

	private int pressX;
	private int pressY;

	public LoginMouseAdapter(LoginUI loginUI) {
		this.loginUI = loginUI;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		pressX = e.getX();
		pressY = e.getY();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		int x = loginUI.getX() + e.getX() - pressX;
		int y = loginUI.getY() + e.getY() - pressY;
		loginUI.setLocation(x, y);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object source = e.getSource();
		if (source instanceof JLabel) {
			JLabel label = (JLabel) source;
			if (label.getName() != null && label.getName().equals("close_button")) {
				loginUI.setVisible(false);
				System.exit(0);
			}
		}
	}
}
