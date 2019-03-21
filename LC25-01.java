/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = dummy;
        ListNode current = head;
        ListNode move = dummy;
        int count = 0;
        while (move.next != null) {
            count++;
            move = move.next;
        }
        int i = 0;
        while (i < count / k) {
            int j = 1;
            while (j < k) {
                move = current.next;
                current.next = move.next;
                move.next = start.next;
                start.next = move;
                j++;
            }
            head = head.next;
            start = current;
            current = head;
            i++;
        }

        return dummy.next;
    }

}
