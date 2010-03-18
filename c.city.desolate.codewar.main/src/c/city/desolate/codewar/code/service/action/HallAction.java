package c.city.desolate.codewar.code.service.action;

/**
 * 大厅
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import c.city.desolate.codewar.code.service.main.CommitClient;
import c.city.desolate.codewar.code.service.main.SID;
import c.city.desolate.codewar.code.ui.bean.CategoryEO;
import c.city.desolate.codewar.code.ui.bean.GameEO;
import c.city.desolate.codewar.code.ui.bean.GameTreeElement;
import c.city.desolate.codewar.code.xml.GameListXML;
import c.city.desolate.codewar.code.xml.bean.GameXML;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

public class HallAction {
	
	/*
	 * [TODO]获得游戏列表
	 */
	public static List<GameTreeElement> getGameList() {
		List<GameTreeElement> gameTreeElements = new ArrayList<GameTreeElement>();
		String command = SID.getSID()+"/hall/getgamelist-context";
		byte[] result = new CommitClient().startClientService(command);
		HashMap<String, GameXML> map = GameListXML.getGameListContext(new ByteInputStream(result,result.length));
		
		Set<String> keys = map.keySet();
		Iterator<String> it = keys.iterator();
		
		String key = "";
		GameXML game = null;
		CategoryEO categoryEO = null;
		GameEO gameEO = null;
		int index = 0;
		
		while(it.hasNext()){
			key = it.next();
			game = map.get(key);
			
			gameEO = new GameEO();
			gameEO.setName(game.getName());
			gameEO.setGID(game.getGID());
			gameEO.setCategory(game.getCategory());
			gameEO.setIndex_url(game.getIndex_url());
			gameEO.setOrder(game.getOrder());
			
			if((index=indexOf(gameTreeElements,game.getCategory())) == -1){
				categoryEO = new CategoryEO();
				categoryEO.setName(game.getCategory());
				categoryEO.setCategoryOrder(game.getCategory_order());
				gameTreeElements.add(categoryEO);
			}else{
				categoryEO = (CategoryEO) gameTreeElements.get(index);
			}
			categoryEO.getChildren().add(gameEO);
		}
		
		for(GameTreeElement e:gameTreeElements){
			Collections.sort(e.getChildren());
		}
		Collections.sort(gameTreeElements);
		return gameTreeElements;
	}
	
	//获得游戏列表版本号
	private static String getGameListVersion() {
		String command = SID.getSID()+"/hall/getgamelist-version";
		byte[] result = new CommitClient().startClientService(command);
		return GameListXML.getGameListVersion(
				new ByteInputStream(result,result.length));
	}

	private static int indexOf(List<GameTreeElement> gameTreeElements,
			String category) {
		for(int i=0;i<gameTreeElements.size();i++){
			if(gameTreeElements.get(i).getName().equals(category)){
				return i;
			}
		}
		return -1;
	}
}

/**
 * 分类排序器
 * @author Administrator
 *
 */
class CategoryComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		GameTreeElement e1 = (GameTreeElement) o1;
		GameTreeElement e2 = (GameTreeElement) o1;
		
		return e1.getCategoryOrder()-e2.getCategoryOrder();
	}
	
}
/**
 * 游戏排序器
 * @author Administrator
 *
 */
class GameComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		GameTreeElement e1 = (GameTreeElement) o1;
		GameTreeElement e2 = (GameTreeElement) o1;
		
		return e1.getOrder()-e2.getOrder();
	}
	
}
