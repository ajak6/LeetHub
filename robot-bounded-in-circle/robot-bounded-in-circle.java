class Solution {
    public boolean isRobotBounded(String instructions) {
        
        
        //if we simluate and from north if it moves in any other direction at the nd it si bound to always be inside the circle
        //we just need to know the direction relations
        int [] up = new int[] {0,1};
        int down[] = new int[] {0,-1};
        int left[] = new int[] {-1,0};
        int right[] = new int[] {1,0};
        Map<int[], int[]> leftMap=new HashMap<>(){{
            put(up, left);
            put(left, down);
            put(down, right);
            put(right, up);
        }};
        Map<int[],int[]> rightMap = new HashMap<>(){{
            put(up, right);
            put(right, down);
            put(down, left);
            put(left, up);
        }};
        int[] curr = up;
        int x=0,y=0;
        for(char c: instructions.toCharArray()){
            if(c=='L') {
                curr=leftMap.get(curr);
            }
            if(c=='R'){
                curr=rightMap.get(curr);
            }
            if(c=='G'){
                x+=curr[0];
                y+=curr[1];
            }
        }

        if (x==0 && y==0) return true; //if we areach to starting point then we are okay and will not go infinite direction.
        //if we are anywhere else then the direction should be something other than up(where we started)
        return curr != up;
    }
}