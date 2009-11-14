package c.city.desolate.client.ides;

import java.awt.event.ActionListener;

import javax.swing.JTextArea;

import org.jdesktop.swingx.JXButton;
import org.jdesktop.swingx.JXPanel;

import c.city.desolate.client.view.Console;

@SuppressWarnings("serial")
public abstract class AbstractIDE extends JXPanel {

	public JXPanel toolBarPanel;// 工具栏
	public JXPanel leftPanel;// 左边
	public JXPanel rightPanel;// 邮编
	public JXPanel editorPanel;// 编辑面板
	public JXPanel consolePanel;// 控制台面板

	public JXButton readyBtn;// 准备按钮
	public JTextArea editorBox;// 代码编辑区
	public Console console = new Console();// 代码控制台

	public abstract void showMe();

	public abstract JXButton getReadyBtn();

	public abstract JTextArea getEditorBox();

	/**************************************************
	 * 提供方法，给初始化
	 ***************************************************/
	// 初始化游戏代码
	public abstract void iniEditorBox(String iniSrcPath);

	/**************************************************/

	/**************************************************
	 * 提供方法，给外部注册监听器,继承的类不能覆盖这些方法
	 ***************************************************/
	// 编辑器监听
	public final void registerEditorBoxActionListener(ActionListener listener) {

	}

	// 准备按钮监听
	public final void registerReadyBtnActionListener(ActionListener listener) {
		readyBtn.addActionListener(listener);
	}
	/**************************************************/
}
