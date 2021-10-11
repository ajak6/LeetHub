class Solution {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0)return 0;
        
        //ROBA HOUR ANDS TORE THE LOOT
        //next house check the profit it we loot the house or not loot the house
        //on every ourwe have 2 choices either to rob or not rob
        
        //brute force is loop and recurse 
        //smarter I only nee d to know if we 
        //max (prevLoot, nums[i]+ prevPrevLoot
        int prevPrevLoot = 0;
        int prevLoot=0;
        for(int i=0;i < nums.length;i++)
        {
            
            int lootTemp = Math.max(nums[i] + prevPrevLoot,  prevLoot);
            prevPrevLoot=prevLoot; //0 1 2 4
            prevLoot=lootTemp; //1 2 4 4
            
        }
        return prevLoot;
    }
}