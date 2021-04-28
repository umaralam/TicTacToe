package games;

import java.util.Scanner;

public class HumanPlayer extends Player{
	
	public HumanPlayer(String letter) {
		super(letter);
	}

	@Override
	public String get_move(String player) {
		Game game = new Game();
		boolean valid_square = false;
		boolean input_square = false;
		int val = 0;
		String square = null;
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		while(!valid_square) {
			while(!input_square){
			    try {
			    	System.out.print(letter + "\'s turn. Input move (0-8):");
			    	square = input.next();
			    	val = Integer.parseInt(square);
			    	
			    } catch (NumberFormatException e) {
			        System.out.println("Invalid sqaure. Try again.");
			        continue;
			    }
			    
			    if(val >= 0 && val <= 8)
			    		input_square = true;
			}
			
			try {
				if(game.available_moves(square)) {
					valid_square = true;	
				}
			} catch (Exception e) {
				System.out.println("Invalid sqaure. Try again.");
			}	
		}
		return square;
		
	}

}
