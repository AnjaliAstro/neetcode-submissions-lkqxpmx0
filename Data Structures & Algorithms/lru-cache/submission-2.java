//Be Great, Be EPIC!
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
        Node previous = found.prev;
        Node nextSeq = found.next;
        previous.next = nextSeq;
        nextSeq.prev = previous;

        //shift found ahead
        Node prevToHead = head.prev;
        prevToHead.next = found;
        found.prev = prevToHead;
        found.next = head;
        head.prev = found;
        return found.value;
    }
    
    public void put(int key, int value) {
        if(isPresent.containsKey(key)){
            Node old = isPresent.get(key);
            old.prev.next = old.next;
            old.next.prev = old.prev;
            isPresent.remove(key);
        }

        Node node = new Node(key, value);
        
        if(isPresent.size() == limit){
            //get the last item to remove
            Node toRemove = tail.next;
            tail.next = toRemove.next;
            toRemove.next.prev = tail;
            isPresent.remove(toRemove.key);
        }

        //insert
        node.next = head;
        node.prev = head.prev;
        head.prev.next = node;
        head.prev = node;
        isPresent.put(key, node);
    }
}
