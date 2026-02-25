class Solution {
    public int longestPalindrome(String s) {
        
        int[] count = new int[128];  // ASCII
        
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        
        int length = 0;
        boolean hasOdd = false;
        
        for (int c : count) {
            
            length += (c / 2) * 2;  // add even part
            
            if (c % 2 == 1) {
                hasOdd = true;  // check if odd exists
            }
        }
        
        if (hasOdd) {
            length += 1;
        }
        
        return length;
    }
}