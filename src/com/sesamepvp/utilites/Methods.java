package com.sesamepvp.utilites;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;

import com.sesamepvp.kitpvp.configmanager.Manager;

public class Methods {

	static Manager manager = Manager.getInstance();

	public static ArrayList<Player> vanish = new ArrayList<Player>();
	public static ArrayList<Player> fly = new ArrayList<Player>();

	public static ArrayList<Player> pvp = new ArrayList<Player>();
	public static ArrayList<Player> archer = new ArrayList<Player>();
	public static ArrayList<Player> tank = new ArrayList<Player>();
	public static ArrayList<Player> golden = new ArrayList<Player>();
	public static ArrayList<Player> alchemist = new ArrayList<Player>();
	public static ArrayList<Player> fisherman = new ArrayList<Player>();
	public static ArrayList<Player> pyro = new ArrayList<Player>();
	public static ArrayList<Player> warrior = new ArrayList<Player>();
	public static ArrayList<Player> gladiator = new ArrayList<Player>();
	public static ArrayList<Player> guardian = new ArrayList<Player>();
	public static ArrayList<Player> berserk = new ArrayList<Player>();
	public static ArrayList<Player> legend = new ArrayList<Player>();
	public static ArrayList<Player> demigod = new ArrayList<Player>();
	public static ArrayList<Player> god = new ArrayList<Player>();
	public static ArrayList<Player> viper = new ArrayList<Player>();
	public static ArrayList<Player> slug = new ArrayList<Player>();
	public static ArrayList<Player> vampire = new ArrayList<Player>();
	public static ArrayList<Player> thor = new ArrayList<Player>();
	public static ArrayList<Player> burner = new ArrayList<Player>();
	public static ArrayList<Player> speedy = new ArrayList<Player>();
	public static ArrayList<Player> assassin = new ArrayList<Player>();
	public static ArrayList<Player> godarcher = new ArrayList<Player>();
	public static ArrayList<Player> insane = new ArrayList<Player>();

	public static void removeArrayLists(Player p) {
		Methods.alchemist.remove(p);
		Methods.pvp.remove(p);
		Methods.archer.remove(p);
		Methods.tank.remove(p);
		Methods.pyro.remove(p);
		Methods.fisherman.remove(p);
		Methods.golden.remove(p);
		Methods.viper.remove(p);
		Methods.slug.remove(p);
		Methods.thor.remove(p);
		Methods.vampire.remove(p);
		Methods.insane.remove(p);
		Methods.speedy.remove(p);
		Methods.assassin.remove(p);
		Methods.burner.remove(p);
		Methods.godarcher.remove(p);
		Methods.warrior.remove(p);
		Methods.gladiator.remove(p);
		Methods.guardian.remove(p);
		Methods.berserk.remove(p);
		Methods.legend.remove(p);
		Methods.demigod.remove(p);
		Methods.god.remove(p);
	}

	public static void clearArmor(Player p) {
		PlayerInventory pi = p.getInventory();
		pi.setBoots(new ItemStack(Material.AIR));
		pi.setChestplate(new ItemStack(Material.AIR));
		pi.setHelmet(new ItemStack(Material.AIR));
		pi.setLeggings(new ItemStack(Material.AIR));
		return;
	}

	public static String format(String format) {
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

		// Vanish
		ItemStack vanish = new ItemStack(Material.INK_SACK, 1, (short) 10);
		ItemMeta vanishim = vanish.getItemMeta();
		ArrayList<String> vanishlore = new ArrayList<String>();
		vanishlore.add(ChatColor.GREEN + "Vanish yourself.");
		vanishim.setLore(rtplore);
		vanishim.setDisplayName(ChatColor.GREEN + "Vanish");
		vanish.setItemMeta(vanishim);

		// flight
		ItemStack flight = new ItemStack(Material.GHAST_TEAR);
		ItemMeta flightim = flight.getItemMeta();
		ArrayList<String> flightlore = new ArrayList<String>();
		flightlore.add(ChatColor.GREEN + "Fly around");
		flightim.setLore(rtplore);
		flightim.setDisplayName(ChatColor.GREEN + "Flight");
		flight.setItemMeta(flightim);

		// flight
		ItemStack worldedit = new ItemStack(Material.WOOD_AXE);
		ItemMeta worldeditim = flight.getItemMeta();
		ArrayList<String> worldeditlore = new ArrayList<String>();
		worldeditlore.add(ChatColor.GREEN + "Admins Only");
		worldeditim.setLore(rtplore);
		worldeditim.setDisplayName(ChatColor.GREEN + "World Edit");
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
		return Bukkit.getServer().dispatchCommand(
				Bukkit.getServer().getConsoleSender(), format);
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

	public static void testkits(Player player, Objective objective) {
		if (Methods.pvp.contains(player)) {
			Score score8 = objective.getScore(" §c" + "Default");
			score8.setScore(8);
		} else if (Methods.archer.contains(player)) {
			Score score8 = objective.getScore(" §c" + "Archer");
			score8.setScore(8);
		} else if (Methods.tank.contains(player)) {
			Score score8 = objective.getScore(" §c" + "Tank");
			score8.setScore(8);
		} else if (Methods.pyro.contains(player)) {
			Score score8 = objective.getScore(" §c" + "Pyro");
			score8.setScore(8);
		} else if (Methods.golden.contains(player)) {
			Score score8 = objective.getScore(" §c" + "Golden");
			score8.setScore(8);
		} else if (Methods.alchemist.contains(player)) {
			Score score8 = objective.getScore(" §c" + "Alchemist");
			score8.setScore(8);
		} else if (Methods.fisherman.contains(player)) {
			Score score8 = objective.getScore(" §c" + "Fisherman");
			score8.setScore(8);
		} else if (Methods.warrior.contains(player)) {
			Score score8 = objective.getScore(" §c" + "Warrior");
			score8.setScore(8);
		} else if (Methods.gladiator.contains(player)) {
			Score score8 = objective.getScore(" §c" + "Gladiator");
			score8.setScore(8);
		} else if (Methods.guardian.contains(player)) {
			Score score8 = objective.getScore(" §c" + "Guardian");
			score8.setScore(8);
		} else if (Methods.berserk.contains(player)) {
			Score score8 = objective.getScore(" §c" + "Berserk");
			score8.setScore(8);
		} else if (Methods.legend.contains(player)) {
			Score score8 = objective.getScore(" §c" + "Legend");
			score8.setScore(8);
		} else if (Methods.demigod.contains(player)) {
			Score score8 = objective.getScore(" §c" + "Demi God");
			score8.setScore(8);
		} else if (Methods.god.contains(player)) {
			Score score8 = objective.getScore(" §c" + "God");
			score8.setScore(8);
		} else if (Methods.burner.contains(player)) {
			Score score8 = objective.getScore(" §c" + "Burner");
			score8.setScore(8);
		} else if (Methods.speedy.contains(player)) {
			Score score8 = objective.getScore(" §c" + "Speedy");
			score8.setScore(8);
		} else if (Methods.godarcher.contains(player)) {
			Score score8 = objective.getScore(" §c" + "God Archer");
			score8.setScore(8);
		} else if (Methods.assassin.contains(player)) {
			Score score8 = objective.getScore(" §c" + "Assassin");
			score8.setScore(8);
		} else if (Methods.insane.contains(player)) {
			Score score8 = objective.getScore(" §c" + "Insane");
			score8.setScore(8);
		} else if (Methods.slug.contains(player)) {
			Score score8 = objective.getScore(" §c" + "Slug");
			score8.setScore(8);
		} else if (Methods.thor.contains(player)) {
			Score score8 = objective.getScore(" §c" + "Thor");
			score8.setScore(8);
		} else if (Methods.viper.contains(player)) {
			Score score8 = objective.getScore(" §c" + "Viper");
			score8.setScore(8);
		} else if (Methods.vampire.contains(player)) {
			Score score8 = objective.getScore(" §c" + "Vampire");
			score8.setScore(8);
		}
	}

	public static void testKits(Player p) {
		if (manager.getData().getBoolean(p.getName() + ".Kits.Assasin") == true
				&& manager.getData().getBoolean(p.getName() + ".Kits.Burner") == true
				&& manager.getData()
						.getBoolean(p.getName() + ".Kits.Godarcher") == true
				&& manager.getData().getBoolean(p.getName() + ".Kits.Speedy") == true
				&& manager.getData().getBoolean(p.getName() + ".Kits.Insane") == true

				&& manager.getData().getString(p.getName() + ".Kits.Warrior")
						.equalsIgnoreCase("")) {
			p.sendMessage(Messages.prefix(Methods
					.format("&aQUESTS: &aYou completed the &2Professional &aQuest!")));
		} else {
			return;
		}
	}
}
