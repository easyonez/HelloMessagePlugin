package me.easyonez.helloMessagePlugin.commands;

import me.easyonez.helloMessagePlugin.HelloMessagePlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlagCommand implements CommandExecutor {

    HelloMessagePlugin plugin; //Instance of the plugin

    public FlagCommand(HelloMessagePlugin plugin) {
        this.plugin = plugin;
    }


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        //Check if the sender is a player
        if(sender instanceof Player) {
            Player player =  (Player) sender;
            if(args.length != 1) {  //Check if there is the good number of arguments after the command
                player.sendMessage(ChatColor.RED + "Usage: /flag [true|false]");
            } else {
                if(args[0].equalsIgnoreCase("true")) {
                    if(plugin.getConfig().getBoolean("PluginEnabled") == true) {
                        player.sendMessage(ChatColor.RED + "It's already enabled.");
                    } else {
                        plugin.setItEnabledFlag(true);
                        plugin.getConfig().set("PluginEnabled", true);
                        plugin.saveConfig();
                        player.sendMessage(ChatColor.GREEN + "You have set the plugin HelloMessagePlugin to true.");
                    }
                } else if(args[0].equalsIgnoreCase("false")) {
                    if(plugin.getConfig().getBoolean("PluginEnabled") == false) {
                        player.sendMessage(ChatColor.RED + "It's already disabled.");
                    } else {
                    plugin.setItEnabledFlag(false);
                    plugin.getConfig().set("PluginEnabled", false);
                    plugin.saveConfig();
                    player.sendMessage(ChatColor.RED + "You have set the plugin HelloMessagePlugin to false.");
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "Usage: /flag [true|false]");
                }
            }
            }


        else { //If sender is not a player
            if(args.length != 1) { //Check if there is the good number of arguments after the command
                System.out.println("Usage: /flag [true|false]");
            } else {
                if(args[0].equalsIgnoreCase("true")) {
                    if(plugin.getConfig().get("itEnabledFlag") == "true") {

                    }
                    plugin.setItEnabledFlag(true);
                    plugin.getConfig().set("itEnabledFlag", true);
                    plugin.saveConfig();
                    System.out.println("You have set the plugin HelloMessagePlugin to true.");
                } else if(args[0].equalsIgnoreCase("false")) {
                    plugin.setItEnabledFlag(false);
                    plugin.getConfig().set("itEnabledFlag", false);
                    plugin.saveConfig();
                    System.out.println("You have set the plugin HelloMessagePlugin to false.");
                } else {
                    System.out.println("Usage: /flag [true|false]");
                }
            }
        }



        return true;
    }
}
