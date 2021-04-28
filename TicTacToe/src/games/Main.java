package games;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		String x = "x";
		String o = "o";
		
		Game game = new Game();
		Player x_player = new HumanPlayer(x);
		Player o_player = new RandomComputerPlayer(o);
		game.play(x_player, o_player, true);
	}

}
