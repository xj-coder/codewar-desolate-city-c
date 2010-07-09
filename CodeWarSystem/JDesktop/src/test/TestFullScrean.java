package test;

import java.awt.DisplayMode;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

public class TestFullScrean {
	public DisplayMode displayMode;

	public static void main(String[] args) {
		new TestFullScrean();
	}

	public TestFullScrean() {
		GraphicsEnvironment gEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice device = gEnv.getDefaultScreenDevice();
		GraphicsConfiguration gConf = device.getDefaultConfiguration();

		try {
			displayMode = device.getDisplayMode();

			Frame frame = new Frame(gConf);
			frame.setIgnoreRepaint(true);
			frame.setUndecorated(true);

			System.out.println("# Original Display Mode = " + displayMode.getWidth() + ", " + displayMode.getHeight() + ", " + displayMode.getBitDepth() + ", "
					+ displayMode.getRefreshRate());
			// make an another display mode.
			int width = 640;
			int height = 480;
			int bitDepth = 32;
			int refRate = 60;
			// DisplayMode mode = new DisplayMode(orgMode.getWidth(),
			// orgMode.getHeight(),
			// orgMode.getBitDepth(),
			// orgMode.getRefreshRate());
			DisplayMode mode = new DisplayMode(width, height, bitDepth, refRate);

			System.out.println("# New Display Mode = " + width + ", " + height + ", " + bitDepth + ", " + refRate);

			device.setFullScreenWindow(frame);
			// Toolkit.getDefaultToolkit().sync();
			if (device.isDisplayChangeSupported()) {
				device.setDisplayMode(mode); // change
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException ex) {
			}
		} finally {
			if (device.isDisplayChangeSupported()) {
				device.setDisplayMode(displayMode);
			}
			device.setFullScreenWindow(null);
		}
		System.exit(0);

	}
}
