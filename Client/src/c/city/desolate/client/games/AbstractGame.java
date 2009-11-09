package c.city.desolate.client.games;

import java.util.HashMap;

import org.jdesktop.swingx.JXPanel;

public abstract class AbstractGame extends JXPanel {
	public abstract void initialization();

	public abstract void start();

	public abstract void play(HashMap<Object, Object> param);

	public abstract void stop();
}
