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
    int maxDia = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxDia;
    }

    private int dfs(TreeNode root){
        //base case
        if(root == null){
            return 0;
        }

        int leftDia = dfs(root.left);
        int rightDia = dfs(root.right);
        int betweenDia = leftDia + rightDia;
        maxDia = Math.max(maxDia, Math.max(betweenDia, Math.max(leftDia, rightDia)));
        return 1 + Math.max(leftDia, rightDia);
    }
}
