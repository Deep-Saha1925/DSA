class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;

        int[] masks = new int[n];

        for(int i=0; i<n; i++){
            for(char ch: words[i].toCharArray()){
                masks[i] |= 1 << (ch - 'a');
            }
        }

        int ans = 0;

        
    }
}