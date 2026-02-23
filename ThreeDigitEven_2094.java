import java.util.*;
class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> res = new TreeSet<>();
        boolean[] used = new boolean[digits.length];

        generate(digits, used, 0, 0, res);

        int[] arr = new int[res.size()];
        int i=0;
        for(int n: res){
            arr[i++] = n;
        }
        return arr;
    }

    private void generate(int[] digits, boolean[] used, int c, int num, Set<Integer> res){
        if(c == 3) {
            if(num % 2 == 0){
                res.add(num);
            }
            return;
        }

        for(int i=0; i<digits.length; i++){
            if(used[i]) continue;

            if(c == 0 && digits[i] == 0) continue;

            used[i] = true;

            generate(digits, used, c+1, num*10 + digits[i], res);

            used[i] = false;    //backtrack
        }
    }
}