package platform.test;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.Document;

public class TestField {
	public static void main(String[] args) {
		JFrame jf = new JFrame();
		jf.setSize(500, 500);

		JPanel panel = new JPanel();
		panel.setLayout(null);

		final JTextField field = new JTextField();
		field.setBounds(10, 10, 300, 50);

		field.addKeyListener(new KeyListener() {
			String old;

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if ((e.getKeyChar() + "").trim().equals("")) {
					field.setText(field.getText().replaceAll(" ", ""));
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if ((e.getKeyChar() + "").trim().equals("")) {
					field.setText(field.getText().replaceAll(" ", ""));
				}
			}
		});

		Document doc = field.getDocument();

		// doc.addDocumentListener(new DocumentListener() {
		//
		// @Override
		// public void removeUpdate(DocumentEvent e) {
		// System.out.println("removeUpdate");
		// }
		//
		// @Override
		// public void insertUpdate(DocumentEvent e) {
		// System.out.println("insertUpdate");
		// try {
		// System.out.println(e.getOffset() + "--" + e.getLength());
		// System.out.println(e.getDocument().getText(e.getOffset(),
		// e.getLength()));
		// if (e.getDocument().getText(e.getOffset(),
		// e.getLength()).trim().equals("")) {
		// String tr1 = field.getText().substring(0, e.getOffset());
		//
		// String tr2 = "";
		// if (field.getText().length() > e.getOffset() + e.getLength()) {
		// field.getText().substring(e.getOffset() + e.getLength(),
		// field.getText().length());
		// }
		//
		// field.setText(tr1 + tr2);
		// }
		// } catch (BadLocationException e1) {
		// e1.printStackTrace();
		// }
		// }
		//
		// @Override
		// public void changedUpdate(DocumentEvent e) {
		// System.out.println("changedUpdate");
		// }
		// });

		panel.add(field);
		jf.setContentPane(panel);

		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);

	}
}
