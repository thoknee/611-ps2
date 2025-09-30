import java.util.Arrays;
import java.util.Scanner;

public class Play {
    
    // Stores the amount of moves
    private int moves = 0;

    private final Scanner sc;
    private final Input p;

    public Play() {
        this.sc = new Scanner(System.in);
        this.p = new ConsoleInput(sc);
    }


    public void run(){
        
        Setup setup = new Setup();
        boolean again;

        do {
            Config cfg = new Config();
            cfg = setup.intro(p, cfg);       // prompts game, players, rows/cols, difficulty (if Sliding)

            switch (cfg.getGameType()) {
                case SLIDING:
                    runSliding(cfg);
                    break;
                case DOTS_AND_BOXES:
                    // runDotsAndBoxes(cfg);    // stub for now
                    break;
            }

            again = p.intInRange("Play again? (1=yes, 0=no): ", 0, 1) == 1;
        } while (again);
    }
        private void runSliding(Config cfg) {
        Board board = new Board(cfg);              // Board(config) as you had
        SlidingGame game = new SlidingGame(board); // same constructor
        game.initializeWin();
        game.shuffleBoard(cfg.getDifficulty());

        System.out.println(board.displayBoard(board.getBoard()));  // requires displayBoard() no-arg
        int moves = 0;

        while (true) {
            int move = p.isInt("What number would you like to move to the empty square? ");

            int direction = game.findMove(move);
            if (direction == -1 || !game.validMove(direction)) {
                System.out.println("That is not a possible move right now.");
                continue;
            }

            game.makeMove(direction);
            System.out.println(board.displayBoard(board.getBoard()));
            moves++;

            // Win check (keeps your old approach)
            if (game.isSolved()) {
                Player p0 = cfg.getPlayer(0);
                if (p0 != null) p0.incrementWins();
                System.out.println("Well done " + cfg.getPlayer(0).getName() + "! You won in " + moves + " move(s).");
                System.out.println("Total wins: " + (p0 == null ? 1 : p0.getWins()));
                break;
            }
        }
    }

    }



