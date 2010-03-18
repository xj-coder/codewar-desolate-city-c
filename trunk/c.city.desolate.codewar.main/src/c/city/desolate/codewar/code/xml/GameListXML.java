package c.city.desolate.codewar.code.xml;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import c.city.desolate.codewar.code.xml.bean.GameXML;

public class GameListXML {
    private static Document document = null;

    @SuppressWarnings( { "unchecked", "null" })
    public static HashMap<String, GameXML> getGameListContext(InputStream in) {
    	HashMap<String, GameXML> result = new HashMap<String, GameXML>();
		try {
		    SAXReader saxReader = new SAXReader();
		    document = saxReader.read(in);
		    Element _root = document.getRootElement();
		    String root = "//game";
		    ArrayList<Node> nodes = (ArrayList<Node>) _root
			    .selectNodes(root);
		    if (nodes != null || !nodes.isEmpty()) {
		    	GameXML gameXML ;
		    	Iterator<Node> it = nodes.iterator(); 
				while(it.hasNext()) {
					Node node = it.next();
					gameXML = new GameXML();
					gameXML.setName(node.selectSingleNode("name").getText());
					gameXML.setGID(node.selectSingleNode("GID").getText());
					gameXML.setIndex_url(node.selectSingleNode("index_url").getText());
					gameXML.setOrder(Integer.parseInt(node.selectSingleNode("order").getText()));
					gameXML.setCategory(node.selectSingleNode("category").getText());
					gameXML.setCategory_order(Integer.parseInt(node.selectSingleNode("category_order").getText()));
					result.put(gameXML.getGID(), gameXML);
				}
		    }
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return result;
    }

    public static String getGameListVersion(InputStream in){
    	String version = null;
    	SAXReader saxReader = new SAXReader();
	    try {
			document = saxReader.read(in);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	    Element _root = document.getRootElement();
	    String root = "//version";
	    Element node = (Element) _root.selectObject(root);
	    if(node != null){
	    	version =  node.getTextTrim();
	    }
	    return version;
    }
}
