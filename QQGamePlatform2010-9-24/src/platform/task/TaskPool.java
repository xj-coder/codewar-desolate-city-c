package platform.task;

import java.util.ArrayList;

public class TaskPool {
	public ArrayList<Task> taskPool = new ArrayList<Task>();

	public synchronized void addTask(Task task) {
		taskPool.add(task);
		// TODO 【唤醒线程到任务池中取任务】

	}

	public synchronized boolean removeTask(Task task) {
		for (Task t : taskPool) {
			if (t == task) {
				t.setEffective(false);
				return true;
			}
		}
		return false;
	}

	public synchronized Task getTask() throws InterruptedException {
		if (taskPool.size() == 0) {
			wait();
		}

		return taskPool.get(0);
	}
}
