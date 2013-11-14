package warlockjk.fireworks.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import warlockjk.fireworks.entities.EntityRocket;

public class TileEntityLauncher extends TileEntity {
	
	private static final int FIRE_TIME = 240;
	private static final int PARTICLE_TIME = 60;
	
	private int fireTimer;
	private int particleTimer;
	
	public TileEntityLauncher() {
		fireTimer = 0;
		particleTimer = 0;
	}
	
	@Override
	public void updateEntity() {
		if (!worldObj.isRemote) {
			if (fireTimer == FIRE_TIME) {
				EntityRocket rocket = new EntityRocket(worldObj);
				
				rocket.posX = xCoord + 0.5;
				rocket.posY = yCoord + 1;
				rocket.posZ = zCoord + 0.5;
				rocket.startX = xCoord + 0.5;
				rocket.startY = yCoord + 1;
				rocket.startZ = zCoord + 0.5;
				rocket.rocketType = this.getBlockMetadata();
							
				worldObj.spawnEntityInWorld(rocket);
				fireTimer = 0;
			}else{
				fireTimer++;
			}
			if(particleTimer == PARTICLE_TIME) {
				
			}else{
				particleTimer++;
			}
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		
		compound.setShort("FireTimer", (short)fireTimer);
		compound.setShort("ParticleTimer", (short)particleTimer);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		
		fireTimer = compound.getShort("FireTimer");
		particleTimer = compound.getShort("ParticleTimer");
	}
}
