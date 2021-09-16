package tokyo.nakanaka;

/**
 * A command object which is undoable
 */
public interface UndoableCommand {

	/**
	 * Execute this command.
	 */
	void execute();
	
	/**
	 * Undo this command.
	 */
	void undo();
	
	/**
	 * Redo this command. 
	 */
	void redo();
	
}
