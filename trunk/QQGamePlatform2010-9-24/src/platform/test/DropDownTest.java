package platform.test;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import platform.ui.widget.BoxButton;

public class DropDownTest extends JFrame {

	final JPanel panel = new JPanel();

	final BoxButton dropdown;

	public DropDownTest() {
		super("Drop Down Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		getContentPane().setLayout(new BorderLayout());

		JToolBar bar = new JToolBar();
		bar.setLayout(new FlowLayout());

		JButton b1 = new JButton("test1");
		JButton b2 = new JButton("2");
		JButton b3 = new JButton("st3");
		JButton b4 = new JButton("est4");

		dropdown = new BoxButton(b1);
		bar.add(dropdown);

		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("b1");
			}
		});
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("b2");
			}
		});
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("b3");
			}
		});
		b4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("b4");
			}
		});

		dropdown.addItems(b2);
		dropdown.addItems(b3);
		dropdown.addItems(b4);

		getContentPane().add("North", bar);
		getContentPane().add("Center", new JLabel("Drop Down Test"));

		pack();
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new DropDownTest();
	}
}