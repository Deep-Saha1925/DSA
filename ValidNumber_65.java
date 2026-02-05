class Solution {
    public boolean isNumber(String s) {

        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenE = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Digit
            if (c >= '0' && c <= '9') {
                seenDigit = true;
            }

            // Sign
            else if (c == '+' || c == '-') {
                // Sign is valid only at start or after e/E
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            }

            // Dot
            else if (c == '.') {
                // Dot can't appear twice or after e
                if (seenDot || seenE) {
                    return false;
                }
                seenDot = true;
            }

            // Exponent
            else if (c == 'e' || c == 'E') {
                // e can't appear twice and must follow a digit
                if (seenE || !seenDigit) {
                    return false;
                }
                seenE = true;
                seenDigit = false; // reset → need digit after e
            }

            // Anything else
            else {
                return false;
            }
        }

        // Must end with a digit
        return seenDigit;
    }
}