package net.imjoycepg.mc.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.imjoycepg.mc.RFTB;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

@Setter
@Getter
@ToString
public class Arena {
    private String nameArena;
    private ArrayList<UUID> players;
    private GameState gameState;

    private int maxPlayers;
    private int minPlayers;

    private int timeArena;

    private Location lobbyArena;
    private Location selectHunter;
    private Location startSpawn;

    private File file = null;
    private YamlConfiguration yml = null;


    public Arena(String nameArena){
        this.nameArena = nameArena;

        loadArenas();
    }

    private void loadArenas(){
        this.file = new File(RFTB.getInstance().getDataFolder() + File.separator + "Arenas" + File.separator + this.nameArena + ".yml");
        this.yml = YamlConfiguration.loadConfiguration(file);

        this.timeArena = this.yml.getInt("Time");
        this.maxPlayers = this.yml.getInt("MaxPlayers");
        this.minPlayers = this.yml.getInt("MinPlayers");
        this.lobbyArena = RFTB.getInstance().getLocationUtil().deserialize("Lobby");
        this.selectHunter = RFTB.getInstance().getLocationUtil().deserialize("SelectHunter");
        this.startSpawn = RFTB.getInstance().getLocationUtil().deserialize("StartSpawn");

        if(this.lobbyArena == null || this.selectHunter == null || this.startSpawn == null){
            this.gameState = GameState.STOPPED;
        }
    }

    public void addPlayer(Player player){
        this.players.add(player.getUniqueId());
    }

    public void removePlayer(Player player){
        this.players.remove(player.getUniqueId());
    }


}
