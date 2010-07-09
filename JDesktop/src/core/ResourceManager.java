package core;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

public class ResourceManager {

	private static Map<String, Image> IMAGE_CACHE = new HashMap<String, Image>();

	public static Image loadImage(String fileName) {

		if (!IMAGE_CACHE.containsKey(fileName)) {
			IMAGE_CACHE.put(fileName, new ImageIcon(ResourceManager.class.getResource("/images/" + fileName)).getImage());
		}
		return IMAGE_CACHE.get(fileName);

	}

}
