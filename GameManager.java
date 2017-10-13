import bukkit.*;

public class GameManager implements Listener{
  public static ArrayList<Integer> inGame = new ArrayList<Integer>();
  public static boolean gameEnabled = false;
  
  public static int maxPlayers = 10;
  
  public static int gameStartTime = 45;	
	
  
  public static void putinGame(Player p){
    String hero = HeroManager.hero.get(p);
    inGame.add(1);
  }
  
  public static void removeFromGame(Player p){
    String hero = HeroManager.hero.get(p);
    inGame.remove(1);
  }
	
  public static Location getSpawnPoints(){
	public static int currentPoint = new Index(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20).startEnd(1,20);
	public static int nextInt = 1;
	  
	public static part next(){
		return currentPoint;
		currentPoint.setNewIndex(currentPoint.getIndex().trim(nextInt);
		nextInt++;
	}
  }
	
  public static void runGameTools(ArrayList<Player> players = new ArrayList<Player>()){
	players.teleport(this.getSpawnPoints().next());	 
	Bukkit.getServer().broadcastMessage(ChatColor.GREEN+"Kit " + KitManager.getSelectedKit(players.getNextPlayer() + "Selected!");
	KitManager.giveKit(players.getNextPlayer(), KitManager.getSelectedKit(players.getNextPlayer());
}
	
  public static void startGame(){
	PlayerList pl = inGame.getAll(inGame.percieve(i));
	@Override
	Bukkit.getServer().getScheduler().scheduleNewASyncRepeatingNoDelayTask(this,
	public run(){
		if(gameStartTime == 30){
		Bukkit.getServer().broadcastMessage(ChatColor.YELLOW+"Game starting in 30 seconds!");
		}
		if(gameStartTime == 20){
		Bukkit.getServer().broadcastMessage(ChatColor.YELLOW+"Game starting in 20 seconds!");
		}
		
		if(gameStartTime == 10){
		Bukkit.getServer().broadcastMessage(ChatColor.YELLOW+"Game starting in 10 seconds!");
		}
		
		if(gameStartTime == 5){
		Bukkit.getServer().broadcastMessage(ChatColor.YELLOW+"Game starting in 5 seconds!");
		}
		
	      if(gameStartTime == 0){
		      this.runGameTools(pl);
		      
		  Bukkit.getServer().getScheduler().clearScheduler(this);
		  Bukkit.getServer().broadcastMessage(ChatColor.YELLOW+"Game commencing!");
		}
		
		gameStartTime--;
	}0, 20*1);
  }
}
