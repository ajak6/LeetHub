class Solution {
    public int findCircleNum(int[][] isConnected) {
        int max = isConnected.length;
//         int roots []  = new int[max];
        
//         for(int i=0; i < roots.length ; i++){
//             roots[i]=i;
//         }
        
//         for(int i=0; i < roots.length ; i++){
//             for(int j = i+1; j < roots.length; j++){
                
//                 if(isConnected[i][j]==1) union(roots, i, j);
//             }
//         }
//         // System.out.println(Arrays.toString(roots));
        
//         int count =0;
//         for(int i=0; i < roots.length ; i++){
//             if(i==roots[i]) count++;
//         }
//         return count;
        
        UnionFind finder = new UnionFind(max);
        for(int i = 0 ; i < isConnected.length; i++){
            for(int j = i+1; j < isConnected.length ; j++){
                if(isConnected[i][j]==1) finder.union(i,j);
            }
        }
        int count =0;
        // System.out.println(Arrays.toString(finder.roots));
        // for(int i=0; i < finder.roots.length ; i++){
        //     if(finder.roots[i]==i) count++;
        // }
        return finder.total;
    }
    
    public void union(int roots[], int i, int j){
        
        //LOOP UNTIL YOU FIND THE THE PARENT OF I WHICH IS I
        while(roots[i]!=i) i = roots[i];
        while(roots[j]!=j) j = roots[j];
        if(i==j) return;   
        roots[j] = i;
    }
}
class UnionFind {
    public void union(int i, int j){
        // int parA = find(i);
        // while(roots[i]!=i) i = roots[i];
        // while(roots[j]!=j) j = roots[j];
        i = find(i);
        j = find(j);
        // int parB = find(j);
        // if(parA==parB) return;
        // total--;
        // roots[j]=parA;
        if(i==j) return;  
        total--;
        roots[j]=i;
    }
    int roots[];
    int total;
    public UnionFind(int n) {
        roots = new int[n];
        for(int i=0; i < n ; i++){
            roots[i]=i;
        }
        total = n;
    }
    
    
    
    public int find(int i) {
        if(roots[i]!=i){
            // roots[i] = roots[roots[i]];
            i = roots[i];
            return find(i);
        }
        return i;
    }
}