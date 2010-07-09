package gui;

import gui.ui.DesktopPanel;
import gui.ui.TaskBar;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DesktopFrame extends JPanel {

	private static final long serialVersionUID = 4910130207447912306L;

	private JFrame frame;
	private TaskBar taskBar;
	private DesktopPanel desktopPanel;

	public DesktopFrame(JFrame frame) {
		this.frame = frame;
		setLayout(new BorderLayout());
		frame.getContentPane().add(this);
		setSize(frame.getWidth(), frame.getHeight());

		taskBar = new TaskBar();
		desktopPanel = new DesktopPanel();

		add(taskBar, BorderLayout.NORTH);
		add(desktopPanel, BorderLayout.CENTER);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	@Override
	public void paint(Graphics g) {
		taskBar.setSize(getWidth(), 25);
		super.paint(g);

	}

	// getter and setter
	public TaskBar getTaskBar() {
		return taskBar;
	}

	public DesktopPanel getDesktopPanel() {
		return desktopPanel;
	}

}
