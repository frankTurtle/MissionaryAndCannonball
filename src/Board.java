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
    final int[] GOAL_STATE = new Board().getBoard();

    public Board(){
        this( new int[]{0,0,3,3,RIGHT} );
    }

    public Board( int[] arrayIn ){
        board = new int[ arrayIn.length ];
        System.arraycopy( arrayIn, 0, board, 0, arrayIn.length );
    }

    private int[] getBoard(){
        int[] returnArray = new int[ board.length ];
        System.arraycopy(board,0, returnArray,0, board.length );
        return returnArray;
    }

    public String toString(){
        String returnString = "";
        String[] labels = { "Missionaries Left: ",
                "Cannibals Left: ",
                "Missionaries Right: ",
                "Cannibals Right: ",
                "Boat Side: "};

        for( int i = 0; i < labels.length; i++ ){
            returnString += String.format( "%s %d", labels[i], board[i] );
        }

        return returnString;
    }

}
