package dev.echo.pointcore.events;

import dev.echo.pointcore.PointCore;
import net.minecraft.server.v1_16_R3.PacketPlayOutGameStateChange;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KillEvent implements Listener {

    @EventHandler
    public void onKill(PlayerDeathEvent event){

        Player player = event.getEntity().getPlayer();

        Player killer = event.getEntity().getKiller();


        int[] amount = new int[] {0,1,2,3,4,5};


        int random = new Random().nextInt(amount.length);

        player.spigot().respawn();

        PointCore.getInstance().getFileManager().setPoints(killer, PointCore.getInstance().getFileManager().getPoints(killer) + random);
        killer.sendMessage(ChatColor.YELLOW + "You have been given "
                + ChatColor.AQUA + ChatColor.BOLD + random + ChatColor.RESET + ChatColor.YELLOW + " points!");
        event.setKeepInventory(false);
        event.setDeathMessage( "");
    }

}
