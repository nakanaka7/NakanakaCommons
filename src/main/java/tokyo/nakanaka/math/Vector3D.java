package tokyo.nakanaka.math;
/**
 * Represents a vector in 3D space
 */
public class Vector3D {
	public static final Vector3D ORIGIN = new Vector3D(0, 0, 0);
	public static final Vector3D ZERO = new Vector3D(0, 0, 0);
	public static final Vector3D PLUS_I = new Vector3D(1, 0, 0);
	public static final Vector3D MINUS_I = new Vector3D(- 1, 0, 0);
	public static final Vector3D PLUS_J = new Vector3D(0, 1, 0);
	public static final Vector3D MINUS_J = new Vector3D(0, - 1, 0);
	public static final Vector3D PLUS_K = new Vector3D(0, 0, 1);
	public static final Vector3D MINUS_K = new Vector3D(0, 0, - 1);
	private double x;
	private double y;
	private double z;
	/**
	 * Construct a vector
	 * @param x x component of the vector
	 * @param y y component of the vector
	 * @param z z component of the vector
	 */
	public Vector3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	/**
	 * Get x component of the vector
	 * @return x component of the vector
	 */
	public double getX() {
		return this.x;
	}
	/**
	 * Get y component of the vector
	 * @return y component of the vector
	 */
	public double getY() {
		return this.y;
	}
	/**
	 * Get z component of the vector
	 * @return z component of the vector
	 */
	public double getZ() {
		return this.z;
	}
	/**
	 * Add another vector to the vector
	 * @param another another vector to the vector
	 * @return the sum of two vector
	 */
	public Vector3D add(Vector3D another) {
		return new Vector3D(this.x + another.getX(), this.y + another.getY(), this.z + another.getZ());
	}
	/**
	 * Negate another vector from the vector
	 * @param another another vector to the vector
	 * @return a vector of the result
	 */
	public Vector3D negate(Vector3D another) {
		return new Vector3D(this.x - another.getX(), this.y - another.getY(), this.z - another.getZ());
	}
	/**
	 * Multiply a double value
	 * @param a a double value to multiply
	 * @return a vector of the result
	 */
	public Vector3D multiply(double a) {
		return new Vector3D(a * x, a * y, a * z);
	}
	
	/**
	 * Divide a vector by a double value
	 * @param a a double value
	 * @return a vector of the result
	 * @throws ArithmeticException if a is 0
	 */
	public Vector3D divide(double a) {
		return new Vector3D(x / a, y / a, z / a);
	}
	/**
	 * Execute an inner product
	 * @param another another vector to calculate the inner product
	 * @return a double value of the result
	 */
	public double innerProduct(Vector3D another) {
		return x * another.getX() + y * another.getY() + z * another.getZ();
	}
	/**
	 * Execute a cross product
	 * @param another another vector to calculate the cross product
	 * @return a vector of the result
	 */
	public Vector3D crossProduct(Vector3D another) {
		double x2 = another.getX();
		double y2 = another.getY();
		double z2 = another.getZ();
		double x3 = this.y * z2 - this.z * y2;
		double y3 = this.z * x2 - this.x * z2;
		double z3 = this.x * y2 - this.y * x2;
		return new Vector3D(x3, y3, z3);
	}
	/**
	 * Get an absolute length of the vector
	 * @return an absolute length of the vector
	 */
	public double getAbsolute() {
		return Math.sqrt(this.innerProduct(this));
	}
	/**
	 * Get a distance of the 2 vector, which is equivalent to the distance of
	 * the two points in 3D space, where each point is represented by the vector
	 * @param another another vector
	 * @return a distance of the 2 vector
	 */
	public double getDistance(Vector3D another) {
		return this.negate(another).getAbsolute();
	}
	/**
	 * Return x/y/z
	 * @return x/y/z
	 */
	@Override
	public String toString() {
		return x + "/ " + y + "/ " + z;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(z);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vector3D other = (Vector3D) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		if (Double.doubleToLongBits(z) != Double.doubleToLongBits(other.z))
			return false;
		return true;
	}
	
}
