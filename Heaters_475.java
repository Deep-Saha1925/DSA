import java.util.*;

class Solution {
    public int findRadius(int[] houses, int[] heaters) {

        Arrays.sort(houses);
        Arrays.sort(heaters);

        int ans = 0;

        for (int house : houses) {

            int idx = Arrays.binarySearch(heaters, house);

            if (idx >= 0) {
                continue; 
            }

            idx = -idx - 1;

            int leftDist = (idx == 0)
                ? Integer.MAX_VALUE
                : house - heaters[idx - 1];

            int rightDist = (idx == heaters.length)
                ? Integer.MAX_VALUE
                : heaters[idx] - house;

            ans = Math.max(ans, Math.min(leftDist, rightDist));
        }

        return ans;
    }
}