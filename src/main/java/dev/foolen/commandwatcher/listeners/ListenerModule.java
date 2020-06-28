package dev.foolen.commandwatcher.listeners;

import dev.foolen.commandwatcher.CommandWatcher;
import dev.foolen.commandwatcher.listeners.events.OnCommandEventListener;
import dev.foolen.commandwatcher.listeners.events.OnJoinEventListener;
import dev.foolen.commandwatcher.listeners.events.OnQuitEventListener;
import org.bukkit.plugin.PluginManager;

public class ListenerModule {
    public ListenerModule() {
        CommandWatcher plugin = CommandWatcher.instance;
        PluginManager pm = plugin.getServer().getPluginManager();

        pm.registerEvents(new OnCommandEventListener(), plugin);
        pm.registerEvents(new OnJoinEventListener(), plugin);
        pm.registerEvents(new OnQuitEventListener(), plugin);
    }
}
