package warlockjk.fireworks;

import warlockjk.fireworks.blocks.Blocks;
import warlockjk.fireworks.config.ConfigHandler;
import warlockjk.fireworks.items.Items;
import warlockjk.fireworks.lib.ModInformation;
import warlockjk.fireworks.network.PacketHandler;
import warlockjk.fireworks.proxies.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = ModInformation.ID, name = ModInformation.NAME, version = ModInformation.VERSION)
@NetworkMod(channels = {ModInformation.CHANNEL}, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class Fireworks {
	
	@Instance(ModInformation.ID)
	public static Fireworks instance;
	
	@SidedProxy(clientSide = "warlockjk.fireworks.proxies.ClientProxy", serverSide = "warlockjk.fireworks.proxies.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {//Doesn't have to be named preInit
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		Items.init();
		Blocks.init();
		
		proxy.initSounds();
		proxy.initRenderers();
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event) {
		Blocks.addNames();
		Items.addNames();
		
//		Items.registerRecipes();
	}
	
	@EventHandler
	public void modsLoaded(FMLPostInitializationEvent event) {
		
	}
}
