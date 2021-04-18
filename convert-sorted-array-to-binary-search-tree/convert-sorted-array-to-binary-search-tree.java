/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public TreeNode sortedArrayToBST(int[] nums) {
        
        return createTree(nums, 0 , nums.length-1);
    }
    
    public TreeNode createTree(int nums [], int i, int j){
        if(i>j)return null;
        int mid = i + (j-i)/2;
        
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createTree(nums, i , mid-1);
        root.right = createTree(nums, mid+1, j);
        return root;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//     public TreeNode sortedArrayToBST(int[] nums) {
        
//         return bst(nums, 0, nums.length-1);
        
//     }
        
//     private TreeNode bst(int nums[], int i, int j){
        
//         if(i>j) return null;
        
//         int root = (i+j)/2;
//         TreeNode left = bst(nums, i, root-1);
//         TreeNode right = bst(nums,root+1, j);
        
//         TreeNode root1 = new TreeNode(nums[root]);
//         root1.left = left;
//         root1.right = right;
//         return root1;
//     }
}