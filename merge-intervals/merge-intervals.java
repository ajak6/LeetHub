class Solution {
    public int[][] merge(int[][] intervals) {
        //condition of overka
        //current oned end time is higher then nextones start time.
        // but the current one start time should be less than nextones start time? it does not matter i think
        //
        List<int[]> temp = new ArrayList<>();
        Arrays.sort(intervals, (x,y)-> Integer.compare(x[0], y[0]));
        int curr []= intervals[0];
        for(int i=1; i < intervals.length; i++) {
            if(overlaps(curr, intervals[i])){
                
                //update curr to new interval.
                curr[0] = Math.min(intervals[i][0], curr[0]);
                curr[1] = Math.max(intervals[i][1], curr[1]);
            }else{
                //curr interval is complete so we do not need anything, store it as a result.
                temp.add(curr);
                curr=intervals[i];
            }
            
        }
         temp.add(curr);
        int result[][] = new int[temp.size()][2];
        temp.toArray(result);
        return result;
    }
    
    public boolean overlaps(int a[], int b[]){
        
        return (a[1] >= b[0]);
    }
}