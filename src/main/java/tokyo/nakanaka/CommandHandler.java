package tokyo.nakanaka;

public interface CommandHandler {
	
	void onCommand(CommandHandler cmdHandler, String[] args);
	
	void onTabComplete(CommandHandler cmdHandler, String[] args);

}
