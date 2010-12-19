package platform.task;

public class TaskThread implements Runnable {
	private static Thread mainThread;
	private static TaskThread taskThread = new TaskThread();

	private TaskPool pool = new TaskPool();

	static {
		startMainThread();
	}

	private TaskThread() {
		super();
	}

	@Override
	public void run() {
		try {
			while (true) {
				Task task = pool.getTask();

				System.out.println("get a task " + task);

				if (task.isEffective()) {
					new Thread(task).start();
				}
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
			mainThread = new Thread(getTaskThread());
			mainThread.start();
		}
	}

	public static TaskThread getTaskThread() {
		return taskThread;
	}
}
