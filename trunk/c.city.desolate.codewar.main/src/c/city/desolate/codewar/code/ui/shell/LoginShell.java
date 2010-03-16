package c.city.desolate.codewar.code.ui.shell;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.swtdesigner.SWTResourceManager;

public class LoginShell extends Shell {
	private Map<String, String> param;// 储存信息的map

	private Text psw_txt;// 登入名
	private Text id_txt;// 登入密码

	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			LoginShell shell = new LoginShell(display, SWT.NO_TRIM);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell
	 * 
	 * @param display
	 * @param style
	 */
	public LoginShell(Display display, int style) {
		super(display, style);
		createContents();
	}

	/**
	 * Create contents of the window
	 */
	protected void createContents() {
		this.setText("Login");
		this.setSize(334, 170);
		int width = this.getMonitor().getClientArea().width;
		int height = this.getMonitor().getClientArea().height;
		int x = this.getSize().x;
		int y = this.getSize().y;
		if (x > width) {
			this.getSize().x = width;
		}
		if (y > height) {
			this.getSize().y = height;
		}
		this.setLocation((width - x) / 2, (height - y) / 2);

		final Label idLabel = new Label(this, SWT.NONE);
		idLabel.setAlignment(SWT.CENTER);
		idLabel.setFont(SWTResourceManager.getFont("", 12, SWT.NONE));
		idLabel.setText("ID:");
		idLabel.setBounds(10, 25, 80, 20);

		final Label passwordLabel = new Label(this, SWT.NONE);
		passwordLabel.setAlignment(SWT.CENTER);
		passwordLabel.setFont(SWTResourceManager.getFont("", 12, SWT.NONE));
		passwordLabel.setText("Password");
		passwordLabel.setBounds(10, 65, 80, 20);

		id_txt = new Text(this, SWT.BORDER);
		id_txt.setBounds(100, 25, 200, 20);

		psw_txt = new Text(this, SWT.BORDER | SWT.PASSWORD);
		psw_txt.setBounds(100, 65, 200, 20);

		final Button submit_btn = new Button(this, SWT.NONE);
		submit_btn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				submit();
			}
		});
		submit_btn.setText("Submit");
		submit_btn.setBounds(198, 111, 48, 22);

		final Button center_btn = new Button(this, SWT.NONE);
		center_btn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				close();
			}
		});
		center_btn.setText("Center");
		center_btn.setBounds(252, 111, 48, 22);
	}

	private void submit() {
		param = new HashMap<String, String>();
		param.put("id", id_txt.getText());
		param.put("psw", psw_txt.getText());
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public Map<String, String> getParam() {
		return param;
	}

	public void setParam(Map<String, String> param) {
		this.param = param;
	}
}
