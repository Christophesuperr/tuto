package me.mcunity.tuto.commands;

import me.mcunity.tuto.Main;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSetSpawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(label.equals("setspawn")){
            if(args.length == 0) {
                if(sender instanceof Player){
                    final Player player = (Player) sender;
                    final World world = (World) sender;

                    if(player.isOp()) {
                        Main.SPAWN_LOCATION = player.getLocation();
                        world.setSpawnLocation(player.getLocation());
                        player.sendMessage(ChatColor.GREEN + "Vous avez défini le point de spawn !");
                    }else{
                        player.sendMessage(ChatColor.RED + "Vous n'êtes pas op !");
                    }

                }
            }
            return true;
        }



        return false;
    }
}
