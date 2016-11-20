package top.wruczek.PJM;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commands implements CommandExecutor {

    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {

        if (args.length != 1) {
            sender.sendMessage(Main.colorString("&aPlayerJoinMessage by &6Wruczek&a and &6NizarZa123&a. Version &6" + Main.instance.getDescription().getVersion()));

            sender.sendMessage(Main.colorString("&7http://dev.bukkit.org/bukkit-plugins/messagejoinplayer/"));
            sender.sendMessage(Main.colorString("&eType &6/pjm reload&e to reload the config\n&8(&7permission: playerjoinmessage.reload&8)"));
            return false;
        }

        if (!sender.hasPermission("playerjoinmessage.reload")) {
            sender.sendMessage(Main.prefix + ChatColor.RED + "You don't have access to this command.");
        } else {
            Main.instance.reloadConfig();
            sender.sendMessage(Main.prefix + ChatColor.GREEN + "Configuration reloaded.");
        }

        return false;
    }

}
