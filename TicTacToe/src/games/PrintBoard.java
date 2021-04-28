package games;

public class PrintBoard {
	
	String[][] matrix = {{" ", " ", " "},{" ", " ", " "},{" ", " ", " "}};
	String num_board[][] = 
	      { { "0", "1", "2" }, { "3", "4", "5" }, { "6", "7", "8" } };
	
	
	public void print_board(String[][] matrix){

		    		    
		    for(int i=0; i<matrix.length; i++) {
		      for(int j=0; j<matrix[0].length; j++) {
		        System.out.print("| " + matrix[i][j] + " ");
		      }
		      System.out.println("|");
		    }
		  }
	
	public void print_board_nums(){
		    for(int i=0; i<num_board.length; i++) {
		      for(int j=0; j<num_board[0].length; j++) {
		        System.out.print("| " + num_board[i][j] + " ");
		      }
		      System.out.println("|");
		    }
		  }
}
