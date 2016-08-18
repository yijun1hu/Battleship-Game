
import java.util.Scanner;

public class Main {
	
	public static void main (String [] args) {
		
		
		System.out.println("Let's play Battleship!!");
		Scanner input = new Scanner (System.in);
		
		System.out.println("Player 1, please enter your name : ");
		String name1 = input.nextLine();
		Player player1 = new Player(name1);
		
		System.out.println("Player 2, please enter your name : ");
		String name2 = input.nextLine();
		Player player2 = new Player(name2);
		
		player1.initMyBoard();
		player2.initMyBoard();
		
		player1.setOppBoard(player2.getMyBoard());
		player2.setOppBoard(player1.getMyBoard());
		
		
		System.out.println("Let's Play");
		
		play(player1, player2, input);
	}
	
	public static void play(Player player1, Player player2, Scanner input) {
		boolean noWinner = false;
		int count = 0;
		while(!noWinner) {
			if (count % 2 == 0) {

				System.out.println("-------------------------------------------");
				System.out.println(player1.getName() + " : Your turn to guess");
				System.out.println("Your Game Boards :");
				player1.printBoards();
				
				System.out.println("Your Move, " + player1.getName() + " !");
				char result = ' ';
				int tries = 0;
				do {
					if (tries != 0) {
						System.out.println("Bad move, try again!!");
					}
					char row =  input.next().charAt(0);
					char col =  input.next().charAt(0);
					result = player1.turn(row, col);
					tries ++;
				} while (result == '!');
				player2.setOppBoard(player1.getMyBoard());
				player2.setMyBoard(player1.getOppBoard());
				
				noWinner = player1.win();

				System.out.println("-------------------------------------------\n");
			} else {
				System.out.println("-------------------------------------------");
				System.out.println( player2.getName() + " : Your turn to guess");
				System.out.println("Your Game Boards :");
				player2.printBoards();
				
				System.out.println("Your Move, " + player2.getName() + " !");
				char result = ' ';
				int tries = 0;
				do {
					if (tries != 0) {
						System.out.println("Bad move, try again!!");
					}
					char row =  input.next().charAt(0);
					char col =  input.next().charAt(0);
					result = player2.turn(row, col);
					tries ++;
				} while (result == '!');
				
				player1.setOppBoard(player2.getMyBoard());
				player1.setMyBoard(player2.getOppBoard());
				
				noWinner = player2.win();
				System.out.println("-------------------------------------------\n");
			}
			count ++;
		}
		
		System.out.println("\n-------------------------------------------");
		if (player1.win()) {
			System.out.println(player1.getName() + " wins!!");
		} else if (player2.win()) {
			System.out.println(player2.getName() + " wins!!");
		}
		System.out.println("-------------------------------------------\n");
	}
}