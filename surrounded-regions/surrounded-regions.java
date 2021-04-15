class Solution {
    
    public void solve(char[][] board) {

        boolean visited [][] = new boolean[board.length][board[0].length];
        // if you find a 0 on a border then you have to dfs from that 0 to other neighbouring 0's and change them to -,
        // if a  cell is called it is bound to change to - other cells will be left as is. At the end traverse and change all 0 to X and - to 0;
        for(int i=0;i< board.length; i++) {        
            
                if(board[i][0]=='O'){
                dfs(board, i, 0, visited);
            }
                
                if(board[i][board[i].length-1]=='O'){
                    // visited[i][j]=true;
                    // board[0][i]='-';
                    dfs(board, i, board[i].length-1, visited);
                }
                
            // }
        }
        for(int i=0;i< board[0].length; i++) {        
            
            if(board[0][i]=='O'){
                dfs(board, 0, i, visited);
            }
            if(board[board.length-1][i]=='O'){
                // visited[i][j]=true;
                // board[0][i]='-';
                dfs(board, board.length-1, i, visited);
            }
        } 
        for(int i=0;i< board.length; i++) {        
            for(int j=0;j< board[i].length; j++) {   
                if (board[i][j]=='O') board[i][j] = 'X';
                else if (board[i][j]=='-') board[i][j] = 'O';
        }
    }
    }
    
    int dirs[][]={ {1,0}, {-1,0}, {0,1}, {0,-1} };
    public void dfs(char[][]board, int i, int j, boolean[][]visited){
        // System.out.println("hellow1");
        if(valid(board,i,j)){
            if(board[i][j]=='X')return;
            
            board[i][j]='-';
            for(int dir[]: dirs){
                int newX = dir[0]+i;
                int newY = dir[1]+j;
                if(valid(board, newX, newY) && board[newX][newY] == 'O' ){
                    dfs(board, newX, newY, visited);
                }
            }
            
            
        }
        
    }
    
    public boolean valid(char[][]board, int i, int j){
        if(i<0 || j < 0 || i >board.length-1 || j > board[i].length-1) return false;
        return true;
    }
}
// [["X","O","X","O","X","O"],
//  ["O","X","O","X","O","X"],
//  ["X","O","X","O","X","O"],
//  ["O","X","O","X","O","X"]]

// [["X","O","X","O","X","O"],
//  ["O","X","X","X","X","X"],
//  ["X","X","X","X","X","O"],
//  ["O","X","O","X","X","X"]]

// [["X","O","X","O","X","O"],
//  ["O","X","X","X","X","X"],
//  ["X","X","X","X","X","O"],
//  ["O","X","O","X","O","X"]]

// if(board[i][0]=='-') board[0][i]='O';
            // if(board[i][board[i].length-1] == '-') board[i][board[i].length-1]='O';
            // if(board[board.length-1][i] == '-') board[board.length-1][i]='O';


// if((board[i-1][j]=='X' || board[i-1][j]=='O') && (board[i+1][j]=='X' || board[i+1][j]=='O' ) && (board[i][j+1]=='X' || board[i][j+1]=='O' ) && (board[i][j-1]=='X' || board[i][j-1]=='O' )){
            //     board[i][j]='X';
            // }else {
            //     board[i][j]='-';
            // }