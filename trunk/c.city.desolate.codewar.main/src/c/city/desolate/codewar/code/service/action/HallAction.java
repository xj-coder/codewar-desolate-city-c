package c.city.desolate.codewar.code.service.action;

/**
 * 大厅
 */

import org.eclipse.swt.widgets.Tree;
import c.city.desolate.codewar.code.service.main.CommitClient;

public class HallAction {

	/*
	 * [TODO]获得游戏列表
	 */
	public static Tree getGameList() {
		String command = "";
		byte[] result = new CommitClient().startClientService(command);
		Tree tree = result2Tree(result);
		
		return tree;
	}

	/*
	 * [TODO]将游戏列表HTTPRequestResult类型结果转换成tree
	 */
	private static Tree result2Tree(byte[] result) {
		return null;
	}
	
}
