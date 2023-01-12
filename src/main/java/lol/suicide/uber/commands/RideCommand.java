package lol.suicide.uber.commands;

import lol.suicide.uber.entities.impl.*;
import lol.suicide.uber.utilities.C;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.List;
import java.util.stream.Collectors;

public class RideCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if(commandLabel.equalsIgnoreCase("ride")) {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                Entity target = getLookingAt(player);
                if(target == null) {
                    player.sendMessage(C.colorize("&cYou must be looking at an entity to ride it."));
                    return true;
                }
                target.remove();

                Location location = target.getLocation();
                CraftWorld world = ((CraftWorld)target.getWorld());

                switch(target.getType()) {
                    case BAT:
                        BatUber batUber = new BatUber((world.getHandle()));
                        batUber.setLocation(location.getBlockX() + 0.5D, location.getY(), location.getBlockZ() + 0.5D, location.getYaw(), location.getPitch());
                        world.getHandle().addEntity(batUber);
                        batUber.getBukkitEntity().setPassenger(player);
                        break;
                    case BLAZE:
                        BlazeUber blazeUber = new BlazeUber((world.getHandle()));
                        blazeUber.setLocation(location.getBlockX() + 0.5D, location.getY(), location.getBlockZ() + 0.5D, location.getYaw(), location.getPitch());
                        world.getHandle().addEntity(blazeUber);
                        blazeUber.getBukkitEntity().setPassenger(player);
                        break;
                    case CAVE_SPIDER:
                        CaveSpiderUber caveSpiderUber = new CaveSpiderUber((world.getHandle()));
                        caveSpiderUber.setLocation(location.getBlockX() + 0.5D, location.getY(), location.getBlockZ() + 0.5D, location.getYaw(), location.getPitch());
                        world.getHandle().addEntity(caveSpiderUber);
                        caveSpiderUber.getBukkitEntity().setPassenger(player);
                        break;
                    case CHICKEN:
                        ChickenUber chickenUber = new ChickenUber((world.getHandle()));
                        chickenUber.setLocation(location.getBlockX() + 0.5D, location.getY(), location.getBlockZ() + 0.5D, location.getYaw(), location.getPitch());
                        world.getHandle().addEntity(chickenUber);
                        chickenUber.getBukkitEntity().setPassenger(player);
                        break;
                    case COW:
                        CowUber cowUber = new CowUber(world.getHandle());
                        cowUber.setLocation(location.getBlockX() + 0.5D, location.getY(), location.getBlockZ() + 0.5D, location.getYaw(), location.getPitch());
                        ((CraftWorld) target.getWorld()).getHandle().addEntity(cowUber);
                        cowUber.getBukkitEntity().setPassenger(player);
                        break;
                    case CREEPER:
                        CreeperUber creeperUber = new CreeperUber(world.getHandle());
                        creeperUber.setLocation(location.getBlockX() + 0.5D, location.getY(), location.getBlockZ() + 0.5D, location.getYaw(), location.getPitch());
                        ((CraftWorld) target.getWorld()).getHandle().addEntity(creeperUber);
                        creeperUber.getBukkitEntity().setPassenger(player);
                        break;
                    case ENDER_DRAGON:
                        EnderDragonUber enderDragonUber = new EnderDragonUber(world.getHandle());
                        enderDragonUber.setLocation(location.getBlockX() + 0.5D, location.getY(), location.getBlockZ() + 0.5D, location.getYaw(), location.getPitch());
                        ((CraftWorld) target.getWorld()).getHandle().addEntity(enderDragonUber);
                        enderDragonUber.getBukkitEntity().setPassenger(player);
                        break;
                    case ENDERMAN:
                        EndermanUber endermanUber = new EndermanUber(world.getHandle());
                        endermanUber.setLocation(location.getBlockX() + 0.5D, location.getY(), location.getBlockZ() + 0.5D, location.getYaw(), location.getPitch());
                        ((CraftWorld) target.getWorld()).getHandle().addEntity(endermanUber);
                        endermanUber.getBukkitEntity().setPassenger(player);
                        break;
                    case ENDERMITE:
                        EndermiteUber endermiteUber = new EndermiteUber(world.getHandle());
                        endermiteUber.setLocation(location.getBlockX() + 0.5D, location.getY(), location.getBlockZ() + 0.5D, location.getYaw(), location.getPitch());
                        ((CraftWorld) target.getWorld()).getHandle().addEntity(endermiteUber);
                        endermiteUber.getBukkitEntity().setPassenger(player);
                        break;
                    case GHAST:
                        GhastUber ghastUber = new GhastUber(world.getHandle());
                        ghastUber.setLocation(location.getBlockX() + 0.5D, location.getY(), location.getBlockZ() + 0.5D, location.getYaw(), location.getPitch());
                        ((CraftWorld) target.getWorld()).getHandle().addEntity(ghastUber);
                        ghastUber.getBukkitEntity().setPassenger(player);
                        break;
                    case GIANT:
                        GiantUber giantUber = new GiantUber(world.getHandle());
                        giantUber.setLocation(location.getBlockX() + 0.5D, location.getY(), location.getBlockZ() + 0.5D, location.getYaw(), location.getPitch());
                        ((CraftWorld) target.getWorld()).getHandle().addEntity(giantUber);
                        giantUber.getBukkitEntity().setPassenger(player);
                        break;
                    case GUARDIAN:
                        GuardianUber guardianUber = new GuardianUber(world.getHandle());
                        guardianUber.setLocation(location.getBlockX() + 0.5D, location.getY(), location.getBlockZ() + 0.5D, location.getYaw(), location.getPitch());
                        ((CraftWorld) target.getWorld()).getHandle().addEntity(guardianUber);
                        guardianUber.getBukkitEntity().setPassenger(player);
                        break;
                    case HORSE:
                        HorseUber horseUber = new HorseUber(world.getHandle());
                        horseUber.setLocation(location.getBlockX() + 0.5D, location.getY(), location.getBlockZ() + 0.5D, location.getYaw(), location.getPitch());
                        ((CraftWorld) target.getWorld()).getHandle().addEntity(horseUber);
                        horseUber.getBukkitEntity().setPassenger(player);
                        break;
                    case IRON_GOLEM:
                        IronGolemUber ironGolemUber = new IronGolemUber(world.getHandle());
                        ironGolemUber.setLocation(location.getBlockX() + 0.5D, location.getY(), location.getBlockZ() + 0.5D, location.getYaw(), location.getPitch());
                        ((CraftWorld) target.getWorld()).getHandle().addEntity(ironGolemUber);
                        ironGolemUber.getBukkitEntity().setPassenger(player);
                        break;
                    case MAGMA_CUBE:
                        MagmaCubeUber magmaCubeUber = new MagmaCubeUber(world.getHandle());
                        magmaCubeUber.setLocation(location.getBlockX() + 0.5D, location.getY(), location.getBlockZ() + 0.5D, location.getYaw(), location.getPitch());
                        ((CraftWorld) target.getWorld()).getHandle().addEntity(magmaCubeUber);
                        magmaCubeUber.getBukkitEntity().setPassenger(player);
                        break;
                    case MUSHROOM_COW:
                        MooshroomUber mooshroomUber = new MooshroomUber(world.getHandle());
                        mooshroomUber.setLocation(location.getBlockX() + 0.5D, location.getY(), location.getBlockZ() + 0.5D, location.getYaw(), location.getPitch());
                        ((CraftWorld) target.getWorld()).getHandle().addEntity(mooshroomUber);
                        mooshroomUber.getBukkitEntity().setPassenger(player);
                        break;
                    case OCELOT:
                        OcelotUber ocelotUber = new OcelotUber(world.getHandle());
                        ocelotUber.setLocation(location.getBlockX() + 0.5D, location.getY(), location.getBlockZ() + 0.5D, location.getYaw(), location.getPitch());
                        ((CraftWorld) target.getWorld()).getHandle().addEntity(ocelotUber);
                        ocelotUber.getBukkitEntity().setPassenger(player);
                        break;
                    case PIG:
                        PigUber pigUber = new PigUber(world.getHandle());
                        pigUber.setLocation(location.getBlockX() + 0.5D, location.getY(), location.getBlockZ() + 0.5D, location.getYaw(), location.getPitch());
                        ((CraftWorld) target.getWorld()).getHandle().addEntity(pigUber);
                        pigUber.getBukkitEntity().setPassenger(player);
                        break;
                    case RABBIT:
                        RabbitUber rabbitUber = new RabbitUber(world.getHandle());
                        rabbitUber.setLocation(location.getBlockX() + 0.5D, location.getY(), location.getBlockZ() + 0.5D, location.getYaw(), location.getPitch());
                        ((CraftWorld) target.getWorld()).getHandle().addEntity(rabbitUber);
                        rabbitUber.getBukkitEntity().setPassenger(player);
                        break;
                    case SHEEP:
                        SheepUber sheepUber = new SheepUber(world.getHandle());
                        sheepUber.setLocation(location.getBlockX() + 0.5D, location.getY(), location.getBlockZ() + 0.5D, location.getYaw(), location.getPitch());
                        ((CraftWorld) target.getWorld()).getHandle().addEntity(sheepUber);
                        sheepUber.getBukkitEntity().setPassenger(player);
                        break;
                    case SILVERFISH:
                        SilverfishUber silverfishUber = new SilverfishUber(world.getHandle());
                        silverfishUber.setLocation(location.getBlockX() + 0.5D, location.getY(), location.getBlockZ() + 0.5D, location.getYaw(), location.getPitch());
                        ((CraftWorld) target.getWorld()).getHandle().addEntity(silverfishUber);
                        silverfishUber.getBukkitEntity().setPassenger(player);
                        break;
                    case SKELETON:
                        SkeletonUber skeletonUber = new SkeletonUber(world.getHandle());
                        skeletonUber.setLocation(location.getBlockX() + 0.5D, location.getY(), location.getBlockZ() + 0.5D, location.getYaw(), location.getPitch());
                        ((CraftWorld) target.getWorld()).getHandle().addEntity(skeletonUber);
                        skeletonUber.getBukkitEntity().setPassenger(player);
                        break;
                    case SLIME:
                        SlimeUber slimeUber = new SlimeUber(world.getHandle());
                        slimeUber.setLocation(location.getBlockX() + 0.5D, location.getY(), location.getBlockZ() + 0.5D, location.getYaw(), location.getPitch());
                        ((CraftWorld) target.getWorld()).getHandle().addEntity(slimeUber);
                        slimeUber.getBukkitEntity().setPassenger(player);
                        break;
                    case SNOWMAN:
                        SnowManUber snowManUber = new SnowManUber(world.getHandle());
                        snowManUber.setLocation(location.getBlockX() + 0.5D, location.getY(), location.getBlockZ() + 0.5D, location.getYaw(), location.getPitch());
                        ((CraftWorld) target.getWorld()).getHandle().addEntity(snowManUber);
                        snowManUber.getBukkitEntity().setPassenger(player);
                        break;
                    case SPIDER:
                        SpiderUber spiderUber = new SpiderUber(world.getHandle());
                        spiderUber.setLocation(location.getBlockX() + 0.5D, location.getY(), location.getBlockZ() + 0.5D, location.getYaw(), location.getPitch());
                        ((CraftWorld) target.getWorld()).getHandle().addEntity(spiderUber);
                        spiderUber.getBukkitEntity().setPassenger(player);
                        break;
                    case SQUID:
                        SquidUber squidUber = new SquidUber(world.getHandle());
                        squidUber.setLocation(location.getBlockX() + 0.5D, location.getY(), location.getBlockZ() + 0.5D, location.getYaw(), location.getPitch());
                        ((CraftWorld) target.getWorld()).getHandle().addEntity(squidUber);
                        squidUber.getBukkitEntity().setPassenger(player);
                        break;
                    case VILLAGER:
                        VillagerUber villagerUber = new VillagerUber(world.getHandle());
                        villagerUber.setLocation(location.getBlockX() + 0.5D, location.getY(), location.getBlockZ() + 0.5D, location.getYaw(), location.getPitch());
                        ((CraftWorld) target.getWorld()).getHandle().addEntity(villagerUber);
                        villagerUber.getBukkitEntity().setPassenger(player);
                        break;
                    case WITCH:
                        WitchUber witchUber = new WitchUber(world.getHandle());
                        witchUber.setLocation(location.getBlockX() + 0.5D, location.getY(), location.getBlockZ() + 0.5D, location.getYaw(), location.getPitch());
                        ((CraftWorld) target.getWorld()).getHandle().addEntity(witchUber);
                        witchUber.getBukkitEntity().setPassenger(player);
                        break;
                    case WITHER:
                        WitherUber witherUber = new WitherUber(world.getHandle());
                        witherUber.setLocation(location.getBlockX() + 0.5D, location.getY(), location.getBlockZ() + 0.5D, location.getYaw(), location.getPitch());
                        ((CraftWorld) target.getWorld()).getHandle().addEntity(witherUber);
                        witherUber.getBukkitEntity().setPassenger(player);
                        break;
                    case WOLF:
                        WolfUber wolfUber = new WolfUber(world.getHandle());
                        wolfUber.setLocation(location.getBlockX() + 0.5D, location.getY(), location.getBlockZ() + 0.5D, location.getYaw(), location.getPitch());
                        ((CraftWorld) target.getWorld()).getHandle().addEntity(wolfUber);
                        wolfUber.getBukkitEntity().setPassenger(player);
                        break;
                    case PIG_ZOMBIE:
                        ZombiePigmanUber zombiePigmanUber = new ZombiePigmanUber(world.getHandle());
                        zombiePigmanUber.setLocation(location.getBlockX() + 0.5D, location.getY(), location.getBlockZ() + 0.5D, location.getYaw(), location.getPitch());
                        ((CraftWorld) target.getWorld()).getHandle().addEntity(zombiePigmanUber);
                        zombiePigmanUber.getBukkitEntity().setPassenger(player);
                        break;
                    case ZOMBIE:
                        ZombieUber zombieUber = new ZombieUber(world.getHandle());
                        zombieUber.setLocation(location.getBlockX() + 0.5D, location.getY(), location.getBlockZ() + 0.5D, location.getYaw(), location.getPitch());
                        ((CraftWorld) target.getWorld()).getHandle().addEntity(zombieUber);
                        zombieUber.getBukkitEntity().setPassenger(player);
                        break;
                    default: break;
                }

                return true;
            } else {
                sender.sendMessage(C.colorize("&cOnly players can use this command."));
                return true;
            }
        } else {
            return true;
        }
    }

    private Entity getLookingAt(Player player) {
        List<Entity> nearbyEntities = player.getNearbyEntities(5, 5, 5);

        Location eye = player.getEyeLocation();

        List<Entity> lookingAt = nearbyEntities.stream().filter(entity -> {
            if(entity instanceof LivingEntity) {
                Vector toEntity = ((LivingEntity) entity).getEyeLocation().toVector().subtract(eye.toVector());
                return toEntity.normalize().dot(eye.getDirection()) > 0.65D;
            }
            return false;
        }).collect(Collectors.toList());

        if(lookingAt.isEmpty()) return null;
        return lookingAt.get(0);
    }
}
