/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode move1 = l1;
        ListNode move2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode result = dummy.next; 
        ListNode current = dummy;
        int carry = 0;
        while (move1 != null && move2 != null) {
            result = new ListNode((carry + move1.val + move2.val) % 10);
            current.next = result;
            carry = (carry + move1.val + move2.val) / 10;
            move1 = move1.next;
            move2 = move2.next;
            result = result.next;
            current = current.next;
        }
        if (move1 == null && move2 != null) {
            while (move2 != null) {
                result = new ListNode((carry + move2.val) % 10);
                current.next = result;
                carry = (carry + move2.val) / 10;
                move2 = move2.next;
                result = result.next;
                current = current.next;
            }
        }
        else if (move1 != null && move2 == null) {
            while (move1 != null) {
                result = new ListNode((carry + move1.val) % 10);
                current.next = result;
                carry = (carry + move1.val) / 10;
                move1 = move1.next;
                result = result.next;
                current = current.next;
            }
        }
        if (move1 == null && move2 == null && carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
