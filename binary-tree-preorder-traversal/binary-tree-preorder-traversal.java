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
    public List<Integer> preorderTraversal(TreeNode root) {
        
        //iterator
        
        //recursive
        List<Integer> result = new ArrayList<>();
        preorderRecurse(result, root);
        return result;
    }
    
    public void preorderRecurse(List<Integer> result, TreeNode root){
        
        if(root==null)return;
        result.add(root.val);
        preorderRecurse(result, root.left);
        preorderRecurse(result, root.right);
    }
}
