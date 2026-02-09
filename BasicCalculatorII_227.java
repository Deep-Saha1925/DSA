class Solution {
    public int calculate(String s) {
        int result = 0;
        int lastNumber = 0;
        int currentNumber = 0;
        char operation = '+';

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Build number
            if (Character.isDigit(ch)) {
                currentNumber = currentNumber * 10 + (ch - '0');
            }

            // If operator or end of string
            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {

                if (operation == '+') {
                    result += lastNumber;
                    lastNumber = currentNumber;
                } else if (operation == '-') {
                    result += lastNumber;
                    lastNumber = -currentNumber;
                } else if (operation == '*') {
                    lastNumber = lastNumber * currentNumber;
                } else if (operation == '/') {
                    lastNumber = lastNumber / currentNumber; // truncates toward zero
                }

                operation = ch;
                currentNumber = 0;
            }
        }

        return result + lastNumber;
    }
}