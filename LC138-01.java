// time: O(n)
// space: O(n)

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
        Node copyHead = new Node(head.val);
        Node copyMove = copyHead;
        Node move = head;
        HashMap <Node, Node> map = new HashMap<Node, Node>();
        map.put(move, copyMove);
        while (move.next != null) {
            copyMove.val = move.val;
            copyMove.next = new Node(move.next.val);
            map.put(move.next, copyMove.next);
            move = move.next;
            copyMove = copyMove.next;
        }
        
        move = head;
        copyMove = copyHead;
        while (move != null) {
            copyMove.random = map.get(move.random);
            move = move.next;
            copyMove = copyMove.next;
        }
        return copyHead;
    }
}
