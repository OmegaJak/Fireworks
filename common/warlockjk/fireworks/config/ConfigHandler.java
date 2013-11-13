package warlockjk.fireworks.config;

import java.io.File;

import net.minecraftforge.common.Configuration;
import warlockjk.fireworks.lib.BlockInfo;
import warlockjk.fireworks.lib.ItemInfo;

public class ConfigHandler {
	
	public static void init(File file) {
		Configuration config = new Configuration(file);
		
		config.load();
		
		BlockInfo.LAUNCHER_ID = config.getBlock(BlockInfo.LAUNCHER_KEY, BlockInfo.LAUNCHER_DEFAULT).getInt();
		
		ItemInfo.CHANGER_ID = config.getItem(ItemInfo.CHANGER_KEY, ItemInfo.CHANGER_DEFAULT).getInt() - 256;
		
		config.save();
	}
}
