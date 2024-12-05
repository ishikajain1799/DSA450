class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    private ListNode findMiddleNode(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while(fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            if(fastPtr != null) {
                slowPtr = slowPtr.next;
            }
        }
        return slowPtr;
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

    private boolean isPalindromeRecursiveHelper(ListNode current, ListNode[] headArr) {
        if(current == null) {
            return true;
        }
        boolean flag = isPalindromeRecursiveHelper(current.next, headArr);
        if(!flag) return false;
        ListNode head = headArr[0];
        headArr[0] = head.next;
        return head.val == current.val;
    }

    private boolean isPalindromeRecursive(ListNode head) {
        ListNode current = head;
        ListNode[] headArr = new ListNode[1];
        headArr[0] = head;
        return isPalindromeRecursiveHelper(current, headArr);
    }

    private boolean isPalindromeIterative(ListNode head) {
        // find the middle node
        ListNode lastNode = findMiddleNode(head);

        // reverse the second half list
        ListNode currentNode = lastNode.next;
        lastNode.next = null;
        ListNode reversedListHead = reverseList(currentNode);

        // compare the two lists
        while(head != null && reversedListHead != null) {
            if(head.val != reversedListHead.val) return false;
            head = head.next;
            reversedListHead = reversedListHead.next;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        return isPalindromeIterative(head);
    }
}