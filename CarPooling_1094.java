class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] stops = new int[1001];
        
        // mark changes
        for (int[] trip : trips) {
            int passengers = trip[0];
            int from = trip[1];
            int to = trip[2];
            
            stops[from] += passengers;  // pick up
            stops[to] -= passengers;    // drop
        }
        
        int current = 0;
        
        // check capacity
        for (int i = 0; i < 1001; i++) {
            current += stops[i];
            if (current > capacity) {
                return false;
            }
        }
        
        return true;
    }
}