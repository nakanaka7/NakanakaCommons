package tokyo.nakanaka.particle;

import tokyo.nakanaka.NamespacedID;
/**
 * Utility class for Particle
 */
public class ParticleUtils {
	/**
	 * Return particle from the input
	 * @param input String sequence to specify the particle
	 * @return particle from the input
	 */
	public Particle parse(String... input) {
		String input0 = input[0];
		if(!input0.contains(":")) {
			input0 = "minecraft:" + input0;
		}
		NamespacedID id = NamespacedID.valueOf(input0);
		return new Particle(id);
	}
	
}
