package warlockjk.fireworks.blocks;

import net.minecraft.block.Block;
import warlockjk.fireworks.items.ItemLauncher;
import warlockjk.fireworks.lib.BlockInfo;
import warlockjk.fireworks.tileentities.TileEntityLauncher;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Blocks {
	
	public static Block launcher;
	
	public static void init() {
		launcher = new BlockFireworksLauncher(BlockInfo.LAUNCHER_ID);
		GameRegistry.registerBlock(launcher, ItemLauncher.class, BlockInfo.LAUNCHER_KEY);
	}
	
	public static void addNames() {
			LanguageRegistry.addName(launcher, BlockInfo.LAUNCHER_NAME);
	}
	
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityLauncher.class, BlockInfo.LAUNCHER_KEY);
	}
}
