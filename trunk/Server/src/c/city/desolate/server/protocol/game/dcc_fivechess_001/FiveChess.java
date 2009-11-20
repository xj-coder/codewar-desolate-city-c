package c.city.desolate.server.protocol.game.dcc_fivechess_001;

import static c.city.desolate.server.protocol.GameDate.DATA;

import java.util.HashMap;
import java.util.Map;

import c.city.desolate.server.protocol.game.AbstractGameProtocol;
import c.city.desolate.server.xml.bean.C2SProtocolXML;
import c.city.desolate.server.xml.bean.S2CGameXML;
import c.city.desolate.server.xml.bean.S2CHeadXML;
import c.city.desolate.server.xml.bean.S2CMethodXML;
import c.city.desolate.server.xml.bean.S2CParamXML;
import c.city.desolate.server.xml.bean.S2CPlayerXML;
import c.city.desolate.server.xml.bean.S2CProtocolXML;
import c.city.desolate.server.xml.parse.S2CProtocolXMLParse;

public class FiveChess extends AbstractGameProtocol {
	@Override
	public byte[] commitProtocol(C2SProtocolXML protocolXML) {
		// [JHS][添加功能][处理五子棋的协议信息]
		// 从游戏数据堆中去数据,没有的话,新建数据
		Map<String, String> params = protocolXML.getParams();
		Data data = null;
		Object obj = DATA.get(params.get("GUID"));
		byte[] b = null;
		String no = protocolXML.getNo();
		if (no == null || no.trim().equals("")) {
			// TODO [JHS][添加功能][错误处理]
		}
		if (null == obj) {
			if (no.trim().equals("enter")) {
				data = new Data();
				for (int i = 0; i < data.boardRow; i++) {
					for (int j = 0; j < data.boardCol; j++) {
						data.chessBoard[i][j] = 0;
					}
				}
				DATA.put(params.get("GUID"), data);
			}
		} else {
			data = (Data) obj;
		}

		S2CProtocolXML S2CprotocolXML = new S2CProtocolXML();
		S2CHeadXML headXML = new S2CHeadXML();
		headXML.setSid(params.get("GUID"));
		S2CprotocolXML.setHeadXML(headXML);
		S2CGameXML gameXML = new S2CGameXML();
		gameXML.setNo(protocolXML.getGameXML().getNo());
		gameXML.setState((protocolXML.getGameXML().getCamp() + 1) % 3);
		S2CprotocolXML.setGameXML(gameXML);
		S2CMethodXML methodXML = new S2CMethodXML();
		methodXML.setNo(protocolXML.getMethodXML().getNo());

		if (no.trim().equals("initialization")) {
			Object obj1 = data.playerXMLs.get(protocolXML.getHeadXML()
					.getName());
			if (null == obj1) {
				S2CPlayerXML playerXML = new S2CPlayerXML();
				playerXML.setName(protocolXML.getHeadXML().getName());
				playerXML.setCamp(data.playerXMLs.size() + 1);
				data.playerXMLs.put(protocolXML.getHeadXML().getName(),
						playerXML);
			}
		} else if (no.trim().equals("start")) {

		} else if (no.trim().equals("stop")) {

		} else if (no.trim().equals("play")) {
			int x = Integer.parseInt(params.get("x").getValue());
			int y = Integer.parseInt(params.get("y").getValue());

			if (x >= data.boardRow) {

			} else if (y >= data.boardCol) {

			} else if (data.chessBoard[x][y] != 0) {

			}

			Map<String, S2CParamXML> paramXMLs = new HashMap<String, S2CParamXML>();
			S2CParamXML paramXML_X = new S2CParamXML();
			paramXML_X.setName("x");
			paramXML_X.setValue(x + "");
			S2CParamXML paramXML_Y = new S2CParamXML();
			paramXML_Y.setName("y");
			paramXML_Y.setValue(y + "");
			paramXMLs.put(paramXML_X.getName(), paramXML_X);
			paramXMLs.put(paramXML_Y.getName(), paramXML_Y);
			methodXML.setParamXMLs(paramXMLs);
		}
		S2CprotocolXML.setMethodXML(methodXML);
		S2CprotocolXML.setPlayerXMLs(data.playerXMLs);

		String xml = S2CProtocolXMLParse.getXML(S2CprotocolXML);

		return xml.getBytes();
	}
}
