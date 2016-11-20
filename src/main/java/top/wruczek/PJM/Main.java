package top.wruczek.PJM;

import java.io.File;

import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    static Main instance;
    static String prefix;

    public void onEnable() {
        instance = this;
        prefix = colorString("&8[&6PJM&8] &8");

        this.saveDefaultConfig();

        if(this.getConfig().getInt("CFGVER", 0) != 1.0) {
            System.out.println("[PlayerJoinMessage] Restoring default config file!");

            new File(this.getDataFolder() + "/config.yml").renameTo(new File(this.getDataFolder() + "/config.old.yml"));
            this.saveResource("config.yml", true);
        }

        this.getServer().getPluginManager().registerEvents(new Listeners(), this);
        this.getCommand("playerjoinmessage").setExecutor(new Commands());
    }

    public static String colorString(String string) {

        if (string == null)
            return string;

        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public static String getColoredMessage(String path) {
        return colorString(Main.instance.getConfig().getString(path));
    }
}
