package com.battleasya.Handler;

import com.battleasya.ReconnectCooldown;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

public class PreLogin implements Listener {

    private final ReconnectCooldown plugin;

    public PreLogin(ReconnectCooldown plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(AsyncPlayerPreLoginEvent e) {

        String playerName = e.getName();

        if (plugin.inCooldown(playerName)) {
            e.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, ChatColor.translateAlternateColorCodes('&', plugin.config.kickMessage));
        }

    }

}
