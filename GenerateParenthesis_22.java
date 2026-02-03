import java.util.*;

class Solution {
    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack("", 0, 0, n);
        return result;
    }

    void backtrack(String curr, int open, int close, int n) {

        if (curr.length() == 2 * n) {
            result.add(curr);
            return;
        }

        if (open < n) {
            backtrack(curr + "(", open + 1, close, n);
        }

        if (close < open) {
            backtrack(curr + ")", open, close + 1, n);
        }
    }
}