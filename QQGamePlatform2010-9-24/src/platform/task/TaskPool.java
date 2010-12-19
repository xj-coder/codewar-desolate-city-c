package platform.task;

import java.util.Vector;

public class TaskPool {
	public Vector<Task> taskPool = new Vector<Task>();

	public synchronized void addTask(Task task) {
		taskPool.add(task);
		notify();
	}

	public synchronized boolean removeTask(Task task) {
		if (task != null) {
			task.setEffective(false);
		}
		return false;
	}

	public synchronized boolean removeTask(int taskId) {
		Task t = taskPool.get(taskId);
		if (t != null) {
			t.setEffective(false);
			return true;
		}
		return false;
	}

	public synchronized Task getTask() throws InterruptedException {
		if (taskPool.size() == 0) {
			wait();
		}
		return taskPool.remove(0);
	}
}
