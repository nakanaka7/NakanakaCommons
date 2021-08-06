package tokyo.nakanaka;

import java.util.UUID;

import tokyo.nakanaka.commandSender.BlockPositionalCommandSender;
/**
 * Represents a player
 */
public interface Player extends BlockPositionalCommandSender {
	UUID getUniqueID();
	
}
