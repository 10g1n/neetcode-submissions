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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // int nthEl Index = size - n + 1

        if (head == null) {
            return null;
        }

        ListNode first = head;
        int size = 0;
        while (first != null) {
            size++;
            first = first.next;
        }

        int nthElIndex = size - n;

        if (nthElIndex == 0) {
            return head.next;
        }

        ListNode prev = head;
        ListNode nodeToDelete = head;

        for (int i = 0; i < nthElIndex; i++) {
            prev = nodeToDelete;
            nodeToDelete = nodeToDelete.next;
        }

        prev.next = nodeToDelete.next;

        return head;
    }
}
