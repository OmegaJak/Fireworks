package warlockjk.fireworks.entities;

import warlockjk.fireworks.Fireworks;
import cpw.mods.fml.common.registry.EntityRegistry;

public class Entities {
	public static void init() {
		EntityRegistry.registerModEntity(EntityRocket.class, "EntityRocket", 0, Fireworks.instance, 80, 3, true);
	}
}
