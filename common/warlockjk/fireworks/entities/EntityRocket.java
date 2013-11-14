package warlockjk.fireworks.entities;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;

import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;

public class EntityRocket extends Entity implements IEntityAdditionalSpawnData {
	
	private static double MAX_DISTANCE = 10;
	
	private static final String START_X_NBT = "StartX";
	private static final String START_Y_NBT = "StartY";
	private static final String START_Z_NBT = "StartZ";
	private static final String TYPE_NBT = "Type";
	
	public double startX;
	public double startY;
	public double startZ;
	public int rocketType = 0;
	private int life = 0;
	
	public EntityRocket(World world) {
		super(world);
		setSize(0.4F, 0.4F);
		motionY = 0.5;
	}

	@Override
	protected void entityInit() {
		dataWatcher.addObject(13, (byte)rocketType);
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound compound) {
		startX = compound.getDouble(START_X_NBT);
		startY = compound.getDouble(START_Y_NBT);
		startZ = compound.getDouble(START_Z_NBT);
		
		rocketType = (int)compound.getByte(TYPE_NBT);
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound compound) {
		compound.setDouble(START_X_NBT, startX);
		compound.setDouble(START_Y_NBT, startY);
		compound.setDouble(START_Z_NBT, startZ);
		
		compound.setByte(TYPE_NBT, (byte)rocketType);
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		
		if (!worldObj.isRemote && (calcDistance() >= (MAX_DISTANCE * MAX_DISTANCE)) && life < 1500) {
				setDead();
		}
		
		motionY = motionY * 0.97D;//Just for a little (poorly) simulated gravity
		life++;//A nice little safeguard, and I'm aware it's not being saved
		
		setPosition(posX + motionX, posY + motionY, posZ + motionZ);
	}
	
	private double calcDistance() {
		double distance;
		distance = Math.pow(posX - startX, 2) + Math.pow(posY - startY, 2) + Math.pow(posZ - startZ, 2);
		return distance;
	}
	
	@Override
	public void writeSpawnData(ByteArrayDataOutput data) {
		data.writeDouble(startX);
		data.writeDouble(startY);
		data.writeDouble(startZ);
		
		data.writeByte((byte)rocketType);
	}
	
	@Override
	public void readSpawnData(ByteArrayDataInput data) {
		startX = data.readDouble();
		startY = data.readDouble();
		startZ = data.readDouble();
		
		rocketType = (int)data.readByte();
	}

}
