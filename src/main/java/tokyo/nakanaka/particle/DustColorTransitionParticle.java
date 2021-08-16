package tokyo.nakanaka.particle;

import tokyo.nakanaka.NamespacedID;
/**
 * Represents "minecraft:dust_color_transition" particle
 */
public class DustColorTransitionParticle extends Particle {
	private float redFrom;
	private float greenFrom;
	private float blueFrom;
	private float size;
	private float redTo;
	private float greenTo;
	private float blueTo;
	
	/**
	 * @param redFrom the initial red component of the color
	 * @param greenFrom the initial green component of the color
	 * @param blueFrom the initial blue component of the color
	 * @param size the particle size
	 * @param redTo the final red component of the color
	 * @param greenTo the final green component of the color
	 * @param blueTo the final blue component of the color
	 */
	public DustColorTransitionParticle(float redFrom, float greenFrom, float blueFrom, float size, float redTo, float greenTo, float blueTo) {
		super(new NamespacedID("minecraft", "dust_color_transition"));
		this.redFrom = redFrom;
		this.greenFrom = greenFrom;
		this.blueFrom = blueFrom;
		this.redTo = redTo;
		this.greenTo = greenTo;
		this.blueTo = blueTo;
	}
	/**
	 * @return an initial red component
	 */
	public float getRedFrom() {
		return redFrom;
	}
	/**
	 * @return an initial green component
	 */
	public float getGreenFrom() {
		return greenFrom;
	}
	/**
	 * @return an initial blue component
	 */
	public float getBlueFrom() {
		return blueFrom;
	}

	public float getSize() {
		return size;
	}
	/**
	 * @return a final red component
	 */
	public float getRedTo() {
		return redTo;
	}
	/**
	 * @return a final green component
	 */
	public float getGreenTo() {
		return greenTo;
	}
	/**
	 * @return a final blue component
	 */
	public float getBlueTo() {
		return blueTo;
	}
	
}
