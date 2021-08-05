package tokyo.nakanaka;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
/**
 * A class for the String expression "name[&lt;key&gt;=&lt;value&gt;...]". The keys and values must be String.
 */
public class MapHolder {
	private String name;
	private Map<String, String> map;
	/**
	 * Constructs a map holder 
	 * @param name the name of the map holder
	 * @param map the map of the map holder
	 */
	public MapHolder(String name, Map<String, String> map) {
		this.name = name;
		this.map = new HashMap<>(map);
	}
	/**
	 * @return name of the map holder
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the map of the map holder
	 */
	public Map<String, String> getMap() {
		return map;
	}
	/**
	 * @return the String expression of the map holder. 
	 */
	@Override
	public String toString() {
		if(map.size() == 0) {
			return name;
		}
		Set<String> inner = new HashSet<>();
		for(Entry<String, String> entry : map.entrySet()) {
			inner.add(entry.getKey() + "=" + entry.getValue());
		}
		return this.name + "[" + String.join(",", inner) + "]";
		
	}
	/**
	 * @param str the input String, which must be the form "name[<key>=<value>...]".
	 * @return a map holder for the input String
	 * @throws IllegalArgumentException if the input is not the appropriate form
	 */
	public static MapHolder valueOf(String str) {
		if(!str.contains("[") && !str.contains("]")) {
			return new MapHolder(str, new HashMap<>());
		}else {
			//check if str endwith "]"
			if(!str.endsWith("]")) {
				throw new IllegalArgumentException(str + ":not end with \"]\"");
			}
			String[] strs = str.split("\\]",-1);
			//check if str contains only 1 "]"
			if(strs.length != 2) {
				throw new IllegalArgumentException("contains several \"]\"");
			}
			//remove the end "]"
			str = strs[0];
			strs = str.split("\\[", -1);
			//check if str contains only 1 "["
			if(strs.length != 2) {
				throw new IllegalArgumentException("must contains only 1 \"[\"");
			}
			String name = strs[0];
			Map<String, String> map = new HashMap<>();
			String[] kvs = strs[1].split(",", -1);
			List<String> kvList = new ArrayList<>(Arrays.asList(kvs));
			for(String kv : kvList) {
				String[] s = kv.split("=", -1);
				if(s.length != 2) {
					throw new IllegalArgumentException("does not contain \"=\"");
				}
				String key = s[0];
				String value = s[1];
				map.put(key, value);
			}
			return new MapHolder(name, map);
		}
	}
}
