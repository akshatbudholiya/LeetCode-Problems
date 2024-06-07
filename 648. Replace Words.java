class Solution {
     // TrieNode class definition
    static class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        public TrieNode() {
            children = new TrieNode[26]; // Assume only lowercase letters
            isEndOfWord = false;
        }
    }

    // Trie class definition
    static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Insert a word into the Trie
        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.isEndOfWord = true;
        }

        // Search for the shortest prefix of the word in the Trie
        public String searchShortestPrefix(String word) {
            TrieNode node = root;
            StringBuilder prefix = new StringBuilder();
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    break;
                }
                node = node.children[index];
                prefix.append(c);
                if (node.isEndOfWord) {
                    return prefix.toString();
                }
            }
            return word; // Return the original word if no prefix found
        }
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String root : dictionary) {
            trie.insert(root);
        }

        StringBuilder result = new StringBuilder();
        String[] words = sentence.split(" ");
        for (String word : words) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(trie.searchShortestPrefix(word));
        }
        return result.toString();
    }
}
