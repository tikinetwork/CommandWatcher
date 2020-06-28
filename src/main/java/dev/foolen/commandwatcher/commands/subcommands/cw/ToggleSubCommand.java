package dev.foolen.commandwatcher.commands.subcommands.cw;

import dev.foolen.commandwatcher.CommandWatcher;
import dev.foolen.commandwatcher.commands.subcommands.SubCommand;
import dev.foolen.commandwatcher.utils.Messenger;
import org.bukkit.entity.Player;

public class ToggleSubCommand implements SubCommand {
    @Override
    public void execute(Player player, String[] args) {
        if (player.hasPermission("commandwatcher.watch") || player.isOp()) {
            CommandWatcher plugin = CommandWatcher.instance;

            if (plugin.hasWatcher(player.getUniqueId())) {
                plugin.removeWatcher(player.getUniqueId());
                Messenger.informPlayer(player, "You no longer watch commands.");
            } else {
                plugin.addWatcher(player);
                Messenger.informPlayer(player, "You are now watching all player executed commands.");
            }
        } else {
            Messenger.informPlayer(player, "&cYou do not have permission to execute this command.");
        }
    }
}
