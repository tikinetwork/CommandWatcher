package dev.foolen.commandwatcher.listeners.events;

import dev.foolen.commandwatcher.CommandWatcher;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnJoinEventListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        if (player.hasPermission("commandwatcher.watch") || player.isOp()) {
            CommandWatcher.instance.addWatcher(player);
        }
    }
}
