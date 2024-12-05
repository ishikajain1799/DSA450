class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    private int pairSumRecursiveHelper(ListNode current, ListNode[] headArr) {
        if(current == null) {
            return 0;
        }
        int ans = pairSumRecursiveHelper(current.next, headArr);
        int currentSum = current.val + headArr[0].val;
        headArr[0] = headArr[0].next;
        return Math.max(currentSum, ans);
    }

    private int pairSumRecursive(ListNode head) {
        ListNode current = head;
        ListNode[] headArr = new ListNode[1];
        headArr[0] = head;
        return pairSumRecursiveHelper(current, headArr);
    }

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

    private int pairSumIterative(ListNode head) {
        // Find the middle node
        ListNode middleNode = findMiddleNode(head);
        ListNode reversedHead = middleNode.next;
        middleNode.next = null;

        // Reverse the second half
        reversedHead = reverseList(reversedHead);

        // Find sum
        int maxSum = 0;
        while(head != null) {
            int currentSum = head.val + reversedHead.val;
            head = head.next;
            reversedHead = reversedHead.next;
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public int pairSum(ListNode head) {
        return pairSumIterative(head);
    }
}