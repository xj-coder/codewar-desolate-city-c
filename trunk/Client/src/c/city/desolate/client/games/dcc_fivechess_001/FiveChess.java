package c.city.desolate.client.games.dcc_fivechess_001;

import static c.city.desolate.client.games.dcc_fivechess_001.Config.CAMP;
import static c.city.desolate.client.games.dcc_fivechess_001.Config.CHESSBOARD;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.Map;

import c.city.desolate.client.games.AbstractGame;

@SuppressWarnings("serial")
public class FiveChess extends AbstractGame {
	private static int rows = 15;
	private static int cols = 15;
	private static Chess[][] qiPan = new Chess[rows][cols];// 棋盘

	public FiveChess() {
		this.setSize(rows * 45, cols * 45);
		this.setBackground(Color.white);
		this.setLayout(new GridLayout(rows, cols));
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				qiPan[i][j] = new Chess(i, j);
				this.add(qiPan[i][j]);
			}
		}
		this.setVisible(true);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	/**
	 * 初始游戏,主要是设置游戏中需要数据的初始值
	 */
	@Override
	public void initialization() {
		// TODO [JHS][添加功能][初始游戏]
	}

	@Override
	public void play(Map<Object, Object> param) {
		// TODO [JHS][添加功能][实现游戏逻辑]
		int x = Integer.parseInt(param.get("x").toString());
		int y = Integer.parseInt(param.get("y").toString());
		CHESSBOARD[x][y].setCurrState(CAMP);
		this.repaint();
	}

	@Override
	public void start() {
		// TODO [JHS][添加功能][实现游戏开始]
	}

	@Override
	public void stop() {
		// TODO [JHS][添加功能][实现游戏结束]
	}

}
