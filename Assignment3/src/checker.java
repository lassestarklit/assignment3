
//import the module scanner
import java.util.Scanner;

class Position{
	int x;
	int y;
	
	public Position(int x,int y) {
		this.x=x * 2 + 2;
		this.y=y+ 2;
		
		
	}
}
/*
@SuppressWarnings("serial")
class isempty extends Exception {
	public isempty() {};
		
	public isempty(String message) {
		super(message);
	}
}
*/
class Player{
	public String Player;
	public void getPlayer(String Player) {
		this.Player=Player;
		
	}
}
class PositionChecker extends  checkerBoard{
	private int x,y;
	public PositionChecker(int x, int y) {
		
		this.x=x;
		this.y = y;
	}

	public boolean isOnBoard() {
		return (x >= 0 && x <= 7 && y >= 0 && y <= 7);
	}
	
	public boolean isEmpty() {
		return (checkerBoard.checker[y][x]=="1");
	}

	
}
class checkerBoard{
	
	public static String[][] checker = { { " ", "  0 ", " 1 ", " 2 ", " 3 ", " 4 ", " 5 ", " 6 ", " 7 ", "<- X axis" },
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
			if (!(checker[y][x]=="1")) {
				System.err.println("You have no piece in this position");
			}else {
				checkerBoard.checker[y][x]=" ";
				printBoard();
				PositionChecker p= new PositionChecker(x,y);
				p.isEmpty();
				
			}


	}
}


	
	



public class checker {


	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		
		
		for(;;) {
			System.out.print("Enter X: ");
			int x = s.nextInt();
			System.out.print("Enter Y: ");
			int y = s.nextInt();
			
			Position p = new Position(x,y);
		
	
			
					
					
			checkerBoard board = new checkerBoard();
					
			board.changeboard(p.x, p.y, checkerBoard.checker);
			
			System.out.print("Enter X: ");
			int xx = s.nextInt();
			System.out.print("Enter Y: ");
			int yy = s.nextInt();
			Position p1 = new Position(xx,yy);	

			board.changeboard(p1.x, p1.y, checkerBoard.checker);

		
		
		}
		
		
	}

}
