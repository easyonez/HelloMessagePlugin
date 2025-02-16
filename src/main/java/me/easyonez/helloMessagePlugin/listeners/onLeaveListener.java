package me.easyonez.helloMessagePlugin.listeners;

import me.easyonez.helloMessagePlugin.HelloMessagePlugin;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class onLeaveListener  implements Listener {

    //Those two are needed to get the isItEnabledFlag from the instance of the plugin
    private final HelloMessagePlugin plugin;
    public onLeaveListener(HelloMessagePlugin plugin) {
        this.plugin = plugin;
    }


     @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        if(plugin.isItEnabledFlag()) {
            Player player = e.getPlayer();
            e.setQuitMessage(ChatColor.RED + "The player " + ChatColor.YELLOW + player.getName() + ChatColor.RED + " has left the game!");
        }
    }
}
