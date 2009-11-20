package c.city.desolate.server.xml.parse;

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

import c.city.desolate.server.properties.ServerProperties;
import c.city.desolate.server.xml.bean.C2SProtocolXML;

public class C2SProtocolXMLParse {

	@SuppressWarnings("unchecked")
	public static C2SProtocolXML getC2SProtocolXML(InputStream is)
			throws DocumentException {
		C2SProtocolXML protocolXML = new C2SProtocolXML();
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(is);
		Element _root = document.getRootElement();

		String xpath = "/no";
		Element _no = _root.element(xpath);
		if (null != _no) {
			protocolXML.setNo(_no.getText());
		} else {

		}

		xpath = "/params//param";
		List<Element> _params = _root.elements(xpath);
		if (null != _params) {
			Map<String, String> params = new HashMap<String, String>();
			for (Element _param : _params) {
				params.put(_param.attributeValue("key"), _param
						.attributeValue("value"));
			}
			protocolXML.setParams(params);
		} else {

		}
		return protocolXML;
	}

	public static String getXML(C2SProtocolXML C2SprotocolXML) {
		// TODO [JHS][添加功能][将C2SProTocolXML对象转化成XML文件，并返回这个XML文件的字符串形式]
		InputStream is = null;
		Document document = null;
		try {
			is = new FileInputStream(new File(
					ServerProperties.C2S_CONFIGFILE_PATH));
			SAXReader saxReader = new SAXReader();
			document = saxReader.read(is);
			Element _root = document.getRootElement();
			String xpath = "/no";
			Element _no = _root.element(xpath);
			_no.setText(C2SprotocolXML.getNo());

			xpath = "/params";
			Element _params = _root.element(xpath);
			Map<String, String> params = C2SprotocolXML.getParams();
			Set<String> keys = params.keySet();
			Element _param = null;
			for (String key : keys) {
				_param = DocumentHelper.createElement("param");
				_param.addAttribute("key", key);
				_param.addAttribute("value", params.get(key));
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
