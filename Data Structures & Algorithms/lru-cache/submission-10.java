public static class Node{
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
        prev = null;
        next = null;
    }
}

class LRUCache {
    private Map<Integer,Node> map;
    private Node left;
    private Node right;
    private int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        left = new Node(0,0);
        right = new Node(0,0);
        left.next = right;
        right.prev = left;
    }
    private void remove(Node node){
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;
    }
    private void insert(Node node){
        Node prev = right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = right;
        right.prev = node;
    }

    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        insert(node);
        return node.val;
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

            if(map.size() > cap){
                node = left.next;
                remove(node);
                map.remove(node.key);
            }
        }

    }
}
