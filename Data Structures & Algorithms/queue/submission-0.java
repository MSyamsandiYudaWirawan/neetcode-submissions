class Node {
    int value;
    Node prev;
    Node next;
    public Node(int value){
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}
class Deque {
    private Node dummyHead;
    private Node dummyTail;

    public Deque() {
        dummyHead = new Node(0);
        dummyTail = new Node(0);

        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public boolean isEmpty() {
        return dummyHead.next == dummyTail;
    }

    public void append(int value) {
       Node newNode = new Node(value);
       newNode.next = dummyTail;
       newNode.prev = dummyTail.prev;
       dummyTail.prev.next = newNode;
       dummyTail.prev = newNode;
    }

    public void appendleft(int value) {
        Node newNode = new Node(value);
        newNode.next = dummyHead.next;
        newNode.prev = dummyHead; 
        dummyHead.next.prev = newNode;
        dummyHead.next = newNode;
    }

    public int pop() {
        if(isEmpty()){
            return -1;
        }
        Node targetNode = dummyTail.prev;
        Node prevNode = targetNode.prev;
        int value = targetNode.value;

        dummyTail.prev = prevNode;
        prevNode.next = dummyTail;
        return value;
    }

    public int popleft() {
        if(isEmpty()){
            return -1;
        }
        Node targetNode = dummyHead.next;
        Node nextNode = targetNode.next;
        int value = targetNode.value;

        dummyHead.next = nextNode;
        nextNode.prev = dummyHead;
        return value;
    }
}
