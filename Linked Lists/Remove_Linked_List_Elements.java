class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode current = head, prev = null;
        head = null;
        while(current != null) {
            if(current.val != val) {
                if(prev == null) {
                    head = current;
                    prev = current;
                } else {
                    prev.next = current;
                    prev = current;
                }
            }
            current = current.next;
        }
        if(prev != null) prev.next = null;
        return head;
    }
}