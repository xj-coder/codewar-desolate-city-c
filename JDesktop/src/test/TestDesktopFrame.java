package test;

import gui.DesktopFrame;

import java.awt.Graphics2D;

import core.FullCore;

public class TestDesktopFrame extends FullCore {
	DesktopFrame gamePanel;

	@Override
	public void init() {
		super.init();
		gamePanel = new DesktopFrame(getWindow());
	}

	@Override
	public void draw(Graphics2D g) {
		getWindow().getLayeredPane().paintComponents(g);

	}

	@Override
	public void update(long elapsedTime) {

	}

	public static void main(String[] args) {
		new TestDesktopFrame().run();
	}
}
