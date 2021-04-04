class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals==null || intervals.length==0)return 0;
        //sort by start time and length
        // head sort by end time desc
        Comparator<int[]> xx= Comparator.comparingInt(x-> x[1]);
        // xx=xx.reversed();
        // Comparator<int[]> xxnew = xx.thenComparingInt(v-> v[1]);
        // Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));
        Arrays.sort(intervals, xx);
        int recentInterval [] = intervals[0];
        int delete = 0;
        for(int i =1 ; i< intervals.length;i++) {
            if(overlaps(recentInterval, intervals[i])){
                delete++;
                // update recent since 
                // 1,4 (2,3), (3,4), (4,5), (6,7)
                //when strat time is lower but still the interval can be long so througing the loger 
                //one gredily makes more sense.
                
            } else {
                //this menas the enxt interval that we are seeing is notoverlapping.
                //since the intervals  are sorted by start time we will atleast see an interval with same 
                //or higher start time.
                //endtime can be  anything in this case.To find next overlapping intevlawe will probably need
                recentInterval = intervals[i];
            }
        }
        return delete;
        
        
    }
    
    public boolean overlaps(int a[], int b[]) {
        
        return a[1]> b[0];
    }
}