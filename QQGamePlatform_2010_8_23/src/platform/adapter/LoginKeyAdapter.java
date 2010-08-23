package platform.adapter;

import java.awt.event.KeyAdapter;

import platform.ui.LoginUI;

public class LoginKeyAdapter extends KeyAdapter {
	private LoginUI loginUI;

	public LoginKeyAdapter(LoginUI loginUI) {
		this.loginUI = loginUI;
	}

}
