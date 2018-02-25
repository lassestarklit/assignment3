
//import the module scanner
import java.util.InputMismatchException;
import java.util.Scanner;

class Position{
	int x,y;
	
	
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
@SuppressWarnings("serial")
class notEmpty extends Exception {
	public notEmpty() {System.err.println("The position is already occupied. Please try again\n");};
		
	
}
@SuppressWarnings("serial")
class illegalMove extends Exception {
	public illegalMove() {System.err.println("The move is not allowed! Please try again\n");};
		
	
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
	public boolean currentPosition(int x, int y, String[][] checker,String Player) throws isEmpty {
		
	
		
		if (!(checker[y][x]==Player)) {
			
			throw new isEmpty();
		}else {
			checkerBoard.checker[y][x]=" ";
			return false;
			
			
		
		}
		
		
	}
		public boolean newPosition(int x, int y,int ox,int oy, String[][] checker,String Player) throws notEmpty,illegalMove {
			
		
			
			boolean bool = true;
			if (!(checker[y][x]==" ")) {
				
				throw new notEmpty();
			}else {
				if (Player=="1") {
					//switch operator, checking how many fields player 1 wants to move its' brick. 
						switch(y-oy) {
						
						//if the player only moves the brick one field in the vertical direction, the only possible move is to either 
						//move the brick 1 to the left or right
							case (1) :
								if ((x-ox)/2==-1 || (x-ox)/2==1) {
									checkerBoard.checker[y][x]="1";
									bool=false;
									break;
								
								}
								
							case (2):
						//if the player moves the brick two fields in the vertical direction, there are 2 possible scenarios which are
						//to move the brick 2 to the left or right. It checks whether there is an opponent's brick in between.
						//and if there it it removes the brick. If not, the move will be illegal.
								
								if ((x-ox)/2==-2  && checker[oy+1][ox-2]=="2" ) {
									checkerBoard.checker[y][x]="1"; 
									checkerBoard.checker[oy+1][ox-2]=" "; 
									System.out.println("Opponent's brick removed from table");
									bool=false;
									break;
								} else if ((x-ox)/2==2  && checker[oy+1][ox+2]=="2" ) {
									checkerBoard.checker[y][x]="1"; 
									checkerBoard.checker[oy+1][ox+2]=" "; 
									System.out.println("Opponent's brick removed from table");
									bool=false;
									break;
									
									
								}
							
							default:throw new illegalMove();

							
						}
				}
						//Same principal for player 2
						if (Player=="2") {
							switch(y-oy) {
							case (-1) :
								if ((x-ox)/2==-1 || (x-ox)/2==1) {
									checkerBoard.checker[y][x]="2";
									bool=false;
									break;
									
								}
								
								
								
							case (-2):
							
								if ((x-ox)/2==-2  && checker[oy-1][ox-2]=="1") {
									checkerBoard.checker[y][x]="2";
									checkerBoard.checker[oy-1][ox-2]=" "; 
									System.out.println("Opponent's brick removed from table");
									bool=false;
									break;
									
								} else if ((x-ox)/2==2  && checker[oy-1][ox+2]=="1") {
									checkerBoard.checker[y][x]="2";
									checkerBoard.checker[oy-1][ox+2]=" "; 
									System.out.println("Opponent's brick removed from table");
									bool=false;
									break;
									
								}
							default:throw new illegalMove();
							}
						}
			}
			return bool;
		
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
			
			while (bool) {
				try {
				System.out.print("Enter X: ");
				int x = s.nextInt();
				System.out.print("Enter Y: ");
				int y = s.nextInt();
				
				
				
				
				
				
				p = new Position(x,y);
				bool=board.currentPosition(p.x, p.y, checkerBoard.checker,player.getPlayer());
				
				} catch (onBoard e) {
					
				} catch (isEmpty ie) {
					
				}catch (InputMismatchException inp) {
					System.out.println("Error! Invalid input");
			         s.next();
					
				}
			} 
			bool=true;
			int oldx=p.x;
			int oldy=p.y;
			System.out.println("\nCoordinate of new position");
			while (bool) {
				
				try {
					
					System.out.print("Enter new X: ");
					int nx = s.nextInt();
					System.out.print("Enter new Y: ");
					int ny = s.nextInt();
					
					
					
					
					
					p = new Position(nx,ny);
					
					
					bool=board.newPosition(p.x, p.y,oldx,oldy, checkerBoard.checker,player.getPlayer());
					
					} catch (onBoard e) {
						
					} catch (notEmpty ne) {
						
					}catch (illegalMove ie) {
						
					}catch (InputMismatchException inp) {
						System.out.println("Error! Invalid input");
				         s.next();
						
					} 
			}
			System.out.println("Piece moved! \n");
			player.changePlayer();
			
		
		}
		
		
	}

}
