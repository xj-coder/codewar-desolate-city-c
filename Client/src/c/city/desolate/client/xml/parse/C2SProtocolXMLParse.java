package c.city.desolate.client.xml.parse;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import c.city.desolate.client.xml.bean.C2SGameXML;
import c.city.desolate.client.xml.bean.C2SHeadXML;
import c.city.desolate.client.xml.bean.C2SMethodXML;
import c.city.desolate.client.xml.bean.C2SParamXML;
import c.city.desolate.client.xml.bean.C2SProtocolXML;

public class C2SProtocolXMLParse {

	@SuppressWarnings("unchecked")
	public static C2SProtocolXML getC2SProtocolXML(InputStream is)
			throws DocumentException {
		C2SProtocolXML protocolXML = new C2SProtocolXML();
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(is);
		Element _root = document.getRootElement();

		String xpath = "/head";
		Element _head = (Element) _root.selectObject(xpath);
		C2SHeadXML headXML = new C2SHeadXML();
		headXML.setSid(_head.elementText("sid"));
		headXML.setName(_head.elementText("name"));
		headXML.setPassword(_head.elementText("password"));
		protocolXML.setHeadXML(headXML);

		xpath = "/game";
		Element _game = (Element) _root.selectObject(xpath);
		C2SGameXML gameXML = new C2SGameXML();
		gameXML.setNo(_game.elementText("no"));
		gameXML.setState(Integer.parseInt(_game.elementText("state")));
		protocolXML.setGameXML(gameXML);

		xpath = "/method";
		Element _method = (Element) _root.selectObject(xpath);
		C2SMethodXML methodXML = new C2SMethodXML();
		methodXML.setNo(_method.elementText("no"));
		xpath = "/params//param";
		List<Element> _params = (List<Element>) _method.selectObject(xpath);
		Map<String, C2SParamXML> paramXMLs = new HashMap<String, C2SParamXML>();
		for (Element e : _params) {
			C2SParamXML paramXML = new C2SParamXML();
			paramXML.setName(e.elementText("name"));
			paramXML.setValue(e.elementText("value"));
			paramXMLs.put(paramXML.getName(), paramXML);
		}
		methodXML.setParamXMLs(paramXMLs);
		protocolXML.setMethodXML(methodXML);

		return protocolXML;
	}

	public static String getXML(C2SProtocolXMLParse C2SprotocolXML) {
		// TODO [JHS][添加功能][将S2CProTocolXML对象转化成XML文件，并返回这个XML文件的字符串形式]
		return null;
	}
}
