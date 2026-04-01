class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();

        // Try all possible first and second numbers
        for (int i = 1; i <= n / 2; i++) {
            for (int j = 1; Math.max(i, j) <= n - i - j; j++) {

                String s1 = num.substring(0, i);
                String s2 = num.substring(i, i + j);

                // Skip leading zero cases
                if ((s1.length() > 1 && s1.charAt(0) == '0') ||
                    (s2.length() > 1 && s2.charAt(0) == '0')) {
                    continue;
                }

                if (check(num, s1, s2, i + j)) return true;
            }
        }
        return false;
    }

    private boolean check(String num, String s1, String s2, int start) {
        if (start == num.length()) return true;

        long n1 = Long.parseLong(s1);
        long n2 = Long.parseLong(s2);
        long sum = n1 + n2;

        String s3 = String.valueOf(sum);

        // Check if next part matches
        if (!num.startsWith(s3, start)) return false;

        return check(num, s2, s3, start + s3.length());
    }
}