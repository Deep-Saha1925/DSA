class Solution {
    int s = 0;
    public int subsetXORSum(int[] nums) {
        dfs(nums, 0, 0);
        return s;
    }

    private void dfs(int[] nums, int idx, int xor){
        if(idx == nums.length){
            s += xor;
            return;
        }
        // Taking curr elem
        dfs(nums, idx+1, xor^nums[idx]);

        // Not taking curr elem
        dfs(nums, idx+1, xor);
    }
}