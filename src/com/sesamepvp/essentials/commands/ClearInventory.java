package com.sesamepvp.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sesamepvp.utilites.Messages;
import com.sesamepvp.utilites.Methods;

public class ClearInventory implements CommandExecutor{

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if(cmd.getName().equalsIgnoreCase("ci") || cmd.getName().equalsIgnoreCase("clear") || cmd.getName().equalsIgnoreCase("clearinventory")){
			Player p = (Player) sender;
			if(sender instanceof Player){
				if(p.hasPermission("core.clearinventory") || p.isOp()){
					if(args.length == 0){
						p.sendMessage(Messages.clearedInventory());
						p.getInventory().clear();
						Methods.clearArmor(p);
					}else{
						if(args.length == 1){
							Player t = Bukkit.getServer().getPlayer(args[0]);
							if(t == null){
								p.sendMessage(Messages.playerNull());
							}else{
								t.getInventory().clear();
								Methods.clearArmor(t);
								t.sendMessage(Messages.clearedInventory());
								p.sendMessage(Messages.playerClearedInventory(t));
							}
						}else{
							p.sendMessage(Messages.clearinventoryUsage());
						}
					}
				}else{
					p.sendMessage(Messages.noPermission());
				}
			}else{
				sender.sendMessage(Messages.notPlayer());
			}
		}
		return true;
	}
	
}
