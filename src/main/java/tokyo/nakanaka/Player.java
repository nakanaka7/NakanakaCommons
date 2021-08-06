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
}
