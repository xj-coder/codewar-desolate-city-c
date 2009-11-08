package c.city.desolate.client.xml.parse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import c.city.desolate.client.properties.ClientProperties;
import c.city.desolate.client.xml.bean.GameXML;

/**
 * games.xml文件解析类
 * 
 * @author JHS
 */
public class GameXMLParse {
	private static Document document = null;
	private static Map<String, GameXML> games;
	static {
		parseProtocolXML();
	}

	/**
	 * 解析整个protocol.xml
	 */
	@SuppressWarnings( { "unchecked", "null" })
	private static void parseProtocolXML() {
		InputStream in = null;
		try {
			in = new FileInputStream(new File(
					ClientProperties.PROTOCOL_FILE_PATH));
			SAXReader saxReader = new SAXReader();
			document = saxReader.read(in);
			// 将整个games.xml文件解析出来
			Element _root = document.getRootElement();
			// 提取XML中的game记录
			String root = "//games//game";
			ArrayList<Element> nodes = (ArrayList<Element>) _root
					.selectObject(root);
			if (nodes != null || !nodes.isEmpty()) {
				// TODO[Desolate.City.C][添加功能][解析整个文档的game标签]
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	public static Map<String, GameXML> getGames() {
		return games;
	}
}
