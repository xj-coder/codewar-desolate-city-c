package c.city.desolate.client.error;

@SuppressWarnings("serial")
public class GameClassInstantiation extends GameException {

	public GameClassInstantiation(String message) {
		super.message = message;
	}

	public GameClassInstantiation(Exception e) {
		super.message = e.getMessage();
	}

}
