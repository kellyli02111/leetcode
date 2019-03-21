/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode last = dummy;
        ListNode move = head;
        while (move != null) {
            if (move.next != null && move.next.val == move.val) {
                while (move.next != null && move.next.val == move.val) {
                    move = move.next;
                }
                last.next = move.next;
            }
            else {
                last = last.next;
            }
            move = move.next;
        }
        return dummy.next;
    }
}
