class WordDictionary {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {

        TrieNode node = root;

        for(char ch : word.toCharArray()) {

            int idx = ch - 'a';

            if(node.children[idx] == null)
                node.children[idx] = new TrieNode();

            node = node.children[idx];
        }

        node.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int pos, TrieNode node) {

        if(node == null)
            return false;

        if(pos == word.length())
            return node.isEnd;

        char ch = word.charAt(pos);

        if(ch == '.') {

            for(TrieNode child : node.children) {

                if(child != null &&
                   dfs(word, pos + 1, child))
                    return true;
            }

            return false;
        }

        return dfs(
            word,
            pos + 1,
            node.children[ch - 'a']
        );
    }
}