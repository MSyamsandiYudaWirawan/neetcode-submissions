public static class Node{
    int val;
    int key;
    Node next;
    Node prev;
    public Node(int key, int val){
        this.key = key;
        this.val = val;
        next = null;
        prev = null;
    }
}

class LRUCache {
    Node left;
    Node right;
    Map<Integer, Node> map;
    int cap;

    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>();
        left = new Node(0,0);
        right = new Node(0,0);
        left.next = right;
        right.prev = left;
    }
    private void remove(Node node){
        Node next = node.next;
        Node prev = node.prev;
        next.prev = prev;
        prev.next = next;
    }

    private void insert(Node node){
        Node next = right;
        Node prev = right.prev;

        prev.next = node;
        node.prev = prev;

        next.prev = node;
        node.next = next;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.val;
        } 
        return -1;
    }
    
    public void put(int key, int value) {
        Node node = null;
        if(map.containsKey(key)){
            node = map.get(key);
            node.val = value;
            remove(node);
            insert(node);
        }else{
            node = new Node(key,value);
            insert(node);
            map.put(key,node);

            if(map.size() > this.cap){
                Node lru = this.left.next;
                remove(lru);
                map.remove(lru.key);
            }
        }
    }
}
