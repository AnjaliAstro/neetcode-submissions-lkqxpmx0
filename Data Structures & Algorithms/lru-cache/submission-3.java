//Be Great, Be EPIC, Have Patience !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
class Node{
    int key;
    int value;
    Node next;
    Node prev;

    Node(int key, int val){
        this.key = key;
        this.value = val;
    }
}

class LRUCache {
    int limit = 0;
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);

    HashMap<Integer, Node> isPresent = new HashMap<>();

    public LRUCache(int capacity) {
        limit = capacity;
        tail.next = head;
        head.prev = tail;
    }
    
    public int get(int key) {
        if(!isPresent.containsKey(key)){
            return -1;
        }

        Node found = isPresent.get(key);

        //remove the node from its curr position
        removeNode(found);

        //shift found ahead
        addAhead(found);

        return found.value;
    }
    
    public void put(int key, int value) {
        if(isPresent.containsKey(key)){
            //remove the node from its curr position
            Node node = isPresent.get(key);
            removeNode(node);
            isPresent.remove(key);
        }

        Node node = new Node(key, value);
        
        if(isPresent.size() == limit){
            //get the last item to remove
            Node toRemove = tail.next;
            removeNode(toRemove);
            isPresent.remove(toRemove.key);
        }

        //addAhead
        addAhead(node);
        isPresent.put(key, node);
    }

    private void addAhead(Node found){
        Node prevToHead = head.prev;
        prevToHead.next = found;
        found.prev = prevToHead;
        found.next = head;
        head.prev = found;
    }

    private void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
