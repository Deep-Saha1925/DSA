/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;

class Codec {

    TreeNode root;

    // -------- SERIALIZE --------
    public String serialize(TreeNode root) {

        List<String> list = new ArrayList<>();
        preorder(root, list);

        return String.join(",", list);
    }

    private void preorder(TreeNode node, List<String> list) {

        if (node == null) return;

        list.add(String.valueOf(node.val));
        preorder(node.left, list);
        preorder(node.right, list);
    }

    // -------- INSERT (YOUR METHOD) --------
    public void insert(int key) {
        root = _insert(root, key);
    }

    private TreeNode _insert(TreeNode node, int key) {

        if (node == null) {
            return new TreeNode(key);
        }

        if (key < node.val) {
            node.left = _insert(node.left, key);
        }
        else if (key > node.val) {
            node.right = _insert(node.right, key);
        }

        return node;
    }

    // -------- DESERIALIZE --------
    public TreeNode deserialize(String data) {

        if (data == null || data.length() == 0)
            return null;

        String[] values = data.split(",");

        root = null; // reset tree

        for (String val : values) {
            insert(Integer.parseInt(val));
        }

        return root;
    }
}
