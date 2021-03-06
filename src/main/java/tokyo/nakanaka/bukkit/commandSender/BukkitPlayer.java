package tokyo.nakanaka.bukkit.commandSender;

import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import tokyo.nakanaka.BlockPosition;
import tokyo.nakanaka.EntityPosition;
import tokyo.nakanaka.Item;
import tokyo.nakanaka.NamespacedID;
import tokyo.nakanaka.Player;
import tokyo.nakanaka.World;
import tokyo.nakanaka.bukkit.BukkitWorld;
/**
 * Represents a player for bukkit
 */
public class BukkitPlayer extends BukkitCommandSender implements Player {
	/**
	 * Construct a player for bukkit
	 * @param player0 an original player of bukkit
	 */
	public BukkitPlayer(org.bukkit.entity.Player player0) {
		super(player0);
	}

	@Override
	public BlockPosition getBlockPosition() {
		org.bukkit.entity.Player player0 = (org.bukkit.entity.Player)this.sender;
		World world = new BukkitWorld(player0.getServer(), player0.getWorld());
		int x = player0.getLocation().getBlockX();
		int y = player0.getLocation().getBlockY();
		int z = player0.getLocation().getBlockZ();
		return new BlockPosition(world, x, y, z);
	}

	@Override
	public UUID getUniqueID() {
		org.bukkit.entity.Player player0 = (org.bukkit.entity.Player)this.sender;
		return player0.getUniqueId();
	}

	@Override
	public EntityPosition getEntityPosition() {
		org.bukkit.entity.Player player0 = (org.bukkit.entity.Player)this.sender;
		World world = new BukkitWorld(player0.getServer(), player0.getWorld());
		double x = player0.getLocation().getX();
		double y = player0.getLocation().getY();
		double z = player0.getLocation().getZ();
		return new EntityPosition(world, x, y, z);
	}

	@Override
	public void giveItem(Item item, int count) {
		NamespacedID id = item.getId();
		if(!id.getNamespace().equals("minecraft")) {
			throw new IllegalArgumentException();
		}
		Material material = Material.valueOf(id.getName().toUpperCase());
		ItemStack itemStack = new ItemStack(material, count);
		org.bukkit.entity.Player player0 = (org.bukkit.entity.Player)this.sender;
		player0.getInventory().addItem(itemStack);
	}

}
