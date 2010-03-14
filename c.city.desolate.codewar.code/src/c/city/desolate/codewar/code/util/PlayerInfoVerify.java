package c.city.desolate.codewar.code.util;

import java.util.HashMap;
import java.util.Map;

import c.city.desolate.codewar.code.bean.Player;

public class PlayerInfoVerify {
	private static final String MSG = "msg";
	private static final String PLAYER = "player";

	// [TODO]添加用户登入验证功能
	public static Map<String, Object> VerufyPlayerLogin(
			Map<String, String> param) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("player", new Player());
		return result;
	}
}
