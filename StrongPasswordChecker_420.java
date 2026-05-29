class Solution {
    public int strongPasswordChecker(String s) {

        int lower = 1, upper = 1, digit = 1;

        for(char c : s.toCharArray()) {
            if(Character.isLowerCase(c)) lower = 0;
            else if(Character.isUpperCase(c)) upper = 0;
            else if(Character.isDigit(c)) digit = 0;
        }

        int missing = lower + upper + digit;

        int replace = 0;

        for(int i = 2; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i-1) &&
               s.charAt(i) == s.charAt(i-2)) {

                replace++;
                i += 2; // skip next two chars
            }
        }

        if(s.length() < 6) {
            return Math.max(missing, 6 - s.length());
        }

        if(s.length() <= 20) {
            return Math.max(missing, replace);
        }

        return (s.length() - 20) +
               Math.max(missing, replace);
    }
}