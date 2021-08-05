package tokyo.nakanaka.commandSender;

import java.util.UUID;
/**
 * Represents a player
 */
public interface Player extends BlockPositionalCommandSender {
	public UUID getUniqueID();
}
