package c.city.desolate.client.xml.parse;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import c.city.desolate.client.xml.bean.S2CGameXML;
import c.city.desolate.client.xml.bean.S2CHeadXML;
import c.city.desolate.client.xml.bean.S2CMethodXML;
import c.city.desolate.client.xml.bean.S2CParamXML;
import c.city.desolate.client.xml.bean.S2CPlayerXML;
import c.city.desolate.client.xml.bean.S2CProtocolXML;

public class S2CProtocolXMLParse {

	@SuppressWarnings("unchecked")
	public S2CProtocolXML getS2CProtocolXML(InputStream in)
			throws DocumentException {
		S2CProtocolXML protocolXML = new S2CProtocolXML();
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(in);
		Element _root = document.getRootElement();

		String xpath = "/head";
		Element _head = (Element) _root.selectObject(xpath);
		S2CHeadXML headXML = new S2CHeadXML();
		headXML.setSid(_head.elementText("sid"));
		protocolXML.setHeadXML(headXML);

		xpath = "/game";
		Element _game = (Element) _root.selectObject(xpath);
		S2CGameXML gameXML = new S2CGameXML();
		gameXML.setNo(_game.elementText("no"));
		gameXML.setState(Integer.parseInt(_game.elementText("state")));
		protocolXML.setGameXML(gameXML);

		xpath = "/player-list//player";
		List<Element> _players = (List<Element>) _root.selectObject(xpath);
		Map<String, S2CPlayerXML> playerXMLs = new HashMap<String, S2CPlayerXML>();
		for (Element e : _players) {
			S2CPlayerXML playerXML = new S2CPlayerXML();
			playerXML.setName(e.elementText("name"));
			playerXML.setCamp(Integer.parseInt(e.elementText("camp")));
			playerXMLs.put(playerXML.getName(), playerXML);
		}
		protocolXML.setPlayerXMLs(playerXMLs);

		xpath = "/method";
		Element _method = (Element) _root.selectObject(xpath);
		S2CMethodXML methodXML = new S2CMethodXML();
		methodXML.setNo(_method.elementText("no"));
		xpath = "/params//param";
		List<Element> _params = (List<Element>) _method.selectObject(xpath);
		Map<String, S2CParamXML> paramXMLs = new HashMap<String, S2CParamXML>();
		for (Element e : _params) {
			S2CParamXML paramXML = new S2CParamXML();
			paramXML.setName(e.elementText("name"));
			paramXML.setValue(e.elementText("value"));
			paramXMLs.put(paramXML.getName(), paramXML);
		}
		methodXML.setParamXMLs(paramXMLs);
		protocolXML.setMethodXML(methodXML);

		return protocolXML;
	}

	public static String getXML(S2CProtocolXML S2CprotocolXML) {
		// TODO [JHS][添加功能][将S2CProTocolXML对象转化成XML文件，并返回这个XML文件的字符串形式]
		return null;
	}
}
