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
    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findLowestCommonAncestor(root, p, q);
        return res;
    }

    private boolean findLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return false;
        }

        boolean left = findLowestCommonAncestor(root.left, p, q);
        boolean right = findLowestCommonAncestor(root.right, p, q);

        boolean curr = root.val == p.val || root.val == q.val;

        if((curr && left) || (curr && right) || (left && right)){
            res = root;
        }
        return curr||left||right;
    }

}
