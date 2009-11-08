package c.city.desolate.client.ides.def;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JTextArea;

import org.jdesktop.swingx.JXButton;
import org.jdesktop.swingx.JXPanel;

import c.city.desolate.client.view.Code;

@SuppressWarnings("serial")
public abstract class Default extends Code {

	public Default() {
		super();
		showMe();
	}

	@Override
	protected JTextArea getEditorBox() {
		if (null == editorBox) {
			editorBox = new JTextArea();
			editorBox.setSize(Integer.parseInt(Tools
					.getProperties("editorBox.width")), Integer.parseInt(Tools
					.getProperties("editorBox.height")));
		}
		return editorBox;
	}

	@Override
	protected JXButton getReadyBtn() {
		if (null == readyBtn) {
			readyBtn = new JXButton("准备");
		}
		return readyBtn;
	}

	@Override
	protected void showMe() {
		editorBox = getEditorBox();
		readyBtn = getReadyBtn();

		// 工具栏
		toolBarPanel = new JXPanel(new FlowLayout(FlowLayout.LEFT));
		toolBarPanel.add(readyBtn);
		// 编辑面板
		editorPanel = new JXPanel(new BorderLayout());
		editorPanel.add(editorBox, BorderLayout.CENTER);
		// 左边
		leftPanel = new JXPanel(new BorderLayout());
		// 右边
		rightPanel = new JXPanel(new BorderLayout());
		// 控制台面板
		consolePanel = new JXPanel(new BorderLayout());
		consolePanel.add(console, BorderLayout.CENTER);

		setLayout(new BorderLayout());
		setSize(Integer.parseInt(Tools.getProperties("codeView.width")),
				Integer.parseInt(Tools.getProperties("codeView.height")));
		add(toolBarPanel, BorderLayout.NORTH);
		add(editorPanel, BorderLayout.CENTER);
		add(consolePanel, BorderLayout.SOUTH);
	}
}
