package com.sesamepvp.kitpvp.quests.quests;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.sesamepvp.kitpvp.quests.managers.QuestManager;
import com.sesamepvp.utilites.Methods;

public class Scavenger implements QuestManager{

	@Override
	public String getName() {
		return Methods.format("Scavenger");
	}

	@Override
	public ItemStack getItem() {
		ItemStack item = new ItemStack(Material.DIAMOND);
		return item;
	}

	@Override
	public String getDisplayName() {
		return Methods.format("&2Scavenger");
	}

	@Override
	public String getLore() {
		return Methods.format("&aUnlock all non-donator kits!");
	}

	@Override
	public void applyQuest(Inventory inventory, int position) {
		ItemStack item = new ItemStack(this.getItem());
		ItemMeta im = item.getItemMeta();
		im.setDisplayName(this.getDisplayName());
		ArrayList<String> itemlore = new ArrayList<String>();
		itemlore.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
				+ "--------------");
		itemlore.add(this.getLore());
		itemlore.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
				+ "--------------");
		itemlore.add(this.getReward());
		itemlore.add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH
				+ "--------------");
		im.setLore(itemlore);
		item.setItemMeta(im);
		inventory.setItem(position, item);
	}
	
	@Override
	public String  getReward(){
		return Methods.format("&aReward: &2$&a2500");
	}

}