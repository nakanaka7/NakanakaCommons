package tokyo.nakanaka.particle;

import tokyo.nakanaka.NamespacedID;
/**
 * Represents "minecraft:dust_color_transition" particle
 */
public class DustColorTransitionParticle extends Particle {
	private float fromRed;
	private float fromGreen;
	private float fromBlue;
	private float size;
	private float toRed;
	private float toGreen;
	private float toBlue;
	
	/**
	 * @param fromRed the initial red component of the color
	 * @param fromGreen the initial green component of the color
	 * @param fromBlue the initial blue component of the color
	 * @param size the particle size
	 * @param toRed the final red component of the color
	 * @param toGreen the final green component of the color
	 * @param toBlue the final blue component of the color
	 */
	public DustColorTransitionParticle(float fromRed, float fromGreen, float fromBlue, float size, float toRed, float toGreen, float toBlue) {
		super(new NamespacedID("minecraft", "dust_color_transition"));
		this.fromRed = fromRed;
		this.fromGreen = fromGreen;
		this.fromBlue = fromBlue;
		this.size = size;
		this.toRed = toRed;
		this.toGreen = toGreen;
		this.toBlue = toBlue;
	}
	/**
	 * @return an initial red component
	 */
	public float getFromRed() {
		return fromRed;
	}
	/**
	 * @return an initial green component
	 */
	public float getFromGreen() {
		return fromGreen;
	}
	/**
	 * @return an initial blue component
	 */
	public float getFromBlue() {
		return fromBlue;
	}

	public float getSize() {
		return size;
	}
	/**
	 * @return a final red component
	 */
	public float getToRed() {
		return toRed;
	}
	/**
	 * @return a final green component
	 */
	public float getToGreen() {
		return toGreen;
	}
	/**
	 * @return a final blue component
	 */
	public float getToBlue() {
		return toBlue;
	}
	
}
