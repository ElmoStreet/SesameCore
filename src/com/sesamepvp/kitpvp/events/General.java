package com.sesamepvp.kitpvp.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.sesamepvp.kitpvp.configmanager.Manager;
import com.sesamepvp.kitpvp.managers.KitListener;
import com.sesamepvp.utilites.Methods;

public class General implements Listener {

	Manager manager = Manager.getInstance();

	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		e.getPlayer().setFoodLevel(20);
	}

	@EventHandler
	public void onLeave1(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		Methods.removeArrayLists(p);
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {

		Player p = e.getPlayer();

		Methods.removeArrayLists(p);

		Location spawnLocation = (Location) this.manager.getData().get("Spawn");
		p.teleport(spawnLocation);
		p.setHealth(p.getMaxHealth());
		p.getInventory().clear();
		p.getActivePotionEffects().clear();

		ItemStack cs = new ItemStack(Material.DIAMOND);
		ItemMeta csm = cs.getItemMeta();
		csm.setDisplayName(ChatColor.RED + "Kit Shop");
		cs.setItemMeta(csm);

		ItemStack ns = new ItemStack(Material.NETHER_STAR);
		ItemMeta nsm = ns.getItemMeta();
		nsm.setDisplayName(ChatColor.RED + "Kit Selector");
		ns.setItemMeta(nsm);
		p.getInventory().setItem(4, ns);
		p.getInventory().setItem(8, cs);
		if (KitListener.kitselected.contains(p)) {
			KitListener.kitselected.remove(p);
		}
	}

	@EventHandler
	public void onLeave(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		String quitmsg = ChatColor.GRAY + "[" + ChatColor.RED + "-"
				+ ChatColor.GRAY + "] " + ChatColor.RED + "" + p.getName()
				+ " has left.";
		e.setQuitMessage(quitmsg);
		Bukkit.getServer().dispatchCommand(
				Bukkit.getServer().getConsoleSender(),
				"effect " + p.getName() + " clear");
		p.setHealth(20);
		p.setFoodLevel(20);

		p.getInventory().clear();
		p.getInventory().setBoots(new ItemStack(Material.AIR));
		p.getInventory().setHelmet(new ItemStack(Material.AIR));
		p.getInventory().setChestplate(new ItemStack(Material.AIR));
		p.getInventory().setLeggings(new ItemStack(Material.AIR));

		ItemStack cs = new ItemStack(Material.DIAMOND);
		ItemMeta csm = cs.getItemMeta();
		csm.setDisplayName(ChatColor.RED + "Kit Shop");
		cs.setItemMeta(csm);

		ItemStack ns = new ItemStack(Material.NETHER_STAR);
		ItemMeta nsm = ns.getItemMeta();
		nsm.setDisplayName(ChatColor.RED + "Kit Selector");
		ns.setItemMeta(nsm);
		p.getInventory().setItem(4, ns);
		p.getInventory().setItem(8, cs);
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onFallDamage(EntityDamageEvent event) {
		if (event.getEntity() instanceof Player
				&& event.getCause() == DamageCause.FALL)
			event.setCancelled(true);
	}

	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player p = e.getEntity();
		if (KitListener.kitselected.contains(p)) {
			KitListener.kitselected.remove(p);
		}
		Methods.removeArrayLists(p);
	}

	@EventHandler
	public void onRespawnEvent(PlayerRespawnEvent e) {
		Player p = e.getPlayer();

		ItemStack cs = new ItemStack(Material.DIAMOND);
		ItemMeta csm = cs.getItemMeta();
		csm.setDisplayName(ChatColor.RED + "Kit Shop");
		cs.setItemMeta(csm);

		ItemStack ns = new ItemStack(Material.NETHER_STAR);
		ItemMeta nsm = ns.getItemMeta();
		nsm.setDisplayName(ChatColor.RED + "Kit Selector");
		ns.setItemMeta(nsm);
		p.getInventory().setItem(4, ns);
		p.getInventory().setItem(8, cs);
	}

	@EventHandler
	public void onCreatureSpawn(CreatureSpawnEvent e) {
		e.setCancelled(true);

	}

}
