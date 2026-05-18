class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;

        k = k%n;

        int ar[] = new int[n];

        for(int i=0; i<n; i++){
            ar[(i+k)%n] = nums[i];
        }

        for (int i = 0; i < n; i++) {

            nums[i] = ar[i];
        }
    }
}