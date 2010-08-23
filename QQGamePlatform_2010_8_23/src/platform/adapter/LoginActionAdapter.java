package platform.adapter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import platform.action.LoginAction;
import platform.bean.LoginBean;
import platform.bean.PlayerBean;
import platform.exception.LoginException;
import platform.ui.IndexUI;
import platform.ui.LoginParams;
import platform.ui.LoginUI;

public class LoginActionAdapter implements ActionListener {
	private LoginUI loginUI;

	private LoginBean loginBean = null;

	private int taskIndex = 0;

	public LoginActionAdapter(LoginUI loginUI) {
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

				taskIndex++;
			} else {
				loginUI.setLoginProcessStart(true);
				loginUI.getLogin_button().setName(LoginParams.NAME_CALCEL);

				loginBean = new LoginBean();

				taskIndex++;

				LoginTask task = new LoginTask(taskIndex);

				new Thread(task).start();
			}
		} else if (event.getActionCommand().equals(LoginParams.ACTION_SETTING)) {
			if (loginUI.getSet_button().getName().equals(
					LoginParams.NAME_SETTING)) {
				loginUI.getSet_button().setName(
						LoginParams.NAME_SETTING_CLICKED);
			} else {
				loginUI.getSet_button().setName(LoginParams.NAME_SETTING);
			}
		}
	}

	class LoginTask implements Runnable {
		private int taskTime;

		public LoginTask(int taskTime) {
			this.taskTime = taskTime;
		}

		@Override
		public void run() {
			try {
				PlayerBean playerBean = new LoginAction().login(loginBean);

				if (LoginActionAdapter.this.taskIndex == taskTime) {
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
