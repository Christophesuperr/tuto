package me.mcunity.tuto;

import me.mcunity.tuto.commands.*;
import org.bukkit.Location;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.*;


public final class Main extends JavaPlugin {

    public static Location SPAWN_LOCATION = null;
    public static Location LOBBY_LOCATION = null;
    public static Location DIEBAN = null;
    public static Main instance;
    public static Main getInstance() {
        return instance;
    }
        @Override
        public void onEnable () {
            getCommand("setspawn").setExecutor(new CommandSetSpawn());
            getCommand("spawn").setExecutor(new CommandSpawn());
            getCommand("eat").setExecutor(new CommandEat());
            getCommand("heal").setExecutor(new CommandHeal());
            getCommand("fly").setExecutor(new CommandFly());
            getCommand("god").setExecutor(new CommandGod());
            getCommand("vanish").setExecutor(new CommandVanish());
            getCommand("sethome").setExecutor(new CommandAllHome());
            getCommand("home").setExecutor(new CommandAllHome());
            getCommand("delhome").setExecutor(new CommandAllHome());

            instance = this;

            ItemStack apple = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 2);
            ShapedRecipe GodApple = new ShapedRecipe(apple);
            GodApple.shape("***", "*B*", "***");
            GodApple.setIngredient('*', Material.GOLD_BLOCK);
            GodApple.setIngredient('B', Material.APPLE);
            getServer().addRecipe(GodApple);

            ItemStack spawner = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 2);
            ShapedRecipe customSpawner = new ShapedRecipe(spawner);
            customSpawner.shape("***", "*B*", "***");
            customSpawner.setIngredient('*', Material.BARRIER);
            customSpawner.setIngredient('B', Material.TORCH);
            getServer().addRecipe(customSpawner);

            ItemStack stick = new ItemStack(Material.DIRT, 64);
            ShapedRecipe customStick = new ShapedRecipe(stick);
            customStick.shape("***", "*B*", "***");
            customStick.setIngredient('*', Material.AIR);
            customStick.setIngredient('B', Material.STICK);
            getServer().addRecipe(customStick);

            ItemStack sell = new ItemStack(Material.SADDLE, 1);
            ShapedRecipe customSell = new ShapedRecipe(sell);
            customSell.shape("***", "B*B", "BBB");
            customSell.setIngredient('*', Material.AIR);
            customSell.setIngredient('B', Material.LEATHER);
            getServer().addRecipe(customSell);

            ItemStack mending = new ItemStack(Material.ENCHANTED_BOOK, 1);
            ShapedRecipe customMending = new ShapedRecipe(mending);
            customSell.shape("***", "B*B", "***");
            customSell.setIngredient('*', Material.AIR);
            customSell.setIngredient('B', Material.OAK_WOOD);
            getServer().addRecipe(customMending);
        }
}