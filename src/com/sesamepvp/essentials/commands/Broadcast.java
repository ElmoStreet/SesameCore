package com.sesamepvp.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sesamepvp.utilites.Messages;
import com.sesamepvp.utilites.Methods;

public class Broadcast implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("broadcast")
				|| cmd.getName().equalsIgnoreCase("bc")) {
			Player p = (Player) sender;
			if (sender instanceof Player) {
				if (p.hasPermission("core.broadcast")) {
					StringBuilder message = new StringBuilder("");
					for (String part : args) {
						if (!message.toString().equals(""))
							message.append(" ");

						message.append(part);
					}

					Bukkit.getServer().broadcastMessage(Messages.prefix(Methods.format(message.toString())));
				}
			} else {
				p.sendMessage(Messages.noPermission());
			}
		} else {
			sender.sendMessage(Messages.notPlayer());
		}

		return true;
	}

}
