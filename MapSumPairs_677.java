class MapSum {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int value;
    }

    TrieNode root;

    public MapSum() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {

        TrieNode node = root;

        for(char ch : key.toCharArray()) {

            int idx = ch - 'a';

            if(node.children[idx] == null)
                node.children[idx] = new TrieNode();

            node = node.children[idx];
        }

        node.value = val;
    }

    public int sum(String prefix) {

        TrieNode node = root;

        for(char ch : prefix.toCharArray()) {

            int idx = ch - 'a';

            if(node.children[idx] == null)
                return 0;

            node = node.children[idx];
        }

        return dfs(node);
    }

    private int dfs(TrieNode node) {

        if(node == null)
            return 0;

        int total = node.value;

        for(TrieNode child : node.children) {
            total += dfs(child);
        }

        return total;
    }
}