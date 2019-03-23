// time: O(n)
// space: O(1)
// Floyd's Tortoise and Hare

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode intersect = new ListNode(0);
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                intersect = fast;
                break;
            }
        }
        if (intersect.next == null) {
            return null;
        }
        slow = head;
        while (intersect != slow) {
            intersect = intersect.next;
            slow = slow.next;
        }
        return slow;
    }

}
