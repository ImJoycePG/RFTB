package net.imjoycepg.mc.commands;

import net.imjoycepg.mc.RFTB;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCMD implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(args.length == 0){
                player.sendMessage("Intenta con /rftb help");
            }

            if(args.length == 1) {
                if (args[0].equalsIgnoreCase("setMainLobby")) {
                    RFTB.getInstance().getSettings().getC().set("MainLobby", RFTB.getInstance().getLocationUtil().serialize(player.getLocation()));
                    player.sendMessage("El Lobby principal fue establecido");
                    RFTB.getInstance().getSettings().save();
                }

                if(args[0].equalsIgnoreCase("help")){

                }

                if(args[0].equalsIgnoreCase("leave")){
                    RFTB.getInstance().getArenaManager().removePlayer(player);
                }
            }

            if(args.length == 2) {
                if(args[0].equalsIgnoreCase("join")){
                    String nameArena = args[1];

                    RFTB.getInstance().getArenaManager().joinPlayer(player, nameArena);
                }
            }

        }else{
            sender.sendMessage("No puedes poner este comando en consola.");
        }



        return false;
    }
}
