package dev.foolen.commandwatcher.commands.executors;

import dev.foolen.commandwatcher.commands.subcommands.SubCommand;
import dev.foolen.commandwatcher.commands.subcommands.cw.*;
import dev.foolen.commandwatcher.utils.Messenger;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.HashMap;

public class CommandwatcherCommand implements CommandExecutor {
    private HashMap<String, SubCommand> subCommands = new HashMap<>();;

    public CommandwatcherCommand() {
        subCommands.put("toggle", new ToggleSubCommand());
        subCommands.put("help", new HelpSubCommand());
        subCommands.put("ignored", new IgnoredSubCommand());
        subCommands.put("reload", new ReloadSubCommand());
        subCommands.put("watchers", new WatchersSubCommand());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be executed by a player.");
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            Messenger.informPlayer(player, "No command specified. See &b/cw help&3 for a list of all commands.");
            return true;
        }

        if (!subCommands.containsKey(args[0])) {
            Messenger.informPlayer(player, "Command not found. See &b/cw help&3 for a list of all commands.");
            return true;
        }

        subCommands.get(args[0]).execute(player, Arrays.copyOfRange(args, 1, args.length));
        return true;
    }
}
