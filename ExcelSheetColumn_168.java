class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--; // make it 0-based
            int rem = columnNumber % 26;
            char ch = (char) ('A' + rem);
            result.append(ch);
            columnNumber /= 26;
        }

        return result.reverse().toString();
    }
}