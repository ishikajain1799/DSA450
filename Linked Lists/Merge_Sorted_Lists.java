
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    private ListNode mergeTwoListsIterative(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode lastNode = null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                if(lastNode == null) {
                    head = l1;
                    lastNode = l1;
                } else {
                    lastNode.next = l1;
                    lastNode = l1;
                }
                l1 = l1.next;
            } else {
                if(lastNode == null) {
                    head = l2;
                    lastNode = l2;
                } else {
                    lastNode.next = l2;
                    lastNode = l2;
                }
                l2 = l2.next;
            }
        }
        while(l1 != null) {
            lastNode.next = l1;
            lastNode = l1;
            l1 = l1.next;
        }
        while(l2 != null) {
            lastNode.next = l2;
            lastNode = l2;
            l2 = l2.next;
        }
        return head;
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        return mergeTwoListsIterative(list1, list2);
    }
}