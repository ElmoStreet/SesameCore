package com.sesamepvp.kitpvp.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sesamepvp.kitpvp.config.Manager;
import com.sesamepvp.kitpvp.gui.StatsGUI;
import com.sesamepvp.utilites.Messages;

public class Sesame implements CommandExecutor {
	Manager manager = Manager.getInstance();

	private void helpPage1(Player p) {
		p.sendMessage("§8§m-------  §c§lSesame §f§lHelp§8§m-------");
		p.sendMessage("§cCommands :");
		p.sendMessage("§c - /kits : Kit Selector GUI.");
		p.sendMessage("§c - /kitshop : Kit Shop.");
		p.sendMessage("§c - /stats : Stats.");
		p.sendMessage("§c - /report : Report players.");
		p.sendMessage("§c - /sesame ranks : KitPvP ranks.");
		p.sendMessage("§c - /list : Kit Shop.");
		p.sendMessage("§c - /msg : Message others.");
		p.sendMessage("§8§m-------  §c§lPage §f§l1§8§m-------");
	}

	private void helpPage2(Player p) {
		p.sendMessage("§8§m-------  §c§lSesame §f§lModerator Help§8§m-------");
		p.sendMessage("§cCommands :");
		p.sendMessage("§c - /mod : Staff Mode.");
		p.sendMessage("§c - /tp : Teleport to others.");
		p.sendMessage("§c - /vanish : Custom vanish.");
		p.sendMessage("§c - /gamemode : Change your gamemode.");
		p.sendMessage("§c - /inspect: Inspect Inventories.");
		p.sendMessage("§c - /cc : Clear chat.");
		p.sendMessage("§c - /fly : Toggle Flight.");
		p.sendMessage("§8§m-------  §c§lPage §f§l2§8§m-------");
	}

	private void helpPage3(Player p) {
		p.sendMessage("§8§m-------  §c§lSesame §f§lModerator Help§8§m-------");
		p.sendMessage("§cCommands :");
		p.sendMessage("§c - /mc : Mute the chat.");
		p.sendMessage("§c - /feed : Feed yourself.");
		p.sendMessage("§c - /heal : Heal yourself.");
		p.sendMessage("§c - /broadcast : Broadcast to the server.");
		p.sendMessage("§c - /freeze: Freeze cheaters.");
		p.sendMessage("§c - /clearinventory : Clear inventory.");
		p.sendMessage("§8§m-------  §c§lPage §f§l3§8§m-------");
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("sesame")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (args.length == 0) {
					helpPage1(p);
				} else {
					if (args[0].equalsIgnoreCase("1")) {
						helpPage1(p);
					}

					if (args[0].equalsIgnoreCase("2")) {
						helpPage2(p);
					}
					if (args[0].equalsIgnoreCase("3")) {
						helpPage3(p);
					}

					if (args[0].equalsIgnoreCase("ranks")) {
						p.sendMessage(Messages.Warrior());
						p.sendMessage(Messages.Gladiator());
						p.sendMessage(Messages.Guardian());
						p.sendMessage(Messages.Berserk());
						p.sendMessage(Messages.Legend());
						p.sendMessage(Messages.DemiGod());
						p.sendMessage(Messages.God());

					} else {
						if (args[0].equalsIgnoreCase("reload")) {
							p.sendMessage(Messages.dataReloaded());
							this.manager.saveData();
							this.manager.saveConfig();
							this.manager.reloadConfig();
							this.manager.reloadData();
							
							StatsGUI.playerStats(p);
						}
					}
				}
			}
		}
		return true;
	}

}
