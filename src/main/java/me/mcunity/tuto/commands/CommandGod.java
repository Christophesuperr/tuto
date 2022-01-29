package me.mcunity.tuto.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandGod implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(label.equals("god")){
            if(args.length == 0){
                if(sender instanceof Player){
                    Player player = (Player) sender;

                    if(player.isOp()){
                        if(player.isInvulnerable()){
                            player.setInvulnerable(false);
                            player.sendMessage(ChatColor.YELLOW + "Vous n'êtes plus invincible !");
                        }else{
                            player.setInvulnerable(true);
                            player.sendMessage(ChatColor.GREEN + "Vous êtes invincible !");
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
