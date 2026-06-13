import java.util..*;
class Solution {

    HashMap<Integer, List<Integer>> map;
    Random rand;

    public Solution(int[] nums) {
        map = new HashMap<>();
        rand = new Random();

        for(int i=0; i<nums.length; i++){
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        List<Integer> list = map.get(target);
        int idx = rand.nextInt(list.size());
        return list.get(idx);
    }
}
