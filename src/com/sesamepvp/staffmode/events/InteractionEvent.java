package com.sesamepvp.staffmode.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import com.sesamepvp.files.StaffmodeFile;
import com.sesamepvp.staffmode.commands.StaffMode;
import com.sesamepvp.staffmode.gui.Inspect;

public class InteractionEvent implements Listener {
	StaffmodeFile sfm = StaffmodeFile.getInstance();
	
	@EventHandler
	public void onInteractOnPlayer(PlayerInteractEntityEvent e) {
		Player p = e.getPlayer();
		Entity t = e.getRightClicked();

		if (t instanceof Player) {
			if (p.getItemInHand().getType() == Material.getMaterial(sfm.getData().getString("Freeze.material"))
					&& StaffMode.staffmode.contains(p)) {
				Bukkit.dispatchCommand(
						(CommandSender) e.getRightClicked(),
						"freeze "
								+ ((HumanEntity) e.getRightClicked()).getName());
			}
		} else {
			return;
		}

	}

	
	@EventHandler
	public void onInteract(PlayerInteractEntityEvent e) {
		Player p = e.getPlayer();
		Entity t = e.getRightClicked();

		if (!(t instanceof Player)) {
			e.setCancelled(true);
			return;
		} else {

			if (p.getItemInHand().getType() == Material.getMaterial(sfm.getData().getString("Inspect.material"))
					&& StaffMode.staffmode.contains(p)) {
				Inspect.InpsectGUI(p, t);
			}
		}
	}
}
