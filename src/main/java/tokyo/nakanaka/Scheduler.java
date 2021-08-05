package tokyo.nakanaka;
/**
 * A interface which schedule a task in the game
 */
public interface Scheduler {
	/**
	 * Schedule a task
	 * @param ticks ticks to wait starting the task
	 * @param runnable a task to run later
	 */
	void scheduleLater(int ticks, Runnable runnable);
}
