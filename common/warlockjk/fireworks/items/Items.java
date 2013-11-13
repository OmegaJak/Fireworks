package warlockjk.fireworks.items;

import cpw.mods.fml.common.registry.LanguageRegistry;
import warlockjk.fireworks.lib.ItemInfo;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Items {
	
	public static Item changer;
	
	public static void init() {
		changer = new ItemTypeChanger(ItemInfo.CHANGER_ID);
	}
	
	public static void addNames() {
		for(int i = 0; i < ItemInfo.CHANGER_NAMES.length; i++) {
			LanguageRegistry.addName(new ItemStack(changer, 1, i), ItemInfo.CHANGER_NAMES[i]);
		}
	}
}
