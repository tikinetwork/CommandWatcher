package dev.foolen.commandwatcher;

import dev.foolen.commandwatcher.commands.CommandModule;
import dev.foolen.commandwatcher.listeners.ListenerModule;
import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public final class CommandWatcher extends JavaPlugin {

    public static final String PREFIX = ChatColor.translateAlternateColorCodes('&', "§3[§bCW§3] ");

    public static CommandWatcher instance;
    private HashMap<UUID, Player> watchers;
    private List<String> ignoredCommands;

    @Override
    public void onEnable() {
        instance = this;

        // Configuration
        createConfig();
        loadConfig();

        // Initialize variables
        watchers = new HashMap<>();

        // Load modules
        new ListenerModule();
        new CommandModule();
    }

    @Override
    public void onDisable() {
        watchers.clear();
        ignoredCommands.clear();
    }

    public List<String> getIgnoredCommands() {
        return ignoredCommands;
    }

    public ArrayList<Player> getWatchers() {
        return new ArrayList<>(watchers.values());
    }

    public void addWatcher(Player player) {
        watchers.put(player.getUniqueId(), player);
    }

    public boolean hasWatcher(UUID uuid) {
        return watchers.containsKey(uuid);
    }

    public void removeWatcher(UUID uuid) {
        watchers.remove(uuid);
    }

    private void createConfig() {
        try {
            if (!getDataFolder().exists()) {
                getDataFolder().mkdirs();
            }
            File file = new File(getDataFolder(), "config.yml");
            if (!file.exists()) {
                getLogger().info("Config.yml not found, creating!");
                saveDefaultConfig();
            } else {
                getLogger().info("Config.yml found, loading!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadConfig() {
        ignoredCommands = getConfig().getStringList("ignored");
    }

    public void reloadConfiguration() {
        reloadConfig();
        loadConfig();
    }
}
