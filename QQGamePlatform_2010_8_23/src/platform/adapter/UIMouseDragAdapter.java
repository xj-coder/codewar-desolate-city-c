package platform.adapter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class UIMouseDragAdapter extends MouseAdapter {
	private JFrame UI;

	private int pressX;
	private int pressY;

	public UIMouseDragAdapter(JFrame UI) {
		this.UI = UI;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		pressX = e.getX();
		pressY = e.getY();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		int x = UI.getX() + e.getX() - pressX;
		int y = UI.getY() + e.getY() - pressY;
		UI.setLocation(x, y);
	}
}
