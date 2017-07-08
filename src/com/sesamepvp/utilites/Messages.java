package com.sesamepvp.utilites;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import com.sesamepvp.main.Core;

public class Messages {
	static Core plugin;
	
	public Messages(Core instance) {
		plugin = instance;
	}

	public static String prefix(String txt) {
		String prefix = "§c§lSesame§f§lPvP §8>> §r";
		return prefix + txt;

	}

	public static String noPermission() {
		String noPermission = "§cYou do not have permission for this.";
		return prefix(noPermission);
	}

	public static String notPlayer() {
		String notPlayer = "§cYou must be a player to execute this command.";
		return prefix(notPlayer);
	}

	public static String modDisabled() {
		String modDisabled = "§cYou have left §4Staff §cmode.";
		return prefix(modDisabled);
	}

	public static String modEnabled() {
		String modEnabled = "§aYou have entered §2Staff §amode.";
		return prefix(modEnabled);
	}

	public static String mustleaveMod() {
		String mustleaveMod = "§cYou must leave §4Staff §cmode to do this.";
		return prefix(mustleaveMod);
	}

	public static String staffJoin(Player p) {
		String staffJoin = "§aStaff Member §3" + p.getName() + " §has joined.";
		return prefix(staffJoin);
	}

	public static String staffQuit(Player p) {
		String staffQuit = "§cStaff Member §4" + p.getName() + " §has left.";
		return prefix(staffQuit);
	}

	public static String noitemDrop() {
		String noitemDrop = "§cYou are not allowed to drop this item in §4Staff §cmode.";
		return prefix(noitemDrop);
	}

	public static String noBlockPlace() {
		String noBlockPlace = "§cYou are not allowed to place this block in §4Staff §cmode.";
		return prefix(noBlockPlace);
	}

	public static String noDamage() {
		String noDamage = "§cYou are not allowed to attack in §4Staff §cmode.";
		return prefix(noDamage);
	}

	public static String freezeArgs() {
		String freezeArgs = "§cUsage: /freeze <player>";
		return prefix(freezeArgs);
	}

	public static String playerNull() {
		String playerNull = "§cThat player is either offline or doesn't exist.";
		return prefix(playerNull);
	}

	public static String frozePlayer(Player p) {
		String frozePlayer = "§cYou have froze §4" + p.getName() + "§c.";
		return prefix(frozePlayer);
	}

	public static String unfrozePlayer(Player p) {
		String unfrozePlayer = "§aYou have unfroze §2" + p.getName() + "§a.";
		return prefix(unfrozePlayer);
	}

	public static String frozen(Player freezer) {
		String frozen = "§cYou have been frozen by §4" + freezer.getName()
				+ " §cPlease join coordinate with the staff member.";
		return prefix(frozen);
	}

	public static String unFrozen(Player unfreezer) {
		String unFrozen = "§aYou have been unfrozen by §2"
				+ unfreezer.getName() + "§a.";
		return prefix(unFrozen);
	}

	public static String playerFrozen() {
		String playerFrozen = "§cYou have been frozen. Please coordinate with the staff member.";
		return prefix(playerFrozen);
	}

	public static String talkDenied() {
		String talkDenied = "§cYou can't talk, chat is currently muted.";
		return prefix(talkDenied);
	}

	public static String chatMuted() {
		String chatMuted = " §4| §cChat is now muted §4| ";
		return prefix(chatMuted);
	}

	public static String chatUnmuted() {
		String chatunMuted = " §2| §aChat is now unmuted §2| ";
		return prefix(chatunMuted);
	}

	public static String chatClear() {
		String chatClear = "§aThe chat has been §2Cleared §a.";
		return prefix(chatClear);
	}

	public static String notenoughPlayers() {
		String notenoughPlayers = "§cThere are not enough §4players §conline.";
		return prefix(notenoughPlayers);
	}

	public static String randomteleportedTo(Player p) {
		String randomteleportedTo = "§aYou have been teleported to §2"
				+ p.getName() + "§a.";
		return prefix(randomteleportedTo);
	}

	public static String flightEnabled() {
		String flightEnabled = "§aFlight has been §2Enabled§a.";
		return prefix(flightEnabled);
	}

	public static String flightDisabled() {
		String flightDisabled = "§cFlight has been §4Disabled§c.";
		return prefix(flightDisabled);
	}

	public static String vanishEnabled() {
		String vanishEnabled = "§aVanish has been §2Enabled§a.";
		return prefix(vanishEnabled);
	}

	public static String vanishDisabled() {
		String vanishDisabled = "§cVanish has been §4Disabled§c.";
		return prefix(vanishDisabled);
	}

	public static String reportUsage() {
		String reportUsage = "§cUsage: /report <player> <reason>";
		return prefix(reportUsage);
	}

	public static String reported(Player target, String reason) {
		String reported = "§aYou have reported §2" + target.getName()
				+ "§a for §2" + reason + ".";
		return prefix(reported);
	}

	public static String purchasedSpeedyKit() {
		String purchasedSpeedyKit = "§cYou have purchased the §aSpeedy§c kit.";
		return prefix(purchasedSpeedyKit);
	}

	public static String purchasedInsaneKit() {
		String purchasedInsaneKit = "§cYou have purchased the §aInsane§c kit.";
		return prefix(purchasedInsaneKit);
	}

	public static String purchasedAssassinKit() {
		String purchasedAssassinKit = "§cYou have purchased the §aAssassin§c kit.";
		return prefix(purchasedAssassinKit);
	}

	public static String purchasedGodArcherKit() {
		String purchasedGodArcherKit = "§cYou have purchased the §aGod Archer§c kit.";
		return prefix(purchasedGodArcherKit);
	}

	public static String purchasedBurnerKit() {
		String purchasedBurnerKit = "§cYou have purchased the §aBurner§c kit.";
		return prefix(purchasedBurnerKit);
	}

	public static String kitalreadyOwned() {
		String kitalreadyOwned = "§cYou already own that kit.";
		return prefix(kitalreadyOwned);
	}

	public static String insufficientFunds() {
		String insufficientFunds = "§cYou do not have enough funds for this.";
		return prefix(insufficientFunds);
	}

	public static String rankNone() {
		String rankNone = "§aRank: §eNone.";
		return prefix(rankNone);
	}

	public static String rank(String rank) {
		String ranks = "§aRank: §e" + rank;
		return prefix(ranks);
	}

	public static String kills(int pkills) {
		String kills = "§aKills: §e" + pkills;
		return prefix(kills);
	}

	public static String deaths(int pdeaths) {
		String deaths = "§aDeaths: §e" + pdeaths;
		return prefix(deaths);
	}

	public static String targetStats(Player t) {
		String targetStats = "§2" + t.getName() + "'s §a stats :";
		return prefix(targetStats);
	}

	public static String openKitShop() {
		String openKitShop = "§aOpening the kit shop!";
		return prefix(openKitShop);
	}

	public static String ranks() {
		String ranks = "§aRanks:";
		return prefix(ranks);
	}

	public static String Warrior() {
		String warrior = "§aWarrior: 150 kills.";
		return prefix(warrior);
	}

	public static String Gladiator() {
		String Gladiator = "§aGladiator: 350 kills.";
		return prefix(Gladiator);
	}

	public static String Guardian() {
		String Guardian = "§aGuardian: 750 kills.";
		return prefix(Guardian);
	}

	public static String Berserk() {
		String Berserk = "§aBerserk: 1250 kills.";
		return prefix(Berserk);
	}

	public static String Legend() {
		String Legend = "§aLegend: 1750 kills.";
		return prefix(Legend);
	}

	public static String DemiGod() {
		String DemiGod = "§aDemi God: 2250 kills.";
		return prefix(DemiGod);
	}

	public static String God() {
		String God = "§aGod: 3500 kills.";
		return prefix(God);
	}

	public static String kitpvpUsage() {
		String kitpvpUsage = "§cUsage: /kitpvp <reload,setspawn,ranks>";
		return prefix(kitpvpUsage);
	}

	public static String dataReloaded() {
		String datareloaded = "§aData.yml has been reloaded";
		return prefix(datareloaded);
	}

	public static String spawnSet() {
		String spawnset = "§aSpawn has been set";
		return prefix(spawnset);
	}

	public static String deathMessage(Entity p, Entity k) {
		String deathmessage = "§c" + p.getName() + " §ehas been killed by §c"
				+ k.getName();
		return prefix(deathmessage);
	}

	public static String reachedwarriorRank(Player k) {
		String reachedwarriorrank = "§c" + k.getName()
				+ " &ahas reached the §bWarrior §arank!";
		return prefix(reachedwarriorrank);
	}

	public static String reachedgladiatorrank(Player k) {
		String reachedgladiatorrank = "§c" + k.getName()
				+ " &ahas reached the §1Warrior §arank!";
		return prefix(reachedgladiatorrank);
	}

	public static String reachedguardianrank(Player k) {
		String reachedguardianrank = "§c" + k.getName()
				+ " &ahas reached the §6Guardian §arank!";
		return prefix(reachedguardianrank);
	}

	public static String reachedberserkrank(Player k) {
		String reachedberserkrank = "§c" + k.getName()
				+ " &ahas reached the §aBerserk §arank!";
		return prefix(reachedberserkrank);
	}

	public static String reachedlegendrank(Player k) {
		String reachedlegendrank = "§c" + k.getName()
				+ " &ahas reached the §3Legend §arank!";
		return prefix(reachedlegendrank);
	}

	public static String reachedemigodrank(Player k) {
		String reachedemigodrank = "§c" + k.getName()
				+ " &ahas reached the §cDemiGod §arank!";
		return prefix(reachedemigodrank);
	}

	public static String reachedgodrank(Player k) {
		String reachedgodrank = "§c" + k.getName()
				+ " &ahas reached the §4God §arank!";
		return prefix(reachedgodrank);
	}

	public static String chatFormat(String message, Player player) {
		String chatformat = player.getDisplayName() + "§8 : §f§r" + message;
		return chatformat;
	}

	public static String joinMessage(Player p) {
		String joinMessage = "§8[§a+§8] §2" + p.getName()
				+ "§a has joined the server.";
		return prefix(joinMessage);
	}

	public static String kitSelected() {
		String kitselected = "§cKit already selected.";
		return prefix(kitselected);
	}

	public static String kitnotOwned() {
		String kitnotowned = "§cYou do not own this kit.";
		return prefix(kitnotowned);
	}

	public static String quitMessage(Player p) {
		String quitmessage = "§8[§c-§8] §2" + p.getName()
				+ "§c has left the server.";
		return prefix(quitmessage);
	}

	public static String onEnable() {
		String onEnable = "§aSesame Core has been enabled!";
		return prefix(onEnable);
	}

	public static String onDisable() {
		String onDisable = "§cSesame Core has been disabled!";
		return prefix(onDisable);
	}

	public static String targetFlightEnabled(Player target) {
		String targetFlightEnabled = "§aYou have enabled §2 " + target.getName() + "'s §aflight.";
		return prefix(targetFlightEnabled);
	}
	
	public static String targetFlightDisabled(Player target) {
		String targetFlightDisabled = "§cYou have disabled §4 " + target.getName() + "'s §cflight.";
		return prefix(targetFlightDisabled);
	}
	
	public static String targetVanishDisabled(Player target) {
		String targetVanishDisabled = "§cYou have disabled §4 " + target.getName() + "'s §cvanish.";
		return prefix(targetVanishDisabled);
	}
	
	public static String targetVanishEnabled(Player target) {
		String targetVanishEnabled = "§aYou have enabled §2 " + target.getName() + "'s §avanish.";
		return prefix(targetVanishEnabled);
	}

	public static String gamemodeCreative() {
		String gamemodeCreative = "§aGamemode set to §2Creative";
		return prefix(gamemodeCreative);
	}
	
	public static String gamemodeSurvival() {
		String gamemodeSurvival = "§aGamemode set to §2Survival";
		return prefix(gamemodeSurvival);
	}
	
	public static String gamemodeAdventure() {
		String gamemodeAdventure = "§aGamemode set to §2Adventure";
		return prefix(gamemodeAdventure);
	}
	
	public static String gamemodeSpectator() {
		String gamemodeSpectator = "§aGamemode set to §2Spectator";
		return prefix(gamemodeSpectator);
	}

	public static String gamemodeUsage() {
		String gamemodeUsage = "§cUsage: /gamemode [type] [player] or /gamemode <type>";
		return prefix(gamemodeUsage);
	}

	public static String teleportedtoSpawn() {
		String teleportedtospawn = "§aYou have teleported to Spawn.";
		return prefix(teleportedtospawn);
	}

	public static String spawnUsage() {
		String spawnUage = "§cUsage: /spawn   or  /spawn <player>";
		return prefix(spawnUage);
	}

	public static String teleportedtargettoSpawn(Player t) {
		String st = "§aYou have teleported §2" + t.getName() + "§a to spawn.";
		return prefix(st);
	}

	public static String feed() {
		String s = "§aYou have been fed.";
		return prefix(s);
	}
	
	public static String feedUsage(){
		String s = "§cUsage: /feed  or /feed <player>";
		return prefix(s);
	}
	
	public static String healUsage(){
		String s = "§cUsage: /heal  or /heal <player>";
		return prefix(s);
	}
	
	public static String healed() {
		String s = "§aYou have been healed.";
		return prefix(s);
	}

	public static String playerFeed(Player t) {
		String s = "§aYou have fed §2" + t.getName() + "§a.";
		return prefix(s);
	}
	
	public static String playerHealed(Player t) {
		String s = "§aYou have healed §2" + t.getName() + "§a.";
		return prefix(s);
	}

	public static String clearedInventory() {
		String s = "§aYou have cleared you're inventory.";
		return prefix(s);
	}

	public static String playerClearedInventory(Player t) {
		String s = "§aYou have cleared §2" + t.getName() +"'s §ainventory.";
		return prefix(s);
	}

	public static String clearinventoryUsage() {
		String s = "§cUsage: /ci  or /ci <player>";
		return prefix(s);
	}

	public static String setwarpUsage() {
		String s = "§cUsage: /setwarp <warpname>";
		return prefix(s);
	}

	public static String warpUsage() {
		String s = "§cUsage: /warp <warpname>";
		return prefix(s);
	}

	public static String broadcastUsage() {
		String s = "§cUsage: /broadcast <message>";
		return prefix(s);
	}

	public static String messageUsage() {
		String s = "§cUsage: /message <player> <message>";
		return prefix(s);
	}

	public static String invseeUsage() {
		String s = "§cUsage: /invsee <player>";
		return prefix(s);
	}

	public static String teleportedtoPlayer(Player target) {
		String s = "§aYou have been teleported to §2" + target.getName();
		return prefix(s);
	}

	public static String teleportUsage() {
		String s = "§cUsage: /teleport <player>";
		return prefix(s);
	}

	public static String closedInventory() {
		String s = "§cClosed Upgrades Menu.";
		return prefix(s);
	}

	public static String upgraded() {
		String s = "§aYou have successfully upgraded a kit!";
		return prefix(s);
	}

	public static String resetPlayerStats(Player t) {
		String s = "§aYou have reset §2" + t.getName()+"'s §astats.";
		return prefix(s);
	}
	
	public static String anticheatPrefix(){
		String s = "§c§lSesame §f§lAntiCheat §8 : §r";
		return s;
	}
	
	
	
	
}
