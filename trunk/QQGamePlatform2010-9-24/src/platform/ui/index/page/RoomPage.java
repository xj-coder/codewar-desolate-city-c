package platform.ui.index.page;

import javax.swing.JPanel;

import platform.bean.GameBean;

public class RoomPage extends JPanel {

	private static final long serialVersionUID = 8955162093186808818L;

	private GameBean gameBean;

	public RoomPage(GameBean gameBean) {
		this.gameBean = gameBean;

	}

	public GameBean getGameBean() {
		return gameBean;
	}

}