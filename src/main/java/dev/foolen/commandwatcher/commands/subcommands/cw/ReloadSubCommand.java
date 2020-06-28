package dev.foolen.commandwatcher.commands.subcommands.cw;

import dev.foolen.commandwatcher.CommandWatcher;
import dev.foolen.commandwatcher.commands.subcommands.SubCommand;
import dev.foolen.commandwatcher.utils.Messenger;
import org.bukkit.entity.Player;

public class ReloadSubCommand implements SubCommand {
    @Override
    public void execute(Player player, String[] args) {
        if (player.hasPermission("commandwatcher.reload") || player.isOp()) {
            CommandWatcher.instance.reloadConfiguration();
            Messenger.informPlayer(player, "Configuration has been reloaded.");
        } else {
            Messenger.informPlayer(player, "&cYou do not have permission to execute this command.");
        }
    }
}
