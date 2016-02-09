/**
 * Board class
 * this class represents the gameboard at a current state
 *
 * Created 02/08/2016
 * Updated 02/08/2016
 * Author: Barret J. Nobel
 * Contact: bear.nobel at gmail
 */

public class Board {
    private int[] board;
    final static int RIGHT = 0;
    final int LEFT = 1;
    final int[] GOAL_STATE = new int[]{ 0,0,3,3, RIGHT }; //. ideal state, when we're done

    // Default constructor
    public Board(){
        this.board = new int[]{ 0,0,3,3, RIGHT };
    }

    // Constructor with parameters
    // takes in an array to create a new board with
    public Board( int[] arrayIn ){
        this.board = new int[ arrayIn.length ]; //................... instantiates local array
        System.arraycopy( arrayIn, 0, board, 0, arrayIn.length ); //. copy the one passed in
    }

    // Method to get the board as an array
    // returns a copy
    private int[] getBoard(){
        int[] returnArray = new int[ board.length ];
        System.arraycopy(board,0, returnArray,0, board.length );
        return returnArray;
    }

    // Overridden toString
    // formatted as:
    //     Missionaries Left:  0
    //        Cannibals Left:  0
    //    Missionaries Right:  3
    //       Cannibals Right:  3
    //             Boat Side:  Right
    public String toString(){
        String returnString = "";
        String[] labels = { "Missionaries Left: ",
                            "Cannibals Left: ",
                            "Missionaries Right: ",
                            "Cannibals Right: ",
                            "Boat Side: "};

        for( int i = 0; i < labels.length; i++ ){
            if( i == labels.length - 1 ){
                returnString += String.format( "%21s %s%n", labels[i], (board[i] == RIGHT) ? "Right" : "Left");
            }
            else{
                returnString += String.format( "%21s %d%n", labels[i], board[i] );
            }
        }

        return returnString;
    }

}
