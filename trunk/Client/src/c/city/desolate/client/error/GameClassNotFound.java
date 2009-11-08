package c.city.desolate.client.error;

@SuppressWarnings("serial")
public class GameClassNotFound extends GameException {

	public GameClassNotFound(Exception e) {
		super.message = e.getMessage();
	}

	public GameClassNotFound(String message) {
		super.message = message;
	}

}
