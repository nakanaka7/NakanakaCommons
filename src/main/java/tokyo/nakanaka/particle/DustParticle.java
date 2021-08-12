package tokyo.nakanaka.particle;

import java.util.List;

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
	
	/**
	 * Not API
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
	/**
	 * Not API
	 * Get a list for tab complete of parsing arg to a dust particle. The parsing way is given by of() method.
	 * @param args the argument to specify a dust particle
	 * @return a list for tab complete of parsing arg to a dust particle.
	 */
	public static List<String> onTabComplete(String[] args){
		if(1 <= args.length && args.length <= 3) {
			return List.of("0", "1");
		}else if(args.length == 4) {
			return List.of("0.5", "1.0", "1.5", "2.0", "2.5", "3.0", "3.5", "4.0", "4.5", "5.0"
					, "5.5", "6.0", "6.5", "7.0", "7.5", "8.0", "8.5", "9.0", "9.5");
		}else {
			return List.of();
		}
	}
	
}
