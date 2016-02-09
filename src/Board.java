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
    final static int RIGHT = 0;
    final int LEFT = 1;
    final int[] GOAL_STATE = new int[]{ 0,0,3,3, RIGHT }; //. ideal state, when we're done
    private int[] board;
    private int currentLevel;

    // Default constructor
    public Board(){
        this.board = new int[]{ 0,0,3,3, RIGHT };
        currentLevel = 0;
    }

    // Constructor with parameters
    // takes in an array to create a new board with
    public Board( int[] arrayIn, int level ){
        this.board = new int[ arrayIn.length ]; //................... instantiates local array
        System.arraycopy( arrayIn, 0, board, 0, arrayIn.length ); //. copy the one passed in
        currentLevel = level; //..................................... sets current level of the object
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
    //         Current Value:  0
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

        return returnString += String.format( "%21s %d%n", "Current Value: ", this.getValue() );
    }

    // Method to get the value
    // determined by the following
    // 3 points for each Missionary on the Left
    // 2 points for each Cannibal on the Left
    // 1 point if the boat is on the Left
    // n points based on the current level
    public int getValue(){
        int returnValue = 0;

        for( int i = 0; i < this.board.length; i++ ){
            switch( i ){
                case 0: //........................................ Missionary Left
                    returnValue += ( 3 * this.board[i] );
                    break;

                case 1: //........................................ Cannibal Left
                    returnValue += ( 2 * this.board[i] );
                    break;

                case 4: //........................................ Boat location
                    if( this.board[i] == LEFT ) returnValue += 1;
                    break;
            }
        }

        return (returnValue + currentLevel); //................... add in current level
    }
}
