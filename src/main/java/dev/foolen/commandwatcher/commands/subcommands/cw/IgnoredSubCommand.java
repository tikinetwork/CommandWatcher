package dev.foolen.commandwatcher.commands.subcommands.cw;

import dev.foolen.commandwatcher.CommandWatcher;
import dev.foolen.commandwatcher.commands.subcommands.SubCommand;
import dev.foolen.commandwatcher.utils.Messenger;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class IgnoredSubCommand implements SubCommand {
    @Override
    public void execute(Player player, String[] args) {
        if (player.hasPermission("commandwatcher.ignored") || player.isOp()) {
            List<String> ignoredCommands = CommandWatcher.instance.getIgnoredCommands();

            if (ignoredCommands.size() > 0) {
                StringBuilder ignoredCommandsStr = new StringBuilder();
                for (int i=0; i<ignoredCommands.size(); i++) {
                    if (i != 0) ignoredCommandsStr.append(", ");
                    ignoredCommandsStr.append(ignoredCommands.get(i));
                }
                Messenger.informPlayer(player, "Currently, the following commands are ignored: ");
                Messenger.informPlayer(player, "&f" + ignoredCommandsStr.toString() + ".");
            } else {
                Messenger.informPlayer(player, "There are currently no commands ignored.");
            }
        } else {
            Messenger.informPlayer(player, "&cYou do not have permission to execute this command.");
        }
    }
}
