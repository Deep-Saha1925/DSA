/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;

class Solution {
    
    HashMap<Integer, Integer> map = new HashMap<>();

    public int[] findMode(TreeNode root) {
        traverse(root);

        int max = 0;
        for(int v : map.values()){
            max = Math.max(max, v);
        }

        List<Integer> list = new ArrayList<>();
        // Collect elements having max frequency
        for (int key : map.keySet()) {
            if (map.get(key) == max) {
                list.add(key);
            }
        }
        
        // Convert List to Array
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        
        return result;
    }
    
    public void traverse(TreeNode root) {
        if (root == null) return;
        
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        
        traverse(root.left);
        traverse(root.right);
    }
}