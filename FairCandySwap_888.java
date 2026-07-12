class Solution {

    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {

        int sumA = 0;
        int sumB = 0;

        for (int x : aliceSizes)
            sumA += x;

        for (int x : bobSizes)
            sumB += x;

        int diff = (sumB - sumA) / 2;

        Set<Integer> set = new HashSet<>();

        for (int x : bobSizes)
            set.add(x);

        for (int x : aliceSizes) {

            if (set.contains(x + diff))
                return new int[]{x, x + diff};
        }

        return new int[]{};
    }
}