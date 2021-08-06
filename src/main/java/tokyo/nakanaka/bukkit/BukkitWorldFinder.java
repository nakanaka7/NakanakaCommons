package tokyo.nakanaka.bukkit;

import java.util.UUID;

import org.bukkit.Server;

import tokyo.nakanaka.World;
import tokyo.nakanaka.WorldFinder;

/**
 * A world finder for bukkit 
 */
public class BukkitWorldFinder implements WorldFinder{
	private Server server;
	
	public BukkitWorldFinder(Server server) {
		this.server = server;
	}

	@Override
	public World findBy(String name) {
		org.bukkit.World world0 = this.server.getWorld(name);
		if(world0 == null) {
			return null;
		}
		return new BukkitWorld(this.server, world0);
	}

	@Override
	public World findBy(UUID uid) {
		org.bukkit.World world0 = this.server.getWorld(uid);
		if(world0 == null) {
			return null;
		}
		return new BukkitWorld(this.server, world0);
	}

}
