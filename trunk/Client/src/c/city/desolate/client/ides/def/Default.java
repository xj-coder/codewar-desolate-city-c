package c.city.desolate.client.ides.def;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.jdesktop.swingx.JXButton;
import org.jdesktop.swingx.JXPanel;

import c.city.desolate.client.ides.AbstractIDE;

@SuppressWarnings("serial")
public class Default extends AbstractIDE {

	private JScrollPane scrollPaneEditorBox;

	public Default() {
		super();
		showMe();
	}

	@Override
	public JTextArea getEditorBox() {
		if (null == editorBox) {
			scrollPaneEditorBox = new JScrollPane();
			editorBox = new JTextArea();
			editorBox.setSize(Integer.parseInt(Tools
					.getProperties("editorBox.width")), Integer.parseInt(Tools
					.getProperties("editorBox.height")));
			scrollPaneEditorBox.setViewportView(editorBox);

		}
		return editorBox;
	}

	@Override
	public JXButton getReadyBtn() {
		if (null == readyBtn) {
			readyBtn = new JXButton("准备");
			// TODO [JHS][添加功能][添加编译按钮]
		}
		return readyBtn;
	}

	@Override
	public void showMe() {
		editorBox = getEditorBox();
		readyBtn = getReadyBtn();

		// 工具栏
		toolBarPanel = new JXPanel(new FlowLayout(FlowLayout.LEFT));
		toolBarPanel.add(readyBtn);
		// 编辑面板
		editorPanel = new JXPanel(new BorderLayout());
		editorPanel.add(scrollPaneEditorBox, BorderLayout.CENTER);
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

	@Override
	public void iniEditorBox(String iniSrcPath) {
		// TODO [JHS][添加功能][初始显示游戏代码]
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(
					new File(iniSrcPath))));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String str = "";
		try {
			while ((str = br.readLine()) != null) {
				str = str.replaceAll("\t", "    ");
				editorBox.append(str + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
