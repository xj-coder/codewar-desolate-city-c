package c.city.desolate.server.xml.parse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import c.city.desolate.server.properties.ServerProperties;
import c.city.desolate.server.xml.bean.CFGGameXML;

/**
 * games.xml文件解析类
 * 
 * @author JHS
 */
public class CFGGameXMLParse {
	private static Document document = null;
	private static Map<String, CFGGameXML> games;
	static {
		parseXML();
	}

	/**
	 * 解析整个games.xml
	 */
	@SuppressWarnings( { "unchecked", "null" })
	private static void parseXML() {
		InputStream in = null;
		try {
			in = new FileInputStream(new File(
					ServerProperties.GAMECONFIG_FILE_PATH));
			SAXReader saxReader = new SAXReader();
			document = saxReader.read(in);
			// 将整个games.xml文件解析出来
			Element _root = document.getRootElement();
			// 提取XML中的game记录
			String xpath = "//game";
			List<Element> nodes = (List<Element>) _root.selectObject(xpath);
			// TODO[Desolate.City.C][OK][解析整个文档的game标签]
			games = new HashMap<String, CFGGameXML>();
			CFGGameXML gameXML = new CFGGameXML();
			for (Element node : nodes) {
				if (node.elementText("no").trim().equals(""))
					continue;
				gameXML.setNo(node.elementText("no"));
				gameXML.setCommitClassPath(node
						.elementText("commit-class-path"));
				games.put(gameXML.getNo(), gameXML);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	public static Map<String, CFGGameXML> getGames() {
		return games;
	}
}
