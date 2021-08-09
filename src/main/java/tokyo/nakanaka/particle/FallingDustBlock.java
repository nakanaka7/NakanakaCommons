package tokyo.nakanaka.particle;

import tokyo.nakanaka.NamespacedID;
import tokyo.nakanaka.block.Block;

/**
 * Represents a particle which id is "minecraft:falling_dust"
 */
public class FallingDustBlock extends Particle {
	private Block block;
	/**
	 * Construct a particle 
	 * @param block a block which is used by the particle
	 */
	public FallingDustBlock(Block block) {
		super(NamespacedID.valueOf("minecraft:block"));
		this.block = block;
	}
	/**
	 * Get a block for the particle
	 * @return a block for the particle 
	 */
	public Block getBlock() {
		return block;
	}
	
}
