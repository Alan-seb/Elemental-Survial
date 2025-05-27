package com.alansebastian.elementsurvival.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChallengeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be used by players.");
            return true;
        }
        Player challenger = (Player) sender;
        if (args.length != 1) {
            challenger.sendMessage(ChatColor.YELLOW + "Usage: /challenge <username>");
            return true;
        }
        Player target = Bukkit.getPlayerExact(args[0]);
        if (target == null) {
            challenger.sendMessage(ChatColor.RED + "Player not found.");
            return true;
        }

        // Start duel logic:
        challenger.sendMessage(ChatColor.GREEN + "You have challenged " + target.getName() + " to a duel.");
        target.sendMessage(ChatColor.GREEN + challenger.getName() + " has challenged you to a duel.");
        // TODO: Open betting GUI and isolate duel zone using event listeners and region protection.

        return true;
    }
}
