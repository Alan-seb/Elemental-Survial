package com.darkangel.elementsurvival.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ElementSelectionGUI {

    public void open(Player player) {
        Inventory inv = Bukkit.createInventory(null, 9, ChatColor.GOLD + "Select Your Element");

        // Each element is represented by an item.
        inv.setItem(0, createElementItem(Material.FIRE_CHARGE, ChatColor.RED + "Fire"));
        inv.setItem(1, createElementItem(Material.WATER_BUCKET, ChatColor.BLUE + "Water"));
        inv.setItem(2, createElementItem(Material.GRASS, ChatColor.GREEN + "Earth"));
        inv.setItem(3, createElementItem(Material.FEATHER, ChatColor.WHITE + "Air"));
        inv.setItem(4, createElementItem(Material.REDSTONE_BLOCK, ChatColor.YELLOW + "Lightning"));

        player.openInventory(inv);
    }

    private ItemStack createElementItem(Material material, String name) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(name);
            item.setItemMeta(meta);
        }
        return item;
    }

    // TODO: Add an event listener in your main plugin class to handle InventoryClickEvent.
    // Check if the clicked inventory matches this GUI and handle element selection logic.
}
