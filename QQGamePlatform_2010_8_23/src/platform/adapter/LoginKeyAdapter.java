package platform.adapter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import platform.ui.LoginUI;

public class LoginKeyAdapter extends KeyAdapter {
	private LoginUI loginUI;

	public LoginKeyAdapter(LoginUI loginUI) {
		this.loginUI = loginUI;
	}

	@Override
	public void keyPressed(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.VK_ENTER) {
			loginUI.getLogin_button().doClick();
		}
	}
}
