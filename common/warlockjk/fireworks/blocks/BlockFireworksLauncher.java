package warlockjk.fireworks.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import warlockjk.fireworks.lib.BlockInfo;
import warlockjk.fireworks.tileentities.TileEntityLauncher;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFireworksLauncher extends BlockContainer {

	public BlockFireworksLauncher(int id) {
		super(id, Material.rock);
		setCreativeTab(CreativeTabs.tabRedstone);
		setHardness(2F);
		setStepSound(Block.soundStoneFootstep);
		setUnlocalizedName(BlockInfo.LAUNCHER_UNLOCALIZED_NAME);
	}
	
	@SideOnly(Side.CLIENT)
	private Icon topIcon;
	@SideOnly(Side.CLIENT)
	private Icon[] sideIcons;
	@SideOnly(Side.CLIENT)
	private Icon botIcon;
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		topIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.LAUNCHER_TOP);
		botIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.LAUNCHER_BOT);
		sideIcons = new Icon[BlockInfo.LAUNCHER_SIDES.length];
		for(int i = 0; i < sideIcons.length; i++) {
			sideIcons[i] = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.LAUNCHER_SIDES[i]);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta) {
		if (side == 0) {
			return botIcon;
		}else if(side == 1) {
			return topIcon;
		}else{
			return sideIcons[meta];
		}
	}
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityLauncher();
	}
	
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int id, CreativeTabs tab, List list) {
		for (int i = 0; i < BlockInfo.LAUNCHER_SIDES.length; i++) {
			list.add(new ItemStack(id, 1, i));
		}
	}
}
