package test;

import java.net.MalformedURLException;
import java.net.URL;

import loader.JarLoader;
import process.face.ProcessManager;
import program.base.Program;

public class Test1 {
	@SuppressWarnings("all")
	public static void main(String[] args) {
		try {
			Program program = null;
			JarLoader loader = new JarLoader(new URL("file:C:/Documents and Settings/Bihe/workspace/JEasyOSCore/program/JEasyOSCoreTestProgram1.jar"));
			Class c = loader.findClass("p1.Program1");
			if (c != null) {
				program = (Program) c.newInstance();
			}
			if (program != null) {
				ProcessManager.starProcess(program);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
}
