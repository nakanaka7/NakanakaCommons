package tokyo.nakanaka;

import java.util.UUID;

import tokyo.nakanaka.commandSender.BlockPositionalCommandSender;
/**
 * Represents a player
 */
public interface Player extends BlockPositionalCommandSender {
	/**
	 * Return the unique ID of the player 
	 * @return the unique ID of the player
	 */
	UUID getUniqueID();
	/**
	 * Return the position of the player
 	 * @return the position of the player
	 */
	EntityPosition getEntityPosition();
	/**
	 * Give the player item(s)
	 * @param item item to give
	 * @param count item number(s)
	 * @throws IllegalArgumentException if the item cannot be given to the player
	 */
	void giveItem(Item item, int count);
}
