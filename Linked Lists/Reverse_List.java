
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution { 
    private ListNode reverseListRecursive(ListNode current, ListNode[] headArr) {
        if(current == null || current.next == null) {
            headArr[0] = current;
            return current;
        }
        ListNode node = reverseListRecursive(current.next, headArr);
        node.next = current;
        current.next = null;
        return current;
    }

    private ListNode reverseListIterative(ListNode head) {
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

    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode[] headArr = new ListNode[1];
        headArr[0]= head;
        current = reverseListRecursive(current, headArr);
        return headArr[0];
    }
}