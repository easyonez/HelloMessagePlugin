package me.easyonez.helloMessagePlugin.listeners;

import me.easyonez.helloMessagePlugin.HelloMessagePlugin;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

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
            e.setJoinMessage(ChatColor.GREEN + "The player " + ChatColor.YELLOW + player.getName() + ChatColor.GREEN + " has joined the game!");
        }
    }

}
