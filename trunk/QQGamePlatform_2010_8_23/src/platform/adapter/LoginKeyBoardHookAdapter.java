package platform.adapter;

import org.eclipse.swt.extension.hook.data.HookData;
import org.eclipse.swt.extension.hook.data.KeyboardHookData;
import org.eclipse.swt.extension.hook.listener.HookEventListener;

import platform.ui.login.LoginUI;

public class LoginKeyBoardHookAdapter implements HookEventListener {
	private LoginUI loginUI;

	public LoginKeyBoardHookAdapter(LoginUI loginUI) {
		this.loginUI = loginUI;
	}

	@Override
	public void acceptHookData(HookData hookData) {
		if (hookData instanceof KeyboardHookData) {
			if (((KeyboardHookData) hookData).getVirtualKeyCode() == '\r') {
				if (!loginUI.isActive()) {
					return;
				}
				loginUI.getLogin_button().doClick();
				loginUI.unRegisterKeyBoardHook();

				new Thread(new Runnable() {
					@Override
					public void run() {
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						loginUI.registerKeyBoardHook();
					}
				}).start();
			}
		}
	}
}
