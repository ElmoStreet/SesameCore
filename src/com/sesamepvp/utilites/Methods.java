package com.sesamepvp.utilites;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class Methods {

	public static ArrayList<Player> vanish = new ArrayList<Player>();
	public static ArrayList<Player> fly = new ArrayList<Player>();

	public static void clearArmor(Player p) {
		PlayerInventory pi = p.getInventory();
		pi.setBoots(new ItemStack(Material.AIR));
		pi.setChestplate(new ItemStack(Material.AIR));
		pi.setHelmet(new ItemStack(Material.AIR));
		pi.setLeggings(new ItemStack(Material.AIR));
		return;
	}

	public static String format(String format){
		return ChatColor.translateAlternateColorCodes('&', format);
		}
	
	
	public static void giveItems(Player p) {
		p.getInventory().clear();
		clearArmor(p);
		
		
		// Freeze Block
		ItemStack iceblock = new ItemStack(Material.ICE, 1);
		ItemMeta iceblockim = iceblock.getItemMeta();
		ArrayList<String> icelore = new ArrayList<String>();
		icelore.add(ChatColor.GREEN + "Freeze players!");
		iceblockim.setLore(icelore);
		iceblockim.setDisplayName(ChatColor.GREEN + "Freeze");
		iceblock.setItemMeta(iceblockim);

		// Inspection
		ItemStack inspect = new ItemStack(Material.BOOK, 1);
		ItemMeta inspectim = inspect.getItemMeta();
		ArrayList<String> inspectlore = new ArrayList<String>();
		inspectlore.add(ChatColor.GREEN + "Inspect players inventories.");
		inspectim.setLore(inspectlore);
		inspectim.setDisplayName(ChatColor.GREEN + "Inspection");
		inspect.setItemMeta(inspectim);

		// Mover
		ItemStack compass = new ItemStack(Material.COMPASS, 1);
		ItemMeta compassim = compass.getItemMeta();
		ArrayList<String> compasslore = new ArrayList<String>();
		compasslore.add(ChatColor.GREEN + "Move faster");
		compassim.setLore(compasslore);
		compassim.setDisplayName(ChatColor.GREEN + "Mover");
		compass.setItemMeta(compassim);

		// Random Teleport
		ItemStack rtp = new ItemStack(Material.BLAZE_ROD, 1);
		ItemMeta rtpim = rtp.getItemMeta();
		ArrayList<String> rtplore = new ArrayList<String>();
		rtplore.add(ChatColor.GREEN + "Move faster");
		rtpim.setLore(rtplore);
		rtpim.setDisplayName(ChatColor.GREEN + "Random Teleport");
		rtp.setItemMeta(rtpim);

		//Vanish
		ItemStack vanish = new ItemStack(Material.INK_SACK, 1, (short) 10);
		ItemMeta vanishim = vanish.getItemMeta();
		ArrayList<String> vanishlore = new ArrayList<String>();
		vanishlore.add(ChatColor.GREEN + "Vanish yourself.");
		vanishim.setLore(rtplore);
		vanishim.setDisplayName(ChatColor.GREEN + "Vanish");
		vanish.setItemMeta(vanishim);
		
		//flight
		ItemStack flight = new ItemStack(Material.GHAST_TEAR);
		ItemMeta flightim = flight.getItemMeta();
		ArrayList<String> flightlore = new ArrayList<String>();
		flightlore.add(ChatColor.GREEN + "Fly around");
		flightim.setLore(rtplore);
		flightim.setDisplayName(ChatColor.GREEN +  "Flight");
		flight.setItemMeta(flightim);
		
		//flight
		ItemStack worldedit = new ItemStack(Material.WOOD_AXE);
		ItemMeta worldeditim = flight.getItemMeta();
		ArrayList<String> worldeditlore = new ArrayList<String>();
		worldeditlore.add(ChatColor.GREEN + "Admins Only");
		worldeditim.setLore(rtplore);
		worldeditim.setDisplayName(ChatColor.GREEN +  "World Edit");
		worldedit.setItemMeta(worldeditim);
		
		p.getInventory().setItem(0, compass);
		p.getInventory().setItem(2, worldedit);
		p.getInventory().setItem(3, inspect);
		p.getInventory().setItem(4, iceblock);
		p.getInventory().setItem(6, rtp);
		p.getInventory().setItem(7, flight);
		p.getInventory().setItem(8, vanish);
	}


	public static boolean cmd(String format) {
		return Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), format);
	}
	
	
	public static void Vanish(Player p) {
		if (vanish.contains(p)) {
			for (Player online : Bukkit.getOnlinePlayers()) {
				if (online.hasPermission("sesame.bypassvanish")) {
				online.showPlayer(p);
				} else {
					online.hidePlayer(p);
				}
			}
		} else {

			for (Player online : Bukkit.getOnlinePlayers()) {
				online.showPlayer(p);
			}

		}
	}
	
	
	
	
	public static void Fly(Player p) {
		if (!fly.contains(p)) { // if contains
			p.setAllowFlight(false); // disable
		} else if (fly.contains(p)) { // if doesnt contain
			p.setAllowFlight(true); // enable
		}
	}

}
