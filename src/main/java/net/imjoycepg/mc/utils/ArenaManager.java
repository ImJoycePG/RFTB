package net.imjoycepg.mc.utils;

import lombok.Getter;
import net.imjoycepg.mc.RFTB;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.ArrayList;

public class ArenaManager {
    @Getter
    private final ArrayList<Arena> arenas = new ArrayList<>();

    public void createConfig(String arenaName){
        File file = new File(RFTB.getInstance().getDataFolder() + File.separator + "Arenas" + File.separator + arenaName + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
        yml.set("Time", 500);
        yml.set("MaxPlayers", 10);
        yml.set("MinPlayers", 2);

        try{
            yml.save(file);
        }catch (Exception ex){
            RFTB.getInstance().getLogger().severe("Failed save config: " + ex);
        }
    }

    public void setMinArena(String arenaName, int minPlayers){
        File file = new File(RFTB.getInstance().getDataFolder() + File.separator + "Arenas" + File.separator + arenaName + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
        yml.set("MinPlayers", minPlayers);

        try{
            yml.save(file);
        }catch (Exception ex){
            RFTB.getInstance().getLogger().severe("Failed save config: " + ex);
        }
    }

    public void setMaxArena(String arenaName, int maxPlayers){
        File file = new File(RFTB.getInstance().getDataFolder() + File.separator + "Arenas" + File.separator + arenaName + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
        yml.set("MaxPlayers", maxPlayers);

        try{
            yml.save(file);
        }catch (Exception ex){
            RFTB.getInstance().getLogger().severe("Failed save config: " + ex);
        }
    }

    public void setTimeArena(String arenaName, int time){
        File file = new File(RFTB.getInstance().getDataFolder() + File.separator + "Arenas" + File.separator + arenaName + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
        yml.set("Time", time);

        try{
            yml.save(file);
        }catch (Exception ex){
            RFTB.getInstance().getLogger().severe("Failed save config: " + ex);
        }
    }

    public void setLobbyArena(String arenaName, String location){
        File file = new File(RFTB.getInstance().getDataFolder() + File.separator + "Arenas" + File.separator + arenaName + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);

        yml.set("Lobby", location);

        try{
            yml.save(file);
        }catch (Exception ex){
            RFTB.getInstance().getLogger().severe("Failed save config: " + ex);
        }
    }

    public void setSelectHunter(String arenaName, String location){
        File file = new File(RFTB.getInstance().getDataFolder() + File.separator + "Arenas" + File.separator + arenaName + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);

        yml.set("SelectHunter", location);

        try{
            yml.save(file);
        }catch (Exception ex){
            RFTB.getInstance().getLogger().severe("Failed save config: " + ex);
        }
    }

    public void setStartSpawn(String arenaName, String location){
        File file = new File(RFTB.getInstance().getDataFolder() + File.separator + "Arenas" + File.separator + arenaName + ".yml");
        YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);

        yml.set("StartSpawn", location);

        try{
            yml.save(file);
        }catch (Exception ex){
            RFTB.getInstance().getLogger().severe("Failed save config: " + ex);
        }
    }
}
