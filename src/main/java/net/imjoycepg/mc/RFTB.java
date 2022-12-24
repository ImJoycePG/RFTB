package net.imjoycepg.mc;

import lombok.Getter;
import net.imjoycepg.mc.commands.ArenaCMD;
import net.imjoycepg.mc.commands.MainCMD;
import net.imjoycepg.mc.utils.ArenaManager;
import net.imjoycepg.mc.utils.ConfigFile;
import net.imjoycepg.mc.utils.LocationUtil;
import net.imjoycepg.mc.utils.Utils;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class RFTB extends JavaPlugin {
    @Getter
    private static RFTB instance;
    private ConfigFile settings;


    private final Utils util = new Utils();
    private final LocationUtil locationUtil = new LocationUtil();
    private final ArenaManager arenaManager = new ArenaManager();

    @Override
    public void onEnable() {
        instance = this;
        settings = new ConfigFile(this, "config.yml");
        util.loadWorlds();
        util.loadArenas();

        this.getCommand("arena").setExecutor(new ArenaCMD());
        this.getCommand("rftb").setExecutor(new MainCMD());
    }
}
