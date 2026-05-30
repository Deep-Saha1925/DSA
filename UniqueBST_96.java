class Solution {
    public int numTrees(int n){
        int[] dp = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=n; i++){
            for(int r=1; r<=i; r++){
                dp[i] += dp[r-1] * dp[i-r];
            }
        }

        return dp[n];
    }
}