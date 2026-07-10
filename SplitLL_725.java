class Solution {

    public ListNode[] splitListToParts(ListNode head, int k) {

        ListNode[] ans = new ListNode[k];

        int length = 0;
        ListNode curr = head;

        while (curr != null) {
            length++;
            curr = curr.next;
        }

        int size = length / k;
        int extra = length % k;

        curr = head;

        for (int i = 0; i < k; i++) {

            if (curr == null) {
                ans[i] = null;
                continue;
            }

            ans[i] = curr;

            int currSize = size + (extra > 0 ? 1 : 0);

            if (extra > 0)
                extra--;

            for (int j = 1; j < currSize; j++)
                curr = curr.next;

            ListNode next = curr.next;
            curr.next = null;
            curr = next;
        }

        return ans;
    }
}