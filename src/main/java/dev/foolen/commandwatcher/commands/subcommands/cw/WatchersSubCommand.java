package dev.foolen.commandwatcher.commands.subcommands.cw;

import dev.foolen.commandwatcher.CommandWatcher;
import dev.foolen.commandwatcher.commands.subcommands.SubCommand;
import dev.foolen.commandwatcher.utils.Messenger;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class WatchersSubCommand implements SubCommand {
    @Override
    public void execute(Player player, String[] args) {
        if (player.hasPermission("commandwatcher.watchers") || player.isOp()) {
            ArrayList<Player> watchers = CommandWatcher.instance.getWatchers();

            if (watchers.size() > 0) {
                StringBuilder watchingPlayers = new StringBuilder();
                for (int i=0; i<watchers.size(); i++) {
                    if (i != 0) watchingPlayers.append(", ");
                    watchingPlayers.append(watchers.get(i).getName());
                }
                Messenger.informPlayer(player, "Currently, the following players are watching commands: ");
                Messenger.informPlayer(player, "&f" + watchingPlayers.toString() + ".");
            } else {
                Messenger.informPlayer(player, "There are currently no players watching commands.");
            }
        } else {
            Messenger.informPlayer(player, "&cYou do not have permission to execute this command.");
        }
    }
}
