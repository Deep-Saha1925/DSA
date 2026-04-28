import java.util.HashMap;
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int s=0, maxLen = 0;
        map.put(0, -1);

        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1){
                s += 1;
            }else{
                s -= 1;
            }

            if(map.containsKey(s)){
                int l = i - map.get(s);
                maxLen = Math.max(l, maxLen);
            }else{
                map.put(s, i);
            }
        }

        return maxLen;
    }
}