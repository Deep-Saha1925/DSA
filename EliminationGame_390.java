class Solution {
    public int lastRemaining(int n) {
        int h = 1, s = 1, r = n;
        boolean left = true;

        while(r > 1){
            if(left || r%2 == 1){
                h += s;
            }

            r /= 2;
            s *= 2;
            left = !left;
        }

        return h;
    }
}