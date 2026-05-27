/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> indexMap = new HashMap<>();//the original node and the new node present there
        Node ptr = head;
        Node newNode = new Node(-1);
        while(ptr != null){
            Node node = new Node(ptr.val);
            newNode.next = node;
            indexMap.put(ptr, node);
            newNode = node;
            ptr = ptr.next;
        }

        ptr = head;
        while(ptr != null){
            Node indexToPoint = ptr.random;
            Node node = indexMap.get(ptr);
            node.random = indexMap.get(indexToPoint);
            ptr = ptr.next;
        }

        return indexMap.get(head);
    }
}
