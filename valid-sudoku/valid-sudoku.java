class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        // open way is for each number i traverse its row and col and small square to find if i is presnt or not
        // if for each number I stores its positions in a map
        // and then for each number I need to get other positions of x and compare if they are present in the same orw and columnm
        //skip the position is same as current position
        HashSet<String> set = new HashSet<>();
        for(int i=0; i < board.length ; i++) {
            for(int j =0; j < board[0].length; j++){
                if(board[i][j]=='.')continue;
                int box = (i/3)*3 + j/3;
                
                String rowStr = ""+board[i][j] + 'r' + i;
                String colStr = ""+board[i][j] + 'c' + j  ;
                String boxStr = ""+board[i][j] + 'b' + box;
                if(!set.add(rowStr) || !set.add(colStr)|| !set.add(boxStr)){
                    System.out.println(set);
                    return false;
                }
            }
        }
        return true;
    }
}