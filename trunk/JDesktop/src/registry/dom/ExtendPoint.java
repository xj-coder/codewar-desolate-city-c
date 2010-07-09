package registry.dom;

public class ExtendPoint {
	private String name;
	private String className;

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

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ExtendPoint) {
			if (((ExtendPoint) obj).getName().equals(name) && ((ExtendPoint) obj).getClassName().equals(className)) {
				return true;
			}
		}
		return false;
	}
}
