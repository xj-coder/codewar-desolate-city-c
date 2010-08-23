package platform.task;

abstract public class Task implements Runnable {
	private boolean isEffective;

	public boolean isEffective() {
		return isEffective;
	}

	public void setEffective(boolean isEffective) {
		this.isEffective = isEffective;
	}

	abstract public void run();

}
