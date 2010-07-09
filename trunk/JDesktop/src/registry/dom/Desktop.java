package registry.dom;

import java.awt.Dimension;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

public class Desktop {
	public static final int NAME = 0;
	public static final int TIME = 1;
	public static final int SIZE = 2;
	public static final int TYPE = 3;

	private Image bgImage;
	private boolean autoSort;
	private int sortType;
	private Dimension resolution;
	private Map<String, ExtendPoint> extendPointMap = new HashMap<String, ExtendPoint>();

	public Image getBgImage() {
		return bgImage;
	}

	public void setBgImage(Image bgImage) {
		this.bgImage = bgImage;
	}

	public boolean isAutoSort() {
		return autoSort;
	}

	public void setAutoSort(boolean autoSort) {
		this.autoSort = autoSort;
	}

	public int getSortType() {
		return sortType;
	}

	public void setSortType(int sortType) {
		this.sortType = sortType;
	}

	public Dimension getResolution() {
		return resolution;
	}

	public void setResolution(Dimension resolution) {
		this.resolution = resolution;
	}

	public Map<String, ExtendPoint> getExtendPointMap() {
		return extendPointMap;
	}

	public void setExtendPointMap(Map<String, ExtendPoint> extendPointMap) {
		this.extendPointMap = extendPointMap;
	}

}
