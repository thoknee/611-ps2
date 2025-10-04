/*
 * 
 *  Handles displaying the dots and boxes board
 *  
 *  Written by Tony Ponomarev and Olivia Ma
 * 
 */

public class dbDisplay implements Display<Board>{
    
    private static String strRepeat(String s, int n) {
        if (n <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(s.length() * n);
        
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
}

    public String display(Board board) {
        
        StringBuilder sb = new StringBuilder();

        int rows = board.getRows();
        int cols = board.getColumns();

        //Append spaces so each box is the same width
        int maxId = rows * cols;

        int w = Math.max(3, String.valueOf(maxId).length() + 2);

        
        
        for (int r = 0; r < rows; r++) {
            // top edges
            for (int c = 0; c < cols; c++) {
                dbPiece p = (dbPiece) board.getPiece(r, c);
                sb.append("*");
                sb.append(p.isEdgeClaimed(Edge.TOP) ? strRepeat("-", w): strRepeat(" ", w));
            }
            sb.append("*\n");

            // middle line with vertical edges + center content
            for (int c = 0; c < cols; c++) {
                dbPiece p = (dbPiece) board.getPiece(r, c);
                sb.append(p.isEdgeClaimed(Edge.LEFT) ? "│" : " ");

                String cell;
                if (p.isBoxClaimed()) {
                    String nm = p.getBoxOwner().getName();
                    char ch = (nm != null && !nm.isEmpty()) ? Character.toUpperCase(nm.charAt(0)) : '?';
                    cell = (String.valueOf(ch));
                } else {
                    cell = strRepeat(" ", w/2) + (String.valueOf(p.getBoxId())) + strRepeat(" ", w/2);
                }
                sb.append(cell);

                if (c == cols - 1) {
                    sb.append(p.isEdgeClaimed(Edge.RIGHT) ? "│" : " ");
                }
            }
            sb.append("\n");
        }

        // bottom edges of last row
        for (int c = 0; c < cols; c++) {
            dbPiece p = (dbPiece) board.getPiece(rows - 1, c);
            sb.append("*");
            sb.append(p.isEdgeClaimed(Edge.BOTTOM) ? strRepeat("-", w) : strRepeat(" ", w));
        }
        sb.append("*\n");

        return sb.toString();
    }
}
    

