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
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode oddMove = head;
        ListNode evenMove = evenHead;
        while (oddMove != null && evenMove != null) {
            if (evenMove.next != null) {
                oddMove.next = evenMove.next;
                oddMove = oddMove.next;
                if (oddMove != null) {
                    evenMove.next = oddMove.next;
                    evenMove = evenMove.next;
                }
            }
            else {
                break;
            }
        }
        oddMove.next = evenHead;
        return head;
    }
}
