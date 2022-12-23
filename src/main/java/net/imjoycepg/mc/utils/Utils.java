package net.imjoycepg.mc.utils;

import net.imjoycepg.mc.RFTB;
import org.bukkit.WorldCreator;

import java.io.File;

public class Utils {

    public void loadWorlds(){
        File folderPath = new File(RFTB.getInstance().getDataFolder() + File.separator + "Arenas" + File.separator);
        String contents[] = folderPath.list();
        if(contents == null) return;
        for (int i = 0; i < contents.length; i++){
            RFTB.getInstance().getServer().createWorld(new WorldCreator(contents[i].replace(".yml", "")));
        }
    }

}
