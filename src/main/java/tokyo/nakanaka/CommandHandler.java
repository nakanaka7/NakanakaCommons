package tokyo.nakanaka;

import tokyo.nakanaka.commandSender.CommandSender;

public interface CommandHandler {
	
	void onCommand(CommandSender cmdSender, String[] args);
	
	void onTabComplete(CommandSender cmdSender, String[] args);

}
