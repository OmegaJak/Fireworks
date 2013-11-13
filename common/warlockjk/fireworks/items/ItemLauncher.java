package warlockjk.fireworks.items;

import net.minecraft.item.ItemBlock;

public class ItemLauncher extends ItemBlock {

	public ItemLauncher(int id) {
		super(id);
		setHasSubtypes(true);
	}
	
	@Override
	public int getMetadata(int meta) {
		return meta;
	}
}
