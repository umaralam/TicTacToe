package games;

import java.util.ArrayList;

public class Game{
	PrintBoard p_board = new PrintBoard();
	ArrayList<String> board = new ArrayList<>();
	ArrayList<String> x_counter = new ArrayList<>();
	ArrayList<String> o_counter = new ArrayList<>();
	
	private String square;
	private String current_winner = null;
	int m = 0, n = 0;

	public boolean available_moves(String square) {
		for(int i=0; i<p_board.matrix.length; i++) {
		      for(int j=0; j<p_board.matrix[0].length; j++) {
		        if(p_board.matrix[i][j] == " "){
		        	return true;
		        }
		      }
		    }
		return false;	
	}
	
	public ArrayList<String> random_available_moves() {
		for(int i=0; i<p_board.matrix.length; i++) {
		      for(int j=0; j<p_board.matrix[0].length; j++) {
		        if(p_board.matrix[i][j] == " "){
		        	board.add(p_board.matrix[i][j]);
		        }
		      }
		    }
		return board;
	}
	
	protected Boolean empty_squares() {
		Boolean empty_squares = false;
		
		for(int i=0; i<p_board.matrix.length; i++) {
		      for(int j=0; j<p_board.matrix[0].length; j++) {
		    	  if (p_board.matrix[i][j] == " ") {
		    		  empty_squares = true;
		    	  }
		      }
		}
		return empty_squares;
	}
	
	private void sqaure_to_Matrix(String square) {
		
		for(int i=0; i<p_board.num_board.length; i++) {
		      for(int j=0; j<p_board.num_board[0].length; j++) {
		    	  if (p_board.num_board[i][j].equals(square)) {
		    		  m = i;
		    		  n = j;
		    	  }
		      }
		}
	}


	private boolean make_move(String square, String letter) {
		
		sqaure_to_Matrix(square);
		
		if (p_board.matrix[m][n] == " ") {
			p_board.matrix[m][n] = letter;
			if (winner(square, letter))
				current_winner = letter;	
			return true;
		}
		return false;
	}

	


	private boolean winner(String square, String letter) {
//      winner if 3 in a row, column or diagonals. We have to check all of these.

//      checking row.	
		for(int i=0; i<p_board.matrix.length; i++) {
			      for(int j=0; j<p_board.matrix[0].length; j++) {
			    	  if (p_board.matrix[i][j] == letter) {
			    		  if (letter == "x")
			    			  x_counter.add(letter);
			    		  else
			    			  o_counter.add(letter);
			    	  }	    	  
		   }
			      if(letter == "x") {
			    	  if (x_counter.size() == 3)
							return true;
			    	  else
			    		  x_counter.clear();
			      }
			      else {
			    	  if (o_counter.size() == 3)
							return true;
			    	  else
			    		  o_counter.clear();
			      }	
		  }	

//        Checking column.

				for(int i=0; i<p_board.matrix.length; i++) {
			      for( int j=0; j<p_board.matrix[0].length; j++) {
			    		  if (p_board.matrix[j][i] == letter) {
				    		  if (letter == "x")
				    			  x_counter.add(letter);
				    		  else
				    			  o_counter.add(letter);
			    		  }	  
			      }
			      if(letter == "x") {
			    	  if (x_counter.size() == 3)
							return true;
			    	  else
			    		  x_counter.clear();
			      }
			      else {
			    	  if (o_counter.size() == 3)
							return true;
			    	  else
			    		  o_counter.clear();
			      }
				}
				
//		Checking Diagonals
		sqaure_to_Matrix(square);
		if (Integer.parseInt(p_board.num_board[m][n]) % 2 == 0) {
			int k=0,l=0;
				for(k=0,l=0; k<p_board.matrix[0].length; k++, l++) {
						if (p_board.matrix[k][l] == letter) {
		  					  if (letter == "x") {
		  						x_counter.add(letter);
		  					  }	  
		  					  	
		  					  else {
		  						o_counter.add(letter);
		  					  }	  
		  			  	}
				}
				if(letter == "x") {
					  if (x_counter.size() == 3)
					  	  return true;
					  else
						  x_counter.clear();
				  }
				  else {
					  if (o_counter.size() == 3)
						  return true;
					  else
						  o_counter.clear();
				  }
				for(k=0,l=2; k<p_board.matrix[0].length; k++, l--) {
						if (p_board.matrix[k][l] == letter) {
		  					  if (letter == "x") {
		  						x_counter.add(letter);
		  					  }  
		  					  else {
		  						o_counter.add(letter);
		  					  }	  
		  			  	}
					}
				if(letter == "x") {
					  if (x_counter.size() == 3)
					  	  return true;
					  else
						  x_counter.clear();
				  }
				  else {
					  if (o_counter.size() == 3)
						  return true;
					  else
						  o_counter.clear();
				  }
			}
		return false;	
	}

	public void play(Player x_player, Player o_player, boolean print_game) throws InterruptedException {
		
		if(print_game) 
			p_board.print_board_nums();
		
		//initial letter
		String letter = "x";
		
		//iterate through until empty squares
		//Winner will eventually break the loop
		//we will return the loop
		
		while(empty_squares()) {
			//get the move from appropriate player
			if (letter == "o")
				square = o_player.get_move(letter);
			else
				square = x_player.get_move(letter);
			
			//now let's define a function to make a move
			if(make_move(square, letter)) {
				if (print_game) {
					System.out.println();
					System.out.println(letter + " makes a move to " + square);
					p_board.print_board(p_board.matrix);
				}
				System.out.println();
				if(current_winner != null) {
					if(print_game)
						System.out.println(letter + " wins!");
					return;
				}
				else {
					Thread.sleep(600);
//	                after we make move, we need to alternate letters. Switch move.
						if(letter == "x") {
							letter = "o";
						}else {
							letter = "x";
						}

				}
			}
//			put a tiny break to make things easier to read				
		}
		if(print_game)
			System.out.println("It's a tie!");
			
	}

}

	
