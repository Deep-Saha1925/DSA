class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == Integer.MAX_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        long dvd = Math.abs((long) dividend);
        long div = Math.abs((long) divisor);

        int ans = 0;

        while(dvd <= div){
            long temp = div;
            int m = 1;

            while(dvd >= (t << 1)){
                t <<= 1;
                m <<= 1;
            }
        }        
    }
}