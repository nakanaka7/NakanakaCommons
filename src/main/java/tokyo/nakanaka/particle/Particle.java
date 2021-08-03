package tokyo.nakanaka.particle;

import tokyo.nakanaka.NamespacedID;

public class Particle {
	private NamespacedID id;

	public Particle(NamespacedID id) {
		this.id = id;
	}

	public NamespacedID getId() {
		return id;
	}
	
}
