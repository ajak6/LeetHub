class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        
        Map<Integer, Set<Integer>> buses = new HashMap<>();
        Map<Integer, Set<Integer>> stopToBuses = new HashMap<>();
        Map<Integer, Set<Integer>> busesToStop = new HashMap<>();
        
        Set<Integer> targetBuses = new HashSet<>();
        for(int i=0; i< routes.length;i++) {
            for(int j = 0; j< routes[i].length; j++) {
                stopToBuses.computeIfAbsent( routes[i][j], x-> new HashSet<>()).add(i);
                busesToStop.computeIfAbsent( i, x-> new HashSet<>()).add(routes[i][j]);
                if(routes[i][j]==target){
                    targetBuses.add(i);
                }
            }
        }
        if(source==target) return 0;
        //create a map with bus
        //if stop buses and destination bus as same then answer is 0
        for(Map.Entry<Integer, Set<Integer>> entry: busesToStop.entrySet()){
            
            buses.putIfAbsent(entry.getKey(), new HashSet<>());
            for(int stops: entry.getValue()){
                
                buses.get(entry.getKey()).addAll(stopToBuses.get(stops));
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        int hops = 1;
        
        queue.addAll(stopToBuses.get(source));
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size>0){
                size--;
                int currentBus = queue.poll();
                if(targetBuses.contains(currentBus)) return hops;
                
                visited.add(currentBus);
                
                for(int connectedBus: buses.get(currentBus)) {
                    
                    if(visited.contains(connectedBus)) continue;
                    
                    queue.offer(connectedBus);
                }
            }
            hops++;
        }
        
        return -1;
        
        
        
    }
}