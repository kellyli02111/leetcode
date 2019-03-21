/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        ListNode first = head.next;
        ListNode second = head;
        while (first != null) {
            second.next = first.next;
            first.next = second;
            current.next = first;
            current = second;
            if (second.next != null) {
                second = second.next;
            }
            first = second.next;
        }
        return dummy.next;
    }
}
