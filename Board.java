public class Board{

    public int[][]board;
    private int rows;
    private int columns;

    public Board(Config config){

        // Creates a board based on the rows and columns given by user
        int rows= config.getRows();
        int columns = config.getColumns();

        this.rows = rows;
        this.columns = columns;

        //Creates board
        board = new int[rows][columns];

    }

    //Getters
    public int[][] getBoard(){
        return this.board;
    }
    public int getRows(){
        return this.rows;
    }
    public int getColumns(){
        return this.columns;
    }


    // Displays the array in a way that looks nice.
    public String displayBoard(int [][] board){
        int maxTile = board.length * board[0].length - 1;

        // Find the longest number(this becomes the consistent width of each cell.)
        int cellWidth = String.valueOf(maxTile).length();
        
        String cellBorder = "--";
        for(int i = 0; i < cellWidth; i ++){
            cellBorder += "-";
        }
        cellBorder += "+";

        String display = "+";
        for(int i = 0; i < board.length;i++){
                
            for(int j = 0; j <board[0].length; j ++){
            display += cellBorder;
            }
            display += "\n| ";
            for (int k = 0;k< board[0].length; k++){
                if (board[i][k] != -1) {
                    display += String.format("%" + cellWidth + "d | ", board[i][k]);
                } else {
                    display += String.format("%" + cellWidth + "s | ", " ");
                }
            }
            display += "\n+";
            }
            for(int j = 0; j <board[0].length; j ++){
            display += cellBorder;
            }

            return display;
    }

}
