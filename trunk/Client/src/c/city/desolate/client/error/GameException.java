package c.city.desolate.client.error;

@SuppressWarnings("serial")
public class GameException extends Exception {
	protected String message;

	public GameException(Exception e) {
		message = e.getMessage();
	}

	public GameException(String message) {
		super();
		this.message = message;
	}

	public GameException() {

	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
