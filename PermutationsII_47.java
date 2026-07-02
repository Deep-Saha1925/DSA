class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);

        boolean[] visited = new boolean[nums.length];

        backtrack(nums, new ArrayList<>(), visited);

        return ans;
    }

    private void backtrack(int[] nums,
                           List<Integer> temp,
                           boolean[] visited) {

        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (visited[i])
                continue;

            if (i > 0 &&
                nums[i] == nums[i - 1] &&
                !visited[i - 1])
                continue;

            visited[i] = true;
            temp.add(nums[i]);

            backtrack(nums, temp, visited);

            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }
}