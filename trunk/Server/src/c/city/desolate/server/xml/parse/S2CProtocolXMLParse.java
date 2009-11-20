package c.city.desolate.server.xml.parse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import c.city.desolate.server.properties.ServerProperties;
import c.city.desolate.server.xml.bean.S2CProtocolXML;

public class S2CProtocolXMLParse {

	@SuppressWarnings("unchecked")
	public S2CProtocolXML getS2CProtocolXML(InputStream is)
			throws DocumentException {
		S2CProtocolXML protocolXML = new S2CProtocolXML();
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(is);
		Element _root = document.getRootElement();

		String xpath = "//entry";
		List<Element> _entrys = _root.elements(xpath);
		if (null != _entrys) {
			Map<String, Map<String, Object>> entryMaps = new HashMap<String, Map<String, Object>>();
			for (Element _entry : _entrys) {
				Map<String, Object> entryMap = new HashMap<String, Object>();
				Iterator<Element> it1 = _entry.nodeIterator();
				String key = null;
				String value = null;
				while (it1.hasNext()) {
					Element e = it1.next();
					if (e.getName().equals("key")) {
						key = e.getText();
					} else if (e.getName().equals("value")) {
						value = e.getText();
						entryMap.put(key, value);
					}
				}
				entryMaps.put(_entry.attributeValue("key"), entryMap);
			}
		}

		return protocolXML;
	}

	public static String getXML(S2CProtocolXML S2CprotocolXML) {
		// TODO [JHS][添加功能][将S2CProTocolXML对象转化成XML文件，并返回这个XML文件的字符串形式]

		InputStream is = null;
		Document document = null;
		try {
			is = new FileInputStream(new File(
					ServerProperties.S2C_CONFIGFILE_PATH));
			SAXReader saxReader = new SAXReader();
			document = saxReader.read(is);
			Element _root = document.getRootElement();

			Map<String, Map<String, String>> entryMaps = S2CprotocolXML
					.getEntryMap();
			Set<String> keys = entryMaps.keySet();
			Element _entry = null;
			Map<String, String> entryMap = null;
			if (null != keys) {
				for (String key : keys) {
					entryMap = entryMaps.get(key);
					_entry = DocumentHelper.createElement("entry");
					_entry.addAttribute("key", key);
					Set<String> keys1 = entryMap.keySet();
					if (null != keys1) {
						Element _key = null;
						Element _value = null;
						for (String key1 : keys1) {
							_key = DocumentHelper.createElement("key");
							_key.setText(key1);
							_value = DocumentHelper.createElement("value");
							_value.setText(entryMap.get(key1));
							_entry.add(_key);
							_entry.add(_value);
						}
					}
				}
			}
			_root.add(_entry);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return document.asXML();
	}
}
