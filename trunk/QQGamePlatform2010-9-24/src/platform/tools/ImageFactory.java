package platform.tools;

/**
 * 图片工厂<BR>
 * 所有读取图片资源的操作都在该类
 */

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;

import platform.define.PathDefine;

public class ImageFactory {

	public static Image getLoginBgUpImage() {
		String url = PathDefine.RES_PATH + "bg_up.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getLoginBgDownImage() {
		String url = PathDefine.RES_PATH + "bg_down.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getLoginBgCenterImage() {
		String url = PathDefine.RES_PATH + "bg_center.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getLoginBannerImage() {
		String url = PathDefine.RES_PATH + "banner.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getLoginProcessbarInImage() {
		String url = PathDefine.RES_PATH + "Login_processbar_in.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getLoginProcessbarOutImage() {
		String url = PathDefine.RES_PATH + "Login_processbar_out.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getLoginProcessbarBgImage() {
		String url = PathDefine.RES_PATH + "Login_processbar_update.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getButton(int width, int height) {
		String url1 = PathDefine.RES_PATH + "button/bleft.png";
		String url2 = PathDefine.RES_PATH + "button/bcenter.png";
		String url3 = PathDefine.RES_PATH + "button/bright.png";
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = bufferedImage.createGraphics();

		Image left = ImageTools.cut(url1, 0, 0, 6, 24, "png");
		Image center = ImageTools.cut(url2, 0, 0, 6, 24, "png");
		Image right = ImageTools.cut(url3, 0, 0, 6, 24, "png");

		g2.drawImage(left.getScaledInstance(6, height, Image.SCALE_DEFAULT), 0, 0, null);
		g2.drawImage(center.getScaledInstance(width - 12, height, Image.SCALE_DEFAULT), 6, 0, null);
		g2.drawImage(right.getScaledInstance(6, height, Image.SCALE_DEFAULT), width - 6, 0, null);

		return bufferedImage.getScaledInstance(width, height, Image.SCALE_DEFAULT);
	}

	public static Image getButtonWithBorder(int width, int height) {
		String url1 = PathDefine.RES_PATH + "button/bleft.png";
		String url2 = PathDefine.RES_PATH + "button/bcenter.png";
		String url3 = PathDefine.RES_PATH + "button/bright.png";
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = bufferedImage.createGraphics();

		Image left = ImageTools.cut(url1, 24, 0, 6, 24, "png");
		Image center = ImageTools.cut(url2, 24, 0, 6, 24, "png");
		Image right = ImageTools.cut(url3, 24, 0, 6, 24, "png");

		g2.drawImage(left.getScaledInstance(6, height, Image.SCALE_DEFAULT), 0, 0, null);
		g2.drawImage(center.getScaledInstance(width - 12, height, Image.SCALE_DEFAULT), 6, 0, null);
		g2.drawImage(right.getScaledInstance(6, height, Image.SCALE_DEFAULT), width - 6, 0, null);

		return bufferedImage.getScaledInstance(width, height, Image.SCALE_DEFAULT);
	}

	public static Image getButtonPressed(int width, int height) {
		String url1 = PathDefine.RES_PATH + "button/bleft.png";
		String url2 = PathDefine.RES_PATH + "button/bcenter.png";
		String url3 = PathDefine.RES_PATH + "button/bright.png";

		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = bufferedImage.createGraphics();

		Image left = ImageTools.cut(url1, 12, 0, 6, 24, "png");
		Image center = ImageTools.cut(url2, 12, 0, 6, 24, "png");
		Image right = ImageTools.cut(url3, 12, 0, 6, 24, "png");

		g2.drawImage(left.getScaledInstance(6, height, Image.SCALE_DEFAULT), 0, 0, null);
		g2.drawImage(center.getScaledInstance(width - 12, height, Image.SCALE_DEFAULT), 6, 0, null);
		g2.drawImage(right.getScaledInstance(6, height, Image.SCALE_DEFAULT), width - 6, 0, null);

		return bufferedImage.getScaledInstance(width, height, Image.SCALE_DEFAULT);
	}

	public static Image getButtonRollover(int width, int height) {
		String url1 = PathDefine.RES_PATH + "button/bleft.png";
		String url2 = PathDefine.RES_PATH + "button/bcenter.png";
		String url3 = PathDefine.RES_PATH + "button/bright.png";

		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = bufferedImage.createGraphics();

		Image left = ImageTools.cut(url1, 6, 0, 6, 24, "png");
		Image center = ImageTools.cut(url2, 6, 0, 6, 24, "png");
		Image right = ImageTools.cut(url3, 6, 0, 6, 24, "png");

		g2.drawImage(left.getScaledInstance(6, height, Image.SCALE_DEFAULT), 0, 0, null);
		g2.drawImage(center.getScaledInstance(width - 12, height, Image.SCALE_DEFAULT), 6, 0, null);
		g2.drawImage(right.getScaledInstance(6, height, Image.SCALE_DEFAULT), width - 6, 0, null);

		return bufferedImage.getScaledInstance(width, height, Image.SCALE_DEFAULT);
	}

	public static Image getIndexBgUpLeftImage() {
		String url = PathDefine.RES_PATH + "index/border/up-left.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getIndexBgDownRightImage() {
		String url = PathDefine.RES_PATH + "index/border/down-right.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getIndexBgDownLeftImage() {
		String url = PathDefine.RES_PATH + "index/border/down-left.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getIndexBgDownCenterImage() {
		String url = PathDefine.RES_PATH + "index/border/down-center.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getIndexBgLeftImage() {
		String url = PathDefine.RES_PATH + "index/border/left.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getIndexBgRightImage() {
		String url = PathDefine.RES_PATH + "index/border/right.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getIndexBgCenterImage() {
		String url = PathDefine.RES_PATH + "index/border/center.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getIndexBgUpRightImage() {
		String url = PathDefine.RES_PATH + "index/border/up-right.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getIndexBgUpCenterImage() {
		String url = PathDefine.RES_PATH + "index/border/up-center.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getIndexIconImage() {
		String url = PathDefine.RES_PATH + "index/QQGame.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getIndexTitleImage() {
		String url = PathDefine.RES_PATH + "index/HallTitle.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getLoginCloseButton() {
		String url = PathDefine.RES_PATH + "close_btn.png";
		return ImageTools.cut(url, 0, 0, 37, 21, "png");
	}

	public static Image getLoginCloseButtonRollover() {
		String url = PathDefine.RES_PATH + "close_btn.png";
		return ImageTools.cut(url, 37, 0, 37, 21, "png");
	}

	public static Image getLoginCloseButtonPressed() {
		String url = PathDefine.RES_PATH + "close_btn.png";
		return ImageTools.cut(url, 74, 0, 37, 21, "png");
	}

	public static Image getLoginHelpButton() throws MalformedURLException {
		String url = PathDefine.RES_PATH + "help.png";
		return ImageTools.cut(url, 0, 0, 21, 22, "png");
	}

	public static Image getLoginHelpButtonRollover() {
		String url = PathDefine.RES_PATH + "help.png";
		return ImageTools.cut(url, 21, 0, 21, 22, "png");
	}

	public static Image getLoginHelpButtonPressed() {
		String url = PathDefine.RES_PATH + "help.png";
		return ImageTools.cut(url, 42, 0, 21, 22, "png");
	}

	public static Image getIndexCloseButton() {
		String url = PathDefine.RES_PATH + "index/button/close_btn.png";
		return ImageTools.cut(url, 0, 0, 37, 22, "png");
	}

	public static Image getIndexCloseButtonRollover() {
		String url = PathDefine.RES_PATH + "index/button/close_btn.png";
		return ImageTools.cut(url, 37, 0, 37, 22, "png");
	}

	public static Image getIndexCloseButtonPressed() {
		String url = PathDefine.RES_PATH + "index/button/close_btn.png";
		return ImageTools.cut(url, 74, 0, 37, 22, "png");
	}

	public static Image getIndexMinButton() {
		String url = PathDefine.RES_PATH + "index/button/min_btn.png";
		return ImageTools.cut(url, 0, 0, 31, 22, "png");
	}

	public static Image getIndexMinButtonRollover() {
		String url = PathDefine.RES_PATH + "index/button/min_btn.png";
		return ImageTools.cut(url, 31, 0, 31, 22, "png");
	}

	public static Image getIndexMinButtonPressed() {
		String url = PathDefine.RES_PATH + "index/button/min_btn.png";
		return ImageTools.cut(url, 62, 0, 31, 22, "png");
	}

	public static Image getIndexMaxButton() {
		String url = PathDefine.RES_PATH + "index/button/max_btn.png";
		return ImageTools.cut(url, 0, 0, 32, 22, "png");
	}

	public static Image getIndexMaxButtonRollover() {
		String url = PathDefine.RES_PATH + "index/button/max_btn.png";
		return ImageTools.cut(url, 32, 0, 32, 22, "png");
	}

	public static Image getIndexMaxButtonPressed() {
		String url = PathDefine.RES_PATH + "index/button/max_btn.png";
		return ImageTools.cut(url, 64, 0, 32, 22, "png");
	}

	public static Image getIndexRestrButton() {
		String url = PathDefine.RES_PATH + "index/button/restr_btn.png";
		return ImageTools.cut(url, 0, 0, 33, 22, "png");
	}

	public static Image getIndexRestrButtonRollover() {
		String url = PathDefine.RES_PATH + "index/button/restr_btn.png";
		return ImageTools.cut(url, 32, 0, 32, 22, "png");
	}

	public static Image getIndexRestrButtonPressed() {
		String url = PathDefine.RES_PATH + "index/button/restr_btn.png";
		return ImageTools.cut(url, 64, 0, 32, 22, "png");
	}

	public static Image getIndexChangeFaceButton() {
		String url = PathDefine.RES_PATH + "index/button/change-face-btn.png";
		return ImageTools.cut(url, 0, 0, 40, 14, "png");
	}

	public static Image getIndexChangeFaceButtonRollover() {
		String url = PathDefine.RES_PATH + "index/button/change-face-btn.png";
		return ImageTools.cut(url, 40, 0, 40, 14, "png");
	}

	public static Image getIndexChangeFaceButtonPressed() {
		String url = PathDefine.RES_PATH + "index/button/change-face-btn.png";
		return ImageTools.cut(url, 80, 0, 40, 14, "png");
	}

	public static Image getIndexMenuButton() {
		String url = PathDefine.RES_PATH + "index/button/menu-btn.png";
		return ImageTools.cut(url, 0, 0, 40, 14, "png");
	}

	public static Image getIndexMenuButtonRollover() {
		String url = PathDefine.RES_PATH + "index/button/menu-btn.png";
		return ImageTools.cut(url, 40, 0, 40, 14, "png");
	}

	public static Image getIndexMenuButtonPressed() {
		String url = PathDefine.RES_PATH + "index/button/menu-btn.png";
		return ImageTools.cut(url, 80, 0, 40, 14, "png");
	}

	public static Image getIndexHeadPicBorderImage() {
		String url = PathDefine.RES_PATH + "index/pic.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getIndexHeadPicBorderHighLightImage() {
		String url = PathDefine.RES_PATH + "index/pic_hl.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getCheckBoxImage() {
		String url = PathDefine.RES_PATH + "button/check.png";
		return ImageTools.cut(url, 0, 0, 13, 13, "png");
	}

	public static Image getDisableCheckBoxImage() {
		String url = PathDefine.RES_PATH + "button/check.png";
		return ImageTools.cut(url, 13, 0, 13, 13, "png");
	}

	public static Image getCheckedBoxImage() {
		String url = PathDefine.RES_PATH + "button/checked.png";
		return ImageTools.cut(url, 0, 0, 13, 13, "png");
	}

	public static Image getDisableCheckedBoxImage() {
		String url = PathDefine.RES_PATH + "button/checked.png";
		return ImageTools.cut(url, 13, 0, 13, 13, "png");
	}

	public static Image getLoginAccountInputButton() {
		String url = PathDefine.RES_PATH + "button/arrow.png";
		return ImageTools.cut(url, 0, 0, 16, 16, "png");
	}

	public static Image getLoginAccountInputButtonRollover() {
		String url = PathDefine.RES_PATH + "button/arrow.png";
		return ImageTools.cut(url, 16, 0, 16, 16, "png");
	}

	public static Image getLoginAccountInputButtonPressed() {
		String url = PathDefine.RES_PATH + "button/arrow.png";
		return ImageTools.cut(url, 32, 0, 16, 16, "png");
	}

	public static Image getLoginAccountInputButtonDisable() {
		String url = PathDefine.RES_PATH + "button/arrow.png";
		return ImageTools.cut(url, 48, 0, 16, 16, "png");
	}

	// 左侧目录树
	public static Image getIndexDirBgUpLeftImage() {
		String url = PathDefine.RES_PATH + "index/DirTree/up-left.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getIndexDirBgUpCenterImage() {
		String url = PathDefine.RES_PATH + "index/DirTree/up-center.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getIndexDirBgUpRightImage() {
		String url = PathDefine.RES_PATH + "index/DirTree/up-right.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getIndexDirBgLeftImage() {
		String url = PathDefine.RES_PATH + "index/DirTree/left.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getIndexDirBgRightImage() {
		String url = PathDefine.RES_PATH + "index/DirTree/right.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getIndexDirBgDownLeftImage() {
		String url = PathDefine.RES_PATH + "index/DirTree/down-left.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getIndexDirBgDownCenterImage() {
		String url = PathDefine.RES_PATH + "index/DirTree/down-center.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getIndexDirBgDownRightImage() {
		String url = PathDefine.RES_PATH + "index/DirTree/down-right.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getIndexDirSearchBgLeftImage() {
		String url = PathDefine.RES_PATH + "index/DirTree/s-left.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getIndexDirSearchBgCenterImage() {
		String url = PathDefine.RES_PATH + "index/DirTree/s-center.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getIndexDirSearchBgRightImage() {
		String url = PathDefine.RES_PATH + "index/DirTree/s-right.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getIndexDirListBgUpLeftImage() {
		String url = PathDefine.RES_PATH + "index/DirTree/l-up-left.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getIndexDirListBgUpCenterImage() {
		String url = PathDefine.RES_PATH + "index/DirTree/l-up-center.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getIndexDirListBgUpRightImage() {
		String url = PathDefine.RES_PATH + "index/DirTree/l-up-right.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getIndexDirListBgLeftImage() {
		String url = PathDefine.RES_PATH + "index/DirTree/l-left.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getIndexDirListBgRightImage() {
		String url = PathDefine.RES_PATH + "index/DirTree/l-right.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getIndexDirListBgDownLeftImage() {
		String url = PathDefine.RES_PATH + "index/DirTree/l-down-left.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getIndexDirListBgDownCenterImage() {
		String url = PathDefine.RES_PATH + "index/DirTree/l-down-center.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getIndexDirListBgDownRightImage() {
		String url = PathDefine.RES_PATH + "index/DirTree/l-down-right.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getIndexDirBgCenterImage() {
		String url = PathDefine.RES_PATH + "index/DirTree/center.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getIndexSearchListButton() {
		String url = PathDefine.RES_PATH + "index/DirTree/s-list.png";
		return ImageTools.cut(url, 0, 0, 7, 5, "png");
	}

	public static Image getIndexSearchListButtonRollover() {
		String url = PathDefine.RES_PATH + "index/DirTree/s-list.png";
		return ImageTools.cut(url, 7, 0, 7, 5, "png");
	}

	public static Image getIndexSearchListButtonPressed() {
		String url = PathDefine.RES_PATH + "index/DirTree/s-list.png";
		return ImageTools.cut(url, 14, 0, 7, 5, "png");
	}

	public static Image getIndexSearchEnterButton() {
		String url = PathDefine.RES_PATH + "index/DirTree/s-enter.png";
		return ImageTools.cut(url, 0, 0, 10, 10, "png");
	}

	public static Image getIndexSearchEnterButtonRollover() {
		String url = PathDefine.RES_PATH + "index/DirTree/s-enter.png";
		return ImageTools.cut(url, 10, 0, 10, 10, "png");
	}

	public static Image getIndexSearchEnterButtonPressed() {
		String url = PathDefine.RES_PATH + "index/DirTree/s-enter.png";
		return ImageTools.cut(url, 20, 0, 10, 10, "png");
	}

	public static Image getIndexDirLockButton() {
		String url = PathDefine.RES_PATH + "index/DirTree/lock.png";
		return ImageTools.cut(url, 0, 0, 18, 17, "png");
	}

	public static Image getIndexDirLockButtonRollover() {
		String url = PathDefine.RES_PATH + "index/DirTree/lock.png";
		return ImageTools.cut(url, 18, 0, 18, 17, "png");
	}

	public static Image getIndexDirLockButtonPressed() {
		String url = PathDefine.RES_PATH + "index/DirTree/unlock.png";
		return ImageTools.cut(url, 0, 0, 18, 17, "png");
	}

	public static Image getIndexDirUnLockButton() {
		String url = PathDefine.RES_PATH + "index/DirTree/unlock.png";
		return ImageTools.cut(url, 0, 0, 18, 17, "png");
	}

	public static Image getIndexDirUnLockButtonRollover() {
		String url = PathDefine.RES_PATH + "index/DirTree/unlock.png";
		return ImageTools.cut(url, 18, 0, 18, 17, "png");
	}

	public static Image getIndexDirUnLockButtonPressed() {
		String url = PathDefine.RES_PATH + "index/DirTree/lock.png";
		return ImageTools.cut(url, 0, 0, 18, 17, "png");
	}

	public static Image getIndexLeftSplitterButton() {
		String url = PathDefine.RES_PATH + "common/splitter/left.png";
		return ImageTools.cut(url, 0, 0, 9, 80, "png");
	}

	public static Image getIndexLeftSplitterButtonRollover() {
		String url = PathDefine.RES_PATH + "common/splitter/left.png";
		return ImageTools.cut(url, 9, 0, 9, 80, "png");
	}

	public static Image getIndexLeftSplitterButtonPressed() {
		String url = PathDefine.RES_PATH + "common/splitter/left.png";
		return ImageTools.cut(url, 18, 0, 9, 80, "png");
	}

	public static Image getIndexLeftSplitterButtonDisable() {
		String url = PathDefine.RES_PATH + "common/splitter/left.png";
		return ImageTools.cut(url, 27, 0, 9, 80, "png");
	}

	public static Image getIndexRightSplitterButton() {
		String url = PathDefine.RES_PATH + "common/splitter/right.png";
		return ImageTools.cut(url, 0, 0, 9, 80, "png");
	}

	public static Image getIndexRightSplitterButtonRollover() {
		String url = PathDefine.RES_PATH + "common/splitter/right.png";
		return ImageTools.cut(url, 9, 0, 9, 80, "png");
	}

	public static Image getIndexRightSplitterButtonPressed() {
		String url = PathDefine.RES_PATH + "common/splitter/right.png";
		return ImageTools.cut(url, 18, 0, 9, 80, "png");
	}

	public static Image getIndexRightSplitterButtonDisable() {
		String url = PathDefine.RES_PATH + "common/splitter/right.png";
		return ImageTools.cut(url, 27, 0, 9, 80, "png");
	}

	public static Image getIndexPageTabTitleIcon() {
		String url = PathDefine.RES_PATH + "index/QQGame.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getIndexTabBackgroundPressed(int width, int height) {
		String url1 = PathDefine.RES_PATH + "common/tab/tab_item_left.png";
		String url2 = PathDefine.RES_PATH + "common/tab/tab_item_mid.png";
		String url3 = PathDefine.RES_PATH + "common/tab/tab_item_right.png";

		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = bufferedImage.createGraphics();

		Image left = ImageTools.cut(url1, 0, 0, 4, 26, "png");
		Image center = ImageTools.cut(url2, 0, 0, 1, 24, "png");
		Image right = ImageTools.cut(url3, 0, 0, 4, 26, "png");

		g2.drawImage(left.getScaledInstance(4, height, Image.SCALE_DEFAULT), 0, 0, null);
		g2.drawImage(center.getScaledInstance(width - 8, height, Image.SCALE_DEFAULT), 4, 0, null);
		g2.drawImage(right.getScaledInstance(4, height, Image.SCALE_DEFAULT), width - 4, 0, null);

		return bufferedImage.getScaledInstance(width, height, Image.SCALE_DEFAULT);
	}

	public static Image getIndexTabBackgroundRollover(int width, int height) {
		String url1 = PathDefine.RES_PATH + "common/tab/tab_item_left.png";
		String url2 = PathDefine.RES_PATH + "common/tab/tab_item_mid.png";
		String url3 = PathDefine.RES_PATH + "common/tab/tab_item_right.png";

		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = bufferedImage.createGraphics();

		Image left = ImageTools.cut(url1, 4, 0, 4, 24, "png");
		Image center = ImageTools.cut(url2, 1, 0, 1, 24, "png");
		Image right = ImageTools.cut(url3, 4, 0, 4, 24, "png");

		g2.drawImage(left.getScaledInstance(4, height, Image.SCALE_DEFAULT), 0, 0, null);
		g2.drawImage(center.getScaledInstance(width - 8, height, Image.SCALE_DEFAULT), 4, 0, null);
		g2.drawImage(right.getScaledInstance(4, height, Image.SCALE_DEFAULT), width - 4, 0, null);

		return bufferedImage.getScaledInstance(width, height, Image.SCALE_DEFAULT);
	}

	public static Image getIndexTabBackground(int width, int height) {
		String url1 = PathDefine.RES_PATH + "common/tab/tab_item_left.png";
		String url2 = PathDefine.RES_PATH + "common/tab/tab_item_mid.png";
		String url3 = PathDefine.RES_PATH + "common/tab/tab_item_right.png";

		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = bufferedImage.createGraphics();

		Image left = ImageTools.cut(url1, 8, 0, 4, 24, "png");
		Image center = ImageTools.cut(url2, 2, 0, 1, 24, "png");
		Image right = ImageTools.cut(url3, 8, 0, 4, 24, "png");

		g2.drawImage(left.getScaledInstance(4, height, Image.SCALE_DEFAULT), 0, 0, null);
		g2.drawImage(center.getScaledInstance(width - 8, height, Image.SCALE_DEFAULT), 4, 0, null);
		g2.drawImage(right.getScaledInstance(4, height, Image.SCALE_DEFAULT), width - 4, 0, null);

		return bufferedImage.getScaledInstance(width, height, Image.SCALE_DEFAULT);
	}

	public static Image getExpandOpenImage() {
		String url = PathDefine.RES_PATH + "index/DirTree/LedOff.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getExpandCloseImage() {
		String url = PathDefine.RES_PATH + "index/DirTree/LedOn.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getIndexTabScrollLeftButton(int width, int height) {
		String url = PathDefine.RES_PATH + "index/button/pre.png";
		return ImageTools.cut(url, 0, 0, 15, 15, "png");
	}

	public static Image getIndexTabScrollLeftButtonRollover(int width, int height) {
		String url = PathDefine.RES_PATH + "index/button/pre.png";
		return ImageTools.cut(url, 15, 0, width, height, "png");
	}

	public static Image getIndexTabScrollLeftButtonPressed(int width, int height) {
		String url = PathDefine.RES_PATH + "index/button/pre.png";
		return ImageTools.cut(url, 30, 0, width, height, "png");
	}

	public static Image getIndexTabScrollLeftDisableButton(int width, int height) {
		String url = PathDefine.RES_PATH + "index/button/pre.png";
		return ImageTools.cut(url, 45, 0, width, height, "png");
	}

	public static Image getIndexTabScrollRightButton(int width, int height) {
		String url = PathDefine.RES_PATH + "index/button/next.png";
		return ImageTools.cut(url, 0, 0, width, height, "png");
	}

	public static Image getIndexTabScrollRightButtonRollover(int width, int height) {
		String url = PathDefine.RES_PATH + "index/button/next.png";
		return ImageTools.cut(url, 15, 0, width, height, "png");
	}

	public static Image getIndexTabScrollRightButtonPressed(int width, int height) {
		String url = PathDefine.RES_PATH + "index/button/next.png";
		return ImageTools.cut(url, 30, 0, width, height, "png");
	}

	public static Image getIndexTabScrollRightDisableButton(int width, int height) {
		String url = PathDefine.RES_PATH + "index/button/next.png";
		return ImageTools.cut(url, 45, 0, width, height, "png");
	}

	public static Image getDefaultDirTreeIcon() {
		String url = PathDefine.RES_PATH + "index/DirTree/defaultIcon.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getIndexPageBackButton(int width, int height) {
		String url = PathDefine.RES_PATH + "index/web/web_pre.png";
		return ImageTools.cut(url, 0, 0, width, height, "png");
	}

	public static Image getIndexPageBackButtonRollover(int width, int height) {
		String url = PathDefine.RES_PATH + "index/web/web_pre.png";
		return ImageTools.cut(url, 20, 0, width, height, "png");
	}

	public static Image getIndexPageBackButtonPressed(int width, int height) {
		String url = PathDefine.RES_PATH + "index/web/web_pre.png";
		return ImageTools.cut(url, 40, 0, width, height, "png");
	}

	public static Image getIndexPageBackButtonDisabled(int width, int height) {
		String url = PathDefine.RES_PATH + "index/web/web_pre.png";
		return ImageTools.cut(url, 60, 0, width, height, "png");
	}

	public static Image getIndexPageGoButton(int width, int height) {
		String url = PathDefine.RES_PATH + "index/web/web_next.png";
		return ImageTools.cut(url, 0, 0, width, height, "png");
	}

	public static Image getIndexPageGoButtonRollover(int width, int height) {
		String url = PathDefine.RES_PATH + "index/web/web_next.png";
		return ImageTools.cut(url, 20, 0, width, height, "png");
	}

	public static Image getIndexPageGoButtonPressed(int width, int height) {
		String url = PathDefine.RES_PATH + "index/web/web_next.png";
		return ImageTools.cut(url, 40, 0, width, height, "png");
	}

	public static Image getIndexPageGoButtonDisabled(int width, int height) {
		String url = PathDefine.RES_PATH + "index/web/web_next.png";
		return ImageTools.cut(url, 60, 0, width, height, "png");
	}

	public static Image getIndexPageCloseButton(int width, int height) {
		String url = PathDefine.RES_PATH + "index/web/web_stop.png";
		return ImageTools.cut(url, 0, 0, width, height, "png");
	}

	public static Image getIndexPageCloseButtonRollover(int width, int height) {
		String url = PathDefine.RES_PATH + "index/web/web_stop.png";
		return ImageTools.cut(url, 20, 0, width, height, "png");
	}

	public static Image getIndexPageCloseButtonPressed(int width, int height) {
		String url = PathDefine.RES_PATH + "index/web/web_stop.png";
		return ImageTools.cut(url, 40, 0, width, height, "png");
	}

	public static Image getIndexPageRefreshButton(int width, int height) {
		String url = PathDefine.RES_PATH + "index/web/web_updt.png";
		return ImageTools.cut(url, 0, 0, width, height, "png");
	}

	public static Image getIndexPageRefreshButtonRollover(int width, int height) {
		String url = PathDefine.RES_PATH + "index/web/web_updt.png";
		return ImageTools.cut(url, 20, 0, width, height, "png");
	}

	public static Image getIndexPageRefreshButtonPressed(int width, int height) {
		String url = PathDefine.RES_PATH + "index/web/web_updt.png";
		return ImageTools.cut(url, 40, 0, width, height, "png");
	}

	public static Image getIndexPageIndexButton(int width, int height) {
		String url = PathDefine.RES_PATH + "index/web/web_home.png";
		return ImageTools.cut(url, 0, 0, width, height, "png");
	}

	public static Image getIndexPageIndexButtonRollover(int width, int height) {
		String url = PathDefine.RES_PATH + "index/web/web_home.png";
		return ImageTools.cut(url, 20, 0, width, height, "png");
	}

	public static Image getIndexPageIndexButtonPressed(int width, int height) {
		String url = PathDefine.RES_PATH + "index/web/web_home.png";
		return ImageTools.cut(url, 40, 0, width, height, "png");
	}

	public static Image getIndexPageSpliterImage() {
		String url = PathDefine.RES_PATH + "index/web/web_spliter.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getRoomPageCopyButton(int width, int height) {
		String url = PathDefine.RES_PATH + "index/ToolBar/copy.png";
		return ImageTools.cut(url, 0, 0, width, height, "png");
	}

	public static Image getRoomPageCopyButtonRollover(int width, int height) {
		String url = PathDefine.RES_PATH + "index/ToolBar/copy.png";
		return ImageTools.cut(url, 16, 0, width, height, "png");
	}

	public static Image getRoomPageCopyButtonPressed(int width, int height) {
		String url = PathDefine.RES_PATH + "index/ToolBar/copy.png";
		return ImageTools.cut(url, 32, 0, width, height, "png");
	}

	public static Image getRoomPageQuickJoinButton(int width, int height) {
		String url = PathDefine.RES_PATH + "index/ToolBar/join.png";
		return ImageTools.cut(url, 0, 0, width, height, "png");
	}

	public static Image getRoomPageQuickJoinButtonRollover(int width, int height) {
		String url = PathDefine.RES_PATH + "index/ToolBar/join.png";
		return ImageTools.cut(url, 94, 0, width, height, "png");
	}

	public static Image getRoomPageQuickJoinButtonPressed(int width, int height) {
		String url = PathDefine.RES_PATH + "index/ToolBar/join.png";
		return ImageTools.cut(url, 188, 0, width, height, "png");
	}

	public static Image getRoomPageQuickJoinButtonDisabled(int width, int height) {
		String url = PathDefine.RES_PATH + "index/ToolBar/join.png";
		return ImageTools.cut(url, 282, 0, width, height, "png");
	}

	public static Image getRoomPageCloseButton(int width, int height) {
		String url = PathDefine.RES_PATH + "index/ToolBar/close.png";
		return ImageTools.cut(url, 0, 0, width, height, "png");
	}

	public static Image getRoomPageCloseButtonRollover(int width, int height) {
		String url = PathDefine.RES_PATH + "index/ToolBar/close.png";
		return ImageTools.cut(url, 16, 0, width, height, "png");
	}

	public static Image getRoomPageCloseButtonPressed(int width, int height) {
		String url = PathDefine.RES_PATH + "index/ToolBar/close.png";
		return ImageTools.cut(url, 32, 0, width, height, "png");
	}

	public static Image getRoomPageInfoIcon() {
		String url = PathDefine.RES_PATH + "index/ToolBar/tringle.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getRoomPageSpliterImage() {
		String url = PathDefine.RES_PATH + "index/ToolBar/splitter.png";
		return Toolkit.getDefaultToolkit().getImage(url);
	}

	public static Image getToolBarDownButton(int width, int height) {
		String url = PathDefine.RES_PATH + "index/ToolBar/down.png";
		return ImageTools.cut(url, 0, 0, width, height, "png");
	}

	public static Image getToolBarDownButtonRollover(int width, int height) {
		String url = PathDefine.RES_PATH + "index/ToolBar/down.png";
		return ImageTools.cut(url, 16, 0, width, height, "png");
	}

	public static Image getToolBarDownButtonPressed(int width, int height) {
		String url = PathDefine.RES_PATH + "index/ToolBar/down.png";
		return ImageTools.cut(url, 32, 0, width, height, "png");
	}

	public static Image getToolBarDownButtonDisabled(int width, int height) {
		String url = PathDefine.RES_PATH + "index/ToolBar/down.png";
		return ImageTools.cut(url, 48, 0, width, height, "png");
	}

}