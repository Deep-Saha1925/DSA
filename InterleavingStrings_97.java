class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        
        return check(s1, s2, s3, 0, 0, 0);
    }

    private boolean check(String s1, String s2, String s3, int i, int j, int k) {
        if (k == s3.length()) return true;

        boolean takeS1 = false;
        boolean takeS2 = false;

        // Take from s1 if matches
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            takeS1 = check(s1, s2, s3, i + 1, j, k + 1);
        }

        // Take from s2 if matches
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            takeS2 = check(s1, s2, s3, i, j + 1, k + 1);
        }

        return takeS1 || takeS2;
    }
}