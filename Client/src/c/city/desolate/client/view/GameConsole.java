package c.city.desolate.client.view;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

import org.jdesktop.swingx.JXPanel;

/**
 * 游戏控制台界面
 * 
 * @author Desolate.City.C
 * 
 */
@SuppressWarnings("serial")
public class GameConsole extends JXPanel {

	private JTextArea console;// 控制台输出区
	private JToolBar toolBarUI;// 工具栏
	private JButton clearBtn;// 清除控制台
	private JButton scrollLockBtn;// 锁屏

	public GameConsole() {
		initialization();
		showMe();
	}

	private void showMe() {
		setVisible(true);
	}

	private void initialization() {

	}

	public JTextArea getConsole() {
		return console;
	}

	public JToolBar getToolBarUI() {
		return toolBarUI;
	}

	public JButton getClearBtn() {
		return clearBtn;
	}

	public JButton getScrollLockBtn() {
		return scrollLockBtn;
	}

	public void println() {

	}

	public void print() {

	}

	public void clear() {

	}

	// 执行控制台命令
	public void excute(String param) {

	}
}
