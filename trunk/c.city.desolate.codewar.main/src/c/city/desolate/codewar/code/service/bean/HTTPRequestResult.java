package c.city.desolate.codewar.code.service.bean;
/**
 * HTTP请求结果bean
 * @author Desolate.City.C
 *
 */
public class HTTPRequestResult {
	private String encoding;//编码
	
	private String context;//结果内容

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}
	
	
}
