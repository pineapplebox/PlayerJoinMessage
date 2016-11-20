package top.wruczek.PJM;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Listeners implements Listener {

    @EventHandler
    public void join(final PlayerJoinEvent event) {
        event.setJoinMessage(getMessage(event));
    }

    @EventHandler
    public void quit(final PlayerQuitEvent event) {
        event.setQuitMessage(getMessage(event));
    }

    private String getMessage(PlayerEvent event) {
        boolean isVIP = event.getPlayer().hasPermission("playerjoinmessage.vip");
        boolean isJoinEvent = event instanceof PlayerJoinEvent;

        String newMessage = Main.getColoredMessage((isVIP ? "VIP" : "Default") + "." + (isJoinEvent ? "Join" : "Leave"));

        if (newMessage != null)
            newMessage = newMessage.replace("%player%", event.getPlayer().getName());

        return newMessage;
    }

}
