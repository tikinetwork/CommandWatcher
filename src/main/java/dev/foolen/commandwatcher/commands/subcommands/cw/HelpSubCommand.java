package dev.foolen.commandwatcher.commands.subcommands.cw;

import dev.foolen.commandwatcher.commands.subcommands.SubCommand;
import dev.foolen.commandwatcher.utils.Messenger;
import org.bukkit.entity.Player;

public class HelpSubCommand implements SubCommand {
    @Override
    public void execute(Player player, String[] args) {
        Messenger.informPlayer(player, "&3&l-=-=-=- &b&lCommandWatcher - Help &3&l-=-=-=-");
        Messenger.informPlayer(player, "&b/cw help &3- &7Shows this list.");
        Messenger.informPlayer(player, "&b/cw ignored &3- &7List all ignored commands.");
        Messenger.informPlayer(player, "&b/cw reload &3- &7Reload configuration file.");
        Messenger.informPlayer(player, "&b/cw toggle &3- &7Toggle watching commands.");
        Messenger.informPlayer(player, "&b/cw watchers &3- &7List all watchers.");
        Messenger.informPlayer(player, "");
        Messenger.informPlayer(player, "Created with ❤ by tjeufoolen.");
        Messenger.informPlayer(player, "&3&l-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    }
}
