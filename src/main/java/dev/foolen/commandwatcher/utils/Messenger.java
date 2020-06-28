package dev.foolen.commandwatcher.utils;

import dev.foolen.commandwatcher.CommandWatcher;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Messenger {
    public static void informPlayer(Player player, String message) {
        player.sendMessage(CommandWatcher.PREFIX + ChatColor.translateAlternateColorCodes('&', message));
    }

    private static final String CONSOLE_PREFIX = "[CommandWatcher]";

    public static void logInfo(String message) {
        System.out.println(CONSOLE_PREFIX + "[Info] " + message);
    }

    public static void logWarning(String message) {
        System.out.println(CONSOLE_PREFIX + "[Warning] " + message);
    }

    public static void logError(String message) {
        System.out.println(CONSOLE_PREFIX + "[Error] " + message);
    }
}
