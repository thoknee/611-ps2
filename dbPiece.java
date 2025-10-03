/*
 * This will hold the dots/boxes piece. 
 * 
 *  It will have a player associated with it and should check if the piece completes a box
 * 
 * 
 * 
 */

public class dbPiece implements Piece{
    
    // hold which player owns this dot/boxes piece
    private Player player;

    public dbPiece(){

    }
    public boolean isBlank(){
         return false;
    }

}
