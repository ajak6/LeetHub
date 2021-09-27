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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum(root, targetSum, 0);
    }
    
    public boolean hasPathSum(TreeNode root, int targetSum , int current) {
        if(root==null) return false;
        
        current +=root.val;
        
        if(targetSum==current && leaf(root)) return true;

        //if any returns true return
        return hasPathSum(root.left, targetSum, current) || hasPathSum(root.right, targetSum, current) ;
        
    }
    
    public boolean leaf(TreeNode root){
        
        return root.left==null && root.right==null;
    }
}