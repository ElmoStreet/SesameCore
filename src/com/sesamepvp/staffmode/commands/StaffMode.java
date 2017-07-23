package com.sesamepvp.staffmode.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.sesamepvp.kitpvp.managers.KitListener;
import com.sesamepvp.utilites.Messages;
import com.sesamepvp.utilites.Methods;

public class StaffMode implements CommandExecutor{
	
	public static Map<Player, ItemStack[]> pArmor = new HashMap<Player, ItemStack[]>();
	public static Map<Player, ItemStack[]> pItems = new HashMap<Player, ItemStack[]>();
	public static ArrayList<Player> staffmode = new ArrayList<Player>();

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("mod")) {
			Player p = (Player) sender;
			if (sender instanceof Player) {
				if (p.hasPermission("sesame.staffmode")) {
					if (staffmode.contains(p)) {
						if(KitListener.kitselected.contains(p)){
							KitListener.kitselected.remove(p);
						}
						p.getInventory().clear();
						staffmode.remove(p);
						Methods.fly.remove(p);
						Methods.Fly(p);
						Methods.vanish.remove(p);
						Methods.Vanish(p);
						if (pItems.containsKey(p)) {
							p.getInventory().setContents((ItemStack[]) pItems.get(p));
						}
						if (pArmor.containsKey(p)) {
							p.getInventory().setArmorContents((ItemStack[]) pArmor.get(p));
						}
						p.sendMessage(Messages.modDisabled());
					} else {
						staffmode.add(p);

						pArmor.put(p, p.getInventory().getArmorContents());
						pItems.put(p, p.getInventory().getContents());
						Methods.fly.add(p);
						Methods.Fly(p);
						Methods.vanish.add(p);
						Methods.Vanish(p);
						
						p.sendMessage(Messages.modEnabled());

						Methods.giveItems(p);
					}
				} else {
					p.sendMessage(Messages.noPermission());
				}
			} else {
				sender.sendMessage(Messages.notPlayer());
			}
		}
		return true;
	}

}
