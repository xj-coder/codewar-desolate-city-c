package platform.exception;

public class XMLException extends Exception {

	private static final long serialVersionUID = -3171049130684968234L;

	public final static int ID_KEYS_VALUES_NOT_SYMMETRY = 0x0;
	public final static int ID_XML_FILE_NOT_FIND = 0x1;

	private static String MESSAGE_KEYS_VALUES_NOT_SYMMETRY = "key和value不对称";
	private static String MESSAGE_XML_FILE_NOT_FIND = "XML文件找不到";

	private int id;
	private String message;

	public XMLException(int id) {
		this(id, null);
	}

	public XMLException(String message) {
		this(-1, message);
	}

	public XMLException(int id, String message) {
		super();
		this.id = id;
		this.message = message;
	}

	@Override
	public String getMessage() {
		if (id == -1) {
			return message;
		} else {
			switch (id) {
			case ID_KEYS_VALUES_NOT_SYMMETRY:
				return MESSAGE_KEYS_VALUES_NOT_SYMMETRY;
			case ID_XML_FILE_NOT_FIND:
				return MESSAGE_XML_FILE_NOT_FIND;
			}
		}
		return null;
	}
}
