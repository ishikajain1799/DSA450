class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
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
    public ListNode removeNodes(ListNode head) {
        if(head == null || head.next == null) return head;
        head = reverseList(head);
        ListNode current = head;
        int maxValue = current.val;
        while(current != null && current.next != null) {
            if(current.next.val < maxValue) {
                current.next = current.next.next;
            } else {
                maxValue = current.next.val;
                current = current.next;
            }
        }
        return reverseList(head);
    }
}