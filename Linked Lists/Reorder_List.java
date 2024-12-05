class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    private ListNode findMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode current = head;
        while(current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    private ListNode alternateMergingLists(ListNode head1, ListNode head2) {
        ListNode head = head1;
        ListNode current = head1;
        head1 = head1.next;
        while(head1 != null && head2 != null) {
            current.next = head2;
            head2 = head2.next;
            current = current.next;
            current.next = head1;
            head1 = head1.next;
            current = current.next;
        }
        while(head1 != null) {
            current.next = head1;
            head1 = head1.next;
            current = current.next;
        }
        while(head2 != null) {
            current.next = head2;
            head2 = head2.next;
            current = current.next;
        }
        return head;
    }

    public void reorderList(ListNode head) {
        // Find middle node 
        ListNode middleNode = findMiddleNode(head);
    
        // Reverse second half of the list
        ListNode head2 = middleNode.next;
        middleNode.next = null;
        head2 = reverseList(head2);

        // Alternately merge the list
        head = alternateMergingLists(head, head2);
    }
}
