class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        //greedy looks like knapsack problem
        
        //if you have capacity pull the max units- so we nee
        
        // priorityQueue with sorted by unit size.
        
        //keep pulling the max ones.
        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x,y) ->  y[1]-x[1]);
        
        for(int box[] : boxTypes){
            maxHeap.offer(box);
        }
        //truck size is max boxes
        //find max units
        int unitss = 0;
        while(truckSize > 0 && !maxHeap.isEmpty()) {
            int[] maxProfit = maxHeap.poll();
            /*
                maxProfit[0] // count of boxes
                maxPRofit[1] // number units per box
            */
            int capacity = Math.min(truckSize, maxProfit[0]); // space left
            
            unitss += capacity* maxProfit[1];
            truckSize -=maxProfit[0];
        }
        return unitss;
        
    }
}