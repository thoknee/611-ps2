/*
 * 
 *  Handles the logic of the game actually playing. 
 *  
 * 
 * 
 * 
 */
import java.util.Scanner;

public class Play {
    
    private final Scanner sc;
    private final ConsoleInput p; 

    public Play() {
        this.sc = new Scanner(System.in);
        this.p = new ConsoleInput(sc);
    }

    public void run(){
        
        Setup setup = new Setup();
        boolean again;

        do {
            Config cfg = new Config();
            cfg = setup.intro(p, cfg);

            RunGame runSlide = new RunSliding();

            switch (cfg.getGameType()) {
                case SLIDING:
                    runSlide.runGame(cfg, p);
                    break;
                case DOTS_AND_BOXES:
                    // runDotsAndBoxes(cfg);
                    break;
            }

            again = p.intInRange("Would you like to play again? 0 = No, 1 = yes", 0, 1) == 1;
        } while (again);
    }
}



