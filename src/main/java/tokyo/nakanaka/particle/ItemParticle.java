package tokyo.nakanaka.particle;

import tokyo.nakanaka.Item;
import tokyo.nakanaka.NamespacedID;

/**
 * Represents "minecraft:item" particle
 */
public class ItemParticle extends Particle {
	private Item item;
	public ItemParticle(Item item) {
		super(NamespacedID.valueOf("minecraft:item"));
		this.item = item;
	}
	/**
	 * Get an item for the particle
	 * @return an item for the particle
	 */
	public Item getItem() {
		return item;
	}
	
}
