package c.city.desolate.client.xml.bean;

public class GameXML {
	private Integer no;
	private String classPath;

	public GameXML() {
	}

	public GameXML(Integer no, String classPath) {
		super();
		this.no = no;
		this.classPath = classPath;
	}

	public Integer getNo() {
		return no;
	}

	public String getClassPath() {
		return classPath;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public void setClassPath(String classPath) {
		this.classPath = classPath;
	}

}
