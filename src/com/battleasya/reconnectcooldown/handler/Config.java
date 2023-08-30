package com.battleasya.reconnectcooldown.handler;

import com.battleasya.reconnectcooldown.ReconnectCooldown;
import org.bukkit.configuration.file.FileConfiguration;

public class Config {

    private final ReconnectCooldown plugin;

    public Config(ReconnectCooldown plugin) {
        this.plugin = plugin;
    }

    public String kickMessage;

    public int cdDuration;

    public String reloadConfig;

    public String noPermission;

    public void fetchConfig() {

        FileConfiguration config = plugin.getConfig();

        kickMessage = config.getString("kick-message");
        cdDuration = config.getInt("cd-duration");
        reloadConfig = config.getString("reload-config");
        noPermission = config.getString("no-permission");

    }

}
