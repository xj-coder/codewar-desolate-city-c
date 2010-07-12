package process.base;

import java.io.InputStream;
import java.io.OutputStream;

public abstract class Process implements Runnable {
	public static int STATE_READY = 00;
	public static int STATE_STARTUP = 01;
	public static int STATE_SLEEP = 02;
	public static int STATE_WAIT = 03;
	public static int STATE_STOPDOWN = 04;

	public static int START_MODE_SINGLE = 00;
	public static int START_MODE_MULTI = 01;

	public int processId = (int) (Math.random() * Integer.MAX_VALUE);
	public int startMode = START_MODE_SINGLE;
	public int state = STATE_READY;

	protected String args[] = new String[] {};

	public abstract InputStream getInputStream();

	public abstract OutputStream getOutputStream();

	public abstract OutputStream getErrorStream();

	public abstract void main(String[] args);

	@Override
	public void run() {
		main(args);
	}

}
