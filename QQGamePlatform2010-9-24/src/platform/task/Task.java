package platform.task;

/**
 * 任务抽象父类<BR>
 * 新建一个任务需继承该类<BR>
 * 在canStop中实现可被中断的处理<BR>
 * 在canNotStop中实现不可被中断的处理<BR>
 * 任务执行时canStop将先被执行,之后执行canNotStop
 * 
 * @author DesolateCity
 * 
 */
abstract public class Task implements Runnable {
	private boolean isEffective = true;

	public boolean isEffective() {
		return isEffective;
	}

	public void setEffective(boolean isEffective) {
		this.isEffective = isEffective;
	}

	public final void run() {
		System.out.println("do canStop");
		canStop();

		if (isEffective()) {
			canNotStop();
			System.out.println("do canNotStop");
		}
	}

	abstract protected void canStop();

	abstract protected void canNotStop();
}
