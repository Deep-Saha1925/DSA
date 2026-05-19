/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
import java.util.Stack;

class Solution {
    public SortList_148 addTwoNumbers(SortList_148 l1, SortList_148 l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        
        // Push values into stacks
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        int carry = 0;
        SortList_148 result = null;
        
        // Process stacks
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int sum = carry;
            
            if (!s1.isEmpty()) sum += s1.pop();
            if (!s2.isEmpty()) sum += s2.pop();
            
            // Create new node
            SortList_148 node = new SortList_148(sum % 10);
            node.next = result;
            result = node;
            
            carry = sum / 10;
        }
        
        return result;
    }
}