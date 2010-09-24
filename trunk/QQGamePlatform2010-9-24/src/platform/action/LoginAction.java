package platform.action;

import platform.bean.LoginBean;
import platform.bean.PlayerBean;
import platform.exception.LoginException;

public class LoginAction {

	public PlayerBean login(LoginBean loginBean) throws LoginException {
		for (int i = 0; i < 1000000000l; i++) {
			i++;
		}

		return new PlayerBean();
	}
}
