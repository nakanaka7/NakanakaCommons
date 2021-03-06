package tokyo.nakanaka.bukkit;

import java.util.UUID;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.inventory.ItemStack;

import tokyo.nakanaka.NamespacedID;
import tokyo.nakanaka.World;
import tokyo.nakanaka.block.Block;
import tokyo.nakanaka.particle.BlockParticle;
import tokyo.nakanaka.particle.DisplayMode;
import tokyo.nakanaka.particle.DustColorTransitionParticle;
import tokyo.nakanaka.particle.DustParticle;
import tokyo.nakanaka.particle.FallingDustParticle;
import tokyo.nakanaka.particle.ItemParticle;
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
			//No use of "FALLING_WATER", "REVERSE_PORTAL", "SMALL_FLA<E",
			//"SNOW_SHOVEL", and "SUSPENDED_DEPTH"
			case "ambient_entity_effect" -> p = org.bukkit.Particle.SPELL_MOB_AMBIENT;
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
			case "bubble" -> p = org.bukkit.Particle.WATER_BUBBLE;
			case "bubble_column_up" -> p = org.bukkit.Particle.BUBBLE_COLUMN_UP;
			case "bubble_pop" -> p = org.bukkit.Particle.BUBBLE_POP;
			case "campfire_cosy_smoke" -> p = org.bukkit.Particle.CAMPFIRE_COSY_SMOKE;
			case "campfire_signal_smoke" -> p = org.bukkit.Particle.CAMPFIRE_SIGNAL_SMOKE;
			case "cloud" -> p = org.bukkit.Particle.CLOUD;
			case "composter" -> p = org.bukkit.Particle.COMPOSTER;
			case "crimson_spore" -> p = org.bukkit.Particle.CRIMSON_SPORE;
			case "crit" -> p = org.bukkit.Particle.CRIT;
			case "current_down" -> p = org.bukkit.Particle.CURRENT_DOWN;
			case "damage_indicator" -> p = org.bukkit.Particle.DAMAGE_INDICATOR;
			case "dolphin" -> p = org.bukkit.Particle.DOLPHIN;
			case "dragon_breath" -> p = org.bukkit.Particle.DRAGON_BREATH;
			case "dripping_dripstone_lava" -> p = org.bukkit.Particle.DRIPPING_DRIPSTONE_LAVA;
			case "dripping_dripstone_water" -> p = org.bukkit.Particle.DRIPPING_DRIPSTONE_WATER;
			case "dripping_honey" -> p = org.bukkit.Particle.DRIPPING_HONEY;
			case "dripping_lava" -> p = org.bukkit.Particle.DRIP_LAVA;
			case "dripping_obsidian_tear" -> p = org.bukkit.Particle.DRIPPING_OBSIDIAN_TEAR;
			case "dripping_water" -> p = org.bukkit.Particle.DRIP_WATER;
			case "dust" -> {
				if(!(particle instanceof DustParticle dp)){
					throw new IllegalArgumentException();
				}
				p = org.bukkit.Particle.REDSTONE;
				var red = (int)Math.floor(255 * dp.getRed());
				var green = (int)Math.floor(255 * dp.getGreen());
				var blue = (int)Math.floor(255 * dp.getBlue());
				data = new org.bukkit.Particle.DustOptions(Color.fromRGB(red, green, blue), dp.getSize());
			}
			case "dust_color_transition" -> {
				if(!(particle instanceof DustColorTransitionParticle dctp)){
					throw new IllegalArgumentException();
				}
				p = org.bukkit.Particle.DUST_COLOR_TRANSITION;
				var fromRed = (int)Math.floor(255 * dctp.getFromRed());
				var fromGreen = (int)Math.floor(255 * dctp.getFromGreen());
				var fromBlue = (int)Math.floor(255 * dctp.getFromBlue());
				Color fromColor = Color.fromRGB(fromRed, fromGreen, fromBlue);
				var toRed = (int)Math.floor(255 * dctp.getToRed());
				var toGreen = (int)Math.floor(255 * dctp.getToGreen());
				var toBlue = (int)Math.floor(255 * dctp.getToBlue());
				Color toColor = Color.fromRGB(toRed, toGreen, toBlue);
				data = new org.bukkit.Particle.DustTransition(fromColor, toColor, dctp.getSize());
			}
			case "effect" -> p = org.bukkit.Particle.SPELL;
			case "elder_guardian" -> p = org.bukkit.Particle.MOB_APPEARANCE;
			case "electric_spark" -> p = org.bukkit.Particle.ELECTRIC_SPARK;
			case "enchant" -> p = org.bukkit.Particle.ENCHANTMENT_TABLE;
			case "enchanted_hit" -> p = org.bukkit.Particle.CRIT_MAGIC;
			case "end_rod" -> p = org.bukkit.Particle.END_ROD;
			case "entity_effect" -> p = org.bukkit.Particle.SPELL_MOB;
			case "explosion" -> p = org.bukkit.Particle.EXPLOSION_LARGE;
			case "explosion_emitter" -> p = org.bukkit.Particle.EXPLOSION_HUGE;
			case "falling_dripstone_lava" -> p = org.bukkit.Particle.FALLING_DRIPSTONE_LAVA;
			case "falling_dripstone_water" -> p = org.bukkit.Particle.FALLING_DRIPSTONE_WATER;
			case "falling_dust" -> {
				if(!(particle instanceof FallingDustParticle fp)){
					throw new IllegalArgumentException();
				}
				p = org.bukkit.Particle.FALLING_DUST;
				data = this.server.createBlockData(fp.getBlock().getBlockStateString());
			}
			case "falling_honey" -> p = org.bukkit.Particle.FALLING_HONEY;
			case "falling_lava" -> p = org.bukkit.Particle.FALLING_LAVA;
			case "falling_nectar" -> p = org.bukkit.Particle.FALLING_NECTAR;
			case "falling_obsidian_tear" -> p = org.bukkit.Particle.FALLING_OBSIDIAN_TEAR;
			case "falling_spore_blossom" -> p = org.bukkit.Particle.FALLING_SPORE_BLOSSOM;
			case "falling_water" -> p = org.bukkit.Particle.FALLING_WATER;
			case "firework" -> p = org.bukkit.Particle.FIREWORKS_SPARK;
			case "fishing" -> p = org.bukkit.Particle.WATER_WAKE;
			case "flame" -> p = org.bukkit.Particle.FLAME;
			case "flash" -> p = org.bukkit.Particle.FLASH;
			case "glow" -> p = org.bukkit.Particle.GLOW;
			case "glow_squid_ink" -> p = org.bukkit.Particle.GLOW_SQUID_INK;
			case "happy_villager" -> p = org.bukkit.Particle.VILLAGER_HAPPY;
			case "heart" -> p = org.bukkit.Particle.HEART;
			case "instant_effect" -> p = org.bukkit.Particle.SPELL_INSTANT;
			case "item" -> {
				if(!(particle instanceof ItemParticle ip)){
					throw new IllegalArgumentException();
				}
				p = org.bukkit.Particle.ITEM_CRACK;
				NamespacedID idItem = ip.getItem().getId();
				if(!idItem.getNamespace().equals("minecraft")) {
					throw new IllegalArgumentException();
				}
				data = new ItemStack(Material.valueOf(idItem.getName().toUpperCase()));
			}
			case "item_slime" -> p = org.bukkit.Particle.SLIME;
			case "item_snowball" -> p = org.bukkit.Particle.SNOWBALL;
			case "landing_honey" -> p = org.bukkit.Particle.LANDING_HONEY;
			case "landing_lava" -> p = org.bukkit.Particle.LANDING_LAVA;
			case "landing_obsidian_tear" -> p = org.bukkit.Particle.LANDING_OBSIDIAN_TEAR;
			case "large_smoke" -> p = org.bukkit.Particle.SMOKE_LARGE;
			case "lava" -> p = org.bukkit.Particle.LAVA;
			case "light" -> p = org.bukkit.Particle.LIGHT;
			case "mycelium" -> p = org.bukkit.Particle.TOWN_AURA;
			case "nautilus" -> p = org.bukkit.Particle.NAUTILUS;
			case "note" -> p = org.bukkit.Particle.NOTE;
			case "poof" -> p = org.bukkit.Particle.EXPLOSION_NORMAL;
			case "portal" -> p = org.bukkit.Particle.PORTAL;
			case "rain" -> p = org.bukkit.Particle.WATER_DROP;
			case "scrape" -> p = org.bukkit.Particle.SCRAPE;
			case "smoke" -> p = org.bukkit.Particle.SMOKE_NORMAL;
			case "sneeze" -> p = org.bukkit.Particle.SNEEZE;
			case "snowflake" -> p = org.bukkit.Particle.SNOWFLAKE;
			case "soul" -> p = org.bukkit.Particle.SOUL;
			case "soul_fire_flame" -> p = org.bukkit.Particle.SOUL_FIRE_FLAME;
			case "spit" -> p = org.bukkit.Particle.SPIT;
			case "spore_blossom_air" -> p = org.bukkit.Particle.SPORE_BLOSSOM_AIR;
			case "splash" -> p = org.bukkit.Particle.WATER_SPLASH;
			case "squid_ink" -> p = org.bukkit.Particle.SQUID_INK;
			case "sweep_attack" -> p = org.bukkit.Particle.SWEEP_ATTACK;
			case "totem_of_undying" -> p = org.bukkit.Particle.TOTEM;
			case "underwater" -> p = org.bukkit.Particle.SUSPENDED;
			//SUSPENDED_DEPTH
			case "vibration" -> p = org.bukkit.Particle.VIBRATION;
			case "warped_spore" -> p = org.bukkit.Particle.WARPED_SPORE;
			case "wax_off" -> p = org.bukkit.Particle.WAX_OFF;
			case "wax_on" -> p = org.bukkit.Particle.WAX_ON;
			case "white_ash" -> p = org.bukkit.Particle.WHITE_ASH;
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
