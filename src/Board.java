
import java.util.Scanner;
import java.util.Stack;

public class Board {
	private int [][] board;
	private Stack<Integer> boats;
	
	public Board () {
		this.board = new int [7][7];
		for (int i = 0; i < this.board.length; i++) {
			for(int j = 0; j < this.board[0].length; j++) {
				this.board[i][j] = 0;
			}
		}
		this.boats = new Stack<Integer>();
		createBoats();
	}
	
	private void createBoats() {
		/*this.boats.push(5);
		this.boats.push(3);
		this.boats.push(3);
		this.boats.push(2);*/
		this.boats.push(2);
	}
	
	public void insertBoats() {
		System.out.println("You have 5 types of boats : \n"
				+ "  1 of size 5, 2 of size 3 and 2 of size 3");
		System.out.println("Let's place your boats! \n"
				+ "Please Note: Boats can only go vertically or horizontally"
				+ " a letter means row and a number means column! \n"
				+ "Ex. to input a boat of size 3 in a vertical row, input 1 a b c \n"
				+ "    or to input a boat of size 2 in a horizontal row input a 1 2 \n"
				+ "Note: this program won't work without spaces!");
		
		boolean conti = false;
		int count;
		while (!boats.isEmpty()) {
			int key = boats.pop();
			count = 0;
			Scanner input = new Scanner (System.in);
			System.out.println("\n Where do you want to insert a boat of size " + key);
			
			while (conti == false) {
				if(count != 0) {
					System.out.println("Try Again, Error exists in input");
					print(true);
				}
				char rOrC= input.next().charAt(0);
				char [] readInput = new char[key];
				for (int i = 0; i < readInput.length; i ++) {
					readInput[i] = input.next().charAt(0);
				}
				conti = setBoard(rOrC, readInput);
				count++;
			}
			conti = false;
		}
	}
	
	public boolean setBoard(char rOrC, char[] inputs) {
		if (rOrC <= 'g' && rOrC >= 'a') {
			return insertBoatHorizontal(rOrC, inputs);
		} else if (rOrC <= '7' && rOrC >= '1') {
			return insertBoatVertical(rOrC, inputs);
		} else {
			return false;
		}
	}
	
	/**
	 * Insert a boat horizontally
	 * @param rOrC the column to put it in
	 * @param inputs the rows in the column where the boat will be
	 * @return true if the boat is correctly placed
	 */
	public boolean insertBoatHorizontal(char rOrC, char[] inputs) {
		boolean continueOn = true;
		int row = rOrC - 'a';
		
		int [] cols = new int[inputs.length];
		for (int i = 0; i < inputs.length; i++) {
			cols[i] = inputs[i] - '0' - 1;
		}
		int change = inputs[0] - '0';
		
		for (int i = 0; i < cols.length; i++) {
			if (cols[i] < this.board[0].length) {
				if (cols[i] - change == -1 || cols[i] - change == 1) {
					change = cols[i];
				} else {
					continueOn = false;
				}
			} else { 
				continueOn = false;
			}
		}
		if (continueOn) {
			for(int i = 0; i < cols.length; i++) {
				if(!checkDefault(row, cols[i])) {
					continueOn = false;
				}
			}
		}
		if (continueOn) {
			for (int i = 0; i < cols.length; i++) {
				this.board[row][cols[i]] = 1;
			}
		}
		return continueOn;
	}

	/**
	 * Insert a boat vertically
	 * @param rOrC the column to put it in
	 * @param inputs the rows in the column where the boat will be
	 * @return true if the boat is correctly placed
	 */
	public boolean insertBoatVertical(char rOrC, char[] inputs) {
		boolean continueOn = true;
		int col = rOrC - '1';
		int [] rows = new int[inputs.length];
		for (int i = 0; i < inputs.length; i++) {
			rows[i] = inputs[i] - 'a';
		}
		int change = inputs[0] - 'a' + 1;
		
		for (int i = 0; i < rows.length; i++) {
			if (rows[i] < this.board.length) {
				if (rows[i] - change == -1 || rows[i] - change == 1) {
					change = rows[i];
				} else {
					continueOn = false;
				}
			} else { 
				continueOn = false;
			}
		}
		if (continueOn) {
			for(int i = 0; i < rows.length; i++) {
				if(!checkDefault(rows[i], col)) {
					continueOn = false;
				}
			}
		}
		for (int i = 0; i < rows.length; i++) {
			this.board[rows[i]][col] = 1;
		}
		return continueOn;
	}
	
	/**
	 * Check if the placement of board[row][col] is blank.
	 * @param row the row to check
	 * @param col the col to check
	 * @return true if nothing is there
	 */
	public boolean checkDefault(int row, int col) {
		if (this.board[row][col] == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public boolean win() {
		for (int i = 0; i < this.board.length; i++) {
			for(int j = 0; j < this.board[0].length; j++) {
				if (this.board[i][j] == 1) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * Print the board.
	 * @param set if the boolean is true, show where the boats 
	 * are, if false the boats are no longer shown
	 */
	public void print(boolean set) {
		char [][] boardChar = new char [this.board.length][this.board[0].length];
		for (int i = 0; i < this.board.length; i++) {
			for(int j = 0; j < this.board[0].length; j++) {
				if (this.board[i][j] == 0) {
					boardChar[i][j] =' ';
				} else if (this.board[i][j] == 1) {
					if (set == true) {
						boardChar[i][j] ='B';
					} else {
						boardChar[i][j] =' ';
					}
				} if (this.board[i][j] == 2) {
					boardChar[i][j] ='M';
				} if (this.board[i][j] == 3) {
					boardChar[i][j] ='H';
				}
			}
		} 
		
		System.out.println("----------------");
		for (int i = 0; i < boardChar.length; i++) {
			System.out.print("|");
			for(int j = 0; j < boardChar[0].length; j++) {
				System.out.print(boardChar[i][j] + " ");
			}
			System.out.println("|");
		} 
		System.out.println("----------------");
	}
	
	public char turn(char row, char col) {
		int i = row - 'a';
		int j = col - '1';
		char hitOrMiss;
		if (this.board[i][j] == 0) {
			this.board[i][j] = 2;
			hitOrMiss = 'm';
			System.out.println("MISS");
		} else if (this.board[i][j] == 1) {
			this.board[i][j] = 3;
			hitOrMiss = 'h';
			System.out.println("HIT");
		} else {
			hitOrMiss = '!';
		}
		return hitOrMiss;
	}
	
	
	public String row(int row, boolean set) {
		String rowStr = "|";
		for (int col = 0; col < this.board[0].length; col++) {
			if (this.board[row][col] == 0) {
				rowStr += " ";
			} else if (this.board[row][col] == 1) {
				if (set == true) {
					rowStr += "B";
				} else {
					rowStr += " ";
				}
			} if (this.board[row][col] == 2) {
				rowStr += "M";
			} if (this.board[row][col] == 3) {
				rowStr += "H";
			}
		}
		rowStr += "|";
		return rowStr;
	}
	
	public int colsNum() {
		return this.board.length;
	}
	
	public boolean legit(char row, char col) {
		if (row <= 'g' && row >= 'a'  && col <= '7' && col >= '1') {
			return true;
		} else {
			return false;
		}
	}
}