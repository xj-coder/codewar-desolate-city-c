package c.city.desolate.client.view;

import java.util.HashMap;

import org.jdesktop.swingx.JXPanel;

import c.city.desolate.client.error.GameException;
import c.city.desolate.client.xml.bean.GameXML;
import c.city.desolate.client.xml.parse.GameXMLParse;

/**
 * 这是一个抽象游戏类，在平台上的所有游戏都要实现该类.<BR>
 * 在游戏主界面打开的时候，将根据你指定的游戏编号，找到相应游戏的实现类.<BR>
 * 将通过getGame()方法得到实现类的一个实例,该实例是JXPanel的子类,返回的实例将直接被嵌套在MainView中的游戏区.<BR>
 * 先通过Initialization()方法初始化游戏,初始化工作可能包括初始化游戏的一些初始值等等.<BR>
 * 通过start()方法开始游戏.<BR>
 * 在进行游戏的时候,玩家(是代码,而非人)的操作将通过通过play(HashMap<Object, Object> param)方法通知游戏,<BR>
 * 不同游戏在play方法中实现游戏的规则逻辑.根据传入的参数进行游戏,并更新游戏显示.<BR>
 * 在游戏结束时,将调用stop()方法
 * 
 * @author Desolate.City.C
 * 
 */
@SuppressWarnings( { "unchecked", "serial" })
public abstract class Game extends JXPanel {

	protected Console console = new Console();// 控制台

	/**
	 * 根据游戏编号，到配置文件中找到指定游戏的Game实现类，并实例化
	 * 
	 * @param gameNo
	 *            游戏编号
	 * @return Game 游戏JXPanel
	 * @throws GameException
	 */
	public static Game getGame(String gameNo) throws GameException {
		Game game = null;
		GameXML gameXML = GameXMLParse.getGames().get(gameNo);
		if (null != gameXML) {
			// TODO[Desolate.City.C][OK][用反射实例化指定Game的实现类]
			try {
				Class<Game> _class = (Class<Game>) Class.forName(gameXML
						.getClassPath());
				game = _class.newInstance();
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
		return game;
	}

	protected Game() {
	}

	public abstract void initialization();

	public abstract void start();

	public abstract void play(HashMap<Object, Object> param);

	public abstract void stop();
}
