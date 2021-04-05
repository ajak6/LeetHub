class TimeMap {
    //as tje a,e says map store for fast accesss.
    //time will be epoch.
    Map<String, List<Pair>> map = new HashMap<>();
    // add the element with time sand value if we add it as a list then how will binary search work
    //you can write binary search. 
    //so for each key we need to store values and their timestmamp
    
    //in a way we want to store elements so that.
    
    //query pattern is 
    // kety and timestamp:
    // you pull the key entryc but niow you also need to find the value where time is smaller than the guiven time.
     
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();            
     }
    
    public void set(String key, String value, int timestamp) {
        Pair p = new Pair(value, timestamp);
        map.computeIfAbsent(key, p1-> new ArrayList<>()).add(p);
        
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return null;
        List<Pair> list = map.get(key);
        // System.out.println(key  + "  "+ list);
        String val="";
        // for(int i=0; i < list.size(); i++) {
        //     if(list.get(i).time <= timestamp){
        //         val = list.get(i).val;
        //     }
        // }
        // return val;
        return binarySearch(timestamp, list);
    }
    // [2,4,6,7,8,10] l =0 h=6 m=3 9
    public String binarySearch(int time, List<Pair> list){
        
        int l = 0; int h = list.size();
        int mid = l + (h-l)/2;
        while( l < h && l!=mid ) {
             mid = l + (h-l)/2;
            if(list.get(mid).time == time){
                l=mid;
                break;
            }
            if(list.get(mid).time < time){
              l=mid+1;  
            } else {
              h=mid;
            }
        }
        //h is the position where this time will b einsete 
        //so the actual position is -1
        int actual = h -1;
        if(actual>=0) {
            return list.get(actual).val;
        } else {
            return "";
        }
        
        
    }
}

class Pair{
    String val;
    int time;
    public Pair(String val, int time){
        this.val = val;
        this.time = time;
    }
    
    public String toString(){
        return "time "+ time + " value: "+val;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */