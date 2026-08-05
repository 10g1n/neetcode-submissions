class Node {
    int val;
    Node next;

    public Node(){}

    public Node(int value) {
        this.val = value;
        this.next = null;
    }
}

class LinkedList {
    Node head;
    Node tail;
    int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int get(int index) {
        if (head == null) {
            return -1;
        }

        if (index < 0) {
            return -1;
        }

        if (index > size - 1) {
            return -1;
        }

        Node first = head;

        int i = 0;
        while (first != null && i < index) {
            first = first.next;
            i++;
        }

        if (first == null) {
            return -1;
        }

        return first.val;
    }

    public void insertHead(int val) {
        Node newNode = new Node(val);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }

        size++;
    }

    public void insertTail(int val) {
        Node newNode = new Node(val);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    public boolean remove(int index) {
        if (head == null) {
            return false;
        }

        if (index < 0) {
            return false;
        }

        if (index > size - 1) {
            return false;
        }


        if (index == 0) {
            head = head.next;

            if (head == null) {
                tail = null;
            }

            size--;
            return true;
        }

        Node first = head;
        Node prev = null;
        int i = 0;

        while (i < index) {
            prev = first;
            first = first.next;
            i++;
        }

        if (first == null) {
            return false;
        }

        prev.next = first.next;

        if (first == tail) {
            tail = prev;
        }

        first.next = null;

        size--;

        return true;
    }

    public ArrayList<Integer> getValues() {
        if (head == null) {
            return new ArrayList<>();
        }

        ArrayList<Integer> values = new ArrayList<>();

        Node first = head;

        while (first != null) {
            values.add(first.val);

            first = first.next;
        }

        return values;
    }
}
