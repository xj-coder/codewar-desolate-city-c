package platform.bean;

public class CategoryBean {
	private String cid;
	private String show_name;
	private String parent;
	private String order;

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getShow_name() {
		return show_name;
	}

	public void setShow_name(String showName) {
		show_name = showName;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return show_name;
	}
}
