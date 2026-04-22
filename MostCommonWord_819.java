import java.util.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        paragraph = paragraph.toLowerCase().replaceAll("[^a-z ]", " ");
        
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        
        //count frequency
        Map<String, Integer> map = new HashMap<>();
        
        String[] words = paragraph.split("\\s+");
        
        for (String word : words) {
            if (!bannedSet.contains(word) && word.length() > 0) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        
        //find max frequency word
        String result = "";
        int max = 0;
        
        for (String word : map.keySet()) {
            if (map.get(word) > max) {
                max = map.get(word);
                result = word;
            }
        }
        
        return result;
    }
}