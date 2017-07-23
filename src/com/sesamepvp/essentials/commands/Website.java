package com.sesamepvp.essentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.sesamepvp.utilites.Messages;
import com.sesamepvp.utilites.Methods;

public class Website implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if(cmd.getName().equalsIgnoreCase("website")){
			sender.sendMessage(Messages.prefix(Methods.format("&chttps://sesamepvp.enjin.com")));
		}
		return true;
	}
}
