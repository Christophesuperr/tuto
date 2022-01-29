package me.mcunity.tuto;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Menu implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        player.getInventory().clear();

        ItemStack customCompass = new ItemStack(Material.COMPASS, 1);
        ItemMeta customM = customCompass.getItemMeta();
        customM.setDisplayName("&cMenu");
        customM.setLore(Arrays.asList("premier ligne", "deuxieme ligne", "tr..."));
        customM.addEnchant(Enchantment.DAMAGE_ALL, 200, true);
        customM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        customCompass.setItemMeta(customM);

        player.getInventory().setItemInMainHand(customCompass);
        player.getInventory().setItem(8, customCompass);
        player.updateInventory();
    }
    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();
        Action action = event.getAction();
        ItemStack it = event.getItem();

        if(it == null) return;

        if(it.getType() == Material.COMPASS && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("&cMenu")){
            Inventory inventory = Bukkit.createInventory(null, 27, "&8Menu");

            inventory.setItem(0, getItem(Material.WHITE_WOOL, "&aSpawn"));
            inventory.setItem(1, getItem(Material.OAK_WOOD, "&aBois"));

            player.openInventory(inventory);
        }
    }
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Inventory inventory = event.getInventory();
        Player player = (Player) event.getWhoClicked();
        ItemStack current = event.getCurrentItem();

        if (current == null) return;

        if (current.getType() == Material.WHITE_WOOL){
            player.closeInventory();
            player.teleport(Main.SPAWN_LOCATION);
        }

        if (current.getType() == Material.OAK_WOOD){
            player.closeInventory();
            ItemStack wood = new ItemStack(Material.OAK_WOOD, 1);
            player.getInventory().setItem(1, wood);
        }
    }

    public ItemStack getItem(Material material, String customName){
        ItemStack it = new ItemStack(material,1);
        ItemMeta itM = it.getItemMeta();
        itM.setDisplayName(customName);
        it.setItemMeta(itM);
        return it;
    }
}
