package c.city.desolate.codewar.code.http.action;

/**
 * ����
 */

import org.eclipse.swt.widgets.Tree;

import c.city.desolate.codewar.code.http.bean.HTTPRequestResult;
import c.city.desolate.codewar.code.http.main.Properties;
import c.city.desolate.codewar.code.util.HTTP;

public class HallAction {

	/*
	 * [TODO]�����Ϸ�б�
	 */
	public static Tree getGameList() {
		String request = Properties.URL+"/main/getgamelist";
		HTTPRequestResult httpResult = HTTP.getHTTPRequestResult(request);
		Tree result = httpResult2Tree(httpResult);
		
		return result;
	}

	/*
	 * [TODO]����Ϸ�б�HTTPRequestResult���ͽ��ת����tree
	 */
	private static Tree httpResult2Tree(HTTPRequestResult httpResult) {
		return null;
	}
	
}
