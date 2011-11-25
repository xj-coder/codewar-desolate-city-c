package test;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TestEffect {
	static String path = "";

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());

		JPanel effectPanel = new JPanel() {
			@Override
			public void paint(Graphics g) {
				super.paint(g);
				final Graphics2D g2 = (Graphics2D) g;
				if (!path.equals("")) {
					File dir = new File(path);
					if (dir.isDirectory()) {
						final File[] files = dir.listFiles();

						new Thread(new Runnable() {
							@Override
							public void run() {
								// for (int i = 0; i < args.length; i++) {
								//									
								// }
								// Toolkit.getDefaultToolkit().getImage(files);
							}
						}).start();
					}
				}
			}
		};
		JPanel buttonPanel = new JPanel();

		frame.add(effectPanel, BorderLayout.CENTER);
		frame.add(buttonPanel, BorderLayout.SOUTH);

		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		frame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("click1");
				e.consume();
				System.out.println("click111");
			}
		});
		frame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("click2");
			}
		});
	}
}
