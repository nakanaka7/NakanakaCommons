package tokyo.nakanaka;

import java.util.List;

import tokyo.nakanaka.commandSender.CommandSender;

public interface CommandHandler {
	
	void onCommand(CommandSender cmdSender, String[] args);
	
	List<String> onTabComplete(CommandSender cmdSender, String[] args);

}
