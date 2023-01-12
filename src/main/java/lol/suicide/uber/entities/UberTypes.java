package lol.suicide.uber.entities;

import com.google.common.collect.Lists;
import lol.suicide.uber.entities.impl.*;
import lol.suicide.uber.utilities.NMSUtils;
import net.minecraft.server.v1_8_R3.*;
import org.bukkit.entity.EntityType;

import java.util.List;

public enum UberTypes {

    CREEPER("Creeper", 50, EntityType.CREEPER, EntityCreeper.class, CreeperUber.class),
    SKELETON("Skeleton", 51, EntityType.SKELETON, EntitySkeleton.class, SkeletonUber.class),
    SPIDER("Spider", 52, EntityType.SPIDER, EntitySpider.class, SpiderUber.class),
    GIANT("Giant", 53, EntityType.GIANT, EntityGiantZombie.class, GiantUber.class),
    ZOMBIE("Zombie", 54, EntityType.ZOMBIE, EntityZombie.class, ZombieUber.class),
    SLIME("Slime", 55, EntityType.SLIME, EntitySlime.class, SlimeUber.class),
    GHAST("Ghast", 56, EntityType.GHAST, EntityGhast.class, GhastUber.class),
    PIGZOMBIE("PigZombie", 57, EntityType.PIG_ZOMBIE, EntityPigZombie.class, ZombiePigmanUber.class),
    ENDERMAN("Enderman", 58, EntityType.ENDERMAN, EntityEnderman.class, EndermanUber.class),
    CAVESPIDER("CaveSpider", 59, EntityType.CAVE_SPIDER, EntityChicken.class, CaveSpiderUber.class),
    SILVERFISH("Silverfish", 60, EntityType.SILVERFISH, EntitySilverfish.class, SilverfishUber.class),
    BLAZE("Blaze", 61, EntityType.BLAZE, EntityBlaze.class, BlazeUber.class),
    MAGMACUBE("MagmaCube", 62, EntityType.MAGMA_CUBE, EntityMagmaCube.class, MagmaCubeUber.class),
    ENDERDRAGON("EnderDragon", 63, EntityType.ENDER_DRAGON, EntityEnderDragon.class, EnderDragonUber.class),
    WITHER("Wither", 64, EntityType.WITHER, EntityWither.class, WitherUber.class),
    BAT("Bat", 65, EntityType.BAT, EntityBat.class, BatUber.class),
    WITCH("Witch", 66, EntityType.WITCH, EntityWitch.class, WitchUber.class),
    ENDERMITE("Endermite", 67, EntityType.ENDERMITE, EntityEndermite.class, EndermiteUber.class),
    GUARDIAN("Guardian", 68, EntityType.GUARDIAN, EntityGuardian.class, GuardianUber.class),

    PIG("Pig", 90, EntityType.PIG, EntityPig.class, PigUber.class),
    SHEEP("Sheep", 91, EntityType.SHEEP, EntitySheep.class, SheepUber.class),
    COW("Cow", 92, EntityType.COW, EntityCow.class, CowUber.class),
    CHICKEN("Chicken", 93, EntityType.CHICKEN, EntityChicken.class, ChickenUber.class),
    SQUID("Squid", 94, EntityType.SQUID, EntitySquid.class, SquidUber.class),
    WOLF("Wolf", 95, EntityType.WOLF, EntityWolf.class, WolfUber.class),
    MUSHROOMCOW("MushroomCow", 96, EntityType.MUSHROOM_COW, EntityMushroomCow.class, MooshroomUber.class),
    SNOWMAN("Snowman", 97, EntityType.SNOWMAN, EntitySnowman.class, SnowManUber.class),
    OCELOT("Ocelot", 98, EntityType.OCELOT, EntityOcelot.class, OcelotUber.class),
    IRONGOLEM("IronGolem", 99, EntityType.IRON_GOLEM, EntityIronGolem.class, IronGolemUber.class),

    HORSE("Horse", 100, EntityType.HORSE, EntityHorse.class, HorseUber.class),
    RABBIT("Rabbit", 101, EntityType.RABBIT, EntityRabbit.class, RabbitUber.class),

    VILLAGER("Villager", 120, EntityType.VILLAGER, EntityVillager.class, VillagerUber.class);

    private String name;
    private int id;
    private EntityType entityType;
    private Class<? extends EntityInsentient> nmsClass;
    private Class<? extends EntityInsentient> customClass;

    UberTypes(final String name, final int id, final EntityType entityType, final Class<? extends EntityInsentient> nmsClass,
              final Class<? extends EntityInsentient> customClass) {
        this.name = name;
        this.id = id;
        this.entityType = entityType;
        this.nmsClass = nmsClass;
        this.customClass = customClass;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return id;
    }

    public EntityType getEntityType() {
        return entityType;
    }

    public Class<? extends EntityInsentient> getNMSClass() {
        return nmsClass;
    }

    public Class<? extends EntityInsentient> getCustomClass() {
        return customClass;
    }

    private static EntityType[] registeredEntityTypes;

    public static void registerEntities() {
        for (final UberTypes entity : values()) {
            NMSUtils.registerEntity(entity.getName(), entity.getID(), entity.getNMSClass(), entity.getCustomClass());
        }
    }

    public static EntityType[] getRegisteredEntityTypes() {
        if (registeredEntityTypes == null) {
            List<EntityType> list = Lists.newArrayList();
            for (final UberTypes entity : values()) {
                list.add(entity.getEntityType());
            }

            registeredEntityTypes = list.toArray(new EntityType[0]);
        }

        return registeredEntityTypes;
    }

    public static UberTypes valueOf(EntityType type) {
        for (final UberTypes entity : values()) {
            if (entity.getEntityType().equals(type)) {
                return entity;
            }
        }
        return null;
    }
}
