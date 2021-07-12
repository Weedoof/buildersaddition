package com.mrh0.buildersaddition.entity;

import com.mrh0.buildersaddition.Index;
import com.mrh0.buildersaddition.blocks.base.ISeat;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class SeatEntity extends Entity{

	public SeatEntity(EntityType<?> entityTypeIn, World worldIn) {
		super(Index.SEAT_ENTITY_TYPE, worldIn);
		this.noClip = true;
	}
	
	public SeatEntity(EntityType<?> entityTypeIn, World worldIn, BlockPos pos) {
		super(Index.SEAT_ENTITY_TYPE, worldIn);
		this.setPosition(pos.getX(), pos.getY(), pos.getZ());
	}
	
	private SeatEntity(World world, BlockPos pos, double y)
    {
        this(Index.SEAT_ENTITY_TYPE, world);
        this.setPosition(pos.getX() + 0.5, pos.getY() + y, pos.getZ() + 0.5);
    }
	
	@Override
	public void tick() {
		super.tick();
		if(!world.isRemote) {
			if(this.getPassengers().isEmpty() || !(world.getBlockState(new BlockPos(this.getPosX(), this.getPosY(), this.getPosZ())).getBlock() instanceof ISeat)) {
				this.remove();
			}
		}
	}

	@Override
	protected void registerData() {
		
	}

	@Override
	protected void readAdditional(CompoundNBT compound) {
		
	}

	@Override
	protected void writeAdditional(CompoundNBT compound) {
		
	}
	
	@Override
    public IPacket<?> createSpawnPacket()
    {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
	
	@Override
	protected boolean canBeRidden(Entity entityIn) {
		return true;
	}
	
	@Override
	public boolean canBePushed() {
		return false;
	}
	
	@Override
	public boolean canBeCollidedWith() {
		return false;
	}
	
	@Override
	public boolean canPassengerSteer() {
		return false;
	}
	
	@Override
	public double getMountedYOffset() {
		return -.1d;
	}

	public static ActionResultType createSeat(World world, BlockPos pos, LivingEntity e, double y, SoundEvent sound) {
		if(e instanceof PlayerEntity)
		world.playSound((PlayerEntity)e, pos, sound, SoundCategory.BLOCKS, 1f, 1f);
		if(world.isRemote)
			return ActionResultType.SUCCESS;
		if(world.getEntitiesWithinAABB(SeatEntity.class, new AxisAlignedBB(pos.getX(), pos.getY(), pos.getZ(), pos.getX() + 1, pos.getY() + 1, pos.getZ() + 1)).isEmpty()) {
			SeatEntity seat = new SeatEntity(world, pos, y);//.35d
			world.addEntity(seat);
			e.startRiding(seat);
			return ActionResultType.CONSUME;
		}
		return ActionResultType.FAIL;
	}
	
	public static ActionResultType createSeat(World world, BlockPos pos, LivingEntity e, SoundEvent sound) {
		return createSeat(world, pos, e, .45d, sound);
	}
}
