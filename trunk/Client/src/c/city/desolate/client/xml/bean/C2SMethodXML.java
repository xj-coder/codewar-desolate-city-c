package c.city.desolate.client.xml.bean;

import java.util.Map;

public class C2SMethodXML {
	private String no;
	private Map<String, C2SParamXML> paramXMLs;

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public Map<String, C2SParamXML> getParamXMLs() {
		return paramXMLs;
	}

	public void setParamXMLs(Map<String, C2SParamXML> paramXMLs) {
		this.paramXMLs = paramXMLs;
	}

}
