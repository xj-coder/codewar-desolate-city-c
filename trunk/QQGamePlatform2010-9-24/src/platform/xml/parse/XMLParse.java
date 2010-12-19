package platform.xml.parse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import platform.exception.XMLException;

public class XMLParse {

	@SuppressWarnings( { "unchecked", "null" })
	public static Vector<HashMap<String, String>> getKeyValueXml(String filePath)
			throws XMLException {
		Vector<HashMap<String, String>> result = new Vector<HashMap<String, String>>();

		InputStream in = null;
		try {
			in = new FileInputStream(new File(filePath));
			SAXReader saxReader = new SAXReader();
			Document document = saxReader.read(in);
			// 将整个games-config.xml文件解析出来
			Element _root = document.getRootElement();
			// 提取XML中的entry记录
			String xpath = "//entry";
			List<Element> nodes = (List<Element>) _root.selectObject(xpath);
			if (nodes != null || !nodes.isEmpty()) {
				for (int i = 0; i < nodes.size(); i++) {
					List<Element> keys = nodes.get(i).selectNodes("key");
					List<Element> values = nodes.get(i).selectNodes("value");

					if (keys.size() != values.size()) {
						throw new XMLException(XMLException.ID_KEYS_VALUES_NOT_SYMMETRY);
					}
					HashMap<String, String> map = new HashMap<String, String>();
					for (int j = 0; j < keys.size(); j++) {
						map.put(keys.get(j).getTextTrim(), values.get(j).getTextTrim());
					}
					result.add(map);
				}

			}
		} catch (FileNotFoundException e) {
			throw new XMLException(XMLException.ID_XML_FILE_NOT_FIND);
		} catch (DocumentException e) {
			throw new XMLException(e.getMessage());
		}

		return result;
	}

}
