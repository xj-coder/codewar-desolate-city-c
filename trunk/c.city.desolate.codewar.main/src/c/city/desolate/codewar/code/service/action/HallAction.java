package c.city.desolate.codewar.code.service.action;

/**
 * ����
 */

import org.eclipse.swt.widgets.Tree;
import c.city.desolate.codewar.code.service.main.CommitClient;

public class HallAction {

	/*
	 * [TODO]�����Ϸ�б�
	 */
	public static Tree getGameList() {
		String command = "";
		byte[] result = new CommitClient().startClientService(command);
		Tree tree = result2Tree(result);
		
		return tree;
	}

	/*
	 * [TODO]����Ϸ�б�HTTPRequestResult���ͽ��ת����tree
	 */
	private static Tree result2Tree(byte[] result) {
		return null;
	}
	
}
