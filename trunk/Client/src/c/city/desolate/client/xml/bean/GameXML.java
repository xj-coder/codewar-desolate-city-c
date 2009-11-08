package c.city.desolate.client.xml.bean;

public class GameXML {
	private String no;
	private String showName;
	private String classPath;

	public GameXML() {
	}

	public GameXML(String no, String showName, String classPath) {
		super();
		this.no = no;
		this.showName = showName;
		this.classPath = classPath;
	}

	public String getNo() {
		return no;
	}

	public String getClassPath() {
		return classPath;
	}

	public void setNo(String no) {
		this.no = no;
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