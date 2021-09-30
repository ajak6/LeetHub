class Solution {
    public boolean exist(char[][] board, String word) {
        
        //dfs if a har matches search in all directions iwht visited matrix
        for(int i=0; i< board.length; i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]==word.charAt(0)){
                    if(search(board, word, 1, ""+board[i][j], i, j, new HashSet<>())){
                        return true;
                    }
                }                
            }
            
        }
        return false;
        
    }
    
    int dirs[][]  = {{1,0},{0,1},{-1,0},{0,-1}};
    public boolean search(char[][]board, String word, int w, String curr, int i, int j, Set<Integer> visited) {
        if(curr.equals(word)) return true;
        
        visited.add(i*board[0].length+j);
        for (int dir[] : dirs) {
            int newx=i+dir[0];
            int newy=j+dir[1];
            int code = newx*board[0].length + newy;
            if(valid(board, newx,newy) && !visited.contains(code) && word.charAt(w)==board[newx][newy]) {
                visited.add(code);
                if(search(board, word, w+1, curr+board[newx][newy], newx, newy, visited)){
                    return true;
                }
                visited.remove(code);
            }
        }
        return false;
    }
    
    public boolean valid(char[][]b, int i, int j){
        return i<b.length && j<b[0].length && i>=0 && j>=0;
    }
}