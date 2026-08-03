class DoublyLinkedList {
    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insertAfterHead(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    public Node removeLast() {
        Node last = tail.prev;

        removeNode(last);
        return last;
    }
}


class Node {
    int key;
    int value;

    Node next;
    Node prev;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public Node(int key, int value, Node next, Node prev) {
        this.key = key;
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}

class LRUCache {
    private int capacity;

    private HashMap<Integer, Node> data = new HashMap<>();
    private DoublyLinkedList dll = new DoublyLinkedList();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (data.containsKey(key)) {
            Node node = data.get(key);

            dll.removeNode(node);
            dll.insertAfterHead(node);

            return node.value;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if (data.containsKey(key)) {
            Node node = data.get(key);
            node.value = value;

            dll.removeNode(node);
            dll.insertAfterHead(node);
        } else {
            if (data.size() >= capacity) {
                Node last = dll.removeLast();
                data.remove(last.key);
            }
            Node newNode = new Node(key, value);
            dll.insertAfterHead(newNode);
            data.put(key, newNode);
        }
    }
}
