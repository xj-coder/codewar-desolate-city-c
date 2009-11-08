package c.city.desolate.client.xml.bean;

public class CompilateXML {
	private String language;
	private String compilateClass;
	private String showName;

	public CompilateXML() {
	}

	public CompilateXML(String language, String compilateClass,
			String showName) {
		super();
		this.language = language;
		this.compilateClass = compilateClass;
		this.showName = showName;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCompilateClass() {
		return compilateClass;
	}

	public void setCompilateClass(String compilateClass) {
		this.compilateClass = compilateClass;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

}
