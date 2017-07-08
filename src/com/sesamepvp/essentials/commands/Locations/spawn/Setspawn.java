package com.sesamepvp.essentials.commands.Locations.spawn;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sesamepvp.kitpvp.config.Manager;
import com.sesamepvp.utilites.Messages;

public class Setspawn implements CommandExecutor {
	Manager manager = Manager.getInstance();

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
			if(cmd.getName().equalsIgnoreCase("setspawn")){
				Player p = (Player) sender;
				if(p.hasPermission("core.setspawn")){
					p.sendMessage(Messages.spawnSet());
					this.manager.getData().set("Spawn", p.getLocation());
					this.manager.saveData();
					this.manager.saveConfig();
				}else{
					p.sendMessage(Messages.noPermission());
				}
			}
			return true;
	}
}
