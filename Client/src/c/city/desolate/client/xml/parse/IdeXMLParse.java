package c.city.desolate.client.xml.parse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import c.city.desolate.client.properties.ClientProperties;
import c.city.desolate.client.xml.bean.IdeXML;

/**
 * ides-config.xml文件解析类
 * 
 * @author Desolate.City.C
 */
public class IdeXMLParse {
	private static Document document = null;
	private static Map<String, IdeXML> ides;
	static {
		parseProtocolXML();
	}

	/**
	 * 解析整个ides-config.xml
	 */
	@SuppressWarnings( { "unchecked", "null" })
	private static void parseProtocolXML() {
		InputStream in = null;
		try {
			in = new FileInputStream(new File(
					ClientProperties.IDECONFIG_FILE_PATH));
			SAXReader saxReader = new SAXReader();
			document = saxReader.read(in);
			// 将整个ides-config.xml文件解析出来
			Element _root = document.getRootElement();
			// 提取XML中的ides记录
			String xpath = "//ide";
			ArrayList<Element> nodes = (ArrayList<Element>) _root
					.selectObject(xpath);
			if (nodes != null || !nodes.isEmpty()) {
				// TODO[Desolate.City.C][添加功能][解析整个文档的ide标签]
				ides = new HashMap<String, IdeXML>();
				IdeXML ideXML = new IdeXML();
				for (Element node : nodes) {
					if (node.elementText("language").trim().equals(""))
						continue;
					ideXML.setLanguage(node.elementText("language"));
					ideXML.setIdeClass(node.elementText("ide-class"));
					ideXML.setCompilateClass(node.elementText("compilate-class"));
					ideXML.setShowName(node.elementText("show-name"));
					ides.put(ideXML.getLanguage(), ideXML);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	public static Map<String, IdeXML> getIdes() {
		return ides;
	}
}
