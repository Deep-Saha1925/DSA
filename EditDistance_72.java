class Solution {

    private int f(String a, String b, int i, int j){
        if(i < 0) return j+1;
        if(j < 0) return i+1;

        if(a.charAt(i) == b.charAt(j))  return f(a, b, i-1, j-1);

        return 1 + Math.min(
            f(a, b, i, j-1),    // insert
            Math.min(
                f(a, b, i-1, j), //remove
                f(a, b, i-1, j-1)    //replace
            )
        );
    }

    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        return f(word1, word2, n, m);
    }
}