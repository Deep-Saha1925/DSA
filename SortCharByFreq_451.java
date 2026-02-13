import java.util.*;
class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Step 2: Put characters into list
        List<Character> list = new ArrayList<>(map.keySet());

        // Sort list based on frequency (descending)
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));

        // Step 3: Build result
        StringBuilder sb = new StringBuilder();

        for (char c : list) {
            int freq = map.get(c);
            while (freq-- > 0) {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}