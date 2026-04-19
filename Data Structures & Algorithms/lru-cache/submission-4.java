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
    HashMap<Integer, Node> cache = new HashMap<>();

    public LRUCache(int capacity) {
        limit = capacity;
        tail.next = head;
        head.prev = tail;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }

        Node found = cache.get(key);
        removeNode(found);
        addAhead(found);
        return found.value;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node old = cache.get(key);
            removeNode(old);
            cache.remove(key);
        }

        Node node = new Node(key, value);
        
        if(cache.size() == limit){
            Node lru = tail.next;
            removeNode(lru);
            cache.remove(lru.key);
        }

        addAhead(node);
        cache.put(key, node);
    }

    private void addAhead(Node node){
        Node prevToHead = head.prev;
        prevToHead.next = node;
        node.prev = prevToHead;
        node.next = head;
        head.prev = node;
    }

    private void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}