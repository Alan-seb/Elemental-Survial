package com.darkangel.elementsurvival.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class NPCListener implements Listener {

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        Entity entity = event.getRightClicked();
        // Citizens typically mark NPCs with metadata. Here we assume the NPC has a custom name.
        if (entity != null && entity.hasMetadata("NPC")) {
            Player player = event.getPlayer();
            String npcName = entity.getCustomName();
            if (npcName != null) {
                if (npcName.contains("PvP World NPC")) {
                    player.sendMessage(ChatColor.GREEN + "Teleporting to the PvP arena...");
                    // TODO: Teleport the player using Multiverse integration.
                } else if (npcName.contains("Survival World NPC")) {
                    player.sendMessage(ChatColor.GREEN + "Teleporting to the Survival world...");
                    // TODO: Teleport the player accordingly.
                }
            }
        }
    }
}
