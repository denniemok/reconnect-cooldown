package com.battleasya.Cmd;

import com.battleasya.ReconnectCooldown;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class rcreload implements CommandExecutor {

    private final ReconnectCooldown plugin;

    public rcreload(ReconnectCooldown plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (!sender.hasPermission("reconnectcooldown.reload")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.noPermission));
        } else {
            plugin.reloadConfig();
            plugin.config.fetchConfig();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.reloadConfig));
        }

        return true;

    }

}
