package tokyo.nakanaka.world;

import tokyo.nakanaka.block.Block;
import tokyo.nakanaka.particle.Particle;

public interface World {
	
	Block getBlock(int x, int y, int z);
	/**
	 * @param x
	 * @param y
	 * @param z
	 * @param block
	 * @param physics
	 * @throws IllegalArgumentException
	 */
	void setBlock(int x, int y, int z, Block block, boolean physics);
	
	/**
	 * @param x
	 * @param y
	 * @param z
	 * @param particle
	 * @throws IllegalArgumentException if this world can not spawn the particle
	 */
	void spawnParticle(double x, double y, double z, Particle particle, int count);
	
}
