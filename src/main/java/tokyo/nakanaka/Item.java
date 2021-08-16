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
	
}
