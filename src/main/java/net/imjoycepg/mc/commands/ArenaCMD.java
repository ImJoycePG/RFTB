package net.imjoycepg.mc.commands;

import net.imjoycepg.mc.RFTB;
import net.imjoycepg.mc.utils.Arena;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ArenaCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(cmd.getName().equalsIgnoreCase("arena")){
                if(args.length == 0){
                    player.sendMessage("Usa /arena create [NameMap]");
                }
                if(args.length == 2) {
                    if (args[0].equalsIgnoreCase("create")) {
                        String nameArena = args[1];

                        WorldCreator wc = new WorldCreator(nameArena);
                        wc.type(WorldType.FLAT);
                        wc.generatorSettings("2;0;1");
                        wc.generateStructures(false);
                        World worldArena = wc.createWorld();

                        Arena arena = new Arena(nameArena);
                        RFTB.getInstance().getArenaManager().createConfig(nameArena);
                        RFTB.getInstance().getArenaManager().getArenas().add(arena);
                        player.teleport(worldArena.getSpawnLocation());
                    }

                    if (args[0].equalsIgnoreCase("delete")) {

                    }

                    if (args[0].equalsIgnoreCase("teleport") || args[0].equalsIgnoreCase("tp")) {
                        String nameArena = args[1];

                        if (RFTB.getInstance().getServer().getWorld(nameArena) == null) {
                            player.sendMessage("Este mundo no existe");
                        } else {
                            player.teleport(RFTB.getInstance().getServer().getWorld(nameArena).getSpawnLocation());
                        }
                    }

                    if(args[0].equalsIgnoreCase("setlobby")) {
                        String nameArena = args[1];

                        RFTB.getInstance().getArenaManager().setLobbyArena(nameArena, RFTB.getInstance().getLocationUtil().serialize(player.getLocation()));
                        player.sendMessage("Los datos fueron guardados.");
                    }

                    if(args[0].equalsIgnoreCase("setHunter")){
                        String nameArena = args[1];

                        RFTB.getInstance().getArenaManager().setSelectHunter(nameArena, RFTB.getInstance().getLocationUtil().serialize(player.getLocation()));
                        player.sendMessage("Los datos fueron guardados.");
                    }

                    if(args[0].equalsIgnoreCase("setStart")){
                        String nameArena = args[1];

                        RFTB.getInstance().getArenaManager().setStartSpawn(nameArena, RFTB.getInstance().getLocationUtil().serialize(player.getLocation()));
                        player.sendMessage("Los datos fueron guardados.");
                    }
                }

                if(args.length == 3) {
                    if (args[0].equalsIgnoreCase("setMin")) {
                        String nameArena = args[1];
                        int minPlayer = Integer.parseInt(args[2]);

                        RFTB.getInstance().getArenaManager().setMinArena(nameArena, minPlayer);
                        player.sendMessage("Los datos fueron guardados.");
                    }

                    if (args[0].equalsIgnoreCase("setMax")) {
                        String nameArena = args[1];
                        int maxPlayer = Integer.parseInt(args[2]);

                        RFTB.getInstance().getArenaManager().setMaxArena(nameArena, maxPlayer);
                        player.sendMessage("Los datos fueron guardados.");
                    }

                    if (args[0].equalsIgnoreCase("setTime")) {
                        String nameArena = args[1];
                        int time = Integer.parseInt(args[2]);

                        RFTB.getInstance().getArenaManager().setTimeArena(nameArena, time);
                        player.sendMessage("Los datos fueron guardados.");
                    }
                }
            }

        }else{
            RFTB.getInstance().getLogger().info("No se permite comando en consola.");
        }

        return false;
    }
}
