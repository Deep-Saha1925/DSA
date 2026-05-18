class Solution {
    public int countPrimes(int n) {
        if(n <= 2)  return 0;

        boolean[] prime = new boolean[n];

        for(int i=2; i<n; i++){
            prime[i] = true;
        }

        for(int i=2; i*i<n; i++){
            if(prime[i]){
                //MArk multiples as false
                for(int j=i*i; j<n; j+=i){
                    prime[j] = false;
                }
            }
        }

        int c = 0;
        for (int i = 2; i < n; i++) {

            if (prime[i]) {
                c++;
            }
        }

        return c;
    }
}