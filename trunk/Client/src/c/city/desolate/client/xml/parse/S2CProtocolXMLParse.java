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
import c.city.desolate.client.xml.bean.S2CGameXML;
import c.city.desolate.client.xml.bean.S2CHeadXML;
import c.city.desolate.client.xml.bean.S2CMethodXML;
import c.city.desolate.client.xml.bean.S2CParamXML;
import c.city.desolate.client.xml.bean.S2CPlayerXML;
import c.city.desolate.client.xml.bean.S2CProtocolXML;

public class S2CProtocolXMLParse {

	@SuppressWarnings("unchecked")
	public S2CProtocolXML getS2CProtocolXML(InputStream is)
			throws DocumentException {
		S2CProtocolXML protocolXML = new S2CProtocolXML();
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(is);
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

		InputStream is = null;
		Document document = null;
		try {
			is = new FileInputStream(new File(Config.S2C_CONFIGFILE_PATH));
			SAXReader saxReader = new SAXReader();
			document = saxReader.read(is);
			Element _root = document.getRootElement();
			String xpath = "/head";
			Element _head = _root.element(xpath);
			xpath = "/sid";
			Element _sid = _head.element(xpath);
			_sid.setText(S2CprotocolXML.getHeadXML().getSid());

			xpath = "/game";
			Element _game = _root.element(xpath);
			xpath = "/no";
			Element _gameNo = _game.element(xpath);
			_gameNo.setText(S2CprotocolXML.getGameXML().getNo());
			xpath = "/state";
			Element _state = _game.element(xpath);
			_state.setText(S2CprotocolXML.getGameXML().getState() + "");

			xpath = "/player-list";
			Element _players = _root.element(xpath);
			Map<String, S2CPlayerXML> players = S2CprotocolXML.getPlayerXMLs();
			Set<String> keys = players.keySet();
			Element _player = null;
			S2CPlayerXML player = null;
			Element _name = null;
			Element _camp = null;
			for (String key : keys) {
				player = players.get(key);
				_player = DocumentHelper.createElement("player");
				_name = DocumentHelper.createElement("name");
				_name.setText(player.getName());
				_camp = DocumentHelper.createElement("camp");
				_camp.setText(player.getCamp() + "");
				_player.add(_name);
				_player.add(_camp);
				_players.add(_player);
			}

			xpath = "/method";
			Element _method = _root.element(xpath);
			xpath = "/no";
			Element _methodNo = _method.element(xpath);
			_methodNo.setText(S2CprotocolXML.getMethodXML().getNo());
			xpath = "/params";
			Element _params = _method.element(xpath);
			Map<String, S2CParamXML> paramXMLs = S2CprotocolXML.getMethodXML()
					.getParamXMLs();
			keys = paramXMLs.keySet();
			Element _param = null;
			S2CParamXML paramXML = null;
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
