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
    int preOrderIndex = 0;
    Map<Integer, Integer> inOrderMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inOrderMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            inOrderMap.put(inorder[i], i); // value -> index, for O(1) lookup
        }

        return build(preorder, 0, inorder.length-1);
    }

    private TreeNode build(int[] preorder, int left , int right){
        if(left>right){
            return null;
        }

        int rootVal = preorder[preOrderIndex];
        preOrderIndex++;
        TreeNode node = new TreeNode(rootVal);

        int mid = inOrderMap.get(rootVal);
        node.left = build(preorder, left, mid-1);
        node.right = build(preorder, mid+1, right);
        return node;
    }
}
