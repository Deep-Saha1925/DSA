class Solution {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        ListNode prev = list1;

        // Move prev to node before index a
        for (int i = 0; i < a - 1; i++) {
            prev = prev.next;
        }

        ListNode next = prev;

        // Move next to node at index b
        for (int i = a - 1; i <= b; i++) {
            next = next.next;
        }

        // Connect prev to list2
        prev.next = list2;

        // Find tail of list2
        while (list2.next != null) {
            list2 = list2.next;
        }

        // Connect tail to next
        list2.next = next;

        return list1;
    }
}