class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        //group of 3 such that min degree
        // n number of graphs.//
        
        // undirected edge betwe u and v
        // trio is have edge between all 3 node pairs.
        // degree of this trio will be number of outside edges connected to these 3 nodes
        // find degree of each node.
        // group of 3  we find get 
        // create from edges adj lsit
            // fina anode and check what all nodes are connected to iot
        // and from that node check wihcih othert node is connected to it
        // if third node has the first nodde in the adj lists it means it is a trio
        // juist add their degree and find the min like this,.
        
        //find the pair which have a cycle is the real deal.
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        Map<Integer, Integer> degree = new HashMap<>();
        
        for(int i=0; i < edges.length; i++) {
            adj.computeIfAbsent(edges[i][0], d -> new HashSet<>()).add(edges[i][1]);
            adj.computeIfAbsent(edges[i][1], d -> new HashSet<>()).add(edges[i][0]);
            degree.merge(edges[i][0], 1 , Integer::sum);
            degree.merge(edges[i][1], 1 , Integer::sum);
        }
        // System.out.println(adj);
        // find the Trio
        //chose 1 node and use all noes in its list and those nodes and it that is connected with the first node
        int max = Integer.MAX_VALUE;
        for(int i =0 ; i < edges.length; i++) {
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            Set<Integer> set1 = adj.get(node1);
            Set<Integer> set2 = adj.get(node2);
            // System.out.println(set1 + " " + set2);
            //find a node which is present in both adj list.
            int degree2 = degree.getOrDefault(node2,0) + degree.getOrDefault(node1,0);
            for (int node3: set1) {
                if(set2.contains(node3)){
                    int degreeT = degree.getOrDefault(node3,0) + degree2 - 6; // remove 6 for the trio degree since they are connect to each other.
                    max = Math.min(max, degreeT);
                }
            }
            
        }
        return max==Integer.MAX_VALUE? -1 : max;
        
        
    }
}