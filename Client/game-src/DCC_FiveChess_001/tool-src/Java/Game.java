import c.city.desolate.client.xml.bean.C2SProtocolXML;

public class Game {
	
	public static boolean play(int x, int y) {
		String command = CodeProperties.SID+"?play&x="+x+"&y="+y;
		byte result = Client.startClientService(command);
		if(null==result)
			return true;
		else
			return false;
		
	}

	public static int getState() {
		
		return 1;
	}

	public static int[][] getChessboard() {
		return null;
	}
}
