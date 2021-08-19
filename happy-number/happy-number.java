class Solution {
    HashSet<Integer> visited=new HashSet<>();
    public boolean isHappy(int n) {
        // System.out.println(n);
        if(visited.contains(n)){
            return false;
        }
        visited.add(n);
        if(n==1)return true;
        int sum=0;
        while(n>0){
            int last = n % 10;
            sum=sum+ (last*last);
            n=n/10;
        }

        
        return isHappy(sum);
    }
}