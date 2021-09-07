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
    public TreeNode deleteNode(TreeNode root, int key) {
        
        TreeNode se []= search(root, null, key);
        if(se==null)return root;
        //you still have to return the root node.
        if(se[1]==null) return deleteRoot(se[0]);
        else{
            if(se[1].left==se[0]){
                se[1].left=deleteRoot(se[0]);
            }else{
                se[1].right=deleteRoot(se[0]);
            }
            return root;
        }
    }
    public TreeNode deleteRoot(TreeNode root) {
        
        // We just want to delete the node and return the lower tree let the caller worry about parent
        if(root==null) return null;
        if(root.left==null) return root.right;
        if(root.right==null) return root.left;
        
        else{
            // this condidition means root have both left and irhg child
            TreeNode leftHigh = root.left;
            TreeNode prev = null;
            while(leftHigh.right!=null){
                prev= leftHigh;
                leftHigh=leftHigh.right;
            }
            //update the parent of leftHigh;
            if(prev!=null) prev.right = leftHigh.left; //will loost leftGHigh left chuild if the rightmost had some childs . // update the parent of left if present, current root should not be updated else it will break the connection from root.right which we don't wnat to touch.
            leftHigh.right = root.right;
            if(leftHigh != root.left)
                leftHigh.left= root.left;
            return leftHigh;
        }
    }
    /**
        Cases: root is deleted : left element in the right tree becomes root. so delete right most element
        node with  2 child is deleted: can be same as root? find the right most and udpate but yo uhave to connect with its parent if it is not null
        node with 1 child is deleted:  
        node wiht no child is deleted
    */
    public TreeNode delete(TreeNode root, TreeNode parent, int key) {
        if(root==null)return null;
        if(root.val == key) {            
            TreeNode leftMostInRight = null;
            if(root.right==null){
                //select the right most in left
                if(root.left!=null && root.left.right != null) {
                    leftMostInRight = getRightMostInLeft(root.left, root);    
                } else {
                    leftMostInRight = root.left;
                    root.left=null;
                }
                if(leftMostInRight!=null)
                    leftMostInRight.right = root.right;

            } else {
                if(root.right!=null && root.right.left != null){
                    leftMostInRight = getLeftMostRight(root.right, root);    
                } else {
                    leftMostInRight = root.right;

                    root.right=null;
                }
                if(leftMostInRight!=null)
                    leftMostInRight.left = root.left;
            }


            if(parent ==null) return leftMostInRight;

            else if (parent.right == root) { 
                parent.right = leftMostInRight;

            } else {
                parent.left= leftMostInRight;    
            }
            // }
        }
        return null;
    }
    
    public TreeNode[] search(TreeNode root, TreeNode parent, int key) {
        if(root==null)return null;
        
        if(root.val==key){
            return new TreeNode[]{root, parent};
        }else if(root.val > key){
            return search(root.left,root, key);
        } else{
            return search(root.right, root, key);
        }
        
    }
    
    public TreeNode getLeftMostRight(TreeNode node, TreeNode parent) {
        if(node==null) return node;
        
        if(node.left==null){
            parent.left=null;
            return node;
        }
        return getLeftMostRight(node.left, node);
    }
    public TreeNode getRightMostInLeft(TreeNode node, TreeNode parent) {
        if(node==null) return node;
        
        if(node.right==null){
            parent.right=null;
            return node;
        }
        return getRightMostInLeft(node.right, node);
    }
}