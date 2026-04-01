class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;

        Boolean[][] memo = new Boolean[s1.length()][s2.length()];
        return check(s1, s2, s3, 0, 0, 0, memo);
    }

    private boolean check(String s1, String s2, String s3,
                          int i, int j, int k, Boolean[][] memo) {

        if (k == s3.length()) return true;

        // Already solved
        if (i < s1.length() && j < s2.length() && memo[i][j] != null) {
            return memo[i][j];
        }

        boolean takeS1 = false;
        boolean takeS2 = false;

        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            takeS1 = check(s1, s2, s3, i + 1, j, k + 1, memo);
        }

        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            takeS2 = check(s1, s2, s3, i, j + 1, k + 1, memo);
        }

        if (i < s1.length() && j < s2.length()) {
            memo[i][j] = takeS1 || takeS2;
        }

        return takeS1 || takeS2;
    }
}