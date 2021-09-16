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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        Stack<TreeNode> stack = new Stack<>();
        // stack.push(root);
        List<Integer> res = new ArrayList<>();
        while(true) {
            while(root!=null){
                stack.push(root);
                root=root.left;
                    
            }
            if(stack.isEmpty())break;
            TreeNode node= stack.pop();
            res.add(node.val);
            
            root = node.right;
        }
        return res;
        
    }
}