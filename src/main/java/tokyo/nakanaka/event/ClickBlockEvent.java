package tokyo.nakanaka.event;

import tokyo.nakanaka.BlockPosition;
import tokyo.nakanaka.ItemStack;
import tokyo.nakanaka.Player;

/**
 * Represents click block event
 */
public interface ClickBlockEvent {
	
	/**
	 * Returns a player of this event
	 * @return a player of this event
	 */
	public Player getPlayer();

	/**
	 * Returns a block position of this event
	 * @return a block position of this event
	 */
	public BlockPosition getBlockPos();

	/**
	 * Returns the hand type of this event
	 * @return the hand type of this event
	 */
	public HandType getHandType();

	/**
	 * Returns the item stack that the player clicked the block by
	 * @return the item stack that the player clicked the block by
	 */
	public ItemStack getItemStack();

	/**
	 * Cancel this event
	 */
	public void cancel();
	
}
