package platform.ui.widget;

import javax.swing.Icon;
import javax.swing.JLabel;

public class ImageLabel extends JLabel {

	private static final long serialVersionUID = 2477820014264329382L;

	public ImageLabel() {
		super();
		setFocusable(true);
	}

	public ImageLabel(Icon icon) {
		super(icon);
		setFocusable(true);
	}

	public ImageLabel(String text) {
		super(text);
		setFocusable(true);
	}

	public ImageLabel(String text, Icon icon, int horizontalAlignment) {
		super(text, icon, horizontalAlignment);
		setFocusable(true);
	}

	public ImageLabel(Icon icon, int horizontalAlignment) {
		super(icon, horizontalAlignment);
		setFocusable(true);
	}

	public ImageLabel(String text, int horizontalAlignment) {
		super(text, horizontalAlignment);
		setFocusable(true);
	}

}
