import bukkit.*;

public class GameManager implements Listener{
  publc static ArrayList<Integer> inGame = new ArrayList<Integer>();
  public static void putinGame(Player p){
    String hero = HeroManager.hero.get(p);
    inGame.add(1);
  }
}
