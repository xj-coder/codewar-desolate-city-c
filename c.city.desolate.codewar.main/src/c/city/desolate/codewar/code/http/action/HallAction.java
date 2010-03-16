package c.city.desolate.codewar.code.http.action;

/**
 * 大厅
 */

import org.eclipse.swt.widgets.Tree;

import c.city.desolate.codewar.code.http.bean.HTTPRequestResult;
import c.city.desolate.codewar.code.http.main.Properties;
import c.city.desolate.codewar.code.util.HTTP;

public class HallAction {

	/*
	 * [TODO]获得游戏列表
	 */
	public static Tree getGameList() {
		String request = Properties.URL+"/main/getgamelist";
		HTTPRequestResult httpResult = HTTP.getHTTPRequestResult(request);
		Tree result = httpResult2Tree(httpResult);
		
		return result;
	}

	/*
	 * [TODO]将游戏列表HTTPRequestResult类型结果转换成tree
	 */
	private static Tree httpResult2Tree(HTTPRequestResult httpResult) {
		return null;
	}
	
}
