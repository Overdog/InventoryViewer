package me.overdog.invsee;
 
import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.overdog.invsee.commands.CommandInvSee;
import me.overdog.invsee.listeners.CustomInventoryClickEvent;
 
public class Core extends JavaPlugin
{
	public static JavaPlugin plugin;
	public static FileConfiguration config;
	
	public static ArrayList<UUID> ingui = new ArrayList<UUID>();
	@Override
	public void onEnable()
	{
		plugin = this;
	    config = new YamlConfiguration();
		this.saveDefaultConfig();
		PluginManager pm = Bukkit.getPluginManager();
		if (config.getBoolean("disable-startup-message")) 
		{
		Bukkit.getLogger().log(Level.INFO, "Hello there! My name is Overdog and I developed InventoryViewer. This is an advertisement in your console. If you'd like, I can remove this message from your plugin, as it does get quite annoying.");
		Bukkit.getLogger().log(Level.INFO, "Taking time away from server development may seem bad, however, just a quick minute of your time will help me. No cash required.");
		Bukkit.getLogger().log(Level.INFO, "I own a Youtube channel named Overdog. I used to upload content, however view counts slowed. If you could just spend a minute and subscribe to me, it will be appreciated.");
		Bukkit.getLogger().log(Level.INFO, "");
		Bukkit.getLogger().log(Level.INFO, "Channel Link: https://www.youtube.com/c/overdog");
		Bukkit.getLogger().log(Level.INFO, "");
		Bukkit.getLogger().log(Level.INFO, "Thank you for your time. Now, let me start your plugin.");
		}
		pm.registerEvents(new CustomInventoryClickEvent(), this);
        getCommand("invsee").setExecutor(new CommandInvSee());
	}
 
	@Override
	public void onDisable()
	{
		if (config.getBoolean("disable-startup-message")) 
		{
		Bukkit.getLogger().log(Level.INFO, "Hello there! My name is Overdog and I developed InventoryViewer. This is an advertisement in your console. If you'd like, I can remove this message from your plugin, as it does get quite annoying.");
		Bukkit.getLogger().log(Level.INFO, "Taking time away from server development may seem bad, however, just a quick minute of your time will help me. No cash required.");
		Bukkit.getLogger().log(Level.INFO, "I own a Youtube channel named Overdog. I used to upload content, however view counts slowed. If you could just spend a minute and subscribe to me, it will be appreciated.");
		Bukkit.getLogger().log(Level.INFO, "");
		Bukkit.getLogger().log(Level.INFO, "Channel Link: https://www.youtube.com/c/overdog");
		Bukkit.getLogger().log(Level.INFO, "");
		Bukkit.getLogger().log(Level.INFO, "Thank you for your time. Now, let me stop your plugin.");
		}
	}
}