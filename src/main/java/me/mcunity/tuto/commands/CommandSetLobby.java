package me.mcunity.tuto.commands;

import me.mcunity.tuto.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSetLobby implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(label.equals("setlobby")){
            if(args.length == 0) {
                if(sender instanceof Player){
                    final Player player = (Player) sender;

                    if(player.isOp()) {
                        Main.LOBBY_LOCATION = player.getLocation();
                        player.sendMessage(ChatColor.GREEN + "Vous avez défini le lobby !");
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
