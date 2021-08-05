package tokyo.nakanaka.block;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import tokyo.nakanaka.MapHolder;
import tokyo.nakanaka.NamespacedID;
/**
 * Represents block
 */
public class Block {
	private NamespacedID id;
	private Map<String, String> stateMap;
	/**
	 * @param id namespacedID of the block
	 * @param stateMap a map that holds information for the block state
	 */
	public Block(NamespacedID id, Map<String, String> stateMap) {
		this.id = id;
		this.stateMap = new HashMap<>(stateMap);
	}
	/**
	 * @param blockStateStr a String which form is &lt;blockID&gt;[&lt;key&gt;=&lt;value&gt;...] or &lt;blockID&gt;
	 * blockID can omit namespace, in which case the namespace will be regarded as "minecraft". The brackets can be omitted,
	 * when there is no key and values.
	 * @return block
	 * @throws IllegalArgumentException if the input can not be parsed to block 
	 */
	public static Block valueOf(String blockStateStr) {
		if(!blockStateStr.contains(":")) {
			blockStateStr = "minecraft:" + blockStateStr;
		}
		MapHolder holder = MapHolder.valueOf(blockStateStr);
		NamespacedID id = NamespacedID.valueOf(holder.getName());
		return new Block(id, holder.getMap());
	}
	/**
	 * Return a namespaceID of the block
	 * @return a namespaceID of the block 
	 */
	public NamespacedID getId() {
		return id;
	}
	/**
	 * Return a state map which holds the information for block state
	 * @return a state map which holds the information for block state
	 */
	public Map<String, String> getStateMap() {
		return stateMap;
	}
	/**
	 * Get a string representation of the block state. For example, minecraft:brick_stairs[facing=east,half=bottom].
	 * @return a string of the block state
	 */
	public String getBlockStateString() {
		String str = this.id.toString();
		if(this.stateMap.size() != 0) {
			List<String> kv = new ArrayList<>();
			for(Entry<String, String> entry : this.stateMap.entrySet()) {
				kv.add(entry.getKey() + "=" + entry.getValue());
			}
			str = str + "[" + String.join(",", kv) + "]";
		}
		return str;
	}
	
}
