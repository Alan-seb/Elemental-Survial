package com.alansebastian.elementsurvival;

import org.bukkit.plugin.java.JavaPlugin;
import com.alansebastian.elementsurvival.commands.ElementCommand;
import com.alansebastian.elementsurvival.commands.TeamCommand;
import com.alansebastian.elementsurvival.commands.StarterCommand;
import com.alansebastian.elementsurvival.commands.ChallengeCommand;
import com.alansebastian.elementsurvival.commands.TradeCommand;
import com.alansebastian.elementsurvival.listeners.GUIListener;
import com.alansebastian.elementsurvival.listeners.NPCListener;

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
