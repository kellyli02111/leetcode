/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = head;
        
        while (current.next != null) {
            ListNode move = current.next;
            current.next = move.next;
            move.next = dummy.next;
            dummy.next = move;

        }
        return dummy.next;
    }
}
