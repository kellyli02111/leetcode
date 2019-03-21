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
        ListNode second = head;
        ListNode first = second.next;
        while (first != null) {
            if (first.val == second.val) {
                second.next = first.next;
            }
            else {
                second = second.next;
            }
            first = first.next;
        }
        return dummy.next;
    }
}
