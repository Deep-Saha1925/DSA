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
class Solution {

    private Map<String, Integer> map = new HashMap<>();
    private List<TreeNode> ans = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        
        dfs(root);
        return ans;
    }

    private String dfs(TreeNode root){
        if(root == null) return "#";

        String left = dfs(root.left);
        String right = dfs(root.right);

        String serial = root.val + "," + left + "," + right;

        int freq = map.getOrDefault(serial, 0);

        if(freq == 1){
            ans.add(root);
        }

        map.put(serial, freq+1);

        return serial;
    }
}