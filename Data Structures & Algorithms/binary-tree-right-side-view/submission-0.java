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
    Map<Integer, Integer> levelMap;
    public List<Integer> rightSideView(TreeNode root) {
        levelMap = new HashMap<>();
        dfs(root, 0);
        return new ArrayList<>(levelMap.values());
    }

    private void dfs(TreeNode root, int level){
        if(root == null){
            return;
        }
        dfs(root.left, level+1);
        levelMap.put(level, root.val);
        dfs(root.right, level+1);
    }
}
