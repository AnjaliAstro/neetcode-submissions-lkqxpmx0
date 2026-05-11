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
    public boolean isValidBST(TreeNode root) {
        return validity(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean validity(TreeNode root, int smallest , int largest){
        if(root == null){
            return true;
        }

        if(root.left != null){
            if(root.left.val >= root.val || root.left.val >= largest || root.left.val <= smallest){
                return false;
            }
        }

        if(root.right != null){
            if(root.right.val <= root.val || root.right.val <= smallest || root.right.val >= largest){
                return false;
            }
        }

        return validity(root.left, smallest, root.val) && validity(root.right, root.val, largest);
    }
}
