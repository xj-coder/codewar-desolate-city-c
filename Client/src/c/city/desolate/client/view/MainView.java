package c.city.desolate.client.view;

import c.city.desolate.client.error.GameException;

/**
 * 主界面
 * 
 * @author Desolate.City.C
 */
public class MainView {
	private String gameNo;
	private Game gameView;
	private Code codeView;

	public MainView() {
		initialization();
		showMe();
	}

	private void showMe() {
	}

	private void initialization() {
	}

	public Game getGameView() {
		if (null == gameView)
			try {
				Game.getGame(gameNo);
			} catch (GameException e) {
				e.printStackTrace();
			}
		return gameView;
	}

	public Code getCodeView() {
		if (null == codeView)
			Code.getView();
		return codeView;
	}
}
