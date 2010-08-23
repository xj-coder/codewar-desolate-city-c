package platform.tools;

/**
 * 图片工厂<BR>
 * 所有读取图片资源的操作都在该类
 */

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.net.URL;

public class ImageFactory {

	public static Image getLoginBgUpImage() {
		URL url = ImageFactory.class.getClassLoader().getResource(
				"image/bg_up.png");
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getLoginBgDownImage() {
		URL url = ImageFactory.class.getClassLoader().getResource(
				"image/bg_down.png");
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getLoginBgCenterImage() {
		URL url = ImageFactory.class.getClassLoader().getResource(
				"image/bg_center.png");
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getLoginBannerImage() {
		URL url = ImageFactory.class.getClassLoader().getResource(
				"image/banner.png");
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getLoginProcessbarInImage() {
		URL url = ImageFactory.class.getClassLoader().getResource(
				"image/Login_processbar_in.png");
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getLoginProcessbarOutImage() {
		URL url = ImageFactory.class.getClassLoader().getResource(
				"image/Login_processbar_out.png");
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getLoginProcessbarBgImage() {
		URL url = ImageFactory.class.getClassLoader().getResource(
				"image/Login_processbar_update.png");
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getButton(int width, int height) {
		URL url1 = ImageFactory.class.getClassLoader().getResource(
				"image/button/bleft.png");
		URL url2 = ImageFactory.class.getClassLoader().getResource(
				"image/button/bcenter.png");
		URL url3 = ImageFactory.class.getClassLoader().getResource(
				"image/button/bright.png");
		BufferedImage bufferedImage = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = bufferedImage.createGraphics();

		Image left = ImageTools.cut(url1, 0, 0, 6, 24, "png");
		Image center = ImageTools.cut(url2, 0, 0, 6, 24, "png");
		Image right = ImageTools.cut(url3, 0, 0, 6, 24, "png");

		g2.drawImage(left.getScaledInstance(6, height, Image.SCALE_DEFAULT), 0,
				0, null);
		g2.drawImage(center.getScaledInstance(width - 12, height,
				Image.SCALE_DEFAULT), 6, 0, null);
		g2.drawImage(right.getScaledInstance(6, height, Image.SCALE_DEFAULT),
				width - 6, 0, null);

		return bufferedImage.getScaledInstance(width, height,
				Image.SCALE_DEFAULT);
	}

	public static Image getButtonPressed(int width, int height) {
		URL url1 = ImageFactory.class.getClassLoader().getResource(
				"image/button/bleft.png");
		URL url2 = ImageFactory.class.getClassLoader().getResource(
				"image/button/bcenter.png");
		URL url3 = ImageFactory.class.getClassLoader().getResource(
				"image/button/bright.png");

		BufferedImage bufferedImage = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = bufferedImage.createGraphics();

		Image left = ImageTools.cut(url1, 12, 0, 6, 24, "png");
		Image center = ImageTools.cut(url2, 12, 0, 6, 24, "png");
		Image right = ImageTools.cut(url3, 12, 0, 6, 24, "png");

		g2.drawImage(left.getScaledInstance(6, height, Image.SCALE_DEFAULT), 0,
				0, null);
		g2.drawImage(center.getScaledInstance(width - 12, height,
				Image.SCALE_DEFAULT), 6, 0, null);
		g2.drawImage(right.getScaledInstance(6, height, Image.SCALE_DEFAULT),
				width - 6, 0, null);

		return bufferedImage.getScaledInstance(width, height,
				Image.SCALE_DEFAULT);
	}

	public static Image getButtonRollover(int width, int height) {
		URL url1 = ImageFactory.class.getClassLoader().getResource(
				"image/button/bleft.png");
		URL url2 = ImageFactory.class.getClassLoader().getResource(
				"image/button/bcenter.png");
		URL url3 = ImageFactory.class.getClassLoader().getResource(
				"image/button/bright.png");

		BufferedImage bufferedImage = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = bufferedImage.createGraphics();

		Image left = ImageTools.cut(url1, 6, 0, 6, 24, "png");
		Image center = ImageTools.cut(url2, 6, 0, 6, 24, "png");
		Image right = ImageTools.cut(url3, 6, 0, 6, 24, "png");

		g2.drawImage(left.getScaledInstance(6, height, Image.SCALE_DEFAULT), 0,
				0, null);
		g2.drawImage(center.getScaledInstance(width - 12, height,
				Image.SCALE_DEFAULT), 6, 0, null);
		g2.drawImage(right.getScaledInstance(6, height, Image.SCALE_DEFAULT),
				width - 6, 0, null);

		return bufferedImage.getScaledInstance(width, height,
				Image.SCALE_DEFAULT);
	}

	public static Image getIndexBgUpLeftImage() {
		URL url = ImageFactory.class.getClassLoader().getResource(
				"image/index/border/up-left.png");
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getIndexBgDownRightImage() {
		URL url = ImageFactory.class.getClassLoader().getResource(
				"image/index/border/down-right.png");
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getIndexBgDownLeftImage() {
		URL url = ImageFactory.class.getClassLoader().getResource(
				"image/index/border/down-left.png");
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getIndexBgDownCenterImage() {
		URL url = ImageFactory.class.getClassLoader().getResource(
				"image/index/border/down-center.png");
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getIndexBgLeftImage() {
		URL url = ImageFactory.class.getClassLoader().getResource(
				"image/index/border/left.png");
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getIndexBgRightImage() {
		URL url = ImageFactory.class.getClassLoader().getResource(
				"image/index/border/right.png");
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getIndexBgCenterImage() {
		URL url = ImageFactory.class.getClassLoader().getResource(
				"image/index/border/center.png");
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getIndexBgUpRightImage() {
		URL url = ImageFactory.class.getClassLoader().getResource(
				"image/index/border/up-right.png");
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getIndexBgUpCenterImage() {
		URL url = ImageFactory.class.getClassLoader().getResource(
				"image/index/border/up-center.png");
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getIndexIconImage() {
		URL url = ImageFactory.class.getClassLoader().getResource(
				"image/index/QQGame.png");
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getIndexTitleImage() {
		URL url = ImageFactory.class.getClassLoader().getResource(
				"image/index/HallTitle.png");
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getLoginCloseButton() {
		URL url = ImageFactory.class.getClassLoader().getResource(
				"image/close_btn.png");
		return ImageTools.cut(url, 0, 0, 37, 21, "png");
	}

	public static Image getLoginCloseButtonRollover() {
		URL url = ImageFactory.class.getClassLoader().getResource(
				"image/close_btn.png");
		return ImageTools.cut(url, 37, 0, 37, 21, "png");
	}

	public static Image getLoginCloseButtonPressed() {
		URL url = ImageFactory.class.getClassLoader().getResource(
				"image/close_btn.png");
		return ImageTools.cut(url, 74, 0, 37, 21, "png");
	}

	public static Image getLoginHelpButton() {
		URL url = ImageFactory.class.getClassLoader().getResource(
				"image/help.png");
		return ImageTools.cut(url, 0, 0, 21, 22, "png");
	}

	public static Image getLoginHelpButtonRollover() {
		URL url = ImageFactory.class.getClassLoader().getResource(
				"image/help.png");
		return ImageTools.cut(url, 21, 0, 21, 22, "png");
	}

	public static Image getLoginHelpButtonPressed() {
		URL url = ImageFactory.class.getClassLoader().getResource(
				"image/help.png");
		return ImageTools.cut(url, 42, 0, 21, 22, "png");
	}

	public static Image getIndexCloseButton() {
		URL url = ImageFactory.class.getClassLoader().getResource(
				"image/index/button/close_btn.png");
		return ImageTools.cut(url, 0, 0, 37, 22, "png");
	}

	public static Image getIndexCloseButtonRollover() {
		URL url = ImageFactory.class.getClassLoader().getResource(
				"image/index/button/close_btn.png");
		return ImageTools.cut(url, 37, 0, 37, 22, "png");
	}

	public static Image getIndexCloseButtonPressed() {
		URL url = ImageFactory.class.getClassLoader().getResource(
				"image/index/button/close_btn.png");
		return ImageTools.cut(url, 74, 0, 37, 22, "png");
	}

	public static Image getIndexMinButton() {
		URL url = ImageFactory.class.getClassLoader().getResource(
				"image/index/button/min_btn.png");
		return ImageTools.cut(url, 0, 0, 31, 22, "png");
	}

	public static Image getIndexMinButtonRollover() {
		URL url = ImageFactory.class.getClassLoader().getResource(
				"image/index/button/min_btn.png");
		return ImageTools.cut(url, 31, 0, 31, 22, "png");
	}

	public static Image getIndexMinButtonPressed() {
		URL url = ImageFactory.class.getClassLoader().getResource(
				"image/index/button/min_btn.png");
		return ImageTools.cut(url, 62, 0, 31, 22, "png");
	}

	public static Image getIndexMaxButton() {
		URL url = ImageFactory.class.getClassLoader().getResource(
				"image/index/button/max_btn.png");
		return ImageTools.cut(url, 0, 0, 32, 22, "png");
	}

	public static Image getIndexMaxButtonRollover() {
		URL url = ImageFactory.class.getClassLoader().getResource(
				"image/index/button/max_btn.png");
		return ImageTools.cut(url, 32, 0, 32, 22, "png");
	}

	public static Image getIndexMaxButtonPressed() {
		URL url = ImageFactory.class.getClassLoader().getResource(
				"image/index/button/max_btn.png");
		return ImageTools.cut(url, 64, 0, 32, 22, "png");
	}

	public static Image getIndexRestrButton() {
		URL url = ImageFactory.class.getClassLoader().getResource(
				"image/index/button/restr_btn.png");
		return ImageTools.cut(url, 0, 0, 33, 22, "png");
	}

	public static Image getIndexRestrButtonRollover() {
		URL url = ImageFactory.class.getClassLoader().getResource(
				"image/index/button/restr_btn.png");
		return ImageTools.cut(url, 32, 0, 32, 22, "png");
	}

	public static Image getIndexRestrButtonPressed() {
		URL url = ImageFactory.class.getClassLoader().getResource(
				"image/index/button/restr_btn.png");
		return ImageTools.cut(url, 64, 0, 32, 22, "png");
	}

	public static Image getIndexChangeFaceButton() {
		URL url = ImageFactory.class.getClassLoader().getResource(
				"image/index/button/change-face-btn.png");
		return ImageTools.cut(url, 0, 0, 40, 14, "png");
	}

	public static Image getIndexChangeFaceButtonRollover() {
		URL url = ImageFactory.class.getClassLoader().getResource(
				"image/index/button/change-face-btn.png");
		return ImageTools.cut(url, 40, 0, 40, 14, "png");
	}

	public static Image getIndexChangeFaceButtonPressed() {
		URL url = ImageFactory.class.getClassLoader().getResource(
				"image/index/button/change-face-btn.png");
		return ImageTools.cut(url, 80, 0, 40, 14, "png");
	}

	public static Image getIndexMenuButton() {
		URL url = ImageFactory.class.getClassLoader().getResource(
				"image/index/button/menu-btn.png");
		return ImageTools.cut(url, 0, 0, 40, 14, "png");
	}

	public static Image getIndexMenuButtonRollover() {
		URL url = ImageFactory.class.getClassLoader().getResource(
				"image/index/button/menu-btn.png");
		return ImageTools.cut(url, 40, 0, 40, 14, "png");
	}

	public static Image getIndexMenuButtonPressed() {
		URL url = ImageFactory.class.getClassLoader().getResource(
				"image/index/button/menu-btn.png");
		return ImageTools.cut(url, 80, 0, 40, 14, "png");
	}

	public static Image getIndexHeadPicBorderImage() {
		URL url = ImageFactory.class.getClassLoader().getResource(
				"image/index/pic.png");
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getIndexHeadPicBorderHighLightImage() {
		URL url = ImageFactory.class.getClassLoader().getResource(
				"image/index/pic_hl.png");
		return Toolkit.getDefaultToolkit().getImage(url);
	}

}