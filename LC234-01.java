// time: O(n)
// space: O(n)

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
        ListNode move = head;
        List<Integer> array = new ArrayList<Integer>();
        while (move != null) {
            array.add(move.val);
            move = move.next;
        }
        for (int i = 0; i < array.size() / 2; i++) {
            
            if (!array.get(i).equals(array.get(array.size() - i - 1))) {
                return false;
            }
        }
        return true;
    }
    
}
