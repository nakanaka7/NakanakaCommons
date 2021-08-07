package tokyo.nakanaka.particle;

import java.util.List;

/**
 * A parser to get a particle
 */
public interface ParticleParser {
	/**
	 * Parse the input to get a particle
	 * @param input the String array for the particle
	 * @return a particle, or null if it failed to parse the input
	 */
	Particle parse(String... input);
	/**
	 * Return a String list for the tab complete
	 * @param input the String array for the particle
	 * @return a String list for the tab complete
	 */
	List<String> onTabComplete(String... input);
}
