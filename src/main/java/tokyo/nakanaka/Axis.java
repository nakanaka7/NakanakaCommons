package tokyo.nakanaka;

import tokyo.nakanaka.math.Vector3D;
/**
 * Represents axis in 3D space
 */
public enum Axis {
	X(1, 0, 0),
	Y(0, 1, 0),
	Z(0, 0, 1);
	
	private double x;
	private double y;
	private double z;
	
	private Axis(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	/**
	 * Return a unit vector corresponding to the axis. The following is every case. 
	 * X -&gt; (1, 0, 0), Y -&gt; (0, 1,0 ), Z -&gt; (0, 0, 1)
	 * @return a unit vector corresponding to the axis
	 */
	public Vector3D toVector3D() {
		return new Vector3D(this.x, this.y, this.z);
	}
	
}
