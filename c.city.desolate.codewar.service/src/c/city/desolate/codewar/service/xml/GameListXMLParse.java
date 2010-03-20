package c.city.desolate.codewar.service.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import c.city.desolate.codewar.service.main.Properties;

public class GameListXMLParse {
	private static Document document = null;
	private static Element _root = null;
	private static InputStream in = null;
	private static long lastModify = 0;
	private static File input = null;
	
	private static void parseGameListXML(){
		input = new File(Properties.GAMELIST_FILE_PATH);
		if(!fileIsModify()){
			return;
		}
		try {
			if(in != null){
				try {
					in.close();
					in = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			lastModify = input.lastModified();
			in = new FileInputStream(input);
		    SAXReader saxReader = new SAXReader();
		    document = saxReader.read(in);
		    _root = document.getRootElement();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static boolean fileIsModify() {
		return !(lastModify == input.lastModified());
	}

	public static String getGameListVersion(){
		parseGameListXML();
		String root = "//version";
		Node node = (Node) _root.selectObject(root);
		return node.asXML();
	}
	
	public static String getGameListContext(){
		parseGameListXML();
		String root = "//games";
		Node node = (Node) _root.selectObject(root);
		return node.asXML();
	}
}
