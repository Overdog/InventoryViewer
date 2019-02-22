package me.overdog.invsee.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.overdog.invsee.Core;

public class CommandInvSee implements CommandExecutor
{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
	    if (!(sender instanceof Player)) 
	    {
	    	System.out.print("This command can only be used in game!");
		  return true;
	    }
	    
	    Player player = (Player) sender;
	    
	    if (!player.hasPermission("invsee.view"))
	    {
	      player.sendMessage(ChatColor.RED + "You don't have proper permissions to use this command!");
	      return true;
	    }
	    
	    if (args.length != 1)
	    {
	      player.sendMessage(ChatColor.RED + "Your arguments for this command are invalid! Do /invsee <Name>!");
	      return true;
	    }
	    
	    Player target = Bukkit.getPlayer(args[0]);
	    
	    if (target == null)
	    {
	      player.sendMessage(ChatColor.RED + "That player isn't online at the moment.");
	      return true;
	    }
	    
	    Core.ingui.add(player.getUniqueId());
	    player.openInventory(target.getInventory());
	      return true;
	  }
}
