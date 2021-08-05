package tokyo.nakanaka.bukkit.commandSender;

import tokyo.nakanaka.commandSender.ConsoleCommandSender;
/**
 * Represents a console command sender for bukkit
 */
public class BukkitConsoleCommandSender extends BukkitCommandSender implements ConsoleCommandSender {	
	/**
	 * Construct a console command sender for bukkit
	 * @param consoleCmdSender an original console command sender
	 */
	public BukkitConsoleCommandSender(org.bukkit.command.ConsoleCommandSender consoleCmdSender) {
		super(consoleCmdSender);
	}

}
