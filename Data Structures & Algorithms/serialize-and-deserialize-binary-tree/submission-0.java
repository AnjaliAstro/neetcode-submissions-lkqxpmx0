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

public class Codec {
    String encoded = "";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        encode(root);
        // System.out.println("string " + encoded);
        return encoded;
    }

    private void encode(TreeNode root){
        if(root == null){
            encoded += ",null";
            return;
        }

        encoded += ","+root.val;
        encode(root.left);
        encode(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>();
        String[] parts = data.split(",");
        for(int i=1; i<parts.length; i++){
            q.add(parts[i]);
        }
        return decode(q);
    }

    private TreeNode decode(Queue<String>q){
        String curr = q.poll();

        if(curr.equals("null")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(curr));
        root.left = decode(q);
        root.right = decode(q);
        return root;
    }
}
//12nullnull34nullnull5nullnull
