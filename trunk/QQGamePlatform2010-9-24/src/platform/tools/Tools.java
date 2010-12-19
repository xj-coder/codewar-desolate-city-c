package platform.tools;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Tools {
	public static Dimension getScreenSize() {
		return Toolkit.getDefaultToolkit().getScreenSize();
	}

	public static void moveToScreenCenter(Component comp) {

	}

	public static void moveToScreenCenter(Component sourceComp, Component targetComp) {

	}

	public static void mapToBean(Map<String, String> map, Object bean) {
		Set<String> keySet = map.keySet();
		Iterator<String> it = keySet.iterator();
		while (it.hasNext()) {
			String key = it.next();
			String value = map.get(key);

			key = key.substring(0, 1).toUpperCase() + key.substring(1, key.length());

			try {
				Method method = bean.getClass().getMethod("set" + key, String.class);
				method.invoke(bean, value);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
