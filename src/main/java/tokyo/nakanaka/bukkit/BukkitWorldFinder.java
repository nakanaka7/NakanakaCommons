package tokyo.nakanaka.bukkit;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.bukkit.Server;

import tokyo.nakanaka.World;
import tokyo.nakanaka.WorldFinder;

/**
 * A world finder for bukkit 
 */
public class BukkitWorldFinder implements WorldFinder{
	private Server server;
	/**
	 * Construct a world finder for bukkit
	 * @param server the server of the bukkit
	 */
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

	@Override
	public List<World> getWorldList() {
		return this.server.getWorlds().stream()
			.map(s -> new BukkitWorld(this.server, s))
			.collect(Collectors.toList());
	}

}
