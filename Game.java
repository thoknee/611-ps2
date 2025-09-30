// Abstract Game class

public abstract class Game {
    public Board board;
    public int[][] winningState;


    public Game(Board board){
        this.board = board;
    }

    public Board getBoard(){
        return this.board;
    }
    public int[][] getWin(){
        return this.winningState;
    }

}
