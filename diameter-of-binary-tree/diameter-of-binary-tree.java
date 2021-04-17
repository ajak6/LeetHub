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
    public int diameterOfBinaryTree(TreeNode root) {
        //max element in the lft tree and max element in the right tree.
        
        // at every root it will count the max lenght of left and righrt. add itself and pass it one. also store th e max it has seen till now.
        
        int max [] = new int[1];
        find(root, max);
        return max[0]-1; // -1 for edges, max is number of vertex, edge is 1 less
    }
    
    public int find(TreeNode root, int max[]){
        
        if(root == null)return 0;
        
        int left = find(root.left, max);
        int right = find(root.right, max);
        
        max[0]= Math.max(max[0], left+ right +1);
        
        return Math.max(left, right) +1;            
    }
}