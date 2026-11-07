class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> s = new Stack<>();

        for(String s: ops){
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
    }
}