package tokyo.nakanaka.particle;

import tokyo.nakanaka.NamespacedID;
import tokyo.nakanaka.block.Block;

/**
 * Represents a particle which id is "minecraft:block"
 */
public class BlockParticle extends Particle {
	private Block block;
	private Type type;
	/**
	 * Construct a particle 
	 * @param block a block which is used by the particle
	 */
	public BlockParticle(Block block, Type type) {
		super(NamespacedID.valueOf("minecraft:block"));
		this.block = block;
		this.type = type;
	}
	/**
	 * Type of the block particle
	 */
	public static enum Type {
		CRACK,
		DUST;
	}
	/**
	 * Get a block for the particle
	 * @return a block for the particle 
	 */
	public Block getBlock() {
		return block;
	}
	/**
	 * Returns a type of the block particle
	 * @return a type of the block particle
	 */
	public Type getType() {
		return type;
	}
	
}
