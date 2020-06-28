package dev.foolen.commandwatcher.listeners.events;

import dev.foolen.commandwatcher.CommandWatcher;
import dev.foolen.commandwatcher.utils.Messenger;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class OnCommandEventListener implements Listener {
    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        Player sender = e.getPlayer();

        // Hide command if ignored
        if (CommandWatcher.instance.getConfig().getStringList("ignored").contains(e.getMessage().split(" ")[0])) return;

        // Show command to watchers
        for (Player watcher : CommandWatcher.instance.getWatchers()) {
            // Hide command if sender is same player as watcher
            if (watcher.getName().equals(sender.getName())) continue;

            // Show command to watchers
            Messenger.informPlayer(watcher, sender.getName() + ": &7" + e.getMessage());
        }
    }
}
