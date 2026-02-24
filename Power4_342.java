class Solution {
    public boolean isPowerOfFour(int n) {
        
        if (n <= 0) return false;   // negative or zero not allowed
        
        if (n == 1) return true;    // base case
        
        if (n % 4 != 0) return false;
        
        return isPowerOfFour(n / 4);
    }
}