class Solution {

    public int[] nextLargerNodes(ListNode head) {

        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int n = list.size();
        int[] ans = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() &&
                   list.get(i) > list.get(stack.peek())) {

                int index = stack.pop();
                ans[index] = list.get(i);
            }

            stack.push(i);
        }

        return ans;
    }
}