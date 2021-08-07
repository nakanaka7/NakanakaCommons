package tokyo.nakanaka;

import java.util.List;
import java.util.UUID;
/**
 * An interface which has methods to find a world
 */
public interface WorldFinder {
	/**
	 * Find a world by the name
	 * @param name the name of the world
	 * @return a world which name equals to the given name, or null
	 * if it can not find the world
	 */
	World findBy(String name);
	/**
	 * Find a world by the unique id 
	 * @param uid the unique id of the world
	 * @return a world which unique id equals to the given id, or null
	 * if it can not find the world
	 */
	World findBy(UUID uid);
	/**
	 * Return a list of the worlds
	 * @return a list of the worlds
	 */
	List<World> getWorldList();
}
