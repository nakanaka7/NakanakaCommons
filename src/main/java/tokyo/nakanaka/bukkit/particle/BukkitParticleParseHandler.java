package tokyo.nakanaka.bukkit.particle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import tokyo.nakanaka.NamespacedID;
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
			return List.of("ambient_entity_effect",
					"angry_villager",
					"ash",
					"barrier",
					"block",
					"bubble",
					"bubble_pop",
					"bubble_column_up",
					"campfire_cosy_smoke",
					"campfire_signal_smoke",
					"cloud",
					"composter",
					"crimson_spore",
					"crit",
					"current_down",
					"damage_indicator",
					"dolphin",
					"dragon_breath",
					"dripping_dripstone_lava",
					"dripping_dripstone_water",
					"dripping_lava",
					"dripping_obsidian_tear",
					"dripping_water",
					"dust",
					"dust_color_transition",
					"effect",
					"elder_guardian",
					"electric_spark",
					"enchant",
					"enchanted_hit",
					"end_rod",
					"entity_effect",
					"explosion_emitter",
					"explosion",
					"falling_dripstone_lava",
					"falling_dripstone_water",
					"falling_dust",
					"falling_lava",
					"falling_obsidian_tear",
					"falling_spore_blossom",
					"falling_water",
					"firework",
					"fishing",
					"flame",
					"flash",
					"glow",
					"glow_squid_ink",
					"happy_villager",
					"heart",
					"instant_effect",
					"item",
					"item_slime",
					"item_snowball",
					"landing_lava",
					"landing_obsidian_tear",
					"large_smoke",
					"lava",
					"light",
					"mycelium",
					"nautilus",
					"note",
					"poof",
					"portal",
					"rain",
					"scrape",
					"smoke",
					"sneeze",
					"snowflake",
					"soul",
					"soul_fire_flame",
					"spit",
					"splash",
					"spore_blossom_air",
					"squid_ink",
					"sweep_attack",
					"totem_of_undying",
					"underwater",
					"vibration",
					"warped_spore",
					"wax_off",
					"wax_on",
					"white_ash",
					"witch").stream()
					.map(s -> "minecraft:" + s)
					.collect(Collectors.toList());
		}else {
			NamespacedID id = NamespacedID.valueOf(label);
			if(this.subParseMap.containsKey(id)) {
				return this.subParseMap.get(id).onTabComplete(args);
			}else {
				return List.of();
			}
		}
	}

}
