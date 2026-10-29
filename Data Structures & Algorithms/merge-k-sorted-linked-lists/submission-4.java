/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        // for (ListNode list : lists) {
        //     ListNode head = list;

        //     while (head != null) {
        //         minHeap.add(head.val);

        //         head = head.next;
        //     }
        // }

        for (ListNode list : lists) {
            ListNode head = list;
            if (head != null && list != null) {
                minHeap.add(head);
            }
        }

        ListNode first = new ListNode(-1);
        ListNode tail = first;
        
        while (!minHeap.isEmpty()) {
            ListNode minNode = minHeap.poll();

            tail.next = minNode;
            tail = minNode;

            if (minNode.next != null) {
                minHeap.add(minNode.next);
            }
        }

        // ListNode first = new ListNode(-1);
        // ListNode tail = first;
        // while (!minHeap.isEmpty()) {
        //     ListNode node = new ListNode(minHeap.poll());
            
        //     tail.next = node;
        //     tail = node;
        // }
        
        return first.next;
    }
}
