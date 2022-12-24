package net.imjoycepg.mc.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.imjoycepg.mc.RFTB;
import org.bukkit.ChatColor;
import org.bukkit.Location;
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
    private ArrayList<UUID> players = new ArrayList<>();
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

        if(this.lobbyArena == null || this.selectHunter == null || this.startSpawn == null){
            this.gameState = GameState.STOPPED;
        }else{
            this.gameState = GameState.STARTING;
            this.lobbyArena = RFTB.getInstance().getLocationUtil().deserialize(this.yml.getString("Lobby"));
            this.selectHunter = RFTB.getInstance().getLocationUtil().deserialize(this.yml.getString("SelectHunter"));
            this.startSpawn = RFTB.getInstance().getLocationUtil().deserialize(this.yml.getString("StartSpawn"));
        }
    }

    public void addPlayer(Player player){
        if(this.gameState == GameState.INGAME){
            player.sendMessage("La partida ya empezo");
        }
        else if(this.gameState == GameState.STOPPED){
            player.sendMessage("La partida esta detenida");
        }
        else if(this.gameState == GameState.FINISHED){
            player.sendMessage("La partida esta terminado");
        }
        else if(this.gameState == GameState.STARTING){
            player.teleport(this.lobbyArena);
            player.getInventory().clear();
            player.getInventory().setArmorContents(null);
            player.setFlying(false);
            player.setAllowFlight(false);
            player.setHealth(20.0);
            player.setFireTicks(0);
            this.players.add(player.getUniqueId());

            player.updateInventory();
        }
    }
}
