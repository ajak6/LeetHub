class Solution {
    public boolean validTree(int n, int[][] edges) {
        //valid tree
        int roots []=new int[n];
        for(int i=0; i < roots.length ; i++) {
            roots[i] = i;
        }
        for(int i=0; i< edges.length ; i++){
            if(!unionfind(roots, edges[i][0], edges[i][1])){
                return false;
            }
        }
        int count =0;
        for (int i=0;i < roots.length; i++) { 
            if(roots[i]==i) count++;
        }
        // we also need to detect cycle
        
        return count==1;   
    }
    
    public boolean unionfind(int root[] , int i, int j) {
        while(root[i]!=i) i = root[i];
        while(root[j]!=j) j = root[j];
        if(i==j)return false;
        root[j]=i;
        return true;
    }
    
    
}