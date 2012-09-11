package ch16.ex16_11;

import java.util.Random;

public class BoldPlayer extends Player{

	@Override
	public void play(Game game) {
		Random ran = new Random();
		while(true){
			while(true){
				int m = ran.nextInt(3); 
				int n = ran.nextInt(3);
				if(game.gridPlate[m][n] == null){
					game.setPiece(m, n, Game.MARU);
					break;
				}
			}
			while(true){
				int m = ran.nextInt(3); 
				int n = ran.nextInt(3);
				if(game.gridPlate[m][n] == null){
					game.setPiece(m, n, Game.BATSU);
					break;
				}
			}
			if(game.end() == true){
				System.out.println("Game End");
				break;
			}
		}
	}

}
