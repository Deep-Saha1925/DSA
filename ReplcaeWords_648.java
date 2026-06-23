class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    TrieNode root = new TrieNode();

    public String replaceWords(List<String> dictionary, String sentence) {
        
        for(String word : dictionary){
            insert(word);
        }

        StringBuilder ans = new StringBuilder();

        String[] words = sentence.split(" ");

        for(String word: words){
            String replacement = findRoot(word);

            ans.append(replacement).append(" ");
        }

        return ans.toString().trim();
    }

    private void insert(String word){
        TrieNode node = root;

        for(char ch : word.toCharArray()){
            int idx = ch - 'a';

            if(node.children[idx] == null){
                node.children[idx] = new TrieNode();
            }

            node = node.children[idx];
        }

        node.isEnd = true;
    }

    private String findRoot(String word){
        TrieNode node = root;

        StringBuilder prefix = new StringBuilder();

        for(char ch : word.toCharArray()){
            int idx = ch - 'a';

            if(node.children[idx] == null)
                return word;

            prefix.append(ch);
            node = node.children[idx];

            if(node.isEnd)
                return prefix.toString();
        }

        return word;
    }
}