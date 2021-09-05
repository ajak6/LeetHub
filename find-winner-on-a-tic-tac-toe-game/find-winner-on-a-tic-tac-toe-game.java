class Solution {
    public String tictactoe(int[][] moves) {
        
        // we need to know for every move
        // when a move is played I need to check row or column or both diagonals if they(the loc is on a diagonal)and total count is 3.
        // for each row if we maintain the count of X and ) played then as soon sas this count gets to 3 we have winnger.
        // so for X ciount +1, for O count -1
        // but what if a move repeats itself? meaning we have already played at turn and now playing agagin?
        // also store all turns.
        
        int row[][] = new int[3][1];        
        int col [][] = new int[3][1];
        int d[][] = new int[2][1];
        int count =0;
        boolean turn = true;
        for(int i =0 ; i < moves.length; i++) {
            int r = moves[i][0];
            int c = moves[i][1];
            if(turn) {
                count = +1;
            } else{
                count = -1;
            }
            int result = count(r , c, row, col, d, count);
            // System.out.println(r + " "+ c);
            if (result==1) return turn ? "A": "B";
            turn=!turn;
        }
        return moves.length==9 ? "Draw": "Pending";
        
    }
    public int count(int r, int c, int row[][], int col[][], int d[][], int count) {
        row[r][0] += count;
        // System.out.println("row " + row[r][0]);
        if(Math.abs(row[r][0]) == 3) return 1;
        col[c][0] += count;
        // System.out.println("col " + col[c][0]);
        if(Math.abs(col[c][0]) == 3) return 1;
        
        if(r==c) {
            d[0][0] += count;
            // System.out.println("d0 " + d[0][0]);
            if(Math.abs(d[0][0]) == 3) return 1;
        }
        
        if(r+c==2) {
            d[1][0]+=count;
            // System.out.println("d1 " + d[1][0]);
            if(Math.abs(d[1][0]) == 3) return 1;
        }
        
        return 0;
    }
}