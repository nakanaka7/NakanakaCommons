package tokyo.nakanaka.particle;

import tokyo.nakanaka.NamespacedID;
/**
 * Represents particle
 */
public class Particle {
	private NamespacedID id;
	/**
	 * Construct particle
	 * @param id namespacedID of the particle
	 */
	public Particle(NamespacedID id) {
		this.id = id;
	}
	/**
	 * Return the namespacedID of the particle
	 * @return the namespacedID of the particle
	 */
	public NamespacedID getId() {
		return id;
	}
	
}
