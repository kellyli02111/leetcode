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
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] result = new ListNode[k];
        if (root == null) {
            return result;
        }
        int count = 0;
        ListNode move = root;
        while (move != null) {
            count++;
            move = move.next;
        }
        int res = count % k;
        move = root;
        for (int i = 0; i < k; i++) {
            int size = count / k;
            if (res > 0) {
                size++;
                res--;
            }
            if (size > 0 && move != null) {
                result[i] = move;
                for (int j = 0; j < size - 1; j++) {
                    move = move.next;
                }
                ListNode end = move;
                move = move.next;
                end.next = null;
            }
        }
        return result;
    }
}
