package c.city.desolate.client.games.dcc_fivechess_001;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class QiZi extends JButton {
	private final Color colorOfBoard = Color.pink;// 背景颜色
	// 棋子状态
	private int currStatus = 0;// 当前棋子状态,0为未落子，1为玩家1(黑)的棋子，2为玩家2(白)的棋子
	private final int x, y; // 当前对象在二维对象数组中的坐标

	QiZi(int x, int y, QiZi[][] qiPan) {
		this.x = x;
		this.y = y;

		setBackground(colorOfBoard);// 棋子背景色
		setSize(10, 10);
	}

	@Override
	public void paintComponent(Graphics g)// 重绘仅只是当前单个按钮
	{
		super.paintComponent(g);// 重绘背景
		g.setXORMode(QiZi.this.getBackground());
		if (currStatus == 0) {
			g.drawString((x) + "\\" + y, 5, 25);// 此对象的坐标
			return; // 重绘完背景即返回
		}
		if (currStatus == 1)
			g.setColor(Color.black);
		if (currStatus == 2)
			g.setColor(Color.white);
		int x = getSize().width / 10;
		int y = getSize().height / 10;
		g.fillOval(x, y, 9 * x, 9 * y);
	}

	int getStatus() {
		return currStatus;// 返回当前棋子状态
	}

	void setCurrStatus(int s) {
		if (s < 0 || s > 2)
			return;
		currStatus = s;
		repaint();
	}

	int getPX() {
		return x;
	}

	int getPY() {
		return y;
	}

	public void setMyma() {
		addMouseListener(null);
	}
}
