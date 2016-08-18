
public class Player {
	private String name;
	private Board myBoard;
	private Board oppBoard;
	
	public Player (String name) {
		this.name = name;
		this.myBoard = new Board();
	}
	
	public String getName() {
		return this.name;
	}
	
	public Board getMyBoard() {
		return this.myBoard;
	}
	
	public void initMyBoard() {
		System.out.println("\n--------------------------------");
		System.out.println(name);
		myBoard.insertBoats();
		myBoard.print(true);
		System.out.println("--------------------------------\n");
	}
	
	public void setMyBoard(Board myBoard) {
		this.myBoard = myBoard;
	}
	
	public void printMyBoard() {
		myBoard.print(true);
	}
	
	public Board getOppBoard() {
		return this.oppBoard;
	}
	
	public void setOppBoard(Board oppBoard) {
		this.oppBoard = oppBoard;
	}
	
	public char turn (char row, char  col) {
		if (!oppBoard.legit(row, col)) {
			System.out.println("Incorrect format!!");
			return '!';
		}
		return oppBoard.turn(row, col);
	}
	
	public void printOppBoard() {
		oppBoard.print(false);
	}
	
	public void printBoards() {
		String print = "My Board :     Playing Board:\n";
			  print += "---------      ---------\n";
		for (int i = 0; i < myBoard.colsNum(); i ++) {
			print += myBoard.row(i, true);
			print += "      ";
			print += oppBoard.row(i, false);
			print += "\n"; 
		}
		print += "---------      ---------\n";
		System.out.println(print);
	}
	
	public boolean win() {
		return oppBoard.win();
	}
}