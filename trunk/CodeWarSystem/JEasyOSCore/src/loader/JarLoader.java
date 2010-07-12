package loader;

import java.net.URL;
import java.net.URLClassLoader;

public class JarLoader extends URLClassLoader {

	public JarLoader(URL url) {
		super(new URL[] { url });
	}

	@Override
	public Class<?> findClass(String name) throws ClassNotFoundException {
		return super.findClass(name);
	}
}
