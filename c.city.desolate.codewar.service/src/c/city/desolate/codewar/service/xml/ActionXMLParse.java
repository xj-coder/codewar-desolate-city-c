package c.city.desolate.codewar.service.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import c.city.desolate.codewar.service.main.Properties;


public class ActionXMLParse {

    private static Document document = null;
    private static ArrayList<HashMap<String, String>> actions = new ArrayList<HashMap<String,String>>();
    
    static {
    	parseActionXML();
    }

    @SuppressWarnings( { "unchecked", "null" })
    private static void parseActionXML() {
		try {
		    InputStream in = new FileInputStream(new File(
			    Properties.ACTION_FILE_PATH));
		    SAXReader saxReader = new SAXReader();
		    document = saxReader.read(in);
		    Element _root = document.getRootElement();
		    String root = "//action";
		    ArrayList<Element> nodes = (ArrayList<Element>) _root
			    .selectObject(root);
		    if (nodes != null || !nodes.isEmpty()) {
		    	HashMap<String, String> action = null;
				for (Element e : nodes) {
					action = new HashMap<String, String>();
					action.put("model",e.elementTextTrim("model"));
					action.put("class",e.elementTextTrim("class"));
					actions.add(action);
				}
		    }
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
    }

	public static String getActionClass(String model) {
		for(HashMap<String, String> action:actions){
			if(action.get("model").equals(model)){
				return action.get("class");
			}
		}
		return null;
	}
}
