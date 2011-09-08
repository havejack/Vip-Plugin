package me.havejack.plugins.vip;

import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Vip extends JavaPlugin {
    private PlayerListener playerlistener = new VIPPlayerListener();
            public void onDisable() {
        // TODO: Place any custom disable code here.
        System.out.println(this + " is now disabled!");
    }

    public void onEnable() {
        // TODO: Place any custom enable code here, such as registering events
        getServer().getPluginManager().registerEvent(Type.PLAYER_MOVE, playerlistener, null, Priority.Highest, this);
        System.out.println(this + " is now enabled!");
    }
}
