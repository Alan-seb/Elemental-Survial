package com.alansebastian.elementsurvival.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;

public class StarterCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be used by players.");
            return true;
        }
        Player player = (Player) sender;
        if (!player.hasPermission("elementsurvival.starter")) {
            player.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
            return true;
        }

        // TODO: Implement a one-time check to ensure the kit is only given once per player.
        // Provide a kit with iron armor, tools, and 32 bread.
        player.getInventory().addItem(new ItemStack(Material.IRON_HELMET));
        player.getInventory().addItem(new ItemStack(Material.IRON_CHESTPLATE));
        player.getInventory().addItem(new ItemStack(Material.IRON_LEGGINGS));
        player.getInventory().addItem(new ItemStack(Material.IRON_BOOTS));
        player.getInventory().addItem(new ItemStack(Material.IRON_SWORD));
        player.getInventory().addItem(new ItemStack(Material.IRON_PICKAXE));
        player.getInventory().addItem(new ItemStack(Material.IRON_AXE));
        player.getInventory().addItem(new ItemStack(Material.BREAD, 32));

        player.sendMessage(ChatColor.GREEN + "Starter kit granted!");
        return true;
    }
}
