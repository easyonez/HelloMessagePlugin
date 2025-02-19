package me.easyonez.helloMessagePlugin;

import me.easyonez.helloMessagePlugin.commands.FlagCommand;
import me.easyonez.helloMessagePlugin.commands.SetMessageCommand;
import me.easyonez.helloMessagePlugin.listeners.onJoinListener;
import me.easyonez.helloMessagePlugin.listeners.onLeaveListener;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class HelloMessagePlugin extends JavaPlugin {


    private boolean isItEnabledFlag; //Flag that is loaded from file (or changed in-game by command /flag "boolean")
    private String prefix = ChatColor.WHITE + "[" + ChatColor.GREEN + "HMP" + ChatColor.WHITE + "] ";
    //Get isItEnabledFlag
    public boolean isItEnabledFlag() {
        return isItEnabledFlag;
    }
    public String getPrefix() {
        return prefix;
    }
    //Set isItEnabledFlag
    public void setItEnabledFlag(boolean itEnabledFlag) {
        isItEnabledFlag = itEnabledFlag;
    }


    @Override
    public void onEnable() {
        // Plugin startup logic

        //Instance of this plugin
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        setItEnabledFlag(getConfig().getBoolean("PluginEnabled"));
        Objects.requireNonNull(getCommand("flag")).setExecutor(new FlagCommand(this));   //Registers flag command
        Objects.requireNonNull(getCommand("setmessage")).setExecutor(new SetMessageCommand(this));   //Registers setmessage command


        //Registers two event listeners, in this case onJoinListener and onLeaveListener
        getServer().getPluginManager().registerEvents(new onJoinListener(this), this);
        getServer().getPluginManager().registerEvents(new onLeaveListener(this), this);


        //AJMAIME Display
        System.out.println(                                                                                              );
        System.out.println("                     ,---._            ____                                  ____             ");
        System.out.println("   ,---,           .-- -.' \\         ,'  , `.   ,---,         ,---,        ,'  , `.    ,---,. ");
        System.out.println("  '  .' \\          |    |   :     ,-+-,.' _ |  '  .' \\     ,`--.' |     ,-+-,.' _ |  ,'  .' | ");
        System.out.println(" /  ;    '.        :    ;   |  ,-+-. ;   , || /  ;    '.   |   :  :  ,-+-. ;   , ||,---.'   | ");
        System.out.println(":  :       \\       :        | ,--.'|'   |  ;|:  :       \\  :   |  ' ,--.'|'   |  ;||   |   .' ");
        System.out.println(":  |   /\\   \\      |    :   :|   |  ,', |  '::  |   /\\   \\ |   :  ||   |  ,', |  '::   :  |-, ");
        System.out.println("|  :  ' ;.   :     :         |   | /  | |  |||  :  ' ;.   :'   '  ;|   | /  | |  ||:   |  ;/| ");
        System.out.println("|  |  ;/  \\   \\    |    ;   |'   | :  | :  |,|  |  ;/  \\   \\   |  |'   | :  | :  |,|   :   .' ");
        System.out.println("'  :  | \\  \\ ,'___ l         ;   . |  ; |--' '  :  | \\  \\ ,'   :  ;;   . |  ; |--' |   |  |-, ");
        System.out.println("|  |  '  '--'/    /\\    J   :|   : |  | ,    |  |  '  '--' |   |  '|   : |  | ,    '   :  ;/| ");
        System.out.println("|  :  :     /  ../  `..-    ,|   : '  |/     |  :  :       '   :  ||   : '  |/     |   |    \\ ");
        System.out.println("|  | ,'     \\    \\         ; ;   | |`-'      |  | ,'       ;   |.' ;   | |`-'      |   :   .' ");
        System.out.println("`--''        \\    \\      ,'  |   ;/          `--''         '---'   |   ;/          |   | ,'   ");
        System.out.println("              \"---....--'    '---'                                 '---'           `----'     ");
        System.out.println(                                                                                              );
        //

    }



    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
