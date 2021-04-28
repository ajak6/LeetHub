class Solution {
    HashMap<Integer,Integer>d=new HashMap<>();
    public int climbStairs(int n) {
       if(n==1 || n==0)return 1;
        if(d.containsKey(n))return d.get(n);
        int result =  climbStairs(n-1)+ climbStairs(n-2);
        d.put(n, result);
        return result;
    }
}