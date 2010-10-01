package platform.test;

import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test1 {
	public static void main(String[] args) {
		JFrame jf = new JFrame();

		jf.setSize(500, 500);
		jf.setVisible(true);

		JButton jb = new JButton() {
			@Override
			public void paint(Graphics g) {
				System.out.println("paint");
				super.paint(g);
			}
		};
		jf.add(jb);
	}
}
