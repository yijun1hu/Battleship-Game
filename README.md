# Battleship Game Summer 2016

Welcome to the README for Battleship Game!

### General Information
This is a Battleship game created in java and can be played in command line.

#### How to Play the Game
You have a board of 7×7.<br>
BOARD:<br>
  1 2 3 4 5 6 7 <br>
a - - - - - - - <br>
b - - - - - - - <br>
c - - - - - - - <br>
d - - - - - - - <br>
e - - - - - - - <br>
f - - - - - - - <br>
g - - - - - - - <br>

You will have 5 ships in total:
* 2 boats of size 2
* 2 boats of size 3
* 1 boat of size 5

KEY: 
* ' ' = nothing there
* 'b' = boat
* 'm' = missed
* 'h' = hit
 
The first thing you should do is to place the boats in the game board.
* Note: Boats can only go vertically or horizontally a letter means row and a number means column!
* Ex. to input a boat of size 3 in a vertical row, input 1 a b c
		or to input a boat of size 2 in a horizontal row input a 1 2
* Note: Make sure there are spaces between the input and the outputs.
 
The goal of the game is to sink all of your opponents ships before they sink all of your ships. A player has 2 different boards, 'my board' has where your ships are located and 'playing board' keeps track of all of your opponent's ships that you have hit or missed.
 
To fire, first give the row and then the number.
* Ex. to fire at position a 1, simply input in 'a 1'. <br> to fire at position 7 d, simplying input in 'd 7'.
* Note: Make sure there are spaces between the input and the outputs.
* Note: Make sure that it follows the format "row col" or "letter number" or else it will be considered invalid.

#### How this game is structured
Players have 2 different boards, their boards and their playing boards.
Their boards contains the placement of their ships and what the
where the opponents have hit and missed. The playing board records where
you have hit the opponent's ship.

#### Original Game
This game is based off of the original battleship game, see 
http://www.hasbro.com/common/instruct/Battleship.PDF for more information
	Note: The grid size and the number of boats are different in this game.

### Build
Run the following in command line:
```
javac Main.java Board.java Player.java
java Main
```