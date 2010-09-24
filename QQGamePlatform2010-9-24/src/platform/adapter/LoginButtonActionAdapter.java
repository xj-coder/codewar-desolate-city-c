package platform.adapter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import platform.action.LoginAction;
import platform.bean.LoginBean;
import platform.bean.PlayerBean;
import platform.exception.LoginException;
import platform.ui.index.IndexUI;
import platform.ui.login.LoginParams;
import platform.ui.login.LoginUI;

public class LoginButtonActionAdapter implements ActionListener {
	private LoginUI loginUI;

	private int taskIndex = 0;

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
				loginUI.getHide_check().setEnabled(true);
				loginUI.getAgree_check().setEnabled(true);

				taskIndex++;
			} else {
				loginUI.setLoginProcessStart(true);
				loginUI.getLogin_button().setName(LoginParams.NAME_CALCEL);

				loginUI.getAccount_input().setEnabled(false);
				loginUI.getPassword_input().setEnabled(false);
				loginUI.getMemory_check().setEnabled(false);
				loginUI.getHide_check().setEnabled(false);
				loginUI.getAgree_check().setEnabled(false);

				LoginBean loginBean = new LoginBean();
				taskIndex++;
				LoginTask task = new LoginTask(loginBean, taskIndex);
				new Thread(task).start();
			}
		} else if (event.getActionCommand().equals(LoginParams.ACTION_SETTING)) {
			if (loginUI.getSet_button().getName().equals(LoginParams.NAME_SETTING)) {
				loginUI.getSet_button().setName(LoginParams.NAME_SETTING_CLICKED);
			} else {
				loginUI.getSet_button().setName(LoginParams.NAME_SETTING);
			}
		}
	}

	class LoginTask implements Runnable {
		private int taskTime;
		private LoginBean loginBean;

		public LoginTask(LoginBean loginBean, int taskTime) {
			this.loginBean = loginBean;
			this.taskTime = taskTime;
		}

		@Override
		public void run() {
			try {
				PlayerBean playerBean = new LoginAction().login(loginBean);

				if (taskIndex == taskTime) {
					loginUI.setVisible(false);
					new IndexUI(playerBean).setVisible(true);
				}
			} catch (LoginException e) {
				System.out.println(e.getMessage());
			}
		}

		public void setTaskTime(int taskTime) {
			this.taskTime = taskTime;
		}
	}
}
