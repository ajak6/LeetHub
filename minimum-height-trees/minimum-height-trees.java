class Pair{
    int val;
    int h;
}

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // from editorial
        List<Integer> res = new ArrayList<>();
        
        if(edges==null || edges.length<2) {
            for(int i=0;i < n; i++) res.add(i);
            return res;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int degree [] = new int[n];
        for(int i=0; i < edges.length ; i++) {
            // adj.computeIfAbsent(edges[i][0], d-> new ArrayList<>()).add(edges[i][1]);
            adj.computeIfAbsent(edges[i][1], d-> new ArrayList<>()).add(edges[i][0]);
            adj.computeIfAbsent(edges[i][0], d-> new ArrayList<>()).add(edges[i][1]);
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
        }
        
        //find all nodes with degree 0 and 
        for(int i=0; i < n;i++) {
            if (degree[i]==1) {
                queue.offer(i);
            }
        }
        // System.out.println(queue);
        // HashSet<Integer>visited = new HashSet<>();
        
        //we don't need visited becquse degree will only get to 0 when all neighboards are visited
        while (!queue.isEmpty()) {
            int size = queue.size();
            res = new ArrayList<>();
            while(size>0){
                size--;
                
                int node= queue.poll();
                res.add(node); // this will save the last batch of nodes who does not have any leftover
                //singlaaing the res is storing the middle elements with heighest degree.
                List<Integer> neighbors= adj.get(node);
                for(int ns: neighbors){
                    degree[ns]--;
                    if(degree[ns]==1){
                        queue.add(ns);
                    }
                }
            }
        }
        return res;
    }
    
    
    public List<Integer> findMinHeightTreesSlowDFS(int n, int[][] edges) {
        // edges are given
        // you can find degree of each node by knowing how many nodes are connecting to it
        // if we do unionfind we can know the degree of each node
        // We cannot use path compression thoughu
        // create a tree but how do we find the height of each node?
        //by doing DFS on each node after constructing the treewe know the height of each node
        //chose the nodes with min heigh as root. 
        //create adh kust
        //start DFS and traverse all paths and note the max depth of each node.
        //at the end chose the nodes with min height using a stack maybe with only min heigh stored
        //in the stack 
        //
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        for(int i=0; i < edges.length ; i++) {
            adj.computeIfAbsent(edges[i][0], d-> new ArrayList<>()).add(edges[i][1]);
            adj.computeIfAbsent(edges[i][1], d-> new ArrayList<>()).add(edges[i][0]);
        }
        
        
        // Need min value and the node value which has the lowest height.
        Deque<Pair> minHeight = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        int height = n+1;
        for(int i=0; i < n; i++) { 
            // System.out.println("Strarting at "+ i);
            int maxHeight = dfs(i, adj, new HashSet<>(), minHeight);
            if(height == maxHeight){
                result.add(i);
            } else if(height > maxHeight) {
                height = maxHeight;
                result = new ArrayList<>();
                result.add(i);
            }
        }
        
        
        return result;
    }
    
    public int dfs(int start, Map<Integer,List<Integer>> adj, HashSet<Integer> visited, Deque<Pair> min) {
        
        visited.add(start);
        List<Integer> adjs = adj.get(start);
        // System.out.println("Strat" + start +  " adjs "+ adjs);
        int maxHeight =0;
        if(adjs==null || adjs.isEmpty()) return 0;
        for(int i=0; i < adjs.size(); i++){
            if(visited.add(adjs.get(i))){
                int height = dfs(adjs.get(i), adj, visited, min);
                maxHeight = Math.max(maxHeight, height);
            }
       }
        
        return maxHeight + 1;
    }
    
}