

import java.util.InputMismatchException;
import java.util.Scanner;
//self made exceptions. 
@SuppressWarnings("serial")
class onBoard extends Exception {
	public onBoard() {System.err.println("The position is not on the board. Please try again\n");};
		
	
}
@SuppressWarnings("serial")
class isEmpty extends Exception {
	public isEmpty() {System.err.println("There is no piece of yours in that position. Please try again\n");};
		
	
}
@SuppressWarnings("serial")
class notEmpty extends Exception {
	public notEmpty() {System.err.println("The position is already occupied. Please try again\n");};
		
	
}
@SuppressWarnings("serial")
class illegalMove extends Exception {
	public illegalMove() {System.err.println("The move is not allowed! Please try again\n");};
		
	
}
//Class that holds the position on the board
class Position{
	int x,y;
	
/*the constructor position  with  a coordinate as input.
It checks if user's desired position is on the board. 
If it isn't the self made exception onBoard is thrown.
If it is the position will get adjusted to the board.
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


//Player class determines, whose turn it is, changes the turn etc.
class Player{
	public String Player;
	/*
	public void currentPlayer(String Player) {
		this.Player=Player;
		
		
	}
	*/
	public String getPlayer() {
		return Player;
	}
	
//Generates random outcome to choose player to start in the beginning
	public void ran() {
		double ran= Math.random();
		ran*=2;
		//String Player;
		if (ran<=1) Player="1";
		else  Player="2";
		//Player="2";;
		System.out.println("Player " + Player + " starts!");
		
		
//Method to change player		
	}
	public void changePlayer() {
		if (Player=="1") {
			Player="2";
		} else {
			Player="1";//currentPlayer("1");
		}
		
		
	}
	
}
//Class to define checkboard, moves etc.
class checkerBoard{
	//Create checker board as matrix	
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
	
	


//method to print board. Uses two nested for loops, which will print the checker board. 
//Each column (j) at a time.
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
//Method to move piece. 
	public void movepPiece(int x, int y, String Player) {
		checker[y][x]=Player;
	}
//Method to clear position when moved
	public void clearPosition(int x, int y) {
		checker[y][x]=" ";
	}
//Method to check the user input. If it indeed is a current position
//current position, it will clear the position to be ready move to new position
//And return false in order to get out of the first while loop in main
	public boolean currentPosition(int x, int y,String Player) throws isEmpty {

		if (!(checker[y][x]==Player)) {
			throw new isEmpty();
		}else {
			clearPosition(x, y);
			return false;
		}	
	}
//Method to check if the desired new position is a legal move
	public boolean newPosition(int x, int y, int ox, int oy, String Player)
			throws notEmpty, illegalMove {

		boolean bool = true;
		if (!(checker[y][x] == " ")) {

			throw new notEmpty();
		} else {
			if (Player == "1") {
				// switch operator, checking how many fields player 1 wants to move its' brick.
				switch (y - oy) {

				// if the player only moves the brick one field in the vertical direction, the
				// only possible move is to either
				// move the brick 1 to the left or right
				case (1):
					if ((x - ox) / 2 == -1 || (x - ox) / 2 == 1) {
						movepPiece(x, y, Player);
						bool = false;
						break;

					}

				case (2):
					// if the player moves the brick two fields in the vertical direction, there are
					// 2 possible scenarios which are
					// to move the brick 2 to the left or right. It checks whether there is an
					// opponent's brick in between.
					// and if there it it removes the brick. If not, the move will be illegal.

					if ((x - ox) / 2 == -2 && checker[oy + 1][ox - 2] == "2") {
						movepPiece(x, y, Player);
						clearPosition(ox - 2, oy + 1);

						System.out.println("Opponent's brick removed from table");
						bool = false;
						break;
					} else if ((x - ox) / 2 == 2 && checker[oy + 1][ox + 2] == "2") {
						movepPiece(x, y, Player);
						clearPosition(ox + 2, oy + 1);

						System.out.println("Opponent's brick removed from table");
						bool = false;
						break;

					}
//If none of the cases are true, the exception illegalMove will get thrown. 
				default: throw new illegalMove();

				}
			}
			// Same principal for player 2
			if (Player == "2") {
				switch (y - oy) {
				case (-1):
					if ((x - ox) / 2 == -1 || (x - ox) / 2 == 1) {
						movepPiece(x, y, Player);
						bool = false;
						break;

					}

				case (-2):

					if ((x - ox) / 2 == -2 && checker[oy - 1][ox - 2] == "1") {
						movepPiece(x, y, Player);
						clearPosition(ox - 2, oy - 1);

						System.out.println("Opponent's brick removed from table");
						bool = false;
						break;

					} else if ((x - ox) / 2 == 2 && checker[oy - 1][ox + 2] == "1") {
						movepPiece(x, y, Player);
						clearPosition(ox + 2, oy - 1);

						System.out.println("Opponent's brick removed from table");
						bool = false;
						break;

					}
				default:
					throw new illegalMove();
				}
			}
		}
			return bool;
		
	}
}


	
	



public class checker {


	public static void main(String[] args) {

//Calls different classes
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		Player player =new Player ();
//Randomly selects a player to start using the method ran in the class Player
		player.ran();
		checkerBoard board = new checkerBoard();
//Creates the static type p from class Position , and let dynamic type =null. 
//Used later for user input.
		Position p = null;

		
		for(;;) {
			boolean bool=true;
			board.printBoard();
			
			System.out.println("\nTurn of player no. " + player.getPlayer());
			System.out.println("Coordinate of piece to move");
//prompts player for input, and uses a try/catch to determine if an exception is met. If something is wrong
//with the input, the while loop will start over. If not, the constructor in Position will create the 
//user input as coordinates and then use it in the method currentPosition, in the checkerBoard class		
			while (bool) {
				try {
				System.out.print("Enter X: ");
				int x = s.nextInt();
				System.out.print("Enter Y: ");
				int y = s.nextInt();
				p = new Position(x,y);
				bool=board.currentPosition(p.x, p.y,player.getPlayer());
				
				} catch (onBoard e) {
					
				} catch (isEmpty ie) {
					
				}catch (InputMismatchException inp) {
					System.out.println("Error! Invalid input");
			         s.next();
					
				}
			} 
			bool=true;
//Defining the coordinates which are now "old" 
			int oldx=p.x;
			int oldy=p.y;
			System.out.println("\nCoordinate of new position");
//Same principle as first while loop
			while (bool) {
				
				try {
					
					System.out.print("Enter new X: ");
					int nx = s.nextInt();
					System.out.print("Enter new Y: ");
					int ny = s.nextInt();

					p = new Position(nx,ny);

					bool=board.newPosition(p.x, p.y,oldx,oldy,player.getPlayer());
					
					} catch (onBoard e) {
						
					} catch (notEmpty ne) {
						
					}catch (illegalMove ie) {
						
					}catch (InputMismatchException inp) {
						System.out.println("Error! Invalid input");
				         s.next();
						
					} 
			}
			System.out.println("Piece moved! \n");
//Changes player using the method in the class Player
			player.changePlayer();

		}
		
		
	}

}
