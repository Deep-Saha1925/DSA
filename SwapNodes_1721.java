class Solution {

    public ListNode swapNodes(ListNode head, int k) {

        ListNode first = head;

        // Move to k-th node from start
        for (int i = 1; i < k; i++) {
            first = first.next;
        }

        ListNode fast = first;
        ListNode second = head;

        // Find k-th node from end
        while (fast.next != null) {
            fast = fast.next;
            second = second.next;
        }

        // Swap values
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return head;
    }
}