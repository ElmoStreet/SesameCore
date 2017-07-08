package com.sesamepvp.kitpvp.upgrades.kits;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.sesamepvp.kitpvp.configmanager.Manager;
import com.sesamepvp.main.Core;
import com.sesamepvp.utilites.Messages;

public class AlchemistUpgraded implements Listener {

	Manager manager = Manager.getInstance();

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInventoryClickEvent(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if (e.getInventory().getTitle().equalsIgnoreCase("Kit Upgrades")) {
			if (e.getCurrentItem() == null) {
				e.setCancelled(true);
				return;
			}
			e.setCancelled(true);
			if (e.getCurrentItem().getType() == Material.GLASS_BOTTLE) {
				boolean AlchemistUpgradeOwned = this.manager.getData().getBoolean(
						p.getName() + ".Kits.Alchemist.Upgraded");
				if (AlchemistUpgradeOwned == true) {
					p.sendMessage(Messages.kitalreadyOwned());
				} else {
					if (Core.econ.withdrawPlayer(p.getName(), 250)
							.transactionSuccess()) {
						p.sendMessage(Messages.upgraded());
						this.manager.getData().set(
								p.getName() + ".Kits.Alchemist.Upgraded", true);
						this.manager.saveData();
						p.playSound(p.getLocation(), Sound.ANVIL_USE, 2F, 1F);
					} else {
						p.sendMessage(Messages.insufficientFunds());
						return;
					}
				}
			}

		}

	}

}
