class Solution {
    public int compareVersion(String version1, String version2) {
        
        //0.0.1 and 1.0
        //1.0.1 and 1
        //0.001 and 0.01
        // traverse until you hit .. and keep comparing 
        //111.11 and 002.1 ->which is bigger? you have to ignore the initial zeros before first.
       
        // . in 1 and not in other ->other is greater
        // 1.1.1 amd 1.1 -> -1 (1.10 is greater than 1.1.1)
        //compare every number between . and see which one is greater
        String v1s [] = version1.split("\\.");
        String v2s [] = version2.split("\\.");
        int v1=0;
        int v2=0;
        //if anyone ends and result is not defined yet
        //search the other one for non zero
        //each split should be onverted to a nmber and then compared whichevert is grater
        while(v1< v1s.length && v2 < v2s.length){
            
            int x=Integer.compare(Integer.parseInt(v1s[v1]), Integer.parseInt(v2s[v2]));
            if(x!=0)return x;
            v1++;v2++;
        }
        // System.out.println("v1 "+Arrays.toString(v1s) + "v2 "+v2); 
        if(v2< v2s.length ){
            //check in v2 if you have non zero
            return checkNonZero(v2s, v2, -1);
        }
        if(v1<v1s.length){
            //check in v2 if you have non zero
            return checkNonZero(v1s, v1, 1);
        }
        return 0;        
    }
    public int checkNonZero(String s[], int st, int ret){
        
        for(int i=st; i< s.length;i++){
            if(Integer.parseInt(s[i])!=0) return ret;
        }
        return 0;
    }
}