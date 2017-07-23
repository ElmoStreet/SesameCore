package com.sesamepvp.kitpvp.kits.donatorkits;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import com.sesamepvp.kitpvp.configmanager.Manager;
import com.sesamepvp.kitpvp.managers.KitListener;
import com.sesamepvp.utilites.Messages;
import com.sesamepvp.utilites.Methods;

public class Vampire implements Listener{
	
	Manager manager = Manager.getInstance();

	@EventHandler
	public void onInventoryClickEvent(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();

		if (e.getInventory().getTitle().equalsIgnoreCase("Kits")) {
			if (e.getCurrentItem() == null) {
				e.setCancelled(true);
				return;
			}

			e.setCancelled(true);
			
			if (e.getCurrentItem().getType() == Material.GHAST_TEAR) {
				if (e.getWhoClicked().hasPermission("kits.vampire")) {

					if (KitListener.kitselected.contains(p)) {
						e.setCancelled(true);
						e.getWhoClicked().closeInventory();
						p.sendMessage(Messages.kitSelected());
						return;
					} else {
						p.getInventory().clear();
						KitListener.kitselected.add(p);
						p.closeInventory();
						Bukkit.getServer().dispatchCommand(
								Bukkit.getServer().getConsoleSender(),
								"kit Vampire " + p.getName());
						p.getInventory().setLeggings(
								new ItemStack(Material.CHAINMAIL_LEGGINGS));
						p.getInventory().setHelmet(
								new ItemStack(Material.CHAINMAIL_HELMET));
						p.getInventory().setChestplate(
								new ItemStack(Material.GOLD_CHESTPLATE));
						p.getInventory().setBoots(
								new ItemStack(Material.DIAMOND_BOOTS));
						Methods.vampire.add(p);
					}
				} else {
					e.getWhoClicked().sendMessage(Messages.noPermission());
				}
			}

		}
	}
}
