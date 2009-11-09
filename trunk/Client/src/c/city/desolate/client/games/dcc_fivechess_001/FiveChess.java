package c.city.desolate.client.games.dcc_fivechess_001;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.HashMap;

import c.city.desolate.client.games.AbstractGame;

@SuppressWarnings("serial")
public class FiveChess extends AbstractGame {
	private static int rows = 15;
	private static int cols = 15;
	private static QiZi[][] qiPan = new QiZi[rows][cols];// 棋盘

	public FiveChess() {
		this.setSize(rows * 45, cols * 45);
		setBackground(Color.white);
		setLayout(new GridLayout(rows, cols));
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				qiPan[i][j] = new QiZi(i, j, qiPan);
				add(qiPan[i][j]);
			}
		}
		this.setVisible(true);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	@Override
	public void initialization() {

	}

	@Override
	public void play(HashMap<Object, Object> param) {
	}

	@Override
	public void start() {
	}

	@Override
	public void stop() {
	}

}
