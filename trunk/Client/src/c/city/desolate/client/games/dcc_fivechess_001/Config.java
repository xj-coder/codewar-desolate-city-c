package c.city.desolate.client.games.dcc_fivechess_001;

public final class Config {

	public static final int BOARD_ROW = 15;
	public static final int BOARD_COL = 15;
	public static int STATE = 0;// 游戏状态,0：自己落子
	public static int CAMP = 1;// 阵营,1为玩家1(黑)，2为玩家2(白)
	public static Chess[][] CHESSBOARD = new Chess[BOARD_ROW][BOARD_COL];
}
