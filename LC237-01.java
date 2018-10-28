// O(n)


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        if (node != null)
        {
            ListNode current = node;
            ListNode tail = current;
            while (current.next != null)
            {
                if (current.next.next == null)
                    tail = current;
                current.val = current.next.val;
                current = current.next;
            }
            tail.next = null;
        }
    }
}
