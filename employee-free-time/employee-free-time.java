/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        // given is busy times.
        // return a common free time of all employees.
        // basically we want to know when all employees are free.
        
        //merge the busy internvals first 
        //traverse to find the issing internval?
        
        
        // treemap - start time +1
        //     end time -1
        //     if you have a map like this
        
        TreeMap<Integer, Integer> treemap = new TreeMap<>(); // normal sort order with increasing time is good
        
        schedule.stream().forEach(s -> {
            System.out.println(s);
            s.stream().forEach(xc-> {
                treemap.merge(xc.start, 1, Integer::sum);
                treemap.merge(xc.end, -1, Integer::sum);    
            });
        });
        int runningSum=0;
        boolean first = true;        
        List<Interval> freeTime = new ArrayList<>();
        int prevend = 0;
        for(Map.Entry<Integer, Integer> entry : treemap.entrySet()){
            
            if(!first && runningSum==0){
                // this means all previous intervals have ended already
                // and now this will be  a new earliest start time after the previous ebnd time.
                // hence it means that the gap will be a free time mostly. 
                freeTime.add(new Interval(prevend, entry.getKey())); //prev end and new start
            }
            
            runningSum+=entry.getValue();
            prevend=entry.getKey();
            first = false;
        }
        return freeTime;
    }
}