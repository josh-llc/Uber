package lol.suicide.uber;

import lol.suicide.uber.commands.RideCommand;
import lol.suicide.uber.entities.UberTypes;
import org.bukkit.plugin.java.JavaPlugin;

public class Uber extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("ride").setExecutor(new RideCommand());
        UberTypes.registerEntities();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

}
