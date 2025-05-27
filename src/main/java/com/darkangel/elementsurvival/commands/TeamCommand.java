package com.darkangel.elementsurvival.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class TeamCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command can only be used by players.");
            return true;
        }
        Player player = (Player) sender;

        if (args.length == 0) {
            player.sendMessage(ChatColor.YELLOW + "Usage: /team <team_name|username|leave>");
            return true;
        }

        if (args[0].equalsIgnoreCase("leave")) {
            // Implement logic to remove player from a team
            player.sendMessage(ChatColor.GREEN + "You have left your team.");
        } else if (args.length == 1) {
            // Create or join team logic
            String teamName = args[0];
            player.sendMessage(ChatColor.GREEN + "You have joined/created team: " + teamName);
        } else if (args.length == 2) {
            // Logic for adding a player to a team: /team {team_name} {username}
            String teamName = args[0];
            String username = args[1];
            Player targetPlayer = Bukkit.getPlayerExact(username);

            if (targetPlayer == null) {
                player.sendMessage(ChatColor.RED + "Player " + username + " is not online.");
                return true;
            }

            player.sendMessage(ChatColor.GREEN + "You have added " + username + " to team " + teamName);
            targetPlayer.sendMessage(ChatColor.GREEN + "You have been added to team " + teamName + " by " + player.getName());
        } else {
            player.sendMessage(ChatColor.RED + "Invalid command usage. Please use /team <team_name|username|leave>.");
        }
        return true;
    }
}
