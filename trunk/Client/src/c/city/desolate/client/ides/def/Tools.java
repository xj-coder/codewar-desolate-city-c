package c.city.desolate.client.ides.def;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Tools {
	public static String getProperties(String param) {
		String result = null;
		Properties properties = new Properties();
		try {
			properties
					.load(new FileInputStream(
							new File(
									"src\\c\\city\\desolate\\client\\ides\\def\\def.properties")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		result = properties.getProperty(param);
		return result;
	}

}
