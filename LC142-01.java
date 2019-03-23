// time: O(n)
// space: O(n)

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
        HashMap<ListNode, Integer> map = new HashMap<ListNode, Integer>();
        ListNode move = head;
        while (move.next != null) {
            if (!map.containsKey(move)) {
                map.put(move, 1);
                move = move.next;
            }
            else {
                return move;
            }
         }
        return null;
    }

}
