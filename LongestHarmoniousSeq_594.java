import java.util.*;

class Solution {
    public int findLHS(int[] nums) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Step 1: Count frequency
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int maxLength = 0;
        
        // Step 2: Check pairs
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                int length = map.get(key) + map.get(key + 1);
                maxLength = Math.max(maxLength, length);
            }
        }
        
        return maxLength;
    }
}