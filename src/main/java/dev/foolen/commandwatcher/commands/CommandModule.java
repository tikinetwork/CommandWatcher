package dev.foolen.commandwatcher.commands;

import dev.foolen.commandwatcher.CommandWatcher;
import dev.foolen.commandwatcher.commands.executors.CommandwatcherCommand;

public class CommandModule {
    public CommandModule() {
        CommandWatcher plugin = CommandWatcher.instance;

        plugin.getCommand("cw").setExecutor(new CommandwatcherCommand());
    }
}
