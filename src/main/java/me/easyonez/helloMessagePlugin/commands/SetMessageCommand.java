package me.easyonez.helloMessagePlugin.commands;

import me.easyonez.helloMessagePlugin.HelloMessagePlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetMessageCommand implements CommandExecutor {

    private HelloMessagePlugin plugin;

    public SetMessageCommand(HelloMessagePlugin plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player player) {
            if(strings.length == 0) {
                player.sendMessage(plugin.getPrefix() + ChatColor.RED + "Usage: /setmessage [join|leave] <message>");
                player.sendMessage(plugin.getPrefix() + ChatColor.RED + "Use %player% in message to display player's name.");
                return true;
            } else {
                if(strings[0].equalsIgnoreCase("join") || strings[0].equalsIgnoreCase("leave")) {
                    strings[0] = strings[0].toLowerCase();
                    StringBuilder message = new StringBuilder();
                    for(int i = 1; i < strings.length; i++) {
                        message.append(strings[i]).append(" ");
                    }
                    String finalMessage = message.toString();
                    plugin.getConfig().set("message."+strings[0]+"-message",finalMessage);
                    plugin.saveConfig();
                            if(strings.length == 1) {
                                player.sendMessage(plugin.getPrefix() + ChatColor.RED + "The " + strings[0] + " message has been disabled.");
                                if(!plugin.isItEnabledFlag()) {
                                    player.sendMessage(plugin.getPrefix() + ChatColor.RED + "The HelloMessagePlugin is disabled! /flag true to enable it.");
                                }
                            } else {
                                player.sendMessage(plugin.getPrefix() + ChatColor.GREEN + "The " + strings[0] + " message has been correctly set.");
                                if(!plugin.isItEnabledFlag()) {
                                    player.sendMessage(plugin.getPrefix() + ChatColor.RED + "The HelloMessagePlugin is disabled! /flag true to enable it.");
                                }
                            }
                }  else {
                    player.sendMessage(plugin.getPrefix() + ChatColor.RED + "Usage: /setmessage [join|leave] <message>");
                    player.sendMessage(plugin.getPrefix() + ChatColor.RED + "Use %player% in message to display player's name.");
                    return true;
                }
            }
        }
        return true;
    }
}

