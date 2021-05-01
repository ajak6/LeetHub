class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int topFloor = cost.length;
        
        int costPreCalculated [] = new int [cost.length+1];
        // costPreCalculated[0] = 0];
        // costPreCalculated[1] = 0;
        
        for(int floor = 2; floor<=topFloor; floor++) {
            
            costPreCalculated[floor] =  + Math.min(costPreCalculated[floor-1] + cost[floor-1], costPreCalculated[floor-2] + cost[floor-2]) ;
        }
        
        return costPreCalculated[topFloor];
    }
}