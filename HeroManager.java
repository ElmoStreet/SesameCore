import bukkit.org.*;
import *;

public class HeroManager {
    public static HashMap<Player,String> hero = new HashMap<Player,String>();
  
  public static void setHero(Player p, String hero){
    hero.put(p,hero);
  }
}
