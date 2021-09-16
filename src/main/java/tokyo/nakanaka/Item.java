package tokyo.nakanaka;
/**
 * Represents item
 *
 */
public class Item {
	private NamespacedID id;
	/**
	 * @param id A namespaced id of the item
	 */
	public Item(NamespacedID id) {
		this.id = id;
	}
	/** 
	 * @return A namespaced id for the item
	 */
	public NamespacedID getId() {
		return id;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Item other = (Item) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
