package c.city.desolate.client.view;

import javax.swing.JTextArea;

import org.jdesktop.swingx.JXButton;

/**
 * 这是代码界面,需要做成可编译不同语言的<BR>
 * 打开编辑框的时候,先调用initialization()方法,<BR>
 * initialization()方法根据配置中指定的language,在编辑框中显示默认语言的初始代码代码.<BR>
 * 
 * @author Desolate.City.C
 * 
 */
@SuppressWarnings("unused")
public class Code {
	private String language;// 语言模式
	private Game game;
	private JTextArea editeBox;
	private JXButton readyBtn;// 准备按钮
	private JXButton runBtn;// 开始按钮

	public Code() {

	}

	public static void getView() {

	}

	public void setGame(Game game) {
		this.game = game;
	}

	public void compilate() {

	}

	public void run() {

	}

}
