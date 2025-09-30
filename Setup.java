// This class will exist as an introduction class. 
// It will welcome the player and get the necessary information needed for the game.
import java.util.Scanner;
public class Setup {

    public Config intro(Input p, Config cfg) {
            
        System.out.println("Select a game:\n  1) Sliding Game\n  2) Dots & Boxes");
        int choice = p.intInRange("Enter 1 or 2: ", 1, 2);
        cfg.setGameType(choice == 1 ? GameType.SLIDING : GameType.DOTS_AND_BOXES);

        for (int i = 0; i < cfg.playerCount(); i++) {
            cfg.setPlayer(i, new Player(p.isLine("Player " + (i + 1) + " name: ")));
        }

        cfg.setRows(p.intAtLeast("Rows (>=2): ", 2));
        cfg.setColumns(p.intAtLeast("Columns (>=2): ", 2));

        if (cfg.getGameType() == GameType.SLIDING) {
            cfg.setDifficulty(p.intInRange("Difficulty 1–5: ", 1, 5));
        }

        return cfg;

    }
    
}
