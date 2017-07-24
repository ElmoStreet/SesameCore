package com.sesamepvp.staffmode.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.sesamepvp.staffmode.commands.StaffMode;
import com.sesamepvp.utilites.Messages;
import com.sesamepvp.utilites.Methods;

public class VanishEvent implements Listener {
	
	@EventHandler
	public void onVanish(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if ((p.getItemInHand().getType() == Material.INK_SACK)
				&& (StaffMode.staffmode.contains(p))
				&& ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))) {
			if (Methods.vanish.contains(p)) {

				p.getInventory().remove(Material.INK_SACK);
				ItemStack grayinksack = new ItemStack(Material.INK_SACK, 1,
						(short) 8);
				ItemMeta grayinksackim = grayinksack.getItemMeta();
				grayinksackim.setDisplayName(ChatColor.GREEN + "Vanish");
				grayinksack.setItemMeta(grayinksackim);
				p.getInventory().setItem(8, grayinksack);
				p.sendMessage(Messages.vanishDisabled());
				for (Player online : Bukkit.getOnlinePlayers()) {

					online.showPlayer(p);

				}

				Methods.vanish.remove(p);
			} else if (!Methods.vanish.contains(p)) {

				p.getInventory().remove(Material.INK_SACK);
				ItemStack greeninksack = new ItemStack(Material.INK_SACK, 1,
						(short) 10);
				ItemMeta greeninksackim = greeninksack.getItemMeta();
				greeninksackim.setDisplayName(ChatColor.GREEN + "Vanish");
				greeninksack.setItemMeta(greeninksackim);
				p.getInventory().setItem(8, greeninksack);
				p.sendMessage(Messages.vanishEnabled());

				for (Player online : Bukkit.getOnlinePlayers()) {
					if (online.hasPermission("sesame.bypassvanish")) {
						online.showPlayer(p);
					} else {
						online.hidePlayer(p);
					}
				}

				Methods.vanish.add(p);

			}
		}
	}
}
