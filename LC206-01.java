/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode current = head;
        ListNode move = head;
        while (current.next != null)
        {
            move = current.next;
            current.next = move.next;
            move.next = head;
            head = move;
            //printLinkedList(head);
        }
        
        return head;
    }
    public void printLinkedList(ListNode head) {
        if (head == null)
            System.out.println("NULL");
        ListNode current = head;
        while (current != null)
        {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("NULL");
    }
}
