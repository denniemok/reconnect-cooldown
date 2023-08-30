package com.battleasya.reconnectcooldown;

import com.battleasya.reconnectcooldown.command.Reload;
import com.battleasya.reconnectcooldown.handler.Config;
import com.battleasya.reconnectcooldown.handler.PreLogin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import java.util.HashMap;

public class ReconnectCooldown extends JavaPlugin {

    public Config config;

    @Override
    public void onEnable() {

        saveDefaultConfig();

        config = new Config(this);
        config.fetchConfig();

        getCommand("rcreload").setExecutor(new Reload(this));
        getServer().getPluginManager().registerEvents(new PreLogin(this), this);

    }

}
