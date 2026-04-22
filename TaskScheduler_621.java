import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int[] freq = new int[26];
        
        // count frequency
        for (char t : tasks) {
            freq[t - 'A']++;
        }
        
        Arrays.sort(freq);
        
        int maxFreq = freq[25]; // highest frequency
        
        int countMax = 1;
        for (int i = 24; i >= 0; i--) {
            if (freq[i] == maxFreq) {
                countMax++;
            } else {
                break;
            }
        }
        
        int partCount = maxFreq - 1;
        int partLength = n + 1;
        
        int result = partCount * partLength + countMax;
        
        return Math.max(tasks.length, result);
    }
}