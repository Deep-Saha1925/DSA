class Solution {

    public char kthCharacter(int k) {
        return solve(k);
    }

    private char solve(int k) {
        if (k == 1) return 'a';

        int len = 1;

        // Find smallest power of 2 >= k
        while (len < k) {
            len *= 2;
        }

        int half = len / 2;

        if (k <= half) {
            return solve(k);
        } else {
            char prev = solve(k - half);
            
            // shift character by +1
            return (char)(prev + 1);
        }
    }
}