import java.util.Arrays;
class Solution {

    private int f(String a, String b, int i, int j, int[][] dp){
        if(i < 0) return j+1;
        if(j < 0) return i+1;

        if(dp[i][j] != -1) return dp[i][j];

        if(a.charAt(i) == b.charAt(j))  return dp[i][j] = f(a, b, i-1, j-1, dp);

        return dp[i][j] =  1 + Math.min(
            f(a, b, i, j-1, dp),    // insert
            Math.min(
                f(a, b, i-1, j, dp), //remove
                f(a, b, i-1, j-1, dp)    //replace
            )
        );
    }

    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n][m];
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return f(word1, word2, n-1, m-1, dp);
    }
}