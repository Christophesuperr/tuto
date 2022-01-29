package me.mcunity.tuto.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandVanish implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(label.equals("vanish")){
            if(args.length == 0){
                if(sender instanceof Player){
                    Player player = (Player) sender;

                    if(player.isOp()){
                        if(player.isInvisible()){
                            player.setInvisible(false);
                            player.setCanPickupItems(true);
                            player.sendMessage(ChatColor.GREEN + "Vous n'êtes plus invisible !");
                            sender.sendMessage(ChatColor.YELLOW + player.getName() + " joined the game.");
                        }else{
                            player.setInvisible(true);
                            player.setCanPickupItems(false);
                            player.sendMessage(ChatColor.GREEN + "Vous êtes invisible !");
                            sender.sendMessage(ChatColor.YELLOW + player.getName() + " left the game.");

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
