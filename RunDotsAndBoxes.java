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
        
        int rows = board.getRows();
        int cols = board.getColumns();
        int currentTurn = 0;

        while(!game.isGameOver()){
            
       

            Player curPlayer = cfg.getPlayers()[currentTurn];

            String boxPrompt = "Welcome " + curPlayer.getName() + "! It is your turn, which box would you like to select?";
            int box = p.intInRange(boxPrompt, 1, (rows-1)*(cols-1));
            
            int idx = box - 1;
            int r = idx / cols;
            int c = idx % cols;


            Piece curPiece = board.getPiece(r, c);
            
            String edgePrompt = "Good choice! Which edge would you like? (1 = top, 2 = right, 3 = bottom, 4 = left)";
            
            
            
            String edgePrompt2 = "Your choices are: " + game.unclaimedEdgesForBox(box).toString();
            
            Edge edge = p.edgeClaimed(edgePrompt + edgePrompt2, (dbPiece) curPiece);

            game.claimEdge(box, edge, curPlayer);
            System.out.println(view.display(board));

            if(game.resolveCompletedBoxes(r,c,curPlayer) == 1){
                continue;
            }
            else if(game.resolveCompletedBoxes(r,c,curPlayer) == 0){
                currentTurn = (currentTurn + 1) % 2;
            }

        }

        
     }
}
