package c.city.desolate.server.protocol.game.dcc_fivechess_001;

import java.util.HashMap;
import java.util.Map;

import c.city.desolate.server.xml.bean.S2CPlayerXML;

public class Data {

	public final int boardRow = 15;
	public final int boardCol = 15;
	public int state = 1;// 游戏状态,值与CAMP相对应
	public int camp = 1;// 阵营,1为玩家1(黑)，2为玩家2(白)
	public int[][] chessBoard = new int[boardRow][boardCol];// 值为0代表为落子,1为黑方落子,2为白方落子
	public Map<String, S2CPlayerXML> playerXMLs = new HashMap<String, S2CPlayerXML>();// 玩家列表
}
