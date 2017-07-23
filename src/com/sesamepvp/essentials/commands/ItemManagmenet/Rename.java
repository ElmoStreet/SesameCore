package com.sesamepvp.essentials.commands.ItemManagmenet;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sesamepvp.utilites.Messages;
import com.sesamepvp.utilites.Methods;

public class Rename implements CommandExecutor{

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if(cmd.getName().equalsIgnoreCase("rename")){
			if(sender instanceof Player){
				Player p = (Player) sender;
				if(p.hasPermission("core.rename")){
					if(p.getItemInHand().getItemMeta() == null){
						p.sendMessage(Messages.nullItem());
					}else{
						p.getItemInHand().getItemMeta().setDisplayName(Methods.format(args[0]));
						p.sendMessage(Messages.prefix("§aRenamed to §c" + args[0]));
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
