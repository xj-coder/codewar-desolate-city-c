package c.city.desolate.client.xml.bean;

public class IdeXML {
	private String language;
	private String classPath;
	private String showName;

	public IdeXML() {
	}

	public IdeXML(String language, String classPath, String showName) {
		super();
		this.language = language;
		this.classPath = classPath;
		this.showName = showName;
	}

	public String getLanguage() {
		return language;
	}

	public String getClassPath() {
		return classPath;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setClassPath(String classPath) {
		this.classPath = classPath;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

}
