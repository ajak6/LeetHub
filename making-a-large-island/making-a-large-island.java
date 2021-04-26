class Solution {
    //edge cases missed
    //When there is a single island you might only flip one zero and increase the isze by 1 e.g. [[1,1],[1,0]]
    //when single island but no zeros then you cannoot replace anything e.g. [[1,1],[1,1]]
    
    public int largestIsland(int[][] grid) {
        //we will traverse and mark each island differently.
        //stre the size of each island. 
        //store the size of each element, lety bgs return the size of replace
        //store the size of each island with is identified.
        // for each zero in the grid now check the near by uisland and add up their size if they are dofferet
        // n2 is mark all the islands. 2 n2
        
        int islandIdentifier = 2;
        Map<Integer,Integer>islandSize = new HashMap<>();
        int maxSize = 0;
        for(int i =0 ;i<grid.length ; i++){
            
            for(int j=0; j < grid[0].length ; j++){
                
                if(grid[i][j]==1){
                    int size = traverse(grid, i ,j, islandIdentifier);
                    islandSize.put(islandIdentifier++, size);
                    maxSize = Math.max(maxSize, size);
                }
            }
        }
        boolean zero = false;
        for( int i =0 ; i < grid.length; i++){
            for(int j =0; j < grid[i].length ; j++) {
                
                if(grid[i][j]==0){
                    zero=true; //to confirm there is atleast 1 zero in the grid to increaser the island size
                    //by atleast 1
                    //now it might be connected 4 different islands
                    //3 island 
                    //2 island
                    //we want to get unique islands surrounding this 0
                    // check all directions and pull the island identifier unique.
                    // get their size from the map and store the max
                    HashSet<Integer> connectedIslands = new HashSet<>();
                    if(i-1>=0 && grid[i-1][j]!=0) {
                        connectedIslands.add(grid[i-1][j]);
                    }
                    if(i+1< grid.length && grid[i+1][j]!=0){
                        connectedIslands.add(grid[i+1][j]);
                    }
                    if(j+1< grid[0].length && grid[i][j+1]!=0){
                        connectedIslands.add(grid[i][j+1]);
                    }
                    if(j-1 >=0 && grid[i][j-1]!=0){
                        connectedIslands.add(grid[i][j-1]);
                    }
                    int totalSizeCurr = 0;
                    if(connectedIslands.size()>1){
                        for(int island: connectedIslands){
                            totalSizeCurr+=islandSize.get(island);
                        }
                    }
                    maxSize=Math.max(maxSize, totalSizeCurr);
                }
            }
        }
        return zero?maxSize+1:maxSize;
    }
    int directions [][] = {{1,0}, {-1,0},{0,1},{0,-1}};
    public int traverse(int grid[][], int i, int j, int id){
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j});
        visited[i][j]=true;
        int size =0;
        while(!queue.isEmpty()) {
            int p[] = queue.poll();
            grid[p[0]][p[1]]=id;
            size++;
            for(int dir[]:directions){
                int newx = p[0]+dir[0];
                int newy = p[1]+dir[1];
                if(valid(grid,newx,newy) && !visited[newx][newy] && grid[newx][newy]==1){
                    queue.offer(new int[]{newx,newy});
                    visited[newx][newy]=true;
                }
            }    
        }
        return size;
    }
    public boolean valid(int grid[][], int i, int j){
        return i>=0 && j>=0 && i <grid.length && j < grid[i].length;
    }
}