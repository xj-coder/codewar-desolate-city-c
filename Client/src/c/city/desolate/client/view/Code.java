package c.city.desolate.client.view;

import c.city.desolate.client.compilate.AbstractCompilate;
import c.city.desolate.client.ides.AbstractIDE;
import c.city.desolate.client.main.Config;
import c.city.desolate.client.xml.bean.CompilateXML;
import c.city.desolate.client.xml.bean.IdeXML;
import c.city.desolate.client.xml.parse.CompilateXMLParse;
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
@SuppressWarnings( { "unchecked" })
public final class Code {
	public static AbstractCompilate COMPILATE;
	public static AbstractIDE IDE;

	static {
		IdeXML ideXML = IdeXMLParse.getIdes().get(Config.IDEMODEL);
		CompilateXML compilateXML = CompilateXMLParse.getCompilates().get(
				Config.LANGUAGE);
		if (null != ideXML) {
			// TODO[Desolate.City.C][OK][用反射实例化指定Game的实现类]
			try {
				Class<AbstractCompilate> compilateClass = (Class<AbstractCompilate>) Class
						.forName(compilateXML.getCompilateClass());
				Class<AbstractIDE> ideClass = (Class<AbstractIDE>) Class
						.forName(ideXML.getIdeClass());
				COMPILATE = compilateClass.newInstance();
				IDE = ideClass.newInstance();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

	protected Code() {

	}

}
