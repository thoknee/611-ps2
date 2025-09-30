// This has all the logic behind the sliding game. It builds on the Board method

import java.util.Random;

public class SlidingGame extends Game{

    // Needed for this specific game
    private int blankRow;
    private int blankColumn;
    
    
    public SlidingGame(Board board){
        super(board);
        int rows = this.board.getRows();
        int columns = this.board.getColumns();

        // Fills empty board
        int count = 1;
        for(int i = 0; i < this.board.getBoard().length;i++){
            for (int j = 0;j< this.board.getBoard()[0].length; j++){
                this.board.getBoard()[i][j] = count;
                count++;
            }
        }

        this.board.getBoard()[rows-1][columns-1] = -1;
        this.blankRow = rows-1;
        this.blankColumn = columns - 1;
    }

    // Gets the winning state we compare with/
    public void initializeWin(){
        this.winningState = new int[this.board.getRows()][this.board.getColumns()];
        for(int i = 0; i < this.board.getRows(); i ++){
            for(int j = 0; j < this.board.getColumns();j ++){
                this.winningState[i][j] = this.board.getBoard()[i][j];
            }
    }
}

public boolean isSolved() {
    int rows = board.getRows(), cols = board.getColumns();
    int expect = 1;
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (i == rows - 1 && j == cols - 1) {
                if (board.getBoard()[i][j] != -1) return false;
            } else {
                if (board.getBoard()[i][j] != expect++) return false;
            }
        }
    }
    return true;
}

    // Translates the value moved into a cardinal direction that works easier with the move function
    public int findMove(int value){
        if(this.blankRow == 0){
        }
        else if(this.board.getBoard()[this.blankRow - 1][this.blankColumn] == value){
            return 1;
        }

        if(this.blankColumn == this.board.getBoard()[0].length - 1){

        }
        else if(this.board.getBoard()[this.blankRow][this.blankColumn + 1] == value){
            return 2;
        }

        if(this.blankRow == this.board.getBoard().length - 1){

        }
         else if(this.board.getBoard()[this.blankRow + 1][this.blankColumn] == value){
            return 3;
        }

        if(this.blankColumn == 0){

        }
        else if(this.board.getBoard()[this.blankRow][this.blankColumn - 1] == value){
            return 4;
        }
            return -1;
        
    }

    // Checks to make sure the move is valid
    public boolean validMove(int direction){
        // Up
        if(direction == 1){
            
            if(this.blankRow == 0){
                return false;
            }
            else{
                return true;
            }
        }
        // Down
        if(direction == 3){
            
            if(this.blankRow == this.board.getBoard().length -1){
                return false;
            }
            else{
                return true;
            }
        }
        //Right
        if(direction == 2){
            
            if(this.blankColumn == this.board.getBoard()[0].length -1){
                return false;
            }
            else{
                return true;
            }
        }
        //Left
        if(direction == 4){
            
            if(this.blankColumn == 0){
                return false;
            }
            else{
                return true;
            }
        }

        return false;

    }


    // Makes the move (switches spaces on the baord.)
    public boolean makeMove(int direction){
        int temp = 0;
        if(direction == 1){
            temp = this.board.getBoard()[this.blankRow - 1][this.blankColumn];

            this.board.getBoard()[this.blankRow - 1][this.blankColumn] = -1;
            this.board.getBoard()[this.blankRow][this.blankColumn] = temp;

            this.blankRow--;
            return true;
        }
        else if(direction == 2){
            temp = this.board.getBoard()[this.blankRow][this.blankColumn + 1];

            this.board.getBoard()[this.blankRow][this.blankColumn + 1] = -1;
            this.board.getBoard()[this.blankRow][this.blankColumn] = temp;

            this.blankColumn++;
            return true;
        }
        else if(direction == 3){
            temp = this.board.getBoard()[this.blankRow + 1][this.blankColumn];

            this.board.getBoard()[this.blankRow + 1][this.blankColumn] = -1;
            this.board.getBoard()[this.blankRow][this.blankColumn] = temp;

            this.blankRow++;
            return true;
        }
        else if(direction == 4){
            temp = this.board.getBoard()[this.blankRow][this.blankColumn - 1];

            this.board.getBoard()[this.blankRow][this.blankColumn - 1] = -1;
            this.board.getBoard()[this.blankRow][this.blankColumn] = temp;

            this.blankColumn--;
            return true;
        }
        else{
            return false;
        }

    }

    // Shuffles the board by making a speicifc amount of moves.
    public void shuffleBoard(int difficulty){
        Random random = new Random();
        int [] moves = {75, 100, 150, 175, 200};

        for(int i = 0; i < moves[difficulty - 1]; i ++){
            int randomNumber = random.nextInt(4) + 1;

            if (validMove(randomNumber)){
                makeMove(randomNumber);
            }
        }

    }

}
