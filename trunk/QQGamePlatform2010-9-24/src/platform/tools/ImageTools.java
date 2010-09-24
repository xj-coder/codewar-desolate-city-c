package platform.tools;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class ImageTools {
	public static Image cut(URL url, int x, int y, int width, int height, String format) {
		Image result = null;

		ImageInputStream iis = null;

		try {

			Iterator<ImageReader> it = ImageIO.getImageReadersByFormatName(format);
			ImageReader reader = it.next();

			iis = ImageIO.createImageInputStream(new File(url.getPath()));

			reader.setInput(iis, true);

			ImageReadParam param = reader.getDefaultReadParam();

			Rectangle rect = new Rectangle(x, y, width, height);

			param.setSourceRegion(rect);

			BufferedImage bi = reader.read(0, param);

			result = Toolkit.getDefaultToolkit().createImage(bi.getSource());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (iis != null)
				try {
					iis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return result;
	}

	public static BufferedImage createImage(int width, int height, boolean flag) {
		if (flag) {
			return new BufferedImage(width, height, 2);
		} else {
			return new BufferedImage(width, height, 1);
		}
	}
}
