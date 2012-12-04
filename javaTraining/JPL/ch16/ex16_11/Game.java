package ch16.ex16_11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Game {
	
	String[][] gridPlate = new String[3][3];
	public static String MARU = "maru";
	public static String BATSU = "batsu";
	
	private static Integer POINT = 30;
	
	Map<String, Integer> score = new HashMap<String, Integer>();
	
	ArrayList<Player> playerList = new ArrayList<Player>();
	private static int playerIndex = 0;
	
	public static void main(String[] args) {
		String name = "ch16.ex16_11.BoldPlayer";//class name
		Game game = new Game();
		
		for(int i = 0; i < 7; i++){
			try{
				PlayerLoader loader = new PlayerLoader();
				Class<? extends Player> classOf = loader.loadClass(name).asSubclass(Player.class);
				Player player = classOf.newInstance();
				player.play(game);
				game.recordScore(name);
				game.reportScore(name);
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Exception: " + e.getCause());
			}
		}
	}
	
	public void setPiece(int m, int n, String sign){
		gridPlate[m][n] = sign;
	}
	
	public boolean end(){
		System.out.println("end?");
		if(MARU.equals(this.gridPlate[0][0]) && MARU.equals(this.gridPlate[0][1]) && MARU.equals(this.gridPlate[0][2])||
				   MARU.equals(this.gridPlate[1][0]) && MARU.equals(this.gridPlate[1][1]) && MARU.equals(this.gridPlate[1][2])||
				   MARU.equals(this.gridPlate[2][0]) && MARU.equals(this.gridPlate[2][1]) && MARU.equals(this.gridPlate[2][2])||
				   MARU.equals(this.gridPlate[0][0]) && MARU.equals(this.gridPlate[1][0]) && MARU.equals(this.gridPlate[2][0])||
				   MARU.equals(this.gridPlate[0][1]) && MARU.equals(this.gridPlate[1][1]) && MARU.equals(this.gridPlate[2][1])||
				   MARU.equals(this.gridPlate[0][2]) && MARU.equals(this.gridPlate[1][2]) && MARU.equals(this.gridPlate[2][2])||
				   MARU.equals(this.gridPlate[0][0]) && MARU.equals(this.gridPlate[1][1]) && MARU.equals(this.gridPlate[2][2])||
				   MARU.equals(this.gridPlate[2][0]) && MARU.equals(this.gridPlate[1][1]) && MARU.equals(this.gridPlate[0][2])){
					System.out.println ("You win!!");
					return true;
		}
		else if(BATSU.equals(this.gridPlate[0][0]) && BATSU.equals(this.gridPlate[0][1]) && BATSU.equals(this.gridPlate[0][2])||
				   BATSU.equals(this.gridPlate[1][0]) && BATSU.equals(this.gridPlate[1][1]) && BATSU.equals(this.gridPlate[1][2])||
				   BATSU.equals(this.gridPlate[2][0]) && BATSU.equals(this.gridPlate[2][1]) && BATSU.equals(this.gridPlate[2][2])||
				   BATSU.equals(this.gridPlate[0][0]) && BATSU.equals(this.gridPlate[1][0]) && BATSU.equals(this.gridPlate[2][0])||
				   BATSU.equals(this.gridPlate[0][1]) && BATSU.equals(this.gridPlate[1][1]) && BATSU.equals(this.gridPlate[2][1])||
				   BATSU.equals(this.gridPlate[0][2]) && BATSU.equals(this.gridPlate[1][2]) && BATSU.equals(this.gridPlate[2][2])||
				   BATSU.equals(this.gridPlate[0][0]) && BATSU.equals(this.gridPlate[1][1]) && BATSU.equals(this.gridPlate[2][2])||
				   BATSU.equals(this.gridPlate[2][0]) && BATSU.equals(this.gridPlate[1][1]) && BATSU.equals(this.gridPlate[0][2])){
					System.out.println("You lose!!");
					return true;
		}
		else if(this.gridPlate[0][0] != null && this.gridPlate[0][1] != null && this.gridPlate[0][2] != null &&
				this.gridPlate[1][0] != null &&this.gridPlate[1][1] != null &&this.gridPlate[1][2] != null &&
				this.gridPlate[2][0] != null &&this.gridPlate[2][1] != null &&this.gridPlate[2][2] != null){
			System.out.println("Draw");
			return true;
		}
		else{
			return false;
		}
	}
	
	public void reportScore(String name){
		System.out.println("Your total score is " + score.get(name));
	}
	
	public void recordScore(String name){
		Integer oldPoint;
		if(score.get(name) == null){
			oldPoint = 0;
		}
		else{
			oldPoint = score.get(name);
		}
		Integer newPoint = oldPoint + POINT;
		score.put(name, newPoint);
	}
	
	public void setNextPlayer(Player player){
		this.playerList.add(player);
	}
	
}
