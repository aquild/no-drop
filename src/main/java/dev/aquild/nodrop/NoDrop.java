package dev.aquild.nodrop;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class NoDrop extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Config
        this.saveDefaultConfig();

        // Register Events
        this.getServer().getPluginManager().registerEvents(new DropListener(this), this);

        this.getLogger().info("No Drop by Aquild Loaded!");
    }

}
