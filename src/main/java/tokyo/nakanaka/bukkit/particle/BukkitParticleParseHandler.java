package tokyo.nakanaka.bukkit.particle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import tokyo.nakanaka.NamespacedID;
import tokyo.nakanaka.particle.JavaParticleID;
import tokyo.nakanaka.particle.Particle;
import tokyo.nakanaka.particle.ParticleParseHandler;
import tokyo.nakanaka.particle.SubParticleParseHandler;
/**
 * ParticleParseHandler for bukkit
 */
public class BukkitParticleParseHandler implements ParticleParseHandler {
	private Map<NamespacedID, SubParticleParseHandler> subParseMap = new HashMap<>();
	
	public BukkitParticleParseHandler() {
		subParseMap.put(NamespacedID.valueOf("minecraft:dust"), new DustParticleParseHandler());
	}
	
	@Override
	public Particle onParse(String label, String[] args) {
		if(!label.contains(":")) {
			label = "minecraft:" + label;
		}
		NamespacedID id = NamespacedID.valueOf(label);
		if(!this.subParseMap.containsKey(id)) {
			return new Particle(id);
		}
		return this.subParseMap.get(id).onParse(args);
	}

	@Override
	public List<String> onTabComplete(String label, String[] args) {
		if(args.length == 0) {
			return List.of(JavaParticleID.values()).stream()
					.map(s -> "minecraft:" + s.toString().toLowerCase())
					.collect(Collectors.toList());
		}else {
			if(!label.contains(":")) {
				label = "minecraft:" + label;
			}
			NamespacedID id = NamespacedID.valueOf(label);
			if(this.subParseMap.containsKey(id)) {
				return this.subParseMap.get(id).onTabComplete(args);
			}else {
				return List.of();
			}
		}
	}

}
