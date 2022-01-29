package me.mcunity.tuto.commands;

import me.mcunity.tuto.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandAllHome implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("sethome")){
            if (sender instanceof Player){
                Player player = (Player) sender;

                if (args.length == 0){
                    player.sendMessage(ChatColor.RED + "Erreur : /sethome <nom>");
                    return false;
                }
                if (args.length == 1){
                    Main.getInstance().getConfig().set("home. " + player.getUniqueId().toString() + "." + args[0] + ".world", player.getLocation().getWorld().getName());
                    Main.getInstance().getConfig().set("home. " + player.getUniqueId().toString() + "." + args[0] + ".x", player.getLocation().getX());
                    Main.getInstance().getConfig().set("home. " + player.getUniqueId().toString() + "." + args[0] + ".y", player.getLocation().getY());
                    Main.getInstance().getConfig().set("home. " + player.getUniqueId().toString() + "." + args[0] + ".z", player.getLocation().getZ());
                    Main.getInstance().getConfig().set("home. " + player.getUniqueId().toString() + "." + args[0] + ".pitch", player.getEyeLocation().getPitch());
                    Main.getInstance().getConfig().set("home. " + player.getUniqueId().toString() + "." + args[0] + ".yaw", player.getEyeLocation().getYaw());
                    Main.getInstance().saveConfig();
                    player.sendMessage(ChatColor.GREEN + "Votre home "+ args[0] +" a été sauvegardé !");
                    return false;
                }
                if (args.length == 2){
                    player.sendMessage(ChatColor.RED + "Erreur : /sethome <nom>");
                    return false;
                }
            }
        }
        if (label.equalsIgnoreCase("home")){
            if (sender instanceof Player){
                Player player = (Player) sender;

                if (args.length == 0){
                    player.sendMessage(ChatColor.RED + "Erreur : /home <nom>");
                    return false;
                }
                if (args.length == 1){
                    if (Main.getInstance().getConfig().contains("home. " + player.getUniqueId().toString() + "." + args[0])){
                        World world = Bukkit.getServer().getWorld(Main.getInstance().getConfig().getString("home. " + player.getUniqueId().toString() + "." + args[0] + ".world"));
                        double x = Main.getInstance().getConfig().getDouble("home. " + player.getUniqueId().toString() + "." + args[0] + ".x");
                        double y = Main.getInstance().getConfig().getDouble("home. " + player.getUniqueId().toString() + "." + args[0] + ".y");
                        double z = Main.getInstance().getConfig().getDouble("home. " + player.getUniqueId().toString() + "." + args[0] + ".z");
                        double pitch = Main.getInstance().getConfig().getDouble("home. " + player.getUniqueId().toString() + "." + args[0] + ".pitch");
                        double yaw = Main.getInstance().getConfig().getDouble("home. " + player.getUniqueId().toString() + "." + args[0] + ".yaw");
                        player.teleport(new Location(world, x, y, z, (float)yaw, (float)pitch));
                        player.sendMessage(ChatColor.GREEN + "Vous avez été téléporté à votre home " + args[0]);
                    }else{
                        player.sendMessage(ChatColor.RED + "Le home " + args[0] + " n'existe pas !");
                        return false;
                    }
                }
                if (args.length == 2){
                    player.sendMessage(ChatColor.RED + "Erreur : /home <nom>");
                    return false;
                }
            }
        }
        if (label.equalsIgnoreCase("delhome")){
            if (sender instanceof Player){
                Player player = (Player) sender;

                if (args.length == 0){
                    player.sendMessage(ChatColor.RED + "Erreur : /delhome <nom>");
                    return false;
                }
                if (args.length == 1){
                    if (Main.getInstance().getConfig().contains("home. " + player.getUniqueId().toString() + "." + args[0])){
                        Main.getInstance().getConfig().set("home. " + player.getUniqueId().toString() + "." + args[0],null);
                        player.sendMessage(ChatColor.GREEN + "Votre home " + args[0] + " a bien été supprimé !");
                        Main.getInstance().saveConfig();
                        return false;
                    }else{
                        player.sendMessage(ChatColor.RED + "Le home " + args[0] + " n'existe pas !");
                        return false;
                    }
                }
                if (args.length == 2){
                    player.sendMessage(ChatColor.RED + "Erreur : /delhome <nom>");
                    return false;
                }
            }
        }
        return false;
    }
}
