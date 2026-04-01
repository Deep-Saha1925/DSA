class Trie {

    class Node {
        Node[] children = new Node[26]; // a-z
        boolean isEnd = false;
    }

    private Node root;

    public Trie() {
        root = new Node();
    }

    // Insert word
    public void insert(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new Node();
            }
            curr = curr.children[index];
        }
        curr.isEnd = true;
    }

    // Search full word
    public boolean search(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) return false;
            curr = curr.children[index];
        }
        return curr.isEnd;
    }

    // Search prefix
    public boolean startsWith(String prefix) {
        Node curr = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) return false;
            curr = curr.children[index];
        }
        return true;
    }
}