class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for(String s: strs){
            int zeros = 0, ones = 0;

            for(char c: s.toCharArray()){
                if(c == '0'){
                    zeros++;
                }else{
                    ones++;
                }
            }
        }
    }
}