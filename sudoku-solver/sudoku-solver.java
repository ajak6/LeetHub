class Solution {
    public void solveSudoku(char[][] board) {
        
        //lengthy solution.
        //fill 1 and check if it possible to fill or not
        /*
        checking possiblility
        1. diagonals left up and right up
        2. Diagonals left down and right down
        3. search within the box it contains. 3X3
        4. search all columns for current row
        5. keep same column and search all rows above and below 
        what can be optimize
        how do we identifgy which box this belongs to?
        */

        backtrack(board, 0,0);
        
    }
    
    public boolean backtrack(char[][] board, int i, int j) {
        // This method should place a bumber at a blank location and try to see if other positions can be fuilled by stack
        // System.out.println("Visiting "+ i +" : "+ j);
        if(i== board.length && j==0) {
            //you have to note somewhere that solution worked
            return true;
        }
        
        int newi=i;
        int newj=j;
        
        if(j==board.length-1) {
                newj =0;
                newi =i+1;
        } else {
            newj++;
        }
        
        if(board[i][j]=='.') {
            
            for(char n='1'; n<='9';n++) {
                System.out.println(" placing "+ n + " at "+ i +" : "+ j);    
                if(checkValid(board, i, j, n)) {
                    board[i][j] = n;
                    //how do we stop
                    if(backtrack(board, newi, newj)) {
                        return true;
                    }
                    board[i][j]='.';
                }
                // System.out.println(" again backtracking for . at "+ i +" : "+ j);
            }
        } else {
               if(backtrack(board, newi, newj)){
                   return true;
               }
        }
        
        return false;    
    }
    
    public boolean checkValid(char board[][], int i, int j, char  num){
        
        //check row
        for(int row = 0; row< board.length; row++){
            if(row==i)continue;
            if(board[row][j]==num)return false;
            
        }
        
        for(int col = 0; col< board.length; col++){
            if(col == j)continue;
            if(board[i][col]==num) return false;
        }
        
        // //check diagonals from current row towards 0
        // int diaOffset = 1;
        // for(int row=i-1; row>=0; row--, diaOffset++) {
        //     int y1 = j - diaOffset;
        //     int y2 = j + diaOffset;
        //     if(y1>=0 && board[row][y1]==num)return false;
        //     if(y2<board.length && board[row][y2]==num)return false;
        // }
        //  diaOffset = 1;
        // for(int row=i+1; row<board.length; row++,diaOffset++) {
        //     int y1 = j - diaOffset;
        //     int y2 = j + diaOffset;
        //     if(y1>=0 && board[row][y1]==num)return false;
        //     if(y2<board.length && board[row][y2]==num)return false;
        // }
        //check the smaller box for validity
        
        int startRow = (i/3)*3;
        int limit = startRow +3;
        int startCol = (j/3)*3;
        int limitJ = startCol+3;
        System.out.println("Validating for "+ num + " at:"+ i +", "+ j);
        for(; startRow < limit; startRow++) {
            
            for(startCol = (j/3)*3; startCol < limitJ; startCol++) {
                // if(startCol==j && startRow==i)continue;
                // System.out.print(board[startRow][startCol] + " ");
                if(board[startRow][startCol]==num)return false;
            }
            // System.out.println();
        }
        // System.out.println("Valid :"  + num + " -> at: " + i + " "+j);
        return true;
        
    }
}