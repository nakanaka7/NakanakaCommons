package tokyo.nakanaka;

/**
 * Represents item stack
 */
public class ItemStack {
	private Item item;
	private int count;
	
	/**
	 * @param item item
	 * @param count item count
	 */
	public ItemStack(Item item, int count) {
		this.item = item;
		this.count = count;
	}

	/**
	 * Get item
	 * @return item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * Get item count
	 * @return item count
	 */
	public int getCount() {
		return count;
	}
	
}
