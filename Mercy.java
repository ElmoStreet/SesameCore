import bukkit.org.*
import java.util

public class Mercy implements Listener {

public static String getHero(Player p){
if(HeroManager.hero.get(p) == null){
 return null;
}else{
 return HeroManager.hero.get(p);
}
}

public static void equip(Player p){
  if(getHero(p) == null){
   p.sendMessage(Messages.format("&cFailed to equip");
  }else{
  PlayerInventory pi = p.getInventory();
  
  }
}
}
