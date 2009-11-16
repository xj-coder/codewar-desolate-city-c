package c.city.desolate.client.actiom;

import static c.city.desolate.client.main.Config.SEPARATOR;
import static c.city.desolate.client.main.Config.USER_SRC_PATH;
import static c.city.desolate.client.properties.ClientProperties.UDER_CODE_MAIN_CLASS_NAME;
import static c.city.desolate.client.view.Code.IDE;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import c.city.desolate.client.compilate.AbstractCompilate;
import c.city.desolate.client.view.Code;

public class CodeAction {

	public static ActionListener ready() {

		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String code = IDE.getEditorBox().getText();
				String codePath = USER_SRC_PATH;
				String codeDPath = codePath + SEPARATOR + "src";
				String codeFPath = UDER_CODE_MAIN_CLASS_NAME;
				mkdir(codeDPath, codeFPath);
				File file = new File(codeDPath + SEPARATOR + codeFPath);
				FileOutputStream fos = null;
				try {
					fos = new FileOutputStream(file);
					fos.write(code.getBytes());
					fos.flush();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} finally {
					try {
						fos.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				AbstractCompilate compilate = Code.COMPILATE;
				compilate.compilate(codePath);
			}
		};
	}

	private static void mkdir(String codeDPath, String codeFPath) {
		// TODO [JHs][添加功能][验证地址,不存在则新建]
		File directory = new File(codeDPath);
		if (!directory.exists()) {
			directory.mkdirs();
		}
		File file = new File(codeFPath);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
