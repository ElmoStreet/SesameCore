package com.sesamepvp.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sesamepvp.utilites.Messages;
import com.sesamepvp.utilites.Methods;

public class Vanish implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("vanish") || cmd.getName().equalsIgnoreCase("v")) {
			Player p = (Player) sender;
			if (sender instanceof Player) {
				if (p.hasPermission("core.vanish") || p.isOp()) {
					if (args.length == 0) {
						if (Methods.vanish.contains(p)) {
							Methods.vanish.remove(p);
							Methods.Vanish(p);
							p.sendMessage(Messages.vanishDisabled());
						} else {
							if (!(Methods.vanish.contains(p))) {
								Methods.vanish.add(p);
								Methods.Vanish(p);
								p.sendMessage(Messages.vanishEnabled());
							}
						}
					} else if (args.length == 1) {
						Player target = Bukkit.getServer().getPlayer(args[0]);
						if (target == null) {
							p.sendMessage(Messages.playerNull());
						} else {
							if (Methods.vanish.contains(target)) {
								Methods.vanish.remove(target);
								Methods.Vanish(target);
								p.sendMessage(Messages
										.targetVanishDisabled(target));
								target.sendMessage(Messages.vanishDisabled());
							} else {
								if (!(Methods.vanish.contains(target))) {
									Methods.vanish.add(target);
									Methods.Vanish(target);
									p.sendMessage(Messages
											.targetVanishEnabled(target));
									target.sendMessage(Messages.vanishEnabled());
								}
							}
						}
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
