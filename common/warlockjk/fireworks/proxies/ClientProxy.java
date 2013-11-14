package warlockjk.fireworks.proxies;

import warlockjk.fireworks.client.RenderRocket;
import warlockjk.fireworks.entities.EntityRocket;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy{
	
	@Override
	public void initSounds() {
		
	}
	
	@Override
	public void initRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntityRocket.class, new RenderRocket());
	}
}
