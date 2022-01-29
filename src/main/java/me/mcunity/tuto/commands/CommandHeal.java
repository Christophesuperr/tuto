package me.mcunity.tuto.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHeal implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(label.equals("heal")){
            if(args.length == 0){
                if(sender instanceof Player){
                    final Player player = (Player) sender;
                    player.setHealth(20);
                    player.sendMessage(ChatColor.GREEN + "Vous êtes guéri");
                }
            }
        }

        return false;
    }
}
