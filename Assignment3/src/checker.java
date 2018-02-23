
//import the module scanner
import java.util.Scanner;

class Position{
	int x;
	int y;
	public String[][] checker ;
	public Position(int x,int y) {
		this.x=x * 2 + 2;
		this.y=y+ 2;
	}
	public boolean isEmpty(int x,int y,String[][] checker) {
		this.checker=checker;
		return (checker[y][x]=="1");
		
		
	}
}
class Player{
	public String Player;
	
	public void getPlayer(String Player) {
		this.Player=Player;
		
	}
}
class checkerBoard{
	
	public String[][] checker = { { " ", "  0 ", " 1 ", " 2 ", " 3 ", " 4 ", " 5 ", " 6 ", " 7 ", "<- X axis" },
			{ " ", "+", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "+" },
			{ "0", "|", " ", " ", "1", " ", " ", " ", "1", " ", " ", " ", "1", " ", " ", " ", "1", " ", "|" },
			{ "1", "|", "1", " ", " ", " ", "1", " ", " ", " ", "1", " ", " ", " ", "1", " ", " ", " ", "|" },
			{ "2", "|", " ", " ", "1", " ", " ", " ", "1", " ", " ", " ", "1", " ", " ", " ", "1", " ", "|" },
			{ "3", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|" },
			{ "4", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|" },
			{ "5", "|", "2", " ", " ", " ", "2", " ", " ", " ", "2", " ", " ", " ", "2", " ", " ", " ", "|" },
			{ "6", "|", " ", " ", "2", " ", " ", " ", "2", " ", " ", " ", "2", " ", " ", " ", "2", " ", "|" },
			{ "7", "|", "2", " ", " ", " ", "2", " ", " ", " ", "2", " ", " ", " ", "2", " ", " ", " ", "|" },
			{ " ", "+", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "+" },
			{ " ", "  0 ", " 1 ", " 2 ", " 3 ", " 4 ", " 5 ", " 6 ", " 7 " } };
	
	



	public void printBoard() {
		for (int i = 0; i < checker.length; i++) {
			for (int j = 0; j < checker[i].length; j++) {
				// prints column
				System.out.print(checker[i][j] + " ");
			}
			// prints new line
			System.out.println();
		
		}
	}
	public void changeboard(int x, int y, String[][] checker) {
		this.checker[y][x]=" ";
		 printBoard();
	}


}


	
	



public class checker {


	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		/*
		for(;;) {
			System.out.print("Enter X: ");
			int x = s.nextInt();
			System.out.print("Enter Y: ");
			int y = s.nextInt();
			Position p = new Position(x,y);
				//p.isEmpty(1, 0, checkerBoard.class)
				
				
			checkerBoard board = new checkerBoard();
				
			board.changeboard(p.x, p.y, null);
			board.printBoard();
				
				
		
		}*/
		
		checkerBoard board = new checkerBoard();
		
		board.changeboard(1* 2 + 2, 0+2, null);
		board.changeboard(3* 2 + 2, 0+2, null);
		board.changeboard(5* 2 + 2, 0+2, null);
		
	}

}
