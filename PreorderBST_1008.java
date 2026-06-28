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
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, 0, preorder.length-1);
    }

    private TreeNode build(int[] pre, int l, int r){
        if (l > r) return null;

        TreeNode root = new TreeNode(pre[l]);

        int split = l+1;

        while(split <= r && pre[split] < pre[l]){
            split++;
        }

        root.left = build(pre, l+1, split-1);
        root.right = build(pre, split, r);

        return root;
    }
}