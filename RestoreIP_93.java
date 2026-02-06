import java.util.*;

class Solution {

    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backtrack(s, 0, 0, "");
        return result;
    }

    void backtrack(String s, int index, int parts, String current) {

        // If 4 parts are used
        if (parts == 4) {
            // If all characters are used
            if (index == s.length()) {
                result.add(current.substring(0, current.length() - 1));
            }
            return;
        }

        // Try 1 to 3 digits
        for (int len = 1; len <= 3; len++) {

            if (index + len > s.length())
                return;

            String part = s.substring(index, index + len);

            if (isValid(part)) {
                backtrack(s, index + len, parts + 1, current + part + ".");
            }
        }
    }

    boolean isValid(String part) {

        // Leading zero check
        if (part.length() > 1 && part.charAt(0) == '0')
            return false;

        int num = Integer.parseInt(part);
        return num >= 0 && num <= 255;
    }
}