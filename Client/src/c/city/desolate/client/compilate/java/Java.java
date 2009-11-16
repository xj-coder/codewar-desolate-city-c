package c.city.desolate.client.compilate.java;

import static c.city.desolate.client.main.Config.GAME_SRC_PATH;
import static c.city.desolate.client.main.Config.PUBLIC_SRC_PATH;
import static c.city.desolate.client.main.Config.SEPARATOR;
import static c.city.desolate.client.main.Config.USER_SRC_PATH;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import c.city.desolate.client.compilate.AbstractCompilate;
import c.city.desolate.client.view.Game;

public class Java extends AbstractCompilate {
	private String command = "";

	@Override
	public void compilate(String codePath) {
		// TODO [JHS][OK][实现Java代码编译]
		configSourceFile(codePath + SEPARATOR + ".source");
		configSystemProperties();// 配置系统环境变量

		String op0 = "javac";
		String op1 = "-classpath" + " " + codePath + SEPARATOR + ".classpath";
		String op2 = "-d" + " " + codePath + SEPARATOR + "bin";
		String op3 = "-encoding" + " " + "utf-8";
		String op4 = "-sourcepath" + " " + codePath + SEPARATOR + ".source";
		String opn = "@" + codePath + SEPARATOR + ".source";
		command = op0 + " " + op1 + " " + op2 + " " + op3 + " " + op4 + " "
				+ opn;
		System.out.println(command);
		Runtime rt = Runtime.getRuntime();
		try {
			Process process = rt.exec(command);

			process.waitFor();
			// 错误信息
			BufferedReader bre = new BufferedReader(new InputStreamReader(
					process.getErrorStream(), "GBK"));
			String context = bre.readLine();
			while (context != null) {
				Game.CONSOLE.println("[ERROR] " + context);
				context = bre.readLine();
			}

			// 输出信息
			BufferedReader bri = new BufferedReader(new InputStreamReader(
					process.getInputStream(), "GBK"));
			context = bri.readLine();
			while (context != null) {
				Game.CONSOLE.println("[MESSAGE] " + context);
				context = bri.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO [JHS][OK][实现Java程序运行]
		String codePath = USER_SRC_PATH + SEPARATOR + "bin";
		String op0 = "java ";
		String op1 = "-classpath " + codePath;
		String op2 = "Main";
		command = op0 + " " + op1 + " " + op2;
		System.out.println(command);
		Runtime rt = Runtime.getRuntime();
		try {
			Process process = rt.exec(command);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					process.getInputStream(), "GBK"));
			String context = br.readLine();
			while (context != null) {
				Game.CONSOLE.println(context);
				context = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void configSystemProperties() {
		// TODO [JHS][添加功能][设置java编译和运行需要的环境变量,需要考虑不同的系统]

	}

	private void configSourceFile(String sourceConfigPath) {
		// TODO[JHS][添加功能][设置java代码文件列表]
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(new File(sourceConfigPath))));
			String str = sourceConfigPath.replace(".source", "src" + SEPARATOR);
			File file = new File(str);
			String ss[] = file.list();
			if (ss != null)
				for (String s : ss) {
					if (!s.endsWith(".java"))
						continue;
					bw.append(str + s + "\n");
				}
			str = PUBLIC_SRC_PATH + SEPARATOR;
			file = new File(str);
			ss = file.list();
			if (ss != null)
				for (String s : ss) {
					if (!s.endsWith(".java"))
						continue;
					bw.append(str + s + "\n");
				}
			str = GAME_SRC_PATH + SEPARATOR;
			file = new File(str);
			ss = file.list();
			if (ss != null)
				for (String s : ss) {
					if (!s.endsWith(".java"))
						continue;
					bw.append(str + s + "\n");
				}
			bw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
