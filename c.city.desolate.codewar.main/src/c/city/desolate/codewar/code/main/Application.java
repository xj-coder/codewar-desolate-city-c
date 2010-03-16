package c.city.desolate.codewar.code.main;

import java.util.Map;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import c.city.desolate.codewar.code.bean.Player;
import c.city.desolate.codewar.code.ui.shell.LoginShell;
import c.city.desolate.codewar.code.util.PlayerInfoVerify;

/**
 * This class controls all aspects of the application's execution
 */
public class Application implements IApplication {
	private final LoginShell loginShell;
	private final Display display;
	private Player player;
	private String msg;

	public Application() {
		display = PlatformUI.createDisplay();
		loginShell = new LoginShell(display, SWT.NO_TRIM);
	}

	/*
	 * @seeorg.eclipse.equinox.app.IApplication#start(org.eclipse.equinox.app.
	 * IApplicationContext)
	 */
	public Object start(IApplicationContext context) throws Exception {
		// 显示登入界面
		loginShell.open();
		loginShell.layout();
		while (!loginShell.isDisposed()) {
			if (loginShell.getParam() != null) {
				Map<String, Object> result = PlayerInfoVerify
						.VerufyPlayerLogin(loginShell.getParam());
				player = (Player) result.get("player");
				msg = (String) result.get("msg");
				if (player != null)
					loginShell.close();
				else {
					loginShell.setParam(null);
				}
				if (msg != null)
					MessageDialog.openError(loginShell, "Error", msg);
			}
			if (!display.readAndDispatch())
				display.sleep();
		}
		if (player != null) {
			int returnCode = PlatformUI.createAndRunWorkbench(display,
					new ApplicationWorkbenchAdvisor());
			if (returnCode == PlatformUI.RETURN_RESTART)
				return IApplication.EXIT_RESTART;
			else
				return IApplication.EXIT_OK;
		}
		display.dispose();
		return IApplication.EXIT_OK;
	}

	/*
	 * @see org.eclipse.equinox.app.IApplication#stop()
	 */
	public void stop() {
		final IWorkbench workbench = PlatformUI.getWorkbench();
		if (workbench == null)
			return;
		final Display display = workbench.getDisplay();
		display.syncExec(new Runnable() {
			public void run() {
				if (!display.isDisposed())
					workbench.close();
			}
		});
	}
}
