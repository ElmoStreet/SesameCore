package com.sesamepvp.kitpvp.quests.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import com.sesamepvp.kitpvp.configmanager.Manager;
import com.sesamepvp.main.SesameCore;
import com.sesamepvp.utilites.Messages;
import com.sesamepvp.utilites.Methods;

public class TestKillEvents implements Listener {
	Manager manager = Manager.getInstance();

	@EventHandler
	public void onDeathEvent(PlayerDeathEvent e) {
		Player p = e.getEntity();
		if (manager.getData().getInt(p.getKiller().getName() + ".Kills") == 50) {
			p.getKiller().sendMessage(Messages.prefix(Methods
					.format("&aQUESTS: &cYou completed the &cHunter &cQuest!")));
			manager.getData().set(p.getKiller().getUniqueId() + ".Quests.Hunter", true);
			manager.saveConfig();
			manager.saveData();
			SesameCore.econ.depositPlayer(p.getKiller(), 500);
		}
		
		if (manager.getData().getInt(p.getKiller().getName() + ".Kills") == 500) {
			p.getKiller().sendMessage(Messages.prefix(Methods
					.format("&aQUESTS: &cYou completed the &4Bloodthirsty &cQuest!")));
			manager.getData().set(p.getKiller().getUniqueId()+ ".Quests.Bloodthirsty", true);
			manager.saveConfig();
			manager.saveData();
			SesameCore.econ.depositPlayer(p.getKiller(), 1500);
		}
		
		if (manager.getData().getInt(p.getKiller().getName() + ".Kills") == 1000) {
			p.getKiller().sendMessage(Messages.prefix(Methods
					.format("&aQUESTS: &cYou completed the &5Professional &cQuest!")));
			manager.getData().set(p.getKiller().getUniqueId() + ".Quests.Professional", true);
			manager.saveConfig();
			manager.saveData();
			SesameCore.econ.depositPlayer(p.getKiller(), 2500);
		}
		
	}
}
