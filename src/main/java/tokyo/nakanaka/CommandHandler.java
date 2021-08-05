package tokyo.nakanaka;

import java.util.List;

import tokyo.nakanaka.commandSender.CommandSender;
/**
 * Handles a command running and auto tab complete.
 */
public interface CommandHandler {
	/**
	 * Invoked when the command is run
	 * @param cmdSender a command sender who run the command
	 * @param args arguments of the command
	 */
	void onCommand(CommandSender cmdSender, String[] args);
	/**
	 * Returns a String list which will be used on auto tab complete for the command
	 * @param cmdSender a command sender who run the command
	 * @param args arguments of the command
	 * @return a String list for the command
	 */
	List<String> onTabComplete(CommandSender cmdSender, String[] args);

}
