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
        HashMap<Node, Node> map = new HashMap<>();

        Node first = new Node(-1);
        first.next = head;

        Node tail = first;

        Node temp = head;

        while (temp != null) {
            Node newNode = new Node(temp.val);
            map.put(temp, newNode);

            temp = temp.next;
        }

        while (head != null) {
            Node copy = map.get(head);
            copy.next = map.get(head.next);
            copy.random = map.get(head.random);

            tail.next = copy;
            tail = copy;

            head = head.next;
        }

        return first.next;
    }
}
