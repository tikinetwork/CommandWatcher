# CommandWatcher
Basic command watcher plugin for spigot 1.20

## Screenshot
![](https://raw.githubusercontent.com/tikinetwork/CommandWatcher/master/screenshot.png)

## Getting Started
1. Download the latest release.
2. Copy the .jar to your server `plugins` folder.
3. Restart/Reload your server.
4. [Optional] Add commands to the ignored section in the `plugins\CommandWatcher\config.yml`.
5. Restart/Reload your server.
6. Relog or use `/cw toggle` to start listening for commands! :tada:

## Commands
| Command                  | Description                 |
|--------------------------|-----------------------------|
| `/cw help` | Shows a list of all commands. |
| `/cw ignored` | List all ignored commands. |
| `/cw reload` | Reload configuration file. |
| `/cw toggle` | Toggle watching commands. |
| `/cw watchers` | List all watchers. |

## Permissions
| Permission               | Description                 |
|--------------------------|-----------------------------|
| `commandwatcher.ignored` | Grants access to /cw ignored command. |
| `commandwatcher.reload` | Grants access to /cw reload command. |
| `commandwatcher.watch` | Grants access to watch player executed commands. |
| `commandwatcher.watchers` | Grants access to /cw watchers command. |

## Config.yml
```
"ignored": ["help", "plugins"]
```

## Authors:
- [Tjeu Foolen](https://github.com/tjeufoolen)
