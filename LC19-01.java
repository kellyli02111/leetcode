// two pass

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode move = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int count = 1;
        while (move.next != null) {
            move = move.next;
            count++;
        }
        System.out.print(count);
        if (n > count) {
            return null;
        }
        move = dummy;
        for (int i = 0; i < count - n; i++) {
            move = move.next;
        }
        move.next = move.next.next;
        return dummy.next;
    }
}
