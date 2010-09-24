package platform.task;

public class TaskThread implements Runnable {
	private static Thread mainThread;
	private static TaskThread taskThread = new TaskThread();

	private TaskPool pool = new TaskPool();

	@Override
	public void run() {
		try {
			while (true) {
				Task task = pool.getTask();

				new Thread(task).start();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public TaskPool getPool() {
		return pool;
	}

	public static void startMainThread() {
		if (mainThread == null) {
			mainThread = new Thread(taskThread);
			mainThread.start();
		}
	}

	public static TaskThread getTaskThread() {
		return taskThread;
	}
}
