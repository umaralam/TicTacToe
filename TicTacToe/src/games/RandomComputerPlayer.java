package games;

public class RandomComputerPlayer extends Player{
	
	public RandomComputerPlayer(String letter) {
		super(letter);
	}

	@Override
	public String get_move(String letter) {
		Game game = new Game();
		java.util.Random random = new java.util.Random();
		String square = String.valueOf(random.nextInt(game.random_available_moves().toString().length()));
		return square;
	}

	
	
	

}
