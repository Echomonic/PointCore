package dev.echo.pointcore;

import dev.echo.pointcore.commands.CommandPoints;
import dev.echo.pointcore.events.JoinEvent;
import dev.echo.pointcore.events.KillEvent;
import dev.echo.pointcore.managers.FileManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class PointCore extends JavaPlugin {

    private FileManager fileManager;

    @Override
    public void onEnable() {

        this.fileManager = new FileManager(this);

        Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
        Bukkit.getPluginManager().registerEvents(new KillEvent(), this);
        getCommand("points").setExecutor(new CommandPoints());
        getCommand("points").setTabCompleter(new CommandPoints());
    }

    @Override
    public void onDisable() {

    }

    public static PointCore getInstance(){
        return PointCore.getPlugin(PointCore.class);
    }

    public FileManager getFileManager() {
        return fileManager;
    }
}
