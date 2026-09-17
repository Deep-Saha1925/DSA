import java.util.*;

class CBTInserter {

    TreeNode root;
    Queue<TreeNode> queue = new LinkedList<>();

    public CBTInserter(TreeNode root) {

        this.root = root;

        Queue<TreeNode> temp = new LinkedList<>();
        temp.add(root);

        while (!temp.isEmpty()) {

            TreeNode node = temp.poll();

            if (node.left != null)
                temp.add(node.left);

            if (node.right != null)
                temp.add(node.right);

            if (node.left == null || node.right == null) {
                queue.add(node);
            }
        }
    }

    public int insert(int val) {

        TreeNode parent = queue.peek();

        TreeNode newNode = new TreeNode(val);

        if (parent.left == null) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
            queue.poll();
        }

        queue.add(newNode);

        return parent.val;
    }

    public TreeNode get_root() {
        return root;
    }
}