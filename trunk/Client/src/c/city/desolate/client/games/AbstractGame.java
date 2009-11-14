package c.city.desolate.client.games;

import java.util.Map;

import org.jdesktop.swingx.JXPanel;

@SuppressWarnings("serial")
public abstract class AbstractGame extends JXPanel {

	public abstract void initialization();

	public abstract void start();

	public abstract void play(Map<Object, Object> param);

	public abstract void stop();
}
