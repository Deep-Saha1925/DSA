import java.util.Stack;

public class Pattern_456 {

    public static void main(String args[]){
        find132pattern(new int[]{1,2,3,4});
    }

    public static boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int third = Integer.MIN_VALUE; // this is nums[k]

        // Traverse from right to left
        for (int i = nums.length - 1; i >= 0; i--) {
                
            if (nums[i] < third) return true;

            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                third = stack.pop();
            }

            stack.push(nums[i]);
        }
        
        return false;
    }
}