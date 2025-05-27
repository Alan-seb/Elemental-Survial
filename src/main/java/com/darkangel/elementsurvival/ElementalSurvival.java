package com.darkangel.elementsurvival;

import org.bukkit.plugin.java.JavaPlugin;
import com.darkangel.elementsurvival.commands.ElementCommand;
import com.darkangel.elementsurvival.commands.TeamCommand;
import com.darkangel.elementsurvival.commands.StarterCommand;
import com.darkangel.elementsurvival.commands.ChallengeCommand;
import com.darkangel.elementsurvival.commands.TradeCommand;
import com.darkangel.elementsurvival.listeners.GUIListener;
import com.darkangel.elementsurvival.listeners.NPCListener;

public class ElementalSurvival extends JavaPlugin {

    private static ElementalSurvival instance;

    public static ElementalSurvival getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        // Register commands
        if (getCommand("element") != null) getCommand("element").setExecutor(new ElementCommand());
        if (getCommand("team") != null) getCommand("team").setExecutor(new TeamCommand());
        if (getCommand("starter") != null) getCommand("starter").setExecutor(new StarterCommand());
        if (getCommand("challenge") != null) getCommand("challenge").setExecutor(new ChallengeCommand());
        if (getCommand("trade") != null) getCommand("trade").setExecutor(new TradeCommand());

        // Register events
        getServer().getPluginManager().registerEvents(new GUIListener(), this);
        getServer().getPluginManager().registerEvents(new NPCListener(), this);

        // Integration setup for Citizens, Vault, Multiverse, etc. would occur here.
        getLogger().info("ElementalSurvival has been enabled!");
    }

    @Override
    public void onDisable() {
        instance = null;
        getLogger().info("ElementalSurvival has been disabled.");
    }
}
