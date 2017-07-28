package com.sesamepvp.punishments.manager;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.sesamepvp.files.PunishmentsFile;
import com.sesamepvp.utilites.Messages;
import com.sesamepvp.utilites.Methods;

public class MuteManager implements Listener{
	static PunishmentsFile pf = PunishmentsFile.getInstance();
	public static boolean ismuted = false;
	
	public static boolean isMuted(Player p){
		if(pf.getData().getBoolean("Mutes." + p.getUniqueId() + ".muted") == true){
			ismuted = true;
		}else{
			ismuted = false;
		}
		return ismuted;
	}
	
	public static void mutePlayer(CommandSender sender, Player target){
		if(isMuted(target) == true){
			sender.sendMessage(Messages.prefix(Methods.format("&cThat player is already muted.")));
		}else{
			pf.getData().set("Mutes." + target.getUniqueId() + ".muted", true);
			pf.getData().set("Mutes." + target.getUniqueId() + ".muter", sender.getName());
			sender.sendMessage(Messages.prefix(Methods.format("&cYou muted &a" + target.getName() + "&c.")));
			pf.saveData();
		}
	}
	
	public static void unmutePlayer(CommandSender p, Player target){
		if(isMuted(target) == true){
			pf.getData().set("Mutes." + target.getUniqueId() + ".muted", false);
			pf.getData().getConfigurationSection("Mutes." + target.getUniqueId()).set("Mutes." + target.getUniqueId(), null);;
			p.sendMessage(Messages.prefix(Methods.format("&cYou unmuted &a" + target.getName() + "&c.")));
			pf.saveData();
		}else{
			p.sendMessage(Messages.prefix(Methods.format("&cThat player is not muted.")));
		}
	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e){
		Player p = e.getPlayer();
		if(isMuted(p) == true){
			e.setCancelled(true);
			p.sendMessage(Messages.prefix(Methods.format("&cYou are currently muted!")));
		}else{
			e.setCancelled(false);
			return;
		}
	}
}
