package tokyo.nakanaka.bukkit;

import java.util.UUID;

import org.bukkit.Color;
import org.bukkit.Server;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;

import tokyo.nakanaka.NamespacedID;
import tokyo.nakanaka.World;
import tokyo.nakanaka.block.Block;
import tokyo.nakanaka.particle.BlockParticle;
import tokyo.nakanaka.particle.DisplayMode;
import tokyo.nakanaka.particle.DustParticle;
import tokyo.nakanaka.particle.Particle;
/**
 * A world for Bukkit
 */
public class BukkitWorld implements World{
	private Server server;
	private org.bukkit.World world;
	private UUID uid;
	
	/**
	 * Construct a world 
	 * @param server a server
	 * @param world a world of original
	 */
	public BukkitWorld(Server server, org.bukkit.World world) {
		this.server = server;
		this.world = world;
		this.uid = world.getUID();
	}
	
	@Override
	public String getName() {
		return this.world.getName();
	}
	
	@Override
	public UUID getUniqueID() {
		return this.uid;
	}
	
	@Override
	public Block getBlock(int x, int y, int z) {
		org.bukkit.block.Block bukkitBlock = world.getBlockAt(x, y, z);
		Block block = Block.valueOf(bukkitBlock.getBlockData().getAsString());
		return block;
	}
	
	@Override
	public void setBlock(int x, int y, int z, Block block, boolean physics) {
		BlockData bd = server.createBlockData(block.getBlockStateString());
		org.bukkit.block.Block bukkitBlock = world.getBlockAt(x, y, z);
		bukkitBlock.setBlockData(bd, physics);
		BlockState state = bukkitBlock.getState();
		state.update();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BukkitWorld other = (BukkitWorld) obj;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		return true;
	}

	@Override
	public void spawnParticle(double x, double y, double z, Particle particle, int count) {
		this.spawnParticle(x, y, z, particle, count, DisplayMode.NORMAL);
	}
	
	@Override
	public void spawnParticle(double x, double y, double z, Particle particle, int count, DisplayMode mode) {
		NamespacedID id = particle.getId();
		if(!id.getNamespace().equals("minecraft")) {
			throw new IllegalArgumentException();
		}
		String name = id.getName();
		org.bukkit.Particle p;
		Object data = null;
		switch(name) {
			case "ambient_entity_effect" -> throw new IllegalArgumentException();
			case "angry_villager" -> p = org.bukkit.Particle.VILLAGER_ANGRY;
			case "ash" -> p = org.bukkit.Particle.ASH;
			case "barrier" -> p = org.bukkit.Particle.BARRIER;
			case "block" -> {
				if(!(particle instanceof BlockParticle bp)) {
					throw new IllegalArgumentException();
				}
				switch(bp.getType()) {
					case CRACK -> p = org.bukkit.Particle.BLOCK_CRACK;
					case DUST -> p = org.bukkit.Particle.BLOCK_DUST;
					default -> throw new IllegalArgumentException();
				}
				data = this.server.createBlockData(bp.getBlock().getBlockStateString());
			}
			case "bubble" -> throw new IllegalArgumentException();
			case "bubble_column_up" -> throw new IllegalArgumentException();
			case "bubble_pop" -> throw new IllegalArgumentException();
			case "campfire_cosy_smoke" -> p = org.bukkit.Particle.CAMPFIRE_COSY_SMOKE;
			case "campfire_signal_smoke" -> p = org.bukkit.Particle.CAMPFIRE_SIGNAL_SMOKE;
			case "cloud" -> p = org.bukkit.Particle.CLOUD;
			case "dust" -> {
				if(!(particle instanceof DustParticle)){
					throw new IllegalArgumentException();
				}
				DustParticle dp = (DustParticle)particle;
				p = org.bukkit.Particle.REDSTONE;
				int red = (int)Math.floor(255 * dp.getRed());
				int green = (int)Math.floor(255 * dp.getGreen());
				int blue = (int)Math.floor(255 * dp.getBlue());
				data = new org.bukkit.Particle.DustOptions(Color.fromRGB(red, green, blue), dp.getSize());
			}
			case "happy_villager" -> p = org.bukkit.Particle.VILLAGER_HAPPY;
			case "wax_off" -> p = org.bukkit.Particle.WAX_OFF;
			case "wax_on" -> p = org.bukkit.Particle.WAX_ON;
			case "witch" -> p = org.bukkit.Particle.SPELL_WITCH;
			default -> p = org.bukkit.Particle.valueOf(name.toUpperCase());
		}
		boolean force = switch(mode) {
			case FORCE: yield true;
			case NORMAL: yield false;
		};
		this.world.spawnParticle(p, x, y, z, count, 0, 0, 0, 0, data, force);
	}
	
}
