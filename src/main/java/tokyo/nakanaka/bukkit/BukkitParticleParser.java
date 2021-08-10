package tokyo.nakanaka.bukkit;

import java.util.List;
import java.util.stream.Collectors;

import tokyo.nakanaka.NamespacedID;
import tokyo.nakanaka.particle.DustParticle;
import tokyo.nakanaka.particle.Particle;
import tokyo.nakanaka.particle.ParticleParser;

/**
 * A particle parser for bukkit
 */
public class BukkitParticleParser implements ParticleParser {

	@Override
	public Particle parse(String... input) {
		if(input.length == 0) {
			return null;
		}
		String input0 = input[0];
		if(!input0.contains(":")) {
			input0 = "minecraft:" + input0;
		}
		NamespacedID id;
		try {
			id = NamespacedID.valueOf(input0);
		}catch(IllegalArgumentException e) {
			return null;
		}
		String[] args = new String[input.length - 1];
		System.arraycopy(input, 1, args, 0, input.length - 1);
		if(id.equals(NamespacedID.valueOf("minecraft:dust"))) {
			return DustParticle.of(args);
		}
		return new Particle(id);
	}

	@Override
	public List<String> onTabComplete(String... input) {
		if(input.length == 0) {
			return List.of();
		}
		if(input.length == 1) {
			return List.of(org.bukkit.Particle.values()).stream()
				.map(s -> "minecraft:" + s.toString().toLowerCase())
				.collect(Collectors.toList());
		}
		String input0 = input[0];
		if(!input0.contains(":")) {
			input0 += "minecraft:";
		}
		NamespacedID id;
		try {
			id = NamespacedID.valueOf(input0);
		}catch(IllegalArgumentException e) {
			return List.of();
		}
		String[] args = new String[input.length - 1];
		System.arraycopy(input, 1, args, 0, input.length - 1);
		if(id.equals(NamespacedID.valueOf("minecraft:dust"))) {
			return DustParticle.onTabComplete(args);
		}
		return List.of();
	}

}
