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
    int tracker = 0;
    int value = 0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return value;
    }

    private void dfs(TreeNode root, int k){
        if(root == null){
            return;
        }
        dfs(root.left, k);
        tracker++;
        if(tracker == k){
            value = root.val;
        }
        dfs(root.right, k);
    }
}
//1st approach - input all and then get the smallest k