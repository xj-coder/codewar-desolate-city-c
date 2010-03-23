package c.city.desolate.codewar.code.service.action;

import c.city.desolate.codewar.code.bean.RoomData;
import c.city.desolate.codewar.code.service.main.CommitClient;
import c.city.desolate.codewar.code.service.main.SID;

public class RoomAction {

	///得到游戏大厅的数据
	public static RoomData getRoomData(String roomGID) {
		String command = SID.getSID()+"/room/getgameroomdata-"+roomGID;
		byte[] result = new CommitClient().startClientService(command);
		
		
		
		return null;
	}

}
