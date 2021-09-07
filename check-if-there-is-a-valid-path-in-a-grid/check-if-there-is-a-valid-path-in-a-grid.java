class Solution {
    public boolean hasValidPath(int[][] grid) {
/*
1 which means a street connecting the left cell and the right cell.
2 which means a street connecting the upper cell and the lower cell.
3 which means a street connecting the left cell and the lower cell.
4 which means a street connecting the right cell and the lower cell.
5 which means a street connecting the left cell and the upper cell.
6 which means a street connecting the right cell and the upper cell.
*/
        
        //every node allows certain move
        //track the visited nodes 
        // do depth first search
        //validate the source path call allow entering this node.
        // visited, sourcePoint, currentPoint, DirectionMap
        Map<Integer, List<int[]>> dir = new HashMap<>();
        dir.put(1, Arrays.asList(new int[] {0,-1}, new int[]{0,1}));
        dir.put(2, Arrays.asList(new int[] {1,0}, new int[]{-1,0}));
        dir.put(3, Arrays.asList(new int[] {0,-1}, new int[]{1,0}));
        dir.put(4, Arrays.asList(new int[] {0, 1}, new int[]{1,0}));
        dir.put(5, Arrays.asList(new int[] {0,-1}, new int[]{-1,0}));
        dir.put(6, Arrays.asList(new int[] {-1,0}, new int[]{0, 1}));
        
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        return dfs(grid, visited, dir, 0, 0, 0, 0);
        
        
    }
    
    public boolean dfs(int grid[][], Set<Integer> visited, Map<Integer, List<int[]>> dir, int ss, int se,int cs, int ce) {
        if(cs<0 ||ce<0 ||cs>=grid.length || ce>=grid[0].length)return false;
        // System.out.println("Starting " + cs+ ":" + ce);
        List<int[]> allowedDirs = dir.get(grid[cs][ce]);
        
        //check if current can reach from source
        if (!(ss==0 && se==0)) { 
            boolean matched=false;
            //check source can move here            
            for(int dirs[]: allowedDirs) {
                //any direction match then we are good.
                if(dirs[0]+cs ==ss && dirs[1]+ce == se){
                    matched=true;
                    break;
                }
            }
            if(!matched) return false;
        }
        
        if(cs==grid.length-1 & ce==grid[0].length-1) {
            //we have verified that we can reach this location from previous location so 
            return true;
        }
        //add current location in visited.
        visited.add(cs*grid[0].length+ce);
        //get the next direction this cell will allow
        
        for(int dirs[]: allowedDirs) {
                //any direction match then we are good.
            int newS =dirs[0] + cs;
            int newE = dirs[1]+ce;
            if(!visited.contains(newS*grid[0].length+newE) && dfs(grid, visited, dir, cs,ce,newS,newE)) return true;
        }
        
        return false;    
    }
}