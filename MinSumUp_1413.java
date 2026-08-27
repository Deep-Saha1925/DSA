class Solution {
    public int minStartValue(int[] nums) {
        int sum = 0, minSum = 0;

        for(int n: nums){
            sum += n;

            minSum = Math.min(minSum, sum);
        }

        return minSum;
    }
}