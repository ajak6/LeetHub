class Solution {
    public int findCircleNum(int[][] isConnected) {
        //brute force : using adj matrix : yiou
        //union find 
        //datastructure which stores the parent of each node
        // at first everyone is their own parent.
        //when there is a connection you mark the other as their parent
        //when you see a connection between 
//         UnionFind union = new UnionFind(isConnected);
//         for(int i=0; i < isConnected.length ; i++){
//             //if you start at j you are calling union i,j and then later with j,i which will affect the union datastructure/
//                 // if(isConnected[i][j]==1)
//                     union.parent.put(i,i);
            
            
//         }
//         for(int i=0; i < isConnected.length ; i++){
//             //if you start at j you are calling union i,j and then later with j,i which will affect the union datastructure/
//             for(int j = 0; j < isConnected[i].length; j++){
//                 if(isConnected[i][j]==1)
//                     union.union(i,j);
//                     System.out.println(union.parent);        
//             }
//         }
//         //at the end we need to find the total unique parent in unionFind.
//         System.out.println(union.parents());
//         int answer = union.parents().size();
//         return answer;
        int [] root = new int[isConnected.length];
        for(int i=0 ; i < root.length ; i++) root[i]=i;
        
        for(int i=0; i < root.length ; i++){
            for(int j = i+1; j < root.length ; j++){
                
                if(isConnected[i][j]==1){
                    unionFind(root, i,j);
                }
            }
        }
        int count=0;
        for (int i = 0; i < root.length; i++)
            if (i == root[i]) count++;
        return count;
    }
    
    void unionFind (int[] root, int v1, int v2) {
        while (root[v1] != v1) v1 = root[v1]; //find v1's root
        while (root[v2] != v2) v2 = root[v2]; //find v2's root
        if (root[v1] != root[v2]) root[v2] = v1; //unite the 2 subtrees 
    }
    
    
}
class UnionFind {
    Map<Integer,Integer> rank = new HashMap<>();
    //bascially we need to find the union with unique parents 
    // total number of parents at the end will bne the answer
    public UnionFind(int graph[][]){
        // for(int i=0; i < graph.length ; i++) {
        //     parent.put(i,i);
        // }
    }
    
    public Set<Integer> parents(){
        return new HashSet<>(parent.values());
    }
    
    HashMap<Integer, Integer> parent = new HashMap<>();
    // initialize each with ittself as the parent
    public int union(int a, int b){
        int parentOfA = find(a);
        int parentOfB = find(b);
        if(parentOfA == parentOfB)return parentOfA;
        parent.put(b, parentOfA);
        return parentOfA;
    }
    
    public int find(int a){
        if(parent.get(a)!=a){
            return find(parent.get(a));
        }
        return a;
    }
     
}