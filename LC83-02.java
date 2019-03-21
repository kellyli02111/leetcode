if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode move = head;
        while (move.next != null) {
            if (move.next.val == move.val) {
                move.next = move.next.next;
            }
            else {
                move = move.next;
            }
        }
        return dummy.next;
