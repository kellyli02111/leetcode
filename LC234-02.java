// time: O(n)
// space: O(1)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode move1 = head;
        int count = 0;
        while (move1 != null) {
            count++;
            move1 = move1.next;
        }
        ListNode newHead = head;
        for (int i = 0; i < count / 2; i++) {
            newHead = newHead.next;
        }
        if (count % 2 > 0) {
            newHead = newHead.next;
        }
        ListNode move2 = reverseLinkedList(newHead);

        move1 = head;
        for (int i = 0; i < count / 2 ; i++) {
            if (move1.val != move2.val) {
                return false;
            }
            move1 = move1.next;
            move2 = move2.next;
        }
        return true;
    }
    public ListNode reverseLinkedList(ListNode head) {
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
