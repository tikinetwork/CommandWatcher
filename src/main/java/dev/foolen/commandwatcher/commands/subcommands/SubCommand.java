package dev.foolen.commandwatcher.commands.subcommands;

import org.bukkit.entity.Player;

public interface SubCommand {
    void execute(Player player, String[] args);
}
