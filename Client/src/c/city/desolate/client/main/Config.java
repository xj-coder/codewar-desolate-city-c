package c.city.desolate.client.main;

public class Config {
	public static String SEPARATOR = "\\";
	public static String USERID = "jhs";// 用户ID
	public static String LANGUAGE = "Java";// 语言模式
	public static String IDEMODEL = "Default";// 语言模式
	public static String COMPLILATE_PATH = "";// 编译器地址
	public static String GAMENO = "DCC_FiveChess_001";// 游戏编号

	public static String APP_PATH = "D:" + SEPARATOR + "Workspace" + SEPARATOR
			+ "CodeWar_SVN" + SEPARATOR + "trunk" + SEPARATOR + "Client";// 程序地址
	public static String USER_SRC_PATH = APP_PATH + SEPARATOR + "user-src"
			+ SEPARATOR + "jhs" + SEPARATOR + "DCC_FiveChess_001" + SEPARATOR
			+ "Java";// 用户代码地址
	public static String PUBLIC_SRC_PATH = APP_PATH + SEPARATOR + "public-src"
			+ SEPARATOR + LANGUAGE;// 公共代码地址
	public static String GAME_SRC_PATH = APP_PATH + SEPARATOR + "game-src"
			+ SEPARATOR + GAMENO + SEPARATOR + "tool-src" + SEPARATOR
			+ LANGUAGE;// 游戏代码地址
}
