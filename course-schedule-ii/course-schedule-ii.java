class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int res[] = new int[numCourses]; int j=0;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        HashMap<Integer, Integer> incoming = new HashMap<>();
        for(int i=0; i < numCourses; i++){
            incoming.merge(i, 0 , Integer::sum);
            adj.put(i, new ArrayList<>());
        }
        for(int cour[]: prerequisites) {
            adj.computeIfAbsent(cour[1], x-> new ArrayList<>()).add(cour[0]);
            incoming.merge(cour[0], 1 , Integer::sum);
        }
        
        Queue<Integer> bfs = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        incoming.entrySet().stream().filter(entry -> entry.getValue()==0).forEach(x-> bfs.offer(x.getKey()));
        
        while(!bfs.isEmpty()){
            
            int take = bfs.poll();
            res[j++]=take;
            
            for(int waiting: adj.get(take)){
                incoming.merge(waiting, -1, Integer::sum);
                if(incoming.get(waiting)==0){
                    bfs.offer(waiting);
                }
            }
            
            
        }
        
        if(j == numCourses){
//             int res [] = new int[result.size()];
//             for(int i=0; i < result.size(); i++){
//                 res[i] = result.get(i);    
//             }
                
            
            return res;
        }
        
        
        return new int[0];
        
        
    }
}