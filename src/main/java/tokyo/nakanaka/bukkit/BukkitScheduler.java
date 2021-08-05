package tokyo.nakanaka.bukkit;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import tokyo.nakanaka.Scheduler;
/**
 * Scheduler for Bukkit
 */
public class BukkitScheduler implements Scheduler{
	private JavaPlugin plugin;
	/**
	 * Constructs a scheduler
	 * @param plugin a plugin which is responsible for a task
	 */
	public BukkitScheduler(JavaPlugin plugin) {
		this.plugin = plugin;
	}

	@Override
	public void scheduleLater(int ticks, Runnable runnable) {
		new BukkitRunnable() {
			@Override
			public void run() {
				runnable.run();
			}
		}.runTaskLater(this.plugin, ticks);
	}
	
}
