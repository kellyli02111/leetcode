/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode move1 = l1;
        ListNode move2 = l2;
        ListNode result = new ListNode(0);
        ListNode current = result;
        while (move1 != null && move2 != null) {
            if (move1.val <= move2.val) {
                current.next = move1;
                move1 = move1.next;
            }
            else {
                current.next = move2;
                move2 = move2.next;
            }
            current = current.next;
        }
        if (move1 == null) {
            current.next = move2;
        }
        else if (move2 == null) {
            current.next = move1;
        }
        return result.next;
    }
}
