class Solution {

    public int minimumPairRemoval(int[] nums) {

        List<Integer> list = new ArrayList<>();

        for (int x : nums)
            list.add(x);

        int ans = 0;

        while (!isSorted(list)) {

            int idx = 0;
            int minSum = list.get(0) + list.get(1);

            for (int i = 1; i < list.size() - 1; i++) {

                int sum = list.get(i) + list.get(i + 1);

                if (sum < minSum) {
                    minSum = sum;
                    idx = i;
                }
            }

            list.set(idx, minSum);
            list.remove(idx + 1);

            ans++;
        }

        return ans;
    }

    private boolean isSorted(List<Integer> list) {

        for (int i = 1; i < list.size(); i++) {

            if (list.get(i) < list.get(i - 1))
                return false;
        }

        return true;
    }
}