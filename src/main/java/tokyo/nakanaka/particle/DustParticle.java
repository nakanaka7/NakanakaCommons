package tokyo.nakanaka.particle;

import tokyo.nakanaka.NamespacedID;
/**
 * Represents a particle "minecraft:dust"
 */
public class DustParticle extends Particle {
	private float red;
	private float green;
	private float blue;
	private float size;
	/**
	 * Construct a particle from the given parameters
	 * @param red the red component of the color
	 * @param green the green component of the color
	 * @param blue the blue component of the color
	 * @param size the particle size
	 */
	public DustParticle(float red, float green, float blue, float size) {
		super(NamespacedID.valueOf("minecraft:dust"));
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.size = size;
	}
	/**
	 * Get a color channel parameter of red 
	 * @return a color channel parameter of red 
	 */
	public float getRed() {
		return red;
	}
	/**
	 * Get a color channel parameter of green 
	 * @return a color channel parameter of green 
	 */
	public float getGreen() {
		return green;
	}
	/**
	 * Get a color channel parameter of blue
	 * @return a color channel parameter of blue 
	 */
	public float getBlue() {
		return blue;
	}
	/**
	 * Get a size of the particle
	 * @return a size of the particle
	 */
	public float getSize() {
		return size;
	}
	
	@Override
	public String toString() {
		return this.id.toString() + "[red=" + red + ",green=" + green + ",blue=" + blue + ",size=" + size + "]";
	}
	
}
