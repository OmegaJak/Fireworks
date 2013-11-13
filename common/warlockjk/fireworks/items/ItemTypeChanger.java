package warlockjk.fireworks.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import warlockjk.fireworks.lib.BlockInfo;
import warlockjk.fireworks.lib.ItemInfo;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTypeChanger extends Item {
	
	@SideOnly(Side.CLIENT)
	private Icon[] icons;
	
	public ItemTypeChanger(int id) {
		super(id);
		setCreativeTab(CreativeTabs.tabMisc);
		setHasSubtypes(true);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		return ItemInfo.CHANGER_UNLOCALIZED_NAME + itemstack.getItemDamage();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		icons = new Icon[ItemInfo.CHANGER_ICONS.length];
		for (int i = 0; i < icons.length; i++) {
			icons[i] = register.registerIcon(ItemInfo.TEXTURE_LOCATION + ":" + ItemInfo.CHANGER_ICONS[i]);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int dmg) {
		return icons[dmg];
	}
	
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void getSubItems(int id, CreativeTabs tab, List list) {
		for (int i = 0; i < ItemInfo.CHANGER_NAMES.length; i++) {
			ItemStack stack = new ItemStack(id, 1, i);
			list.add(stack);
		}
	}
	
	@Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if (!world.isRemote && world.getBlockId(x,  y,  z) == BlockInfo.LAUNCHER_ID) {
			
			world.setBlockMetadataWithNotify(x, y, z, stack.getItemDamage(), 3);
			stack.stackSize--;
			
			return true;
		}else{
			return false;
		}
	}
}
