package registry.dom;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class TaskBar {
	public static final int UP = 0;
	public static final int BOTTOM = 1;
	public static final int LEFT = 2;
	public static final int RIGHT = 3;

	private Color fgColor;
	private Color bgColor;
	private int location;
	private Map<String, ExtendPoint> extendPointMap = new HashMap<String, ExtendPoint>();

	public Color getFgColor() {
		return fgColor;
	}

	public void setFgColor(Color fgColor) {
		this.fgColor = fgColor;
	}

	public Color getBgColor() {
		return bgColor;
	}

	public void setBgColor(Color bgColor) {
		this.bgColor = bgColor;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public Map<String, ExtendPoint> getExtendPointMap() {
		return extendPointMap;
	}

	public void setExtendPointMap(Map<String, ExtendPoint> extendPointMap) {
		this.extendPointMap = extendPointMap;
	}

}
