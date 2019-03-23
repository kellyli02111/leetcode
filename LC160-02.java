/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null) {
            return headA;
        }
        if (headB == null) {
            return headB;
        }
        ListNode moveA = headA;
        ListNode moveB = headB;
        while (moveA != moveB) {
            if (moveA != null && moveB != null) {
                moveA = moveA.next;
                moveB = moveB.next;
            }
            else if (moveA == null && moveB != null) {
                moveA = headB;
                moveB = moveB.next;
            }
            else if (moveB == null && moveA != null) {
                moveB = headA;
                moveA = moveA.next;
            }
        }
        if (moveA == null) {
            return null;
        }
        else {
            return moveA;
        }
    }
}
