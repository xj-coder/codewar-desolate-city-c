package c.city.desolate.server.xml.bean;

import java.util.Map;

public class S2CMethodXML {
	private String no;
	private Map<String, S2CParamXML> paramXMLs;

	public S2CMethodXML() {
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public Map<String, S2CParamXML> getParamXMLs() {
		return paramXMLs;
	}

	public void setParamXMLs(Map<String, S2CParamXML> paramXMLs) {
		this.paramXMLs = paramXMLs;
	}

}
