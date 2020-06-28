package dev.foolen.commandwatcher.listeners.events;

import dev.foolen.commandwatcher.CommandWatcher;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class OnQuitEventListener implements Listener {
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();

        if (player.hasPermission("commandwatcher.watch") || player.isOp()) {
            CommandWatcher.instance.removeWatcher(player.getUniqueId());
        }
    }
}
