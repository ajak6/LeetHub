class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses==1)return true;
        if(prerequisites==null || prerequisites.length==0 || prerequisites[0].length==0) return true;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        HashMap<Integer, Integer> incoming = new HashMap<>();
        
        for(int a [] : prerequisites){
            adj.computeIfAbsent(a[1], x-> new ArrayList<>()).add(a[0]);
            incoming.merge(a[0], 1, Integer::sum);
            incoming.merge(a[1], 0, Integer::sum);
        }
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        //create a string of numbers and see if we land on a top sort/
        for(Map.Entry<Integer,Integer> entry : incoming.entrySet()){
            if(entry.getValue()==0){
                queue.offer(entry.getKey());
                visited.add(entry.getKey());
            }
        }
        int count= 0;
        // System.out.println(adj);
        
        while(!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            List<Integer> list = adj.get(course);
            if(list==null || list.isEmpty()) continue;
            // System.out.println(incoming);
            for(int l : list) {
                incoming.merge(l, -1, Integer::sum);
                if(incoming.get(l)==0 && !visited.contains(l)){
                    queue.offer(l);
                    visited.add(l);
                }
            }
        }
        return count==incoming.size();
    }
}