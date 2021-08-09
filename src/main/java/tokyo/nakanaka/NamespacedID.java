package tokyo.nakanaka;
/**
 * Represents NamespacedID, which is a String expression &lt;namespace&gt;:&lt;name&gt;"
 */
public class NamespacedID {
	private String namespace;
	private String name;
	/**
	 * Construct a namespacedID by the given namespace and name
	 * @param namespace namespace of the NamespacedID
	 * @param name name of the NamespacedID
	 */
	public NamespacedID(String namespace, String name) {
		this.namespace = namespace;
		this.name = name;
	}
	/**
	 * Returns a namespacedID
	 * @param str the input to parse
	 * @return a namespacedID
	 * @throws IllegalArgumentException if the input is not the form &lt;namespace&gt;:&lt;name&gt;
	 */
	public static NamespacedID valueOf(String str) {
		String namespace;
		String name;
		String[] strs = str.split(":");
		if(strs.length != 2) {
			throw new IllegalArgumentException("must contain one \":\"");
		}else {
			namespace = strs[0];
			name = strs[1];
			return new NamespacedID(namespace, name);
		}
	}
	/**
	 * Return the namespace of the namespacedID
	 * @return the namespace of the namespacedID
	 */
	public String getNamespace() {
		return this.namespace;
	}
	/**
	 * Return the name of the namespacedID
	 * @return the name of the namespacedID
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * Returns the String expression of the namespacedID, &lt;namespace&gt;:&lt;name&gt;
	 * @return the String expression of the namespacedID, &lt;namespace&gt;:&lt;name&gt;
	 */
	@Override
	public String toString() {
		return this.namespace + ":" + this.name;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((namespace == null) ? 0 : namespace.hashCode());
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
		NamespacedID other = (NamespacedID) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (namespace == null) {
			if (other.namespace != null)
				return false;
		} else if (!namespace.equals(other.namespace))
			return false;
		return true;
	}
	
}
