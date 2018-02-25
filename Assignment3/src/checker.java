
//import the module scanner
import java.util.InputMismatchException;
import java.util.Scanner;

class Position{
	int x;
	int y;
	
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
	public onBoard() {System.err.println("The position is not on the board. Please try again\n");};
		
	
}
@SuppressWarnings("serial")
class isEmpty extends Exception {
	public isEmpty() {System.err.println("There is no piece of yours in that position. Please try again\n");};
		
	
}

class Player{
	public String Player;

	public void changePlayer(String Player) {
		this.Player=Player;
		
		
	}
	
	public String getPlayer() {
		return Player;
	}
	
	public void ran() {
		double ran= Math.random();
		ran*=2;
		String Player;
		if (ran<=1) Player="1";
		else  Player="2";
		changePlayer(Player);
		System.out.println("Player " + Player + " starts!");
		
		
		
	}
	public void changePlayer() {
		if (Player=="1") {
			Player="2";
		} else {
			Player="1";
		}
		changePlayer(Player);
		
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
	public boolean changeboard(int x, int y, String[][] checker,String Player) throws isEmpty {
		
	
		
		if (!(checker[y][x]==Player)) {
			
			throw new isEmpty();
		}else {
			checkerBoard.checker[y][x]=" ";
			printBoard();
			return false;
			
		
		}
		
	}
}


	
	



public class checker {


	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		Player player =new Player ();
		player.ran();
		checkerBoard board = new checkerBoard();
		Position p = null;
	
		
		
		
		for(;;) {
			boolean bool=true;
			board.printBoard();
			//prints output to game play
			System.out.println("\nTurn of player no. " + player.getPlayer());
			System.out.println("Coordinate of piece to move");
			
			while (bool)
			try {
			System.out.print("Enter X: ");
			int x = s.nextInt();
			System.out.print("Enter Y: ");
			int y = s.nextInt();
			
			
			
			
			
			
			p = new Position(x,y);
			bool=board.changeboard(p.x, p.y, checkerBoard.checker,player.getPlayer());
			} catch (onBoard e) {
				
			} catch (isEmpty ie) {
				
			}catch (InputMismatchException inp) {
				System.out.println("Error! Invalid input");
		         s.next();
				
			}
			player.changePlayer();
			
			
		
		}
		
		
	}

}
