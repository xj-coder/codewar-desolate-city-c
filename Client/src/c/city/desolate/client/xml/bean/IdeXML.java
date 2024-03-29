package c.city.desolate.client.xml.bean;

public class IdeXML {
	private String language;
	private String ideClass;
	private String showName;

	public IdeXML() {
	}

	public IdeXML(String language, String ideClass,
			String showName){
		super();
		this.language = language;
		this.ideClass = ideClass;
		this.showName = showName;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getIdeClass() {
		return ideClass;
	}

	public void setIdeClass(String ideClass) {
		this.ideClass = ideClass;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

}
