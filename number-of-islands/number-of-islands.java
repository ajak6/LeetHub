class UnionFind {
    HashMap<Integer,Integer> unionFind = new HashMap<>();
    HashMap<Integer,Integer> degree = new HashMap<>();
    
   public void initialize(char c[][]) {
       
        int m = c.length;
        int n = c[0].length;
        for(int i = 0; i < c.length ; i++){
            for(int j = 0 ; j < c[0].length; j++) {  
                if(c[i][j]=='1'){
                    count++;
                    unionFind.put(i*n + j, i*n +j);
                    degree.put(i*n+j,1);    
                }
                
            }
        }
    } 
    int count =0;
    public void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        if(parentA==parentB) return;
        count--;
        // higher degree should make a and b
        if(degree.get(parentA)>= degree.get(parentB)) {
            unionFind.put(parentA, parentB);
            degree.merge(parentA, 1, Integer::sum);
        } else {
            unionFind.put(parentB, parentA);
            degree.merge(parentB, 1, Integer::sum);
        }
        
    }
    public int getCount(){
        // System.out.println(unionFind);
        // return unionFind.keySet().size();
        return count;
    }
    public int find(int a){
        while (a != unionFind.get(a)){
            unionFind.put(a, unionFind.get(unionFind.get(a)));
            a = unionFind.get(a);
        }
        return unionFind.get(a);
    }
}

class Solution {
    public int numIslands(char[][] c) {
        UnionFind uf = new UnionFind();
        uf.initialize(c);
        int rows = c.length;
        int n = c[0].length;
        for(int i=0;i < c.length; i++){
            for(int j=0; j < c[0].length; j++) {
                int curr = i*n+j;
                if(c[i][j]=='1') {
                    if(i-1>=0 && c[i-1][j] =='1') {
                        uf.union(curr, (i-1)*n+j);
                    }
                    if(j-1>=0 && c[i][j-1] =='1') {
                        uf.union(curr, (i)*n+j-1);
                    }
                    if(j+1 < n && c[i][j+1] =='1') {
                        uf.union(curr, (i)*n+j+1);
                    }
                    if(i+1< c.length && c[i+1][j] =='1') {
                        uf.union(curr, (i+1)*n+j);
                    }   
                }
            }
        }
        int getParent = uf.getCount();
        return getParent;
    }
        // we can do BFS and traverse grid to ffind islands
        // union find?
        //start with an array and if you find a 1 then start a bfs and covera ll 1 adjacent to it.
        // and loop again if the nodes are not visited then start abiother bfs from it.
        // complexity: n2 to traverse outerloop of every index.
        //     if all are 1's then you will see 1 and again to 2 for loops to visit everyone and comoe back to outer look and visited all nodes again
        //         although they weill be visited but the loop will still go thrpuight\
        //         in totoal complexity will be at the end: 
        
        // everyone is their own parent
        // we can normalize the array indexes currently
        // now you consider 2 at a time and mark 1 of them as a parent.
        //
        // how will do union -> either you do any near by is 1 
        // eithre you lets say every index is its own parent.
        // 
        
        //this is given in the form of graph
        //union find ou want tkno w if htere is a edge between index i and j 
        //that we can add it in union find datastructure 
        // but in this case the 1 are the vertex and edge is between i,j to x,y
        /**
        a vertex is connected to ther if there is a connection or it is near a 1 already.
        
        **/
//         int n = a.length;
//         int m = a[0].length;
//         initialize(a);
//         for(int i =0 ; i < n; i++) {
//             for(int j =0; j < m ; j++) {
//                 if(a[i][j]=='1'){
//                     a[i][j] = 0;
//                     // union with nearby 1's
//                     int current = i * m + j;
//                     // check all directions and if it is 1 the union with those indexes.
//                     if (i>0 && a[i-1][j] == '1') {
//                          union(current, (i-1)*m + j);
//                     }
//                     if(i+1<n && a[i+1][j]=='1') {
//                         union(current, (i+1)*m + j);
//                     }
//                     if(j>0 && a[i][j-1]=='1') {
//                         union(current, (i)*m + j-1);
//                     }
//                     if(j+1 < m && a[i][j+1]=='1') {
//                         union(current, (i*m) + j+1);
//                     }
//                 }
//             }
//         }
//         System.out.println(union);
//         return count;
//     }
    
//     int count =0;
//     public void initialize(char a[][]) {
//         int n=a.length;
//         int m = a[0].length;
        
//         for(int i =0 ; i < n; i++) {
//             for(int j=0; j < m; j++) {
                
//                 if(a[i][j]=='1'){
//                     count++;
//                     union.put(m*i+j, m*i+j);
//                     rank.put(m*i+j,1);    
//                 }
                
//             }
//         }
//     }
    
//     HashMap<Integer, Integer> union = new HashMap<>();
//     HashMap<Integer,Integer> rank = new HashMap<>();
//     public void union(int x, int y) {
//         while(x!=union.get(x)) {
//             // union.put(x, union.get(union.get(x)));
//             x = union.get(union.get(x));
//         } 
//         while(y!=union.get(y)) {
//             // union.put(y, union.get(union.get(y)));  
//             y = union.get(union.get(y));  
//         }
//         //might need ranks.
//         if(x != y) {
//             if(rank.get(x)> rank.get(y)) {
//                 union.put(y,x);
//                 rank.merge(x, rank.get(y), Integer::sum);
//             } else {
//                 union.put(y,x);
//                 rank.merge(y, rank.get(x), Integer::sum);
//             }
//             count--;
            
//         }
        
//     }
}