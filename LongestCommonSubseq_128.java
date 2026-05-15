import java.util.HashSet;

class LongestCommonSubseq_128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int n: nums){
            set.add(n);
        }

        int longest = 0;

        for(int n: set){
            if(!set.contains(n-1)){
                int curr = n;
                int count = 1;

                while(set.contains(curr+1)){
                    curr++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
}