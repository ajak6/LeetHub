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
    public int closestValue(TreeNode root, double target) {
        Stack<TreeNode> stack = new Stack<>();
        double minDiff = 1.0*Integer.MAX_VALUE;
        Integer prev = null;
        if(root==null)return 0;
        
        while(!(root==null && stack.isEmpty())) {
            
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root = stack.pop();
            if(Math.abs(target - 1.0*root.val) < minDiff){
                prev=root.val;
                minDiff=Math.abs(target - 1.0*root.val);
            }
            root=root.right;
        }
        return prev;
    }
}