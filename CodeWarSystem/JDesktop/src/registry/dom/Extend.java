package registry.dom;

import java.util.HashMap;
import java.util.Map;

public class Extend {
	private ExtendPoint pointExtend;
	private String name;
	private String className;
	private String jarPath;
	private Map<String, String> paramMap = new HashMap<String, String>();

	public ExtendPoint getPointExtend() {
		return pointExtend;
	}

	public void setPointExtend(ExtendPoint pointExtend) {
		this.pointExtend = pointExtend;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getJarPath() {
		return jarPath;
	}

	public void setJarPath(String jarPath) {
		this.jarPath = jarPath;
	}

	public Map<String, String> getParamMap() {
		return paramMap;
	}

	public void setParamMap(Map<String, String> paramMap) {
		this.paramMap = paramMap;
	}

}
