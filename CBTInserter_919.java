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
class CBTInserter {

    Queue<TreeNode> queue;

    public CBTInserter(TreeNode root) {
        queue = new LinkedList<>();

        Queue<TreeNode> temp = new LinkedList<>();
        temp.add(root);

        while (!temp.isEmpty()) {
            TreeNode node = temp.poll();

            if (node.left != null)
                temp.add(node.left);

            if (node.right != null)
                temp.add(node.right);

            // Node having an empty child
            if (node.left == null || node.right == null) {
                queue.add(node);
            }
        }
    }
    
    public int insert(int val) {
        
    }
    
    public TreeNode get_root() {
        
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */