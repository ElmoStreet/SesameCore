package com.sesamepvp.main;

import java.util.logging.Level;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import com.sesamepvp.chatmanagement.commands.ChatMute;
import com.sesamepvp.chatmanagement.commands.ClearChat;
import com.sesamepvp.chatmanagement.events.ChatMuteListener;
import com.sesamepvp.essentials.commands.Broadcast;
import com.sesamepvp.essentials.commands.ClearInventory;
import com.sesamepvp.essentials.commands.Feed;
import com.sesamepvp.essentials.commands.Fly;
import com.sesamepvp.essentials.commands.Gamemode;
import com.sesamepvp.essentials.commands.Heal;
import com.sesamepvp.essentials.commands.Invsee;
import com.sesamepvp.essentials.commands.List;
import com.sesamepvp.essentials.commands.Message;
import com.sesamepvp.essentials.commands.Teleport;
import com.sesamepvp.essentials.commands.Vanish;
import com.sesamepvp.essentials.commands.Locations.spawn.Setspawn;
import com.sesamepvp.essentials.commands.Locations.spawn.Spawn;
import com.sesamepvp.essentials.events.ListListener;
import com.sesamepvp.kitpvp.abilities.InsaneAbility;
import com.sesamepvp.kitpvp.abilities.SlugAbility;
import com.sesamepvp.kitpvp.abilities.VampireAbility;
import com.sesamepvp.kitpvp.commands.KitShop;
import com.sesamepvp.kitpvp.commands.Kits;
import com.sesamepvp.kitpvp.commands.PathSeter;
import com.sesamepvp.kitpvp.commands.Sesame;
import com.sesamepvp.kitpvp.commands.Stats;
import com.sesamepvp.kitpvp.config.Manager;
import com.sesamepvp.kitpvp.events.General;
import com.sesamepvp.kitpvp.events.GiveRespawnItems;
import com.sesamepvp.kitpvp.kits.defaultkits.Alchemist;
import com.sesamepvp.kitpvp.kits.defaultkits.Archer;
import com.sesamepvp.kitpvp.kits.defaultkits.Default;
import com.sesamepvp.kitpvp.kits.defaultkits.Fisherman;
import com.sesamepvp.kitpvp.kits.defaultkits.Golden;
import com.sesamepvp.kitpvp.kits.defaultkits.Pyro;
import com.sesamepvp.kitpvp.kits.defaultkits.Tank;
import com.sesamepvp.kitpvp.kits.donatorkits.Slug;
import com.sesamepvp.kitpvp.kits.donatorkits.Thor;
import com.sesamepvp.kitpvp.kits.donatorkits.Vampire;
import com.sesamepvp.kitpvp.kits.donatorkits.Viper;
import com.sesamepvp.kitpvp.kits.purchasedkits.Assassin;
import com.sesamepvp.kitpvp.kits.purchasedkits.Burner;
import com.sesamepvp.kitpvp.kits.purchasedkits.GodArcher;
import com.sesamepvp.kitpvp.kits.purchasedkits.Insane;
import com.sesamepvp.kitpvp.kits.purchasedkits.Speed;
import com.sesamepvp.kitpvp.managers.KitListener;
import com.sesamepvp.kitpvp.managers.KitShopManager;
import com.sesamepvp.kitpvp.managers.RankupSystem;
import com.sesamepvp.kitpvp.managers.StatsManager;
import com.sesamepvp.kitpvp.upgrades.UpgradeClickEvent;
import com.sesamepvp.kitpvp.upgrades.kits.AlchemistUpgraded;
import com.sesamepvp.kitpvp.upgrades.kits.ArcherUpgraded;
import com.sesamepvp.kitpvp.upgrades.kits.DefaultUpgraded;
import com.sesamepvp.kitpvp.upgrades.kits.FishermanUpgraded;
import com.sesamepvp.kitpvp.upgrades.kits.GoldenUpgraded;
import com.sesamepvp.kitpvp.upgrades.kits.PyroUpgraded;
import com.sesamepvp.kitpvp.upgrades.kits.TankUpgraded;
import com.sesamepvp.staffmode.commands.Freeze;
import com.sesamepvp.staffmode.commands.Report;
import com.sesamepvp.staffmode.commands.StaffMode;
import com.sesamepvp.staffmode.events.BlockPlace;
import com.sesamepvp.staffmode.events.DamageCancel;
import com.sesamepvp.staffmode.events.FlightEvent;
import com.sesamepvp.staffmode.events.FreezeListener;
import com.sesamepvp.staffmode.events.InteractionEvent;
import com.sesamepvp.staffmode.events.InvClickEvent;
import com.sesamepvp.staffmode.events.ItemDrop;
import com.sesamepvp.staffmode.events.LoggedWhilstFrozen;
import com.sesamepvp.staffmode.events.RandomTeleport;
import com.sesamepvp.staffmode.events.VanishEvent;
import com.sesamepvp.utilites.Messages;

public class Core extends JavaPlugin {

	Manager manager = Manager.getInstance();

	private PluginManager pm;
	private ConsoleCommandSender cs;

	public static Economy econ = null;
	public static EconomyResponse r;

	public void onEnable() {
		if (!setupEconomy()) {
			Bukkit.getServer()
					.getLogger()
					.log(Level.SEVERE,
							String.format(
									"[%s] - Disabled due to no Vault dependency found!",
									getDescription().getName()));
			getServer().getPluginManager().disablePlugin(this);
			return;
		}
		pm = Bukkit.getServer().getPluginManager();
		cs = Bukkit.getServer().getConsoleSender();
		cs.sendMessage(Messages.onEnable());
		registerEvents();
		registerCommands();
		registerConfig();
		manager.setup(this);
		registerEconomy();
		setupEconomy();
	}

	public void registerConfig() {
		final FileConfiguration config = this.getConfig();
		config.options().copyDefaults(true);
		config.addDefault("Prefix", "&c&lSesame&f&lPvP &8>>&r");
		saveConfig();
	}

	public void registerEconomy() {
		if (!setupEconomy()) {
			Bukkit.getServer()
					.getLogger()
					.log(Level.SEVERE,
							String.format(
									"[%s] - Disabled due to no Vault dependency found!",
									getDescription().getName()));
			getServer().getPluginManager().disablePlugin(this);
			return;
		}
	}

	private boolean setupEconomy() {
		if (getServer().getPluginManager().getPlugin("Vault") == null) {
			return false;
		}
		RegisteredServiceProvider<Economy> rsp = getServer()
				.getServicesManager().getRegistration(Economy.class);
		if (rsp == null) {
			return false;
		}
		econ = rsp.getProvider();
		return econ != null;
	}

	private void registerCommands() {
		getCommand("clearchat").setExecutor(new ClearChat());
		getCommand("cc").setExecutor(new ClearChat());
		getCommand("mutechat").setExecutor(new ChatMute());
		getCommand("mc").setExecutor(new ChatMute());
		getCommand("mod").setExecutor(new StaffMode());
		getCommand("freeze").setExecutor(new Freeze());
		getCommand("report").setExecutor(new Report(this));
		getCommand("stats").setExecutor(new Stats());
		getCommand("list").setExecutor(new List());
		getCommand("kits").setExecutor(new Kits());
		getCommand("kitshop").setExecutor(new KitShop());
		getCommand("sesame").setExecutor(new Sesame());
		getCommand("fly").setExecutor(new Fly());
		getCommand("vanish").setExecutor(new Vanish());
		getCommand("v").setExecutor(new Vanish());
		getCommand("gm").setExecutor(new Gamemode());
		getCommand("gamemode").setExecutor(new Gamemode());
		getCommand("setspawn").setExecutor(new Setspawn());
		getCommand("spawn").setExecutor(new Spawn());
		getCommand("feed").setExecutor(new Feed());
		getCommand("heal").setExecutor(new Heal());
		getCommand("ci").setExecutor(new ClearInventory());
		getCommand("clearinventory").setExecutor(new ClearInventory());
		getCommand("clear").setExecutor(new ClearInventory());
		getCommand("bc").setExecutor(new Broadcast());
		getCommand("broadcast").setExecutor(new Broadcast());
		getCommand("msg").setExecutor(new Message());
		getCommand("m").setExecutor(new Message());
		getCommand("message").setExecutor(new Message());
		getCommand("invsee").setExecutor(new Invsee());
		getCommand("inspect").setExecutor(new Invsee());
		getCommand("teleport").setExecutor(new Teleport());
		getCommand("tp").setExecutor(new Teleport());
		getCommand("setpath").setExecutor(new PathSeter());
	}

	private void registerEvents() {
		pm.registerEvents(new StatsManager(),this);
		pm.registerEvents(new ListListener(), this);
		pm.registerEvents(new InsaneAbility(), this);
		pm.registerEvents(new SlugAbility(), this);
		pm.registerEvents(new VampireAbility(), this);
		pm.registerEvents(new UpgradeClickEvent(), this);
		pm.registerEvents(new ChatMuteListener(), this);
		pm.registerEvents(new FreezeListener(), this);
		pm.registerEvents(new FlightEvent(), this);
		pm.registerEvents(new VanishEvent(), this);
		pm.registerEvents(new RandomTeleport(), this);
		pm.registerEvents(new LoggedWhilstFrozen(), this);
		pm.registerEvents(new DamageCancel(), this);
		pm.registerEvents(new ItemDrop(), this);
		pm.registerEvents(new BlockPlace(), this);
		pm.registerEvents(new InteractionEvent(), this);
		pm.registerEvents(new InvClickEvent(), this);
		pm.registerEvents(new GiveRespawnItems(), this);
		pm.registerEvents(new KitListener(), this);
		pm.registerEvents(new KitShopManager(), this);
		pm.registerEvents(new General(), this);
		pm.registerEvents(new RankupSystem(), this);

		// Kits
		pm.registerEvents(new Alchemist(), this);
		pm.registerEvents(new Archer(), this);
		pm.registerEvents(new Default(), this);
		pm.registerEvents(new Fisherman(), this);
		pm.registerEvents(new Golden(), this);
		pm.registerEvents(new Pyro(), this);
		pm.registerEvents(new Tank(), this);

		pm.registerEvents(new AlchemistUpgraded(), this);
		pm.registerEvents(new ArcherUpgraded(), this);
		pm.registerEvents(new DefaultUpgraded(), this);
		pm.registerEvents(new FishermanUpgraded(), this);
		pm.registerEvents(new GoldenUpgraded(), this);
		pm.registerEvents(new PyroUpgraded(), this);
		pm.registerEvents(new TankUpgraded(), this);

		pm.registerEvents(new Slug(), this);
		pm.registerEvents(new Thor(), this);
		pm.registerEvents(new Vampire(), this);
		pm.registerEvents(new Viper(), this);

		pm.registerEvents(new Assassin(), this);
		pm.registerEvents(new Burner(), this);
		pm.registerEvents(new GodArcher(), this);
		pm.registerEvents(new Insane(), this);
		pm.registerEvents(new Speed(), this);
		pm.registerEvents(new Kits(), this);
		pm.registerEvents(new KitShop(), this);
	}

	public void onDisable() {
		cs.sendMessage(Messages.onDisable());
	}
}
