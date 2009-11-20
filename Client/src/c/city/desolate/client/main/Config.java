package c.city.desolate.client.main;

public class Config {
	public static String SEPARATOR = "\\";
	public static String USERID = "jhs";// 用户ID
	public static String LANGUAGE = "Java";// 语言模式
	public static String IDEMODEL = "Default";// 语言模式
	public static String COMPILATE_PATH = "";// 编译器地址
	public static String GAMENO = "DCC_FiveChess_001";// 游戏编号

	public static String APP_PATH = "D:" + SEPARATOR + "Workspace" + SEPARATOR
			+ "CodeWar_SVN" + SEPARATOR + "trunk" + SEPARATOR + "Client";// 程序地址
	public static final String USER_SRC_ROOT_PATH = APP_PATH + SEPARATOR
			+ "user-src";// 用户代码根地址
	public static String USER_SRC_PATH = USER_SRC_ROOT_PATH + SEPARATOR + "jhs"
			+ SEPARATOR + "DCC_FiveChess_001" + SEPARATOR + "Java";// 用户代码地址
	public static final String PUBLIC_SRC_ROOT_PATH = APP_PATH + SEPARATOR
			+ "public-src";// 公共代码根地址
	public static String PUBLIC_SRC_PATH = PUBLIC_SRC_ROOT_PATH + SEPARATOR
			+ LANGUAGE;// 公共代码地址
	public static final String GAME_SRC_ROOT_PATH = APP_PATH + SEPARATOR
			+ "game-src";// 游戏代码根地址
	public static String GAME_TOOL_SRC_PATH = GAME_SRC_ROOT_PATH + SEPARATOR
			+ GAMENO + SEPARATOR + "tool-src" + SEPARATOR + LANGUAGE;// 游戏Tool代码地址
	public static String GAME_INIT_SRC_PATH = GAME_SRC_ROOT_PATH + SEPARATOR
			+ GAMENO + SEPARATOR + "init-src" + SEPARATOR + LANGUAGE;// 游戏Init代码地址

	public static final String IDE_CONFIG_PATH = APP_PATH + SEPARATOR
			+ "config\\ides-config.xml";
	public static final String GAME_CONFIG__PATH = APP_PATH + SEPARATOR
			+ "config\\games-config.xml";
	public static final String COMPILATE_CONFIG_PATH = APP_PATH + SEPARATOR
			+ "config\\compilates-config.xml";
	public static final String C2S_CONFIGFILE_PATH = APP_PATH + SEPARATOR
			+ "config\\c2s.xml";
	public static final String S2C_CONFIGFILE_PATH = APP_PATH + SEPARATOR
			+ "config\\s2c.xml";

	public static final String USER_CODE_MAIN_CLASS_NAME = "GameCode.java";
}
