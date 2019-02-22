package me.overdog.invsee.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import me.overdog.invsee.Core;
import me.overdog.invsee.utils.UtilOp;

public class CustomInventoryClickEvent implements Listener 
{

	@EventHandler
	public void onClickEvent(InventoryClickEvent event)
	{
		if (Core.ingui.contains(event.getWhoClicked().getUniqueId()))
		{
			if (Core.config.getBoolean("require-permission-for-take")) 
			{
				if (!event.getWhoClicked().hasPermission("invsee.take") || UtilOp.isOp((Player) event.getWhoClicked()))
				{
					event.setCancelled(true);
					event.getWhoClicked().closeInventory();
					event.getWhoClicked().sendMessage(ChatColor.RED + "You don't have proper permissions to use this ability! You can only view inventories.");
					return;
				} else
				{
					event.getWhoClicked().sendMessage(ChatColor.GREEN + "You took " + event.getCurrentItem().getItemMeta().getDisplayName().toUpperCase() + " from that player's inventory.");
					return;
				}
			} else 
			{
				
			}
			event.getWhoClicked().sendMessage(ChatColor.GREEN + "You took " + event.getCurrentItem().getItemMeta().getDisplayName().toUpperCase() + " from that player's inventory.");
			return;
		}
	}
}
