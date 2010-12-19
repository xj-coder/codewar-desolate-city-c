package platform.adapter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import platform.bean.LoginBean;
import platform.define.RunTimeDefine;
import platform.task.TaskThread;
import platform.task.login.LoginTask;
import platform.ui.login.LoginParams;
import platform.ui.login.LoginUI;

public class LoginButtonActionAdapter implements ActionListener {
	private LoginUI loginUI;
	private LoginTask loginTask;

	public LoginButtonActionAdapter(LoginUI loginUI) {
		this.loginUI = loginUI;
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		if (event.getActionCommand().equals(LoginParams.ACTION_CLOSE)) {
			loginUI.setVisible(false);
			System.exit(0);
		} else if (event.getActionCommand().equals(LoginParams.ACTION_LOGIN)) {
			if (loginUI.isLoginProcessStart()) {
				loginUI.setLoginProcessStart(false);
				loginUI.getLogin_button().setName(LoginParams.NAME_LOGIN);

				loginUI.getAccount_input().setEnabled(true);
				loginUI.getPassword_input().setEnabled(true);
				loginUI.getMemory_check().setEnabled(true);
				loginUI.getAlone_check().setEnabled(true);
				loginUI.getAgree_check().setEnabled(true);

				TaskThread.getTaskThread().getPool().removeTask(loginTask);
			} else {
				loginUI.setLoginProcessStart(true);
				loginUI.getLogin_button().setName(LoginParams.NAME_CALCEL);

				loginUI.getAccount_input().setEnabled(false);
				loginUI.getPassword_input().setEnabled(false);
				loginUI.getMemory_check().setEnabled(false);
				loginUI.getAlone_check().setEnabled(false);
				loginUI.getAgree_check().setEnabled(false);

				LoginBean loginBean = new LoginBean();
				if (loginUI.getAlone_check().isSelected()) {
					RunTimeDefine.isAlone = true;
					loginTask = new LoginTask(loginUI, loginBean, true);
				} else {
					RunTimeDefine.isAlone = false;
					loginTask = new LoginTask(loginUI, loginBean, false);
				}
				TaskThread.getTaskThread().getPool().addTask(loginTask);
			}
		} else if (event.getActionCommand().equals(LoginParams.ACTION_SETTING)) {
			if (loginUI.getSet_button().getName().equals(LoginParams.NAME_SETTING)) {
				loginUI.getSet_button().setName(LoginParams.NAME_SETTING_CLICKED);
			} else {
				loginUI.getSet_button().setName(LoginParams.NAME_SETTING);
			}
		}
	}
}
