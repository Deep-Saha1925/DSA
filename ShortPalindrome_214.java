class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;

        String rev = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + rev;

        int[] lps = buildLPS(combined);

        int palPrefixLen = lps[combined.length() - 1];

        String toAdd = s.substring(palPrefixLen);
        return new StringBuilder(toAdd).reverse().toString() + s;
    }

    private int[] buildLPS(String str) {
        int n = str.length();
        int[] lps = new int[n];

        int len = 0; // length of previous longest prefix suffix
        int i = 1;

        while (i < n) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
