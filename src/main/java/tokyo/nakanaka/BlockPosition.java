package tokyo.nakanaka;

import tokyo.nakanaka.world.World;

public record BlockPosition(World world, int x, int y, int z) {
}
