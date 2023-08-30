package com.battleasya.reconnectcooldown;

import com.battleasya.reconnectcooldown.command.Reload;
import com.battleasya.reconnectcooldown.handler.Config;
import com.battleasya.reconnectcooldown.handler.PreLogin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import java.util.HashMap;

public class ReconnectCooldown extends JavaPlugin {

    public HashMap<String, Integer> cooldown = new HashMap<>();

    public Config config;

    @Override
    public void onEnable() {

        saveDefaultConfig();

        config = new Config(this);
        config.fetchConfig();

        getCommand("rcreload").setExecutor(new Reload(this));
        getServer().getPluginManager().registerEvents(new PreLogin(this), this);

    }

    public boolean inCooldown(String player) {

        if(cooldown.containsKey(player)) {
            return true;
        } else {
            cooldown.put(player, 1);
            (new BukkitRunnable() {
                public void run() {
                    cooldown.remove(player);
                }
            }).runTaskLater(this, 20L * config.cdDuration);
            return false;
        }

    }

}
