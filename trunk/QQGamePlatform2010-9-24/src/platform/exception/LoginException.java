package platform.exception;

public class LoginException extends Exception {
	private static final long serialVersionUID = -3681532912972729335L;

	public final static int ID_USERNAME_IS_NULL = 0x0;
	public final static int ID_USERNAME_IS_ERROR = 0x1;
	public final static int ID_PASSWORD_IS_NULL = 0x2;
	public final static int ID_PASSWORD_IS_ERROR = 0x3;
	public final static int ID_CAPTCHA_IS_NULL = 0x4;
	public final static int ID_CAPTCHA_IS_ERROR = 0x5;

	private static String MESSAGE_USERNAME_IS_NULL = "用户名不能为空";
	private static String MESSAGE_USERNAME_IS_ERROR = "用户名错误";
	private static String MESSAGE_PASSWORD_IS_NULL = "密码不能为空";
	private static String MESSAGE_PASSWORD_IS_ERROR = "密码错误";
	private static String MESSAGE_CAPTCHA_IS_NULL = "验证码不能为空";
	private static String MESSAGE_CAPTCHA_IS_ERROR = "验证码错误";

	private final int id;

	public LoginException(int id) {
		this.id = id;
	}

	@Override
	public String getMessage() {
		switch (id) {
		case ID_USERNAME_IS_ERROR:
			return MESSAGE_USERNAME_IS_ERROR;
		case ID_USERNAME_IS_NULL:
			return MESSAGE_USERNAME_IS_NULL;
		case ID_PASSWORD_IS_NULL:
			return MESSAGE_PASSWORD_IS_NULL;
		case ID_PASSWORD_IS_ERROR:
			return MESSAGE_PASSWORD_IS_ERROR;
		case ID_CAPTCHA_IS_NULL:
			return MESSAGE_CAPTCHA_IS_NULL;
		case ID_CAPTCHA_IS_ERROR:
			return MESSAGE_CAPTCHA_IS_ERROR;
		}
		return null;
	}
}
