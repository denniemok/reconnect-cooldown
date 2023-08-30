package com.battleasya.reconnectcooldown.handler;

import com.battleasya.reconnectcooldown.ReconnectCooldown;
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
    public void onJoin(AsyncPlayerPreLoginEvent event) {

        String playerName = event.getName();

        if (plugin.inCooldown(playerName)) {
            event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, ChatColor.translateAlternateColorCodes('&', plugin.config.kickMessage));
        }

    }

}
