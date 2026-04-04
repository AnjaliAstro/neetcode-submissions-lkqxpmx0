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
    int good = 0;
    public int goodNodes(TreeNode root) {
        traverse(root, Integer.MIN_VALUE);
        return good;
    }

    private void traverse(TreeNode root, int value){
        if(root == null){
            return;
        }
        if(root.val >= value){
            good++;
            value = root.val;
        }
        traverse(root.left, value);
        traverse(root.right, value);
    }
}
