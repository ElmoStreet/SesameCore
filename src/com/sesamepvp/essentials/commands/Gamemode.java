package com.sesamepvp.essentials.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sesamepvp.utilites.Messages;

public class Gamemode implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("gamemode")
				|| cmd.getName().equalsIgnoreCase("gm")) {
			Player p = (Player) sender;
			if (sender instanceof Player) {
				if (p.hasPermission("core.gamemode")) {

					if (args.length == 0) {
						p.sendMessage(Messages.gamemodeUsage());
					} else {
						if (args.length == 1) {
							if (args[0].equalsIgnoreCase("creative")
									|| args[0].equalsIgnoreCase("1")) {
								p.setGameMode(GameMode.CREATIVE);
								p.sendMessage(Messages.gamemodeCreative());
							}
							if (args[0].equalsIgnoreCase("survival")
									|| args[0].equalsIgnoreCase("0")) {
								p.setGameMode(GameMode.SURVIVAL);
								p.sendMessage(Messages.gamemodeSurvival());
							}
							if (args[0].equalsIgnoreCase("creative")
									|| args[0].equalsIgnoreCase("2")) {
								p.setGameMode(GameMode.ADVENTURE);
								p.sendMessage(Messages.gamemodeAdventure());
							}
							if (args[0].equalsIgnoreCase("spectator")
									|| args[0].equalsIgnoreCase("3")) {
								p.setGameMode(GameMode.SPECTATOR);
								p.sendMessage(Messages.gamemodeSpectator());
							}
						} else {
							p.sendMessage(Messages.gamemodeUsage());
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
