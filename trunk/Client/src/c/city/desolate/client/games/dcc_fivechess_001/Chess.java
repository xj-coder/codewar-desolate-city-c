package c.city.desolate.client.games.dcc_fivechess_001;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class Chess extends JButton {
	private Color colorOfBoard = Color.pink;// 背景颜色

	private int currState = 0;// 当前棋子状态,0为未落子，1为玩家1(黑)的棋子，2为玩家2(白)的棋子
	private int chess_x, chess_y; // 当前对象在二维对象数组中的坐标

	public Chess(int x, int y) {
		this.chess_x = x;
		this.chess_y = y;

		setBackground(colorOfBoard);// 棋子背景色
		setSize(10, 10);
	}

	@Override
	public void paintComponent(Graphics g)// 重绘仅只是当前单个按钮
	{
		super.paintComponent(g);// 重绘背景
		g.setXORMode(Chess.this.getBackground());
		if (currState == 0) {
			g.drawString((chess_x) + "\\" + chess_y, 5, 25);// 此对象的坐标
			return; // 重绘完背景即返回
		}
		if (currState == 1)
			g.setColor(Color.black);
		if (currState == 2)
			g.setColor(Color.white);
		int x = getSize().width / 10;
		int y = getSize().height / 10;
		g.fillOval(x, y, 9 * x, 9 * y);
	}

	public int getCurrState() {
		return currState;
	}

	public void setCurrState(int currState) {
		this.currState = currState;
	}

	public Color getColorOfBoard() {
		return colorOfBoard;
	}

	public void setColorOfBoard(Color colorOfBoard) {
		this.colorOfBoard = colorOfBoard;
	}

	public int getChess_x() {
		return chess_x;
	}

	public void setChess_x(int chessX) {
		chess_x = chessX;
	}

	public int getChess_y() {
		return chess_y;
	}

	public void setChess_y(int chessY) {
		chess_y = chessY;
	}

	public void setMyma() {
		addMouseListener(null);
	}
}
