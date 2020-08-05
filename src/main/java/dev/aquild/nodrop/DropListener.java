package dev.aquild.nodrop;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class DropListener implements Listener {
    private final JavaPlugin plugin;

    public DropListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDrop(PlayerDropItemEvent event) {
        if (event.isCancelled()) return;

        ItemStack itemStack = event.getItemDrop().getItemStack();

        String name = "";
        try {
            name = itemStack.getItemMeta().getDisplayName();
        } catch (NullPointerException e) {}

        String type = itemStack.getType().name().toLowerCase();

        List<String> frozenTypes = this.plugin.getConfig().getStringList("frozen-items");
        List<String> frozenNames = this.plugin.getConfig().getStringList("frozen-item-names");

        event.setCancelled(frozenNames.contains(name) | frozenTypes.contains(type));
    }
}
