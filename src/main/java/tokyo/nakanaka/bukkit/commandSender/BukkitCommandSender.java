package tokyo.nakanaka.bukkit.commandSender;

import tokyo.nakanaka.commandSender.CommandSender;
/**
 * Represents a command sender for bukkit
 */
public class BukkitCommandSender implements CommandSender{
	protected org.bukkit.command.CommandSender sender;
	
	/**
	 * Construct a command sender
	 * @param sender an original command sender for bukkit
	 */
	public BukkitCommandSender(org.bukkit.command.CommandSender sender) {
		this.sender = sender;
	}

	@Override
	public void print(String msg) {
		this.sender.sendMessage(msg);
	}

}


