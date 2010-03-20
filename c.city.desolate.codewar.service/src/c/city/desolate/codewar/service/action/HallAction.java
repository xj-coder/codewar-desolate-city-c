package c.city.desolate.codewar.service.action;

import c.city.desolate.codewar.service.xml.GameListXMLParse;

public class HallAction extends DefaultAction{
	
	public String getGameList(String param){
		if(param.trim().equals("version")){
			return GameListXMLParse.getGameListVersion();
		}else if(param.trim().equals("context")){
			return GameListXMLParse.getGameListContext();
		}
		return "";
	}
}
