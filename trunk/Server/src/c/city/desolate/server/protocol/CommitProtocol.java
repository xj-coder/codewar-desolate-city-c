package c.city.desolate.server.protocol;

import c.city.desolate.server.protocol.game.AbstractGameProtocol;
import c.city.desolate.server.xml.bean.C2SProtocolXML;
import c.city.desolate.server.xml.parse.CFGGameXMLParse;

public class CommitProtocol {

	@SuppressWarnings("unchecked")
	public static byte[] commitProtocol(C2SProtocolXML protocolXML) {
		byte[] result = null;
		boolean go = verifyProtocol(protocolXML);
		if (go) {
			try {
				Class<AbstractGameProtocol> gameCommitClass = (Class<AbstractGameProtocol>) Class
						.forName(CFGGameXMLParse.getGames().get(
								protocolXML.getGameXML().getNo())
								.getCommitClassPath());
				AbstractGameProtocol protocol = gameCommitClass.newInstance();
				result = protocol.commitProtocol(protocolXML);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	private static boolean verifyProtocol(C2SProtocolXML protocolXML) {
		// TODO[JHS][添加功能][验证协议信息的合法性,根据sid就可以判断合法性,如果sid为空,
		// 则判断用户名和密码,如果用户名和密码真确,也是合法信息,并为其分配一个唯一sid]

		return false;
	}

}
