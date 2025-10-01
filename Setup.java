// This class will exist as an introduction class. 
// It will welcome the player and get the necessary information needed for the game.
// import java.util.Scanner;
public class Setup {

    public Config intro(Input p, Config cfg) {
            
        System.out.println("Welcome! What game would you like to play?\n Enter 1 for sliding game and 2 for dots and boxes.");
        int choice = p.intInRange("Enter 1 or 2: ", 1, 2);
        

        if (choice == 1){
            cfg.setGameType(GameType.SLIDING);
            
        }
        else  if (choice == 1){
            cfg.setGameType(GameType.DOTS_AND_BOXES);
        }




        for (int i = 0; i < cfg.playerCount(); i++) {
            cfg.setPlayer(i, new Player(p.isLine("What is player " + (i + 1) + "'s' name? ")));
        }

        cfg.setRows(p.intAtLeast("How many rows do you want? (must be 2 or more)): ", 2));
        cfg.setColumns(p.intAtLeast("How many columns do you want? (must be 2 or more): ", 2));

        if (cfg.getGameType() == GameType.SLIDING) {
            cfg.setDifficulty(p.intInRange("What difficulty do you want from 1-5: ", 1, 5));
        }

        return cfg;

    }
    
}
