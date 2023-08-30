package com.battleasya.reconnectcooldown.handler;

import com.battleasya.reconnectcooldown.ReconnectCooldown;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class PreLogin implements Listener {

    private final ReconnectCooldown plugin;

    public PreLogin(ReconnectCooldown plugin) {
        this.plugin = plugin;
    }

    public HashMap<String, Integer> cooldown = new HashMap<>();

    @EventHandler
    public void onJoin(AsyncPlayerPreLoginEvent event) {

        String playerName = event.getName();

        if (inCooldown(playerName)) {
            event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, ChatColor.translateAlternateColorCodes('&', plugin.config.kickMessage));
        }

    }

    public boolean inCooldown(String player) {

        if (cooldown.containsKey(player)) {
            return true;
        } else {
            cooldown.put(player, 1);
            (new BukkitRunnable() {
                public void run() {
                    cooldown.remove(player);
                }
            }).runTaskLater(plugin, 20L * plugin.config.cdDuration);
            return false;
        }

    }

}
