package com.sesamepvp.kitpvp.kits.purchasedkits;

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

public class Insane implements Listener {

	Manager manager = Manager.getInstance();

	@EventHandler
	public void InventoryClickEvent(InventoryClickEvent event) {
		Player p = (Player) event.getWhoClicked();

		if (event.getInventory().getTitle().equals("Kits")) {

			if (event.getCurrentItem() == null) {
				return;
			}
			if (event.getCurrentItem().getType() == Material.LAVA_BUCKET) {

				if (KitListener.kitselected.contains(p)) {
					event.setCancelled(true);
					event.getWhoClicked().closeInventory();
					p.sendMessage(Messages.kitSelected());
					return;

				} else {
					boolean InsaneKitOwned = this.manager.getData().getBoolean(
							p.getUniqueId() + ".Kits.Insane");
					if (InsaneKitOwned == true) {
						p.getActivePotionEffects().clear();
						p.getInventory().clear();
						KitListener.kitselected.add(p);
						event.getWhoClicked().closeInventory();
						Bukkit.getServer()
								.dispatchCommand(
										Bukkit.getServer().getConsoleSender(),
										"kit Insane "
												+ event.getWhoClicked()
														.getName());
						p.getInventory().setLeggings(
								new ItemStack(Material.IRON_LEGGINGS));
						p.getInventory().setHelmet(
								new ItemStack(Material.IRON_HELMET));
						p.getInventory().setChestplate(
								new ItemStack(Material.IRON_CHESTPLATE));
						p.getInventory().setBoots(
								new ItemStack(Material.IRON_BOOTS));
						Methods.insane.add(p);
					} else {
						if (InsaneKitOwned == false) {
							event.setCancelled(true);
							p.sendMessage(Messages.kitnotOwned());
							return;

						}
					}
				}
			}
		}
	}

}
