class Solution {
    
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // We can traverse and add the interval where its start time fits
        // then we can run through the arrau and merge  intervals using heap
        // [[1,3],[6,7]] disjoin-> 4,5 [1,3][4,5][6,7]
        // [[1,3],[2,7]] 1,4 exist
        // given 1,9 [1,2][3,4][5,6][6,7] there an be multiple intervals which new one can overlap
        //[1,9]
        
        //start times are sorted how is it useful?
        //may be put only the intervals which are higher than the given new interval start time that way rest of the others does not need to be touched or sorted: this will reduce the queue size
        
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(x-> x[0])); //sort by start times.
        List<int[]> result = new ArrayList<>();
        // since these are non overlapping we are ending beore this starts
        int i=0;
        for(;i<intervals.length; i++){
            if (!overlaps(intervals[i], newInterval)) {
                result.add(intervals[i]);
            } else {
                break;
            }
        }
        // i is either finished or at the interval which does not overlap
        if(i==intervals.length)
        {
            result.add(newInterval);
            return convert(result);
        }
        
        for(;i<intervals.length;i++){
             
            //merge the current one with new one
            if (overlaps(newInterval, intervals[i])){
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
                
            } else{
                result.add(newInterval);
                break;
            }
        }
        //3,8 - 6,7
        //3,8 
        if(i==intervals.length){
            result.add(newInterval);
        }
            
        for(;i<intervals.length;i++){
            result.add(intervals[i]);
        }
        return convert(result);
            
        
        
        
        
    }
    public int[][] convert(List<int[]> res){
        int [][] r = new int[res.size()][2];
        for(int i=0; i < res.size();i++){
            r[i]=res.get(i);
        }
        return r;
    }
    // 1,9-2,5 | 1,4-2,5 | 1,2-3,4 | 2,5-1,4
    public boolean overlaps(int a[], int b[]){
            // return (a[0]<b[0]&& a[1]>b[1]) ||(a[1]>b[0]) 
                // || ()
        if(a[0] > b[0]) {
            int temp[] = a;
            a=b;
            b=a;
        }
        return b[0] <= a[1];
    }
}