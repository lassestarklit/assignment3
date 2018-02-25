
//import the module scanner
import java.util.Scanner;

class Position{
	int x;
	int y;
	/*
	public static void onBoard(int x,int y) throws onBoard {
	if (!(x >= 0 && x <= 7 && y >= 0 && y <= 7)) {
		throw new onBoard();
	} else {}}
	*/
	public Position(int x,int y) throws onBoard {
		if (!(x >= 0 && x <= 7 && y >= 0 && y <= 7)) {
			throw new onBoard();
		}else {
		this.x=x * 2 + 2;
		this.y=y+ 2;
		}
	}
	
	
}

@SuppressWarnings("serial")
class onBoard extends Exception {
	public onBoard() {System.err.println("The position is not on the board");};
		
	
}

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
		System.out.print(x + " " + y);
		return (x >= 0 && x <= 7 && y >= 0 && y <= 7);
	}
	
	public boolean isEmpty() {
		return (!(checkerBoard.checker[y][x]=="1"));
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
			PositionChecker p= new PositionChecker(x,y);
			
			
			if(!(p.isEmpty())) {
					checkerBoard.checker[y][x]=" ";
					printBoard();
			}else {System.err.println("You have no piece in this position");}
			


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
			checkerBoard board = new checkerBoard();
			
			Position p = null;
			try {
				p = new Position(x,y);
				board.changeboard(p.x, p.y, checkerBoard.checker);
			} catch (onBoard e) {
				
			}
			
			
			
	
			
					

		
		
		}
		
		
	}

}
