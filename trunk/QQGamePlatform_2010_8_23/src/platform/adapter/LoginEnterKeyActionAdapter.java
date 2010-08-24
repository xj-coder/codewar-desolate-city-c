package platform.adapter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import platform.ui.LoginParams;
import platform.ui.LoginUI;

public class LoginEnterKeyActionAdapter implements ActionListener {
	private LoginUI loginUI;

	public LoginEnterKeyActionAdapter(LoginUI loginUI) {
		this.loginUI = loginUI;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals(LoginParams.ACTION_LOGIN)) {
			loginUI.getLogin_button().doClick();
		}
	}

}
