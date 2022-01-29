package me.mcunity.tuto.commands;

import me.mcunity.tuto.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSpawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (label.equalsIgnoreCase("spawn")) {
            if (args.length == 0) {
                if (sender instanceof Player) {
                    final Player player = (Player) sender;

                    if (Main.SPAWN_LOCATION != null) {
                        player.teleport(Main.SPAWN_LOCATION);
                    } else {
                        player.sendMessage(ChatColor.RED + "Le point de spawn n'a pas été défini !");
                    }
                } else {
                    sender.sendMessage("Cette commande n'est exécutable que par un joueur !");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "Votre commande a trop d'arguments !");
            }
            return true;
        }

        return false;
    }
}

