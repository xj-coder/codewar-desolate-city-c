package platform.task.login;

import platform.action.LoginAction;
import platform.bean.LoginBean;
import platform.bean.PlayerBean;
import platform.exception.LoginException;
import platform.task.Task;
import platform.ui.index.IndexUI;
import platform.ui.login.LoginUI;

public class LoginTask extends Task {
	private LoginBean loginBean;
	private LoginUI loginUI;
	private boolean isAlone;

	private PlayerBean playerBean;

	public LoginTask(LoginUI loginUI, LoginBean loginBean, boolean isAlone) {
		this.loginUI = loginUI;
		this.loginBean = loginBean;
		this.isAlone = isAlone;
	}

	@Override
	protected void canNotStop() {
		loginUI.setVisible(false);
		IndexUI indexUI = new IndexUI(playerBean);
		indexUI.showMe();
	}

	@Override
	protected void canStop() {
		try {
			if (!isAlone) {
				playerBean = new LoginAction().login(loginBean);
			} else {

			}
		} catch (LoginException e) {
			System.out.println(e.getMessage());
		}
	}
}