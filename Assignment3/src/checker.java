
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
	public static void isEmpty(int x,int y, String[][] checker) {
		if (!(checker[y][x]=="1")) {
			System.err.println("NO PIECE");
			
		}
		
	}
}
*/
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
		if (!(checker[y][x]=="1")) {
			System.err.println("You do not have a piece in that position");
			
		}else {
		this.checker[y][x]=" ";
		printBoard();
		
		}
		
	}


}


	
	



public class checker {


	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		
		System.out.print("Enter X: ");
		int x = s.nextInt();
		System.out.print("Enter Y: ");
		int y = s.nextInt();
		
		Position p = new Position(x,y);
	

		
				
				
		checkerBoard board = new checkerBoard();
				
		
		board.changeboard(p.x, p.y, board.checker);
		
		
		
		//New move
		System.out.print("Enter X: ");
		int xx = s.nextInt();
		System.out.print("Enter Y: ");
		int yy = s.nextInt();
		Position p1 = new Position(xx,yy);	

		board.changeboard(p1.x, p1.y, board.checker);

		
		//New move
		System.out.print("Enter X: ");
		int xxx = s.nextInt();
		System.out.print("Enter Y: ");
		int yyy = s.nextInt();
		Position p2 = new Position(xxx,yyy);	

		board.changeboard(p2.x, p2.y, board.checker);
			
	

				
				
		
	}

}
