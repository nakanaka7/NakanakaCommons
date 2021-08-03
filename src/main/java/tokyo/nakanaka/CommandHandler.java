package tokyo.nakanaka;

public interface CommandHandler {
	
	void onCommand(CommandHandler cmdHandler, String label, String[] args);
	
	void onTabComplete(CommandHandler cmdHandler, String label, String[] args);

}
