import java.util.ArrayList;

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
    final static int MSSNRY_LEFT = 0;
    final static int CNNBL_LEFT = 1;
    final static int MSSNRY_RIGHT = 2;
    final static int CNNBL_RIGHT = 3;
    final static int BOAT_LOC = 4;

    private static int[] board;
    private int currentLevel;

    // Default constructor
    public Board(){
        board = new int[]{ 0,0,3,3, RIGHT };
        currentLevel = 0;
    }

    // Constructor with parameters
    // takes in an array to create a new board with
    public Board( int[] arrayIn, int level ){
        board = new int[ arrayIn.length ]; //................... instantiates local array
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
        String[] labels1 = { "Missionaries Left: ",
                            "Cannibals Left: ",
                            "Boat Side: "};
        String[] labels2 = { " :Missionaries Right",
                             " :Cannibals Right"};
        int[] values = new int[] { board[MSSNRY_RIGHT], board[CNNBL_RIGHT] };

        for( int i = 0; i < labels1.length; i++ ){
            if( i == labels1.length - 1){
                if( board[BOAT_LOC] == RIGHT ){
                    returnString += String.format("%21s %-6s %-21s%n", " ", "Right", ":Boat Side");
                }
                else{
                    returnString += String.format("%21s %-6s%n", "Boat Side: ","Left");
                }
            }
            else{
                returnString += String.format( "%21s %d %d   %-21s%n", labels1[i], board[i], values[i], labels2[i] );
            }
        }

        return returnString += String.format( "%21s %d%n", "Current Value: ", this.getValue() );
    }

    // Method to check if the object is equal
    // Overrides equals method
    public boolean equals( Object checkMe ){
        if( this == checkMe )return true; //................................. if it is itself then it equals itself ... GO FIGURE!
        if( !(checkMe instanceof Board) ) return false; //................... if its not even an object of this class it's clearly not going to be equal

        Board compareTo = (Board) checkMe; //................................ cast the object to check instance variables
        for( int i = 0; i < compareTo.getBoard().length; i++ ){
            if( compareTo.getBoard()[i] != board[i] ) return false;
        }

        return compareTo.currentLevel == this.currentLevel; //............... compare levels
    }

    // Method to get the value
    // determined by the following
    // 3 points for each Missionary on the Left
    // 2 points for each Cannibal on the Left
    // 1 point if the boat is on the Left
    // n points based on the current level
    public int getValue(){
        int returnValue = 0;

        for( int i = 0; i < board.length; i++ ){
            switch( i ){
                case MSSNRY_LEFT: //........................................ Missionary Left
                    returnValue += ( 3 * board[i] );
                    break;

                case CNNBL_LEFT: //......................................... Cannibal Left
                    returnValue += ( 2 * board[i] );
                    break;

                case BOAT_LOC: //........................................... Boat location
                    if( board[i] == LEFT ) returnValue += 1;
                    break;
            }
        }

        return (returnValue + currentLevel); //................... add in current level
    }

    public Board[] getAvailableMoves(){
        ArrayList<Board> returnBoard = new ArrayList<>();
        Board copyBoard = new Board( board, this.currentLevel );

        if( copyBoard.getBoard()[BOAT_LOC] == RIGHT ){ //.................. we've going to move left

        }
        else{ //........................................................... we're going to move right

        }

        return (Board[])returnBoard.toArray();
    }

    public static boolean isValidBoard( Board testMe ) {
        System.out.println( testMe );

        for (int i = 0; i < testMe.getBoard().length; i++) {
            switch (i) {
                case MSSNRY_LEFT:
                case CNNBL_RIGHT:
                    if (!(board[MSSNRY_RIGHT] >= testMe.getBoard()[CNNBL_RIGHT]))
                        return false;

                case CNNBL_LEFT:
                case MSSNRY_RIGHT:
                    if (!(board[MSSNRY_LEFT] >= testMe.getBoard()[CNNBL_LEFT]))
                        return false;
            }
        }
        return true;
    }

    private void moveBoard( Board board, int direction ){
        switch( direction ){
            case LEFT:

                break;

            case RIGHT:
                break;
        }
    }
}
