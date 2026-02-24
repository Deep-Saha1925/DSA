import java.util.*;

class Solution {
    
    Set<Integer> result = new HashSet<>();
    
    public int totalNumbers(int[] digits) {
        boolean[] used = new boolean[digits.length];
        backtrack(digits, used, 0, 0);
        return result.size();
    }
    
    private void backtrack(int[] digits, boolean[] used, int current, int length) {
        
        // If 3 digits formed
        if (length == 3) {
            if (current % 2 == 0) {  // must be even
                result.add(current);
            }
            return;
        }
        
        for (int i = 0; i < digits.length; i++) {
            
            if (used[i]) continue;
            
            // No leading zero
            if (length == 0 && digits[i] == 0) continue;
            
            used[i] = true;
            
            backtrack(digits, used, current * 10 + digits[i], length + 1);
            
            used[i] = false;  // backtrack
        }
    }
}