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
    public int rangeSumBST(TreeNode root, int low, int high) {
        //inorder traversal, once you see a number greater than high stop for optimization
        Stack<TreeNode> stack = new Stack<>();
        int sum =0;
        while(true){
            
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            if(stack.isEmpty()) break;
            
            root = stack.pop();
            if(root.val>= low && root.val <= high){
                sum+=root.val;
            }
            root=root.right;
        }
        return sum;
        
    }
}