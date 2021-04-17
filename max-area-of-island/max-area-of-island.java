class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        //on everty 1 run a DFS and find all the ones connected recuirsively?????
        //may be ,aomtoma another array we count how many nes we have seen near a 1 and we add that nuber.
        
        // we cannot do bfs because it will be counting diffeent aread whic hare prolly not even connected.
            //dfs will start 1 are adn cfinish before starting noather one in a different idrecitons
            
        // questiubs
        // approach 1: Every function returns how many 1 it has seen near by.but the prob
        boolean visited [][]  = new boolean [grid.length][grid[0].length];
        int max = 0;
        for(int i =0;i<grid.length; i++){
            for(int j =0; j < grid[i].length; j++){
                if (grid[i][j]==1 && !visited[i][j]) {
                    int dfs = dfs(grid, i,j, visited);
                    max = Math.max(dfs, max);
                    
                }
                
            }
        }
        return max;
        
        
    }
    int dires [][]={{1,0},{0,1}, {0,-1}, {-1,0}};
    public int dfs(int grid[][], int i, int j, boolean[][]visited) {
        int count = 0;
        // for(int i=a; i < grid.length; i++) {
        //     for(int j = b; j < grid[0].length ; j++){
        if(grid[i][j]==1 && !visited[i][j]){
            visited[i][j]=true;
            count=1;

            for(int dir[]: dires){
                int newx = i + dir[0];
                int newy = j + dir[1];
                if(valid(newx,newy,grid) && !visited[newx][newy] && grid[newx][newy]==1){
                    count+=dfs(grid, newx, newy, visited);
                }
            }
                    
//                 }
                
//             }
        }
        return count;
        
         
        
    }
    public boolean valid(int x , int y , int[][]grid){
        return (x>=0 && y >=0 && x < grid.length && y < grid[x].length);
    }
}