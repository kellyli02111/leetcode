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
        int length1 = getLength(l1);
        int length2 = getLength(l2);
        int diff = Math.abs(length1 - length2);
        if (length1 < length2) {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        ListNode move1 = l1;
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        ListNode right = current;
        while (diff > 0) {
            current.next = new ListNode(move1.val);
            if (move1.val < 9) {
                right = current.next;
            }
            current = current.next;
            move1 = move1.next;
            diff--;
        }
        ListNode move2 = l2;
        while (move1 != null) {
            int sum = move1.val + move2.val;
            if (sum > 9) {
                right.val++;
                sum %= 10;
                while (right.next != null) {
                    right.next.val = 0;
                    right = right.next;
                }
                right = current;
            }
            current.next = new ListNode(sum);
            if (sum < 9) {
                right = current.next;
            }
            current = current.next;
            move1 = move1.next;
            move2 = move2.next;
        }
        if (dummy.val > 0) {
            return dummy;
        }
        else {
            return dummy.next;
        }
        
    }
    public int getLength(ListNode head) {
        ListNode move = head;
        int length = 0;
        while (move != null) {
            length++;
            move = move.next;
        }
        return length;
    }

}
