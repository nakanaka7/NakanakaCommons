package tokyo.nakanaka;

import java.util.UUID;

import tokyo.nakanaka.block.Block;
import tokyo.nakanaka.particle.Particle;
/**
 * Represents a minecraft world
 */
public interface World {
	/**
	 * Return the name of the world
	 * @return the name of the world
	 */
	String getName();
	/**
	 * Get the unique ID of the world 
	 * @return the unique ID of the world
	 */
	UUID getUniqueID();
	/**
	 * Get a block at the specified position
	 * @param x the x coordinate of the block
	 * @param y the y coordinate of the block
	 * @param z the z coordinate of the block
	 * @return block at the specified position
	 */
	Block getBlock(int x, int y, int z);
	/**
	 * Set a block at the specified position
	 * @param x the x coordinate of the block
	 * @param y the y coordinate of the block
	 * @param z the z coordinate of the block
	 * @param block to place
	 * @param physics whether apply physics when setting a block
	 * @throws IllegalArgumentException if the world cannot set the block
	 */
	void setBlock(int x, int y, int z, Block block, boolean physics);
	/**
	 * Spawn particle(s) at the specified position
	 * @param x the x coordinate of the block
	 * @param y the y coordinate of the block
	 * @param z the z coordinate of the block
	 * @param particle to spawn
	 * @throws IllegalArgumentException if this world can not spawn the particle
	 */
	void spawnParticle(double x, double y, double z, Particle particle, int count);
}
