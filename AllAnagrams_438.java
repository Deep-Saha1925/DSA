import java.util.*;

class Solution {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();

        if (s.length() < p.length())
            return ans;

        int[] pCount = new int[26];
        int[] window = new int[26];

        // Frequency of p
        for (char ch : p.toCharArray())
            pCount[ch - 'a']++;

        // First window
        for (int i = 0; i < p.length(); i++)
            window[s.charAt(i) - 'a']++;

        if (Arrays.equals(pCount, window))
            ans.add(0);

        // Slide the window
        for (int i = p.length(); i < s.length(); i++) {

            // Remove left character
            window[s.charAt(i - p.length()) - 'a']--;

            // Add right character
            window[s.charAt(i) - 'a']++;

            if (Arrays.equals(pCount, window))
                ans.add(i - p.length() + 1);
        }

        return ans;
    }
}