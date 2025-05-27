package com.darkangel.elementsurvival.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class GUIListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equals(ChatColor.GOLD + "Select Your Element")) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null || event.getCurrentItem().getItemMeta() == null) return;
            Player player = (Player) event.getWhoClicked();
            String element = event.getCurrentItem().getItemMeta().getDisplayName();
            // Save player's selected element (this is where you could also load ability GUIs and cooldown management)
            player.sendMessage(ChatColor.GREEN + "You have selected: " + element);
            player.closeInventory();
        }
    }
}
