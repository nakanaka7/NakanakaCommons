package tokyo.nakanaka.particle;

import tokyo.nakanaka.NamespacedID;
/**
 * Represents a particle "minecraft:dust"
 */
public class DustParticle extends Particle {
	private int red;
	private int green;
	private int blue;
	private float size;
	/**
	 * Construct a particle from the given parameters
	 * @param red the red component of the color
	 * @param green the green component of the color
	 * @param blue the blue component of the color
	 * @param size the particle size
	 */
	public DustParticle(int red, int green, int blue, float size) {
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
	public int getRed() {
		return red;
	}
	/**
	 * Get a color channel parameter of green 
	 * @return a color channel parameter of green 
	 */
	public int getGreen() {
		return green;
	}
	/**
	 * Get a color channel parameter of blue
	 * @return a color channel parameter of blue 
	 */
	public int getBlue() {
		return blue;
	}
	/**
	 * Get a size of the particle
	 * @return a size of the particle
	 */
	public float getSize() {
		return size;
	}
	/**
	 * Get a dust particle. The arg must be "&lt;red&gt; &lt;green&gt; &lt;blue&gt; &lt;size&gt;" 
	 * @param arg the argument to specify a dust particle
	 * @return a dust particle for the arg
	 * @throws if it can not parse arg to a dust particle
	 */
	public static DustParticle of(String[] args) {
		if(args.length != 4) {
			throw new IllegalArgumentException();
		}
		int red = Integer.parseInt(args[0]);
		int green = Integer.parseInt(args[1]);
		int blue = Integer.parseInt(args[2]);
		float size = Float.parseFloat(args[3]);
		return new DustParticle(red, green, blue, size);
	}
	
}
