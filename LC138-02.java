// time: O(n)
// space: O(1)

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node move = head;
        Node headCopy = head;
        Node moveCopy = new Node(move.val);
        while (move != null) {
            moveCopy = new Node(move.val);
            moveCopy.next = move.next;
            move.next = moveCopy;
            move = move.next.next;
        }
        move = head;
        headCopy = head.next;
        moveCopy = headCopy;
        while (moveCopy != null) {
            if (move.random != null) {
                moveCopy.random = move.random.next;
            }
            else {
                moveCopy.random = move.random;
            }
            move = move.next.next;
            moveCopy = moveCopy.next;
            if (moveCopy == null) {
                break;
            }
            if (moveCopy.next != null) {
                moveCopy = moveCopy.next;
            }
        }
        
        move = head;
        moveCopy = headCopy;
        while (move != null && move.next != null) {
            move.next = moveCopy.next;
            move = move.next;
            if (move != null) {
                moveCopy.next = move.next;
            }
            
            moveCopy = moveCopy.next;
        }

        return headCopy;
    }
    public void printLinkedList(Node head) {
        if (head == null)
            System.out.println("NULL");
        Node current = head;
        while (current != null)
        {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("NULL");
    }
}
