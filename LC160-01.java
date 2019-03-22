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
        
        int countA = 1;
        int countB = 1;
        while (moveA.next != null) {
            countA++;
            moveA = moveA.next;
        }
        while (moveB.next != null) {
            countB++;
            moveB = moveB.next;
        }
        moveA = headA;
        moveB = headB;
        if (countA > countB) {
            for (int i = 0; i < countA - countB; i++) {
                moveA = moveA.next;
            }
        }
        else if (countA < countB) {
            for (int i = 0; i < countB - countA; i++) {
                moveB = moveB.next;
            }
        }
        while (moveA != null && moveB != null) {
            if (moveA == moveB) {
                return moveA;
            }
            else {
                moveA = moveA.next;
                moveB = moveB.next;
            }
        }
        return null;
    }
}
