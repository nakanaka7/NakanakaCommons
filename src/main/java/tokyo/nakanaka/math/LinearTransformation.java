package tokyo.nakanaka.math;

import tokyo.nakanaka.Axis;

public class LinearTransformation {
	public static final LinearTransformation IDENTITY = new LinearTransformation(Matrix3x3.IDENTITY);
	public static final LinearTransformation X_MIRROR = new LinearTransformation(Matrix3x3.X_MIRROR);
	public static final LinearTransformation Y_MIRROR = new LinearTransformation(Matrix3x3.Y_MIRROR);
	public static final LinearTransformation Z_MIRROR = new LinearTransformation(Matrix3x3.Z_MIRROR);
	
	private Matrix3x3 matrix;
	
	public LinearTransformation(Matrix3x3 matrix) {
		this.matrix = matrix;
	}
	
	public Matrix3x3 getMatrix() {
		return matrix;
	}
	
	public Vector3D apply(Vector3D v) {
		return this.matrix.apply(v);
	}
	
	public LinearTransformation multipy(LinearTransformation trans) {
		return new LinearTransformation(this.matrix.multiply(trans.getMatrix()));
	}
	
	/**
	 * @throws SingularOperatorException
	 */
	public LinearTransformation getInverse() {
		Matrix3x3 inv = this.matrix.getInverse();
		return new LinearTransformation(inv);
	}
	
	public static LinearTransformation ofMirror(Axis axis) {
		switch(axis) {
		case X:
			return X_MIRROR;
		case Y:
			return Y_MIRROR;
		case Z:
			return Z_MIRROR;
		default:
			throw new UnsupportedOperationException();
		}
	}
	
	public static LinearTransformation ofScale(Axis axis, double factor) {
		switch(axis) {
		case X:
			return ofXScale(factor);
		case Y:
			return ofYScale(factor);
		case Z:
			return ofZScale(factor);
		default:
			throw new UnsupportedOperationException();
		}
	}
	
	public static LinearTransformation ofXScale(double factor) {
		return new LinearTransformation(Matrix3x3.ofXScale(factor));
	}
	
	public static LinearTransformation ofYScale(double factor) {
		return new LinearTransformation(Matrix3x3.ofYScale(factor));
	}
	
	public static LinearTransformation ofZScale(double factor) {
		return new LinearTransformation(Matrix3x3.ofZScale(factor));
	}
	
	public static LinearTransformation ofRotation(Axis axis, double degree) {
		switch(axis) {
		case X:
			return LinearTransformation.ofXRotation(degree);
		case Y:
			return LinearTransformation.ofYRotation(degree);
		case Z:
			return LinearTransformation.ofZRotation(degree);
		default:
			throw new UnsupportedOperationException();
		}
	}
	
	public static LinearTransformation ofXRotation(double degree) {
		return new LinearTransformation(Matrix3x3.ofXRotation(degree));
	}
	
	public static LinearTransformation ofYRotation(double degree) {
		return new LinearTransformation(Matrix3x3.ofYRotation(degree));
	}
	
	public static LinearTransformation ofZRotation(double degree) {
		return new LinearTransformation(Matrix3x3.ofZRotation(degree));
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matrix == null) ? 0 : matrix.hashCode());
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
		LinearTransformation other = (LinearTransformation) obj;
		if (matrix == null) {
			if (other.matrix != null)
				return false;
		} else if (!matrix.equals(other.matrix))
			return false;
		return true;
	}
	
	
}
