package tokyo.nakanaka.particle;

import java.util.List;

public class DustParticleParser {
	public DustParticle parse(String[] args) {
		if(args.length != 4) {
			throw new IllegalArgumentException();
		}
		float red = Float.parseFloat(args[0]);
		float green = Float.parseFloat(args[1]);
		float blue = Float.parseFloat(args[2]);
		float size = Float.parseFloat(args[3]);
		return new DustParticle(red, green, blue, size);
	}
	
	public List<String> onTabComplete(String[] args) {
		if(1 <= args.length && args.length <= 3) {
			return List.of("0", "0.1", "0.2", "0.3", "0.4", "0.5", "0.6", "0.7", "0.8", "0.9", "1");
		}else if(args.length == 4) {
			return List.of("0.5", "1.0", "1.5", "2.0", "2.5", "3.0", "3.5", "4.0", "4.5", "5.0"
					, "5.5", "6.0", "6.5", "7.0", "7.5", "8.0", "8.5", "9.0", "9.5");
		}else {
			return List.of();
		}
	}
}
