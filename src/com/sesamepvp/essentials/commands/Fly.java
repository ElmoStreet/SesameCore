package com.sesamepvp.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sesamepvp.utilites.Messages;
import com.sesamepvp.utilites.Methods;

public class Fly implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("fly")) {
			Player p = (Player) sender;
			if (sender instanceof Player) {
				if (p.hasPermission("core.fly") || p.isOp()) {
					if (args.length == 0) {
						if (Methods.fly.contains(p)) {
							Methods.fly.remove(p);
							Methods.Fly(p);
							p.sendMessage(Messages.flightDisabled());
						} else {
							if (!(Methods.fly.contains(p))) {
								Methods.fly.add(p);
								Methods.Fly(p);
								p.sendMessage(Messages.flightEnabled());
							}
						}
					} else if (args.length == 1) {

						Player target = Bukkit.getServer().getPlayer(args[0]);
						if (target == null) {
							p.sendMessage(Messages.playerNull());
						} else {
							if (Methods.fly.contains(target)) {
								Methods.fly.remove(target);
								Methods.Fly(target);
								p.sendMessage(Messages.targetFlightDisabled(target));
								target.sendMessage(Messages.flightDisabled());
							} else {
								if (!(Methods.fly.contains(target))) {
									Methods.fly.add(target);
									Methods.Fly(target);
									p.sendMessage(Messages.targetFlightEnabled(target));
									target.sendMessage(Messages.flightEnabled());
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
