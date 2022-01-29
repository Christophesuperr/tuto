package me.mcunity.tuto.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandFly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(label.equals("fly")){
            if(args.length == 0){
                if(sender instanceof Player){
                    Player player = (Player) sender;

                    if(player.isOp()){
                        if(player.getAllowFlight()){
                            player.setAllowFlight(false);
                            player.sendMessage(ChatColor.YELLOW + "Vous ne pouvez plus voler !");
                        }else{
                            player.setAllowFlight(true);
                            player.sendMessage(ChatColor.GREEN + "Vous pouvez voler !");
                        }

                    }else{
                        player.sendMessage(ChatColor.RED + "Vous n'êtes pas op !");
                    }
                }else{
                    sender.sendMessage(ChatColor.RED + "Cette commande n'est éxecutable que par un joueur !");
                }
            }else{
                sender.sendMessage(ChatColor.RED + "Votre command a trop d'arguments !");
            }
            return true;
        }
        return false;
    }
}