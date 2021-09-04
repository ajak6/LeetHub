/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        
        //start from root and find all sums in left and right
        // and then do same starting at each node.
        //function which recurse and add the root every time nad checksfor target if it is increase the count and look in left and right as well with the left over sun 
        
        int ways = countMeIN(root, targetSum, 0);

        ways+= pathSum(root.left, targetSum);
        ways+= pathSum(root.right, targetSum);
        
        return ways;
    }
    public int countMeIN(TreeNode root, int target, int curr){
        
        if(root==null) return 0;
        int ways=0;
        curr+=root.val;
        if(curr==target) ways++;
        
        int leftWays = countMeIN(root.left, target, curr);
        int rightWays = countMeIN(root.right , target, curr);
        
        return leftWays+rightWays+ways;
    }
}