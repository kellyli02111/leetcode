/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = dummy;
        ListNode current = head;
        for (int i = 0; i < m - 1; i++) {
            current = current.next;
            start = start.next;
        }
        for (int i = m; i < n; i++) {
            ListNode move = current.next;
            current.next = move.next;
            move.next = start.next;
            start.next = move;
        }
        return dummy.next;
    }
}
