package tokyo.nakanaka.bukkit;

import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import tokyo.nakanaka.bukkit.commandSender.BukkitBlockCommandSender;
import tokyo.nakanaka.bukkit.commandSender.BukkitCommandSender;
import tokyo.nakanaka.bukkit.commandSender.BukkitConsoleCommandSender;
import tokyo.nakanaka.bukkit.commandSender.BukkitPlayer;
import tokyo.nakanaka.commandSender.CommandSender;

public class BukkitFunctions {
	public static CommandSender convertCommandSender(org.bukkit.command.CommandSender cmdSender0) {
		if(cmdSender0 instanceof Player p) {
			return new BukkitPlayer(p);
		}else if(cmdSender0 instanceof BlockCommandSender b) {
			return new BukkitBlockCommandSender(b);
		}else if(cmdSender0 instanceof ConsoleCommandSender c) {
			return new BukkitConsoleCommandSender(c);
		}else {
			return new BukkitCommandSender(cmdSender0);
		}
	}
}
