/*
 * 
 *  NEEDS IMPLEMENTATION 
 *  
 *  Will run dots and boxes similar to RunSliding.java
 * 
 *  Written by Tony Ponomarev and Olivia Ma
 * 
 */

public class RunDotsAndBoxes {
    public void runGame(Config cfg, ConsoleInput p) {
        
        
        Board board = new Board(cfg);
        dbGame game = new dbGame(board);

        Display<Board> view = new dbDisplay();
        System.out.println(view.display(board));        

        
     }
}
