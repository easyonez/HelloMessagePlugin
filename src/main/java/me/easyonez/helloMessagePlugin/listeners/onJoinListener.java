package me.easyonez.helloMessagePlugin.listeners;

import me.easyonez.helloMessagePlugin.HelloMessagePlugin;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Objects;

public class onJoinListener implements Listener {

    //Those two are needed to get the isItEnabledFlag from the instance of the plugin
    private final HelloMessagePlugin plugin;
    public onJoinListener(HelloMessagePlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if(plugin.isItEnabledFlag()) {
            Player player = e.getPlayer();
            String JoinMessage = Objects.requireNonNull(plugin.getConfig().getString("message.join-message")).replace("%player%", player.getName());
            JoinMessage = ChatColor.translateAlternateColorCodes('&', JoinMessage);
            e.setJoinMessage(JoinMessage);
        }
    }

}
