package platform.tools;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

public class ImageFactory {

	public static Image getLoginBgUpImage() {
		return Toolkit.getDefaultToolkit().getImage("image\\bg_up.png");
	}

	public static Image getLoginBgDownImage() {
		return Toolkit.getDefaultToolkit().getImage("image\\bg_down.png");
	}

	public static Image getLoginBgCenterImage() {
		return Toolkit.getDefaultToolkit().getImage("image\\bg_center.png");
	}

	public static Image getLoginCloseButton1() {
		return ImageTools.cut("image\\close_btn.png", 0, 0, 37, 21, "png");
	}

	public static Image getLoginCloseButton2() {
		return ImageTools.cut("image\\close_btn.png", 37, 0, 37, 21, "png");
	}

	public static Image getLoginCloseButton3() {
		return ImageTools.cut("image\\close_btn.png", 74, 0, 37, 21, "png");
	}

	public static Image getLoginHelpButton1() {
		return ImageTools.cut("image\\help.png", 0, 0, 21, 22, "png");
	}

	public static Image getLoginHelpButton2() {
		return ImageTools.cut("image\\help.png", 21, 0, 21, 22, "png");
	}

	public static Image getLoginHelpButton3() {
		return ImageTools.cut("image\\help.png", 42, 0, 21, 22, "png");
	}

	public static Image getLoginBannerImage() {
		return Toolkit.getDefaultToolkit().getImage("image\\banner.png");
	}

	public static Image getLoginProcessbarInImage() {
		return Toolkit.getDefaultToolkit().getImage("image\\Login_processbar_in.png");
	}

	public static Image getLoginProcessbarOutImage() {
		return Toolkit.getDefaultToolkit().getImage("image\\Login_processbar_out.png");
	}

	public static Image getLoginProcessbarBgImage() {
		return Toolkit.getDefaultToolkit().getImage("image\\Login_processbar_update.png");
	}

	public static Image getButtonOut1(int width, int height, boolean isShader) {
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = bufferedImage.createGraphics();

		Image left = ImageTools.cut("image\\button\\bleft" + (isShader ? "" : "_noshader") + ".png", 0, 0, 6, 24, "png");
		Image center = ImageTools.cut("image\\button\\bcenter" + (isShader ? "" : "_noshader") + ".png", 0, 0, 6, 24, "png");
		Image right = ImageTools.cut("image\\button\\bright" + (isShader ? "" : "_noshader") + ".png", 0, 0, 6, 24, "png");

		g2.drawImage(left.getScaledInstance(6, height, Image.SCALE_DEFAULT), 0, 0, null);
		g2.drawImage(center.getScaledInstance(width - 12, height, Image.SCALE_DEFAULT), 6, 0, null);
		g2.drawImage(right.getScaledInstance(6, height, Image.SCALE_DEFAULT), width - 6, 0, null);

		return bufferedImage.getScaledInstance(width, height, Image.SCALE_DEFAULT);
	}

	public static Image getButtonOut2(int width, int height, boolean isShader) {
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = bufferedImage.createGraphics();

		Image left = ImageTools.cut("image\\button\\bleft" + (isShader ? "" : "_noshader") + ".png", 24, 0, 6, 24, "png");
		Image center = ImageTools.cut("image\\button\\bcenter" + (isShader ? "" : "_noshader") + ".png", 24, 0, 6, 24, "png");
		Image right = ImageTools.cut("image\\button\\bright" + (isShader ? "" : "_noshader") + ".png", 24, 0, 6, 24, "png");

		g2.drawImage(left.getScaledInstance(6, height, Image.SCALE_DEFAULT), 0, 0, null);
		g2.drawImage(center.getScaledInstance(width - 12, height, Image.SCALE_DEFAULT), 6, 0, null);
		g2.drawImage(right.getScaledInstance(6, height, Image.SCALE_DEFAULT), width - 6, 0, null);

		return bufferedImage.getScaledInstance(width, height, Image.SCALE_DEFAULT);
	}

	public static Image getButtonDown1(int width, int height, boolean isShader) {
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = bufferedImage.createGraphics();

		Image left = ImageTools.cut("image\\button\\bleft" + (isShader ? "" : "_noshader") + ".png", 12, 0, 6, 24, "png");
		Image center = ImageTools.cut("image\\button\\bcenter" + (isShader ? "" : "_noshader") + ".png", 12, 0, 6, 24, "png");
		Image right = ImageTools.cut("image\\button\\bright" + (isShader ? "" : "_noshader") + ".png", 12, 0, 6, 24, "png");

		g2.drawImage(left.getScaledInstance(6, height, Image.SCALE_DEFAULT), 0, 0, null);
		g2.drawImage(center.getScaledInstance(width - 12, height, Image.SCALE_DEFAULT), 6, 0, null);
		g2.drawImage(right.getScaledInstance(6, height, Image.SCALE_DEFAULT), width - 6, 0, null);

		return bufferedImage.getScaledInstance(width, height, Image.SCALE_DEFAULT);
	}

	public static Image getButtonOn1(int width, int height, boolean isShader) {

		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = bufferedImage.createGraphics();

		Image left = ImageTools.cut("image\\button\\bleft" + (isShader ? "" : "_noshader") + ".png", 6, 0, 6, 24, "png");
		Image center = ImageTools.cut("image\\button\\bcenter" + (isShader ? "" : "_noshader") + ".png", 6, 0, 6, 24, "png");
		Image right = ImageTools.cut("image\\button\\bright" + (isShader ? "" : "_noshader") + ".png", 6, 0, 6, 24, "png");

		g2.drawImage(left.getScaledInstance(6, height, Image.SCALE_DEFAULT), 0, 0, null);
		g2.drawImage(center.getScaledInstance(width - 12, height, Image.SCALE_DEFAULT), 6, 0, null);
		g2.drawImage(right.getScaledInstance(6, height, Image.SCALE_DEFAULT), width - 6, 0, null);

		return bufferedImage.getScaledInstance(width, height, Image.SCALE_DEFAULT);
	}

}
