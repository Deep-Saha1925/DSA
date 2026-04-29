class Solution {
    public double largestSumOfAverages(int[] nums, int K) {
        int n = nums.length;

        // Prefix sum
        double[] prefix = new double[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        double[][] dp = new double[n][K + 1];

        // Base case: 1 group
        for (int i = 0; i < n; i++) {
            dp[i][1] = (prefix[n] - prefix[i]) / (n - i);
        }

        // Fill DP
        for (int k = 2; k <= K; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    double avg = (prefix[j + 1] - prefix[i]) / (j - i + 1);

                    if (j == n - 1) {
                        dp[i][k] = Math.max(dp[i][k], avg);
                    } else {
                        dp[i][k] = Math.max(dp[i][k],
                            avg + dp[j + 1][k - 1]);
                    }
                }
            }
        }

        return dp[0][K];
    }
}