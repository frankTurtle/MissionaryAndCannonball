/**
 * MissionaryAndCannibal class
 * this class represents the actual gameplan
 *
 * Created 02/08/2016
 * Updated 02/08/2016
 * Author: Barret J. Nobel
 * Contact: bear.nobel at gmail
 */

public class MissionaryAndCannibal {
    public static void main( String[] args ){
        Board newBoard = new Board();

        System.out.println( newBoard );

//        System.out.println( newBoard.equals(new Board( new int[]{ 3,0,0,3,0 }, 0) ));
//        System.out.println( newBoard.isValidBoard( newBoard ));
        newBoard.equals(new Board( new int[]{ 2,0,3,0,1 }, 0) );
        System.out.println( newBoard.isValidBoard( newBoard ));
    }
}
