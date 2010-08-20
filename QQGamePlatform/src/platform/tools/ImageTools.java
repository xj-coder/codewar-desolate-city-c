package platform.tools;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class ImageTools {
	public static Image cut(String imagePath, int x, int y, int width, int height, String format) {
		Image result = null;

		ImageInputStream iis = null;

		try {

			/*
			 * ���ذ������е�ǰ��ע�� ImageReader �� Iterator����Щ ImageReader �����ܹ�����ָ����ʽ��
			 * ������formatName - ��������ʽ��ʽ���� .������ "jpeg" �� "tiff"���� ��
			 */
			Iterator<ImageReader> it = ImageIO.getImageReadersByFormatName(format);
			ImageReader reader = it.next();

			// ��ȡͼƬ��
			iis = ImageIO.createImageInputStream(new File(imagePath));

			/*
			 * <p>iis:��ȡԴ.true:ֻ��ǰ���� </p>.�������Ϊ ��ֻ��ǰ��������
			 * ��������ζ�Ű���������Դ�е�ͼ��ֻ��˳���ȡ���������� reader ���⻺���������ǰ�Ѿ���ȡ��ͼ����������ݵ���Щ���벿�֡�
			 */
			reader.setInput(iis, true);

			/*
			 * <p>������ζ������н������<p>.����ָ�����������ʱ�� Java Image I/O
			 * ��ܵ��������е���ת��һ��ͼ���һ��ͼ�������ض�ͼ���ʽ�Ĳ�� ������ ImageReader ʵ�ֵ�
			 * getDefaultReadParam �����з��� ImageReadParam ��ʵ����
			 */
			ImageReadParam param = reader.getDefaultReadParam();

			/*
			 * ͼƬ�ü�����Rectangle ָ��������ռ��е�һ������ͨ�� Rectangle ����
			 * �����϶�������꣨x��y������Ⱥ͸߶ȿ��Զ����������
			 */
			Rectangle rect = new Rectangle(x, y, width, height);

			// �ṩһ�� BufferedImage���������������������ݵ�Ŀ�ꡣ
			param.setSourceRegion(rect);

			/*
			 * ʹ�����ṩ�� ImageReadParam ��ȡͨ������ imageIndex ָ���Ķ��󣬲��� ����Ϊһ��������
			 * BufferedImage ���ء�
			 */
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
}
