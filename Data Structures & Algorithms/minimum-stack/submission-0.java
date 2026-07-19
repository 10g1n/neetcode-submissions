class Node {
    int value;
    Node next;

    public Node(int val, Node nextNode) {
        this.value = val;
        this.next = nextNode;
    }
}

class MinStack {
    private Node top;
    private Node minTop;

    public MinStack() {
    }
    
    public void push(int val) {
        Node newNode = new Node(val, null);

        newNode.next = top;
        top = newNode;

        if (minTop == null) {
            minTop = new Node(val, null);
        } else {
            minTop = new Node(Math.min(newNode.value, minTop.value), minTop);
        }
    }
    
    public void pop() {
        if (top == null) {
            return;
        }

        top = top.next;
        minTop = minTop.next;
    }
    
    public int top() {
        return top.value;
    }
    
    public int getMin() {
        return minTop.value;
    }
}
