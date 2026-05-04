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
    Map<Integer, List<Integer>> levelMap;
    public List<List<Integer>> levelOrder(TreeNode root) {
        levelMap = new HashMap<>();
        traversal(root, 0);
        return new ArrayList<>(levelMap.values());
    }

    private void traversal(TreeNode root, int level){
        if(root == null){
            return;
        }

        List<Integer> currList = levelMap.getOrDefault(level, new ArrayList<>());
        currList.add(root.val);
        levelMap.put(level, currList);

        traversal(root.left, level+1);
        traversal(root.right, level+1);
    }
}
