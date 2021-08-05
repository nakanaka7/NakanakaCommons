package tokyo.nakanaka.commandSender;

import tokyo.nakanaka.BlockPosition;
/**
 * Represents a command sender who has block position
 */
public interface BlockPositionalCommandSender extends CommandSender {
	public BlockPosition getBlockPosition();
}
