package lol.suicide.uber.entities.impl;

import net.minecraft.server.v1_8_R3.EntityLiving;
import net.minecraft.server.v1_8_R3.EntityPig;
import net.minecraft.server.v1_8_R3.EntitySkeleton;
import net.minecraft.server.v1_8_R3.World;

import java.lang.reflect.Field;

public class SkeletonUber extends EntitySkeleton {

    private final double speed, jumpHeight, sideMod, backMod, stepHeight;
    private Field JUMP;

    public SkeletonUber(World world) {
        super(world);
        speed = 0.2;
        jumpHeight = 0.6;
        sideMod = 0.5;
        backMod = 0.25;
        stepHeight = 1.0;
    }

    @Override
    public void g(float f, float f1) {
        EntityLiving entityliving = (EntityLiving) passenger;
        if (entityliving == null) {
            super.g(f, f1);
            return;
        }

        this.lastYaw = this.yaw = entityliving.yaw;
        this.pitch = entityliving.pitch * 0.5F;
        this.setYawPitch(this.yaw, this.pitch);
        this.aK = this.aI = this.yaw;
        f = (float) (entityliving.aZ * sideMod);

        f1 = entityliving.ba;
        if (f1 <= 0.0f) {
            f1 *= backMod;
        }

        this.k((float) speed);

        super.g(f, f1);

        if (this.JUMP == null) {
            try {
                this.JUMP = EntityLiving.class.getDeclaredField("aY");
                this.JUMP.setAccessible(true);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }

        if(JUMP != null && this.passenger != null) {
            if(this.onGround) {
                try {
                    if(JUMP.getBoolean(this.passenger)) {
                        this.motY = jumpHeight;
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        S = (float) stepHeight;
    }
}
