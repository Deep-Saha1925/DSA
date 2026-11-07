import java.util.*;

class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();

        for (String s : operations) {
            if (s.equals("C")) {
                st.pop();
            }
            else if (s.equals("D")) {
                st.push(st.peek() * 2);
            }
            else if (s.equals("+")) {
                int a = st.pop();
                int b = st.peek();

                st.push(a);
                st.push(a + b);
            }
            else {
                st.push(Integer.parseInt(s));
            }
        }

        int sum = 0;

        for (int n : st) {
            sum += n;
        }

        return sum;
    }
}