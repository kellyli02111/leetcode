/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = head;
        ListNode pre = dummy;
        while (current != null) {
            if (current.val == val) {
                pre.next = current.next;
            }
            else {
                pre = pre.next;
            }
            current = current.next;
        }
        return dummy.next;
    }
}
