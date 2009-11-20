package c.city.desolate.client.xml.parse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import c.city.desolate.client.main.Config;
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
		gameXML.setCamp(Integer.parseInt(_game.elementText("state")));
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

	public static String getXML(C2SProtocolXML C2SprotocolXML) {
		// TODO [JHS][添加功能][将C2SProTocolXML对象转化成XML文件，并返回这个XML文件的字符串形式]
		InputStream is = null;
		Document document = null;
		try {
			is = new FileInputStream(new File(Config.C2S_CONFIGFILE_PATH));
			SAXReader saxReader = new SAXReader();
			document = saxReader.read(is);
			Element _root = document.getRootElement();
			String xpath = "/head";
			Element _head = _root.element(xpath);
			xpath = "/sid";
			Element _sid = _head.element(xpath);
			_sid.setText(C2SprotocolXML.getHeadXML().getSid());
			xpath = "/name";
			Element _name = _head.element(xpath);
			_name.setText(C2SprotocolXML.getHeadXML().getName());
			xpath = "/password";
			Element _password = _head.element(xpath);
			_password.setText(C2SprotocolXML.getHeadXML().getPassword());

			xpath = "/game";
			Element _game = _root.element(xpath);
			xpath = "/no";
			Element _gameNo = _game.element(xpath);
			_gameNo.setText(C2SprotocolXML.getGameXML().getNo());
			xpath = "/camp";
			Element _camp = _game.element(xpath);
			_camp.setText(C2SprotocolXML.getGameXML().getCamp() + "");

			xpath = "/method";
			Element _method = _root.element(xpath);
			xpath = "/no";
			Element _methodNo = _method.element(xpath);
			_methodNo.setText(C2SprotocolXML.getMethodXML().getNo());
			xpath = "/params";
			Element _params = _method.element(xpath);
			Map<String, C2SParamXML> paramXMLs = C2SprotocolXML.getMethodXML()
					.getParamXMLs();
			Set<String> keys = paramXMLs.keySet();
			Element _param = null;
			C2SParamXML paramXML = null;
			for (String key : keys) {
				paramXML = paramXMLs.get(key);
				_param = DocumentHelper.createElement("param");
				_param.addAttribute("name", paramXML.getName());
				_param.addAttribute("value", paramXML.getValue());
				_params.add(_param);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return document.asXML();
	}
}
