package c.city.desolate.client.ides;

import java.awt.event.ActionListener;

import javax.swing.JTextArea;

import org.jdesktop.swingx.JXButton;
import org.jdesktop.swingx.JXPanel;

import c.city.desolate.client.view.Console;

@SuppressWarnings("serial")
public abstract class AbstractIDE extends JXPanel{
	
	protected JXPanel toolBarPanel;// 工具栏
	protected JXPanel leftPanel;// 左边
	protected JXPanel rightPanel;// 邮编
	protected JXPanel editorPanel;// 编辑面板
	protected JXPanel consolePanel;// 控制台面板

	protected JXButton readyBtn;// 准备按钮
	protected JTextArea editorBox;// 代码编辑区
	protected Console console = new Console();// 代码控制台
	

	protected abstract void showMe();

	protected abstract JXButton getReadyBtn();

	protected abstract JTextArea getEditorBox();

	/**************************************************
	 * 提供方法，给外部注册监听器,继承的类不能覆盖这些方法
	 ***************************************************/
	// 编辑器监听
	public final void regiestEditorBox(ActionListener listener) {

	}

	// 准备按钮监听
	public final void registerReadyBtn(ActionListener listener) {
		readyBtn.addActionListener(listener);
	}
	/**************************************************/
}
