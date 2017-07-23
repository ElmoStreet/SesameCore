package com.sesamepvp.kitpvp.abilities;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.sesamepvp.utilites.Methods;

public class VampireAbility implements Listener {
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
		Player t = (Player) e.getEntity();
		if (e.getDamager().getType() == EntityType.ARROW) {
			@SuppressWarnings("unused")
			Entity p = e.getDamager();
			return;
		} else {
			if (e.getDamager().getType() == EntityType.PLAYER) {
				Player p = (Player) e.getDamager();
				if (p.getItemInHand().getType() == Material.DIAMOND_SWORD) {
					if (Methods.vampire.contains(p)) {

						if (p.getHealth() <= 20) {
							p.setHealth(p.getHealth() + 2);
						}
						t.setHealth(t.getHealth() - 2);

					} else {
						return;
					}

				}
			}
		}

	}
}
