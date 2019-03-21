/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        int count = 0;
        while (first.next != null) {
            count++;
            first = first.next;
        }
        k = k % count;
        first = dummy;
        for (int i = 0; i < k; i++) {
            first = first.next;
        }
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        first.next = head;
        dummy.next = second.next;
        second.next = null;
        return dummy.next;
    }
}
