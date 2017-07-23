package com.sesamepvp.Scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import com.sesamepvp.kitpvp.configmanager.Manager;
import com.sesamepvp.kitpvp.managers.KitListener;
import com.sesamepvp.main.SesameCore;
import com.sesamepvp.staffmode.commands.StaffMode;
import com.sesamepvp.utilites.Methods;

public class SB implements Listener {
	Manager manager = Manager.getInstance();
	SesameCore plugin;

	public SB(SesameCore instance) {
		plugin = instance;
	}

	public void updateScoreboard(Player player) {
		if (KitListener.kitselected.contains(player)) {
			Manager manager1 = Manager.getInstance();
			ScoreboardManager manager = Bukkit.getScoreboardManager();
			final Scoreboard board = manager.getNewScoreboard();
			final Objective objective = board.registerNewObjective("test", "dummy");

			objective.setDisplaySlot(DisplaySlot.SIDEBAR);
			objective.setDisplayName(Methods.format("&c&lSesame&f&lPvP"));

			Score score = objective.getScore(Methods.format("&8&l&m------------------"));
			score.setScore(10);

			Score score9 = objective.getScore(Methods.format("&4&lKit:"));
			score9.setScore(9);

			Methods.testkits(player, objective);

			Score score7 = objective.getScore(" ");
			score7.setScore(7);

			Score score6 = objective.getScore(Methods.format("&4&lRank:"));
			score6.setScore(6);
			if (manager1.getData().getString(player.getName() + ".Rank") == null) {
				Score score5 = objective.getScore(Methods.format(" &cNone"));
				score5.setScore(5);
			} else {
				Score score5 = objective
						.getScore(Methods.format(" &c" + manager1.getData().getString(player.getName() + ".Rank")));
				score5.setScore(5);
			}
			Score score4 = objective.getScore("");
			score4.setScore(4);

			Score score3 = objective.getScore(Methods.format("&4&lStats:"));
			score3.setScore(3);

			Score score2 = objective.getScore(
					Methods.format(" &cKills:&r&4 " + manager1.getData().getInt(player.getName() + ".Kills")));
			score2.setScore(2);

			Score score1 = objective.getScore(
					Methods.format(" &cDeaths: &r&4" + manager1.getData().getInt(player.getName() + ".Deaths")));
			score1.setScore(1);

			Score score0 = objective.getScore(Methods.format("&8&l&m--------I--------"));
			score0.setScore(0);

			player.setScoreboard(board);
		} else if (StaffMode.staffmode.contains(player)) {
			@SuppressWarnings("unused")
			Manager manager1 = Manager.getInstance();
			ScoreboardManager manager = Bukkit.getScoreboardManager();
			final Scoreboard board = manager.getNewScoreboard();
			final Objective objective = board.registerNewObjective("test", "dummy");

			objective.setDisplaySlot(DisplaySlot.SIDEBAR);
			objective.setDisplayName(Methods.format("&c&lSesame&f&lPvP"));

			Score score = objective.getScore(Methods.format("&8&l&m------------------"));
			score.setScore(7);
			Score score6 = objective.getScore(Methods.format("&4&lStaff Mode: "));
			score6.setScore(6);

			if (Methods.vanish.contains(player)) {
				Score score4 = objective.getScore(Methods.format(" &cVanish: &aEnabled"));
				score4.setScore(5);
			} else {
				Score score4 = objective.getScore(Methods.format(" &cVanish: &cDisabled"));
				score4.setScore(5);
			}

			if (Methods.fly.contains(player)) {
				Score score3 = objective.getScore(Methods.format(" &cFlight: &aEnabled"));
				score3.setScore(4);
			} else {
				Score score3 = objective.getScore(Methods.format(" &cFlight: &cDisabled"));
				score3.setScore(4);
			}
			Score score2 = objective.getScore(Methods.format(" &cGamemode: &a" + player.getGameMode()));
			score2.setScore(3);

			Score score0 = objective.getScore(Methods.format("&8&l&m--------I--------"));
			score0.setScore(0);

			player.setScoreboard(board);
		} else {
			Manager manager1 = Manager.getInstance();
			ScoreboardManager manager = Bukkit.getScoreboardManager();
			final Scoreboard board = manager.getNewScoreboard();
			final Objective objective = board.registerNewObjective("test", "dummy");

			objective.setDisplaySlot(DisplaySlot.SIDEBAR);
			objective.setDisplayName(Methods.format("&c&lSesame&f&lPvP"));

			Score score = objective.getScore(Methods.format("&8&l&m------------------"));
			score.setScore(10);

			Score score7 = objective.getScore("");
			score7.setScore(7);

			Score score6 = objective.getScore(Methods.format("&4&lRank:"));
			score6.setScore(6);
			if (manager1.getData().getString(player.getName() + ".Rank") == null) {
				Score score5 = objective.getScore(Methods.format(" &cNone"));
				score5.setScore(5);
			} else {
				Score score5 = objective
						.getScore(Methods.format(" &c" + manager1.getData().getString(player.getName() + ".Rank")));
				score5.setScore(5);
			}
			Score score4 = objective.getScore("");
			score4.setScore(4);

			Score score3 = objective.getScore(Methods.format("&4&lStats:"));
			score3.setScore(3);

			Score score2 = objective.getScore(
					Methods.format(" &cKills:&r&4 " + manager1.getData().getInt(player.getName() + ".Kills")));
			score2.setScore(2);

			Score score1 = objective.getScore(
					Methods.format(" &cDeaths: &r&4" + manager1.getData().getInt(player.getName() + ".Deaths")));
			score1.setScore(1);

			Score score0 = objective.getScore(Methods.format("&8&l&m--------I--------"));
			score0.setScore(0);

			player.setScoreboard(board);
		}
	}

	public void add(final Player player) {
		BukkitScheduler Scheduler = Bukkit.getServer().getScheduler();
		Scheduler.scheduleSyncRepeatingTask(plugin, new Runnable() {
			@Override
			public void run() {
				updateScoreboard(player);
			}
		}, 0, 5);
	}

	@EventHandler
	public void PlayerJoinEvent(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		this.add(p);
	}

}
