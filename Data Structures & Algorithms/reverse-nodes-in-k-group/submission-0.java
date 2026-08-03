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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        int length = 0;
        ListNode curr = head;

        while (curr != null) {
            length++;
            curr = curr.next;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode groupPrev = dummy;
        curr = head;

        while (length >= k) {
            ListNode groupStart = curr;
            ListNode prev = null;

            for (int i = 0; i < k; i++) {
                ListNode next = curr.next;

                curr.next = prev;
                prev = curr;
                curr = next;
            }

            groupPrev.next = prev;
            groupStart.next = curr;

            groupPrev = groupStart;

            length -= k;
        }

        return dummy.next;
    }
}
