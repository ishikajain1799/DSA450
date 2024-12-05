class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head2 = list2;
        ListNode tail2 = null;
        while(list2 != null) {
            tail2 = list2;
            list2 = list2.next;
        }
        int count = 1;
        ListNode head1 = list1;
        while(count < a) {
            list1 = list1.next;
            count++;
        }
        ListNode remainingList1 = list1.next;
        while(count < b) {
            remainingList1 = remainingList1.next;
            count++;
        }
        list1.next = head2;
        tail2.next = remainingList1.next;
        return head1;
    }
}