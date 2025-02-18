package me.easyonez.helloMessagePlugin;

import me.easyonez.helloMessagePlugin.commands.FlagCommand;
import me.easyonez.helloMessagePlugin.listeners.onJoinListener;
import me.easyonez.helloMessagePlugin.listeners.onLeaveListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class HelloMessagePlugin extends JavaPlugin {

    private static HelloMessagePlugin plugin;    //Instance of this plugin


    private boolean isItEnabledFlag; //Flag that is loaded from file (or changed in-game by command /flag "boolean")

    //get_instance return the instance of the current plugin
    HelloMessagePlugin get_instance() {
        return plugin;
    }

    //Get isItEnabledFlag
    public boolean isItEnabledFlag() {
        return isItEnabledFlag;
    }
    //Set isItEnabledFlag
    public void setItEnabledFlag(boolean itEnabledFlag) {
        isItEnabledFlag = itEnabledFlag;
    }


    @Override
    public void onEnable() {
        // Plugin startup logic

        plugin = this;  //Instance of this plugin
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        setItEnabledFlag(getConfig().getBoolean("itEnabled"));
        getCommand("flag").setExecutor(new FlagCommand(this));   //Registers flag command


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
