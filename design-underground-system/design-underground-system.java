class Pair{
    String name;
    int time;
    public Pair(String n, int t) {
        name=n;time=t;
    }
}
class UndergroundSystem {
        //has a customer checking intop out system if yes don't allow another checking
    //store for a ID checkin station and time
    // checkin map to bhave id and station time
    //at checking find the station and time - calculate the time
    // now you have names of othstations and time;
    // note the time t takes for start to end stations
    // this will keep happening. so you have to add up these values
    // keeop adding values for time
    //
    Map<String, Map<String, Integer>> times;
    Map<Integer, Pair> checkinStationTimes;
    Map<String,Map<String, Integer>> travelSamples ;
    public UndergroundSystem() {
        times = new HashMap<>();
        checkinStationTimes = new HashMap<>();
        travelSamples = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkinStationTimes.put(id, new Pair(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair p = checkinStationTimes.get(id);
        times.computeIfAbsent(p.name, x-> new HashMap<>()).merge(stationName, t-p.time, Integer::sum);
        travelSamples.computeIfAbsent(p.name, x-> new HashMap<>()).merge(stationName, 1, Integer::sum);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        Map<String, Integer> totalTravelSamples = travelSamples.get(startStation);
        int x  = totalTravelSamples.get(endStation);
        return times.get(startStation).get(endStation)*1.0/x;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */