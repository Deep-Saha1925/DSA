class Solution {
    public int findNthDigit(int n) {

        long digitLength = 1;
        long count = 9;
        long start = 1;

        while (n > digitLength * count) {
            n -= digitLength * count;
            digitLength++;
            count *= 10;
            start *= 10;
        }

        // Find the actual number
        start += (n - 1) / digitLength;

        // Convert number to string
        String s = Long.toString(start);

        // Return the required digit
        return s.charAt((int)((n - 1) % digitLength)) - '0';
    }
}