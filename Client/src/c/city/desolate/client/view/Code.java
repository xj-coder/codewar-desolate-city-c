package c.city.desolate.client.view;

import java.awt.event.ActionListener;

import javax.swing.JTextArea;

import org.jdesktop.swingx.JXButton;
import org.jdesktop.swingx.JXPanel;

import c.city.desolate.client.error.GameException;
import c.city.desolate.client.xml.bean.IdeXML;
import c.city.desolate.client.xml.parse.IdeXMLParse;

/**
 * 这是代码界面,需要做成可编译不同语言的<BR>
 * 打开编辑框的时候,先调用initialization()方法,<BR>
 * initialization()方法根据指定的language,用相应的显示初始代码方案显示初始代码.<BR>
 * -----在各自的显示初始代码方案中要做的事:<BR>
 * ---------1)加入公用代码 、包或者函数块<BR>
 * ---------2)显示必须实现的空方法<BR>
 * 在按下准备按钮的时候调用compilate()方法编译源代码<BR>
 * compilate()方法根据指定的language，用相应的编译方案进行编译Code&lt;<BR>
 * -----在各自的编译方案中，要做的事有：<BR>
 * ---------1)<BR>
 * ---------2)<BR>
 * 当所有玩家都处于准备状态的时候,调用run()方法，运行游戏
 * 
 * 
 * 
 * @author Desolate.City.C
 * 
 */
@SuppressWarnings( { "unchecked", "serial" })
public abstract class Code extends JXPanel {

	protected JXPanel toolBarPanel;// 工具栏
	protected JXPanel leftPanel;// 左边
	protected JXPanel rightPanel;// 邮编
	protected JXPanel editorPanel;// 编辑面板
	protected JXPanel consolePanel;// 控制台面板

	protected JXButton readyBtn;// 准备按钮
	protected JTextArea editorBox;// 代码编辑区
	protected Console console = new Console();// 代码控制台

	public static Code getCode(String language) throws GameException {
		Code code = null;
		IdeXML ideXML = IdeXMLParse.getIdes().get(language);
		if (null != ideXML) {
			// TODO[Desolate.City.C][OK][用反射实例化指定Game的实现类]
			try {
				Class<Code> _class = (Class<Code>) Class.forName(ideXML
						.getClassPath());
				code = _class.newInstance();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				throw new GameException(e);
			} catch (InstantiationException e) {
				e.printStackTrace();
				throw new GameException(e);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				throw new GameException(e);
			}
		}
		return code;
	}

	protected Code() {
	}

	protected abstract void showMe();

	protected abstract JXButton getReadyBtn();

	protected abstract JTextArea getEditorBox();

	protected abstract void initialization();

	protected abstract void compilate();

	protected abstract void run();

	// 提供方法，给外部注册监听器
	// 编辑器监听
	public void regiestEditorBox(ActionListener listener) {

	}

	// 准备按钮监听
	public void registerReadyBtn(ActionListener listener) {
		readyBtn.addActionListener(listener);
	}
}
