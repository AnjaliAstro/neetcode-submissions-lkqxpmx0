/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Integer, Node> visited = new HashMap<>();
        return recur(node, visited);
    }

    private Node recur(Node node, Map<Integer, Node> visited){
        Node copyNode;
        if(visited.containsKey(node.val)){
            copyNode = visited.get(node.val);
            return copyNode;
        }
        else{
            copyNode = new Node();
        }

        copyNode.val = node.val;
        visited.put(node.val, copyNode);
        copyNode.neighbors = new ArrayList<Node>();
        for(Node temp: node.neighbors){
            Node adj = recur(temp, visited);
            visited.put(temp.val, adj);
            copyNode.neighbors.add(adj);
        }
        return copyNode;
    }
}