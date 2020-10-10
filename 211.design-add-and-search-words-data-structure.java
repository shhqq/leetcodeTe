/*
 * @lc app=leetcode id=211 lang=java
 *
 * [211] Design Add and Search Words Data Structure
 */

// @lc code=start
class WordDictionary {
    // fields字段
    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word, 0, root);
    }

    /**
     * 一个帮助函数，使用递归匹配字符串
     */
    private boolean search(String word, int i, TrieNode node) {
        char ch = word.charAt(i);
        // 如果是最后一个字符了，这时要判断isEnd
        if (i == word.length()-1) {
            if(ch == '.') {
                for (int j = 0; j < 26; j++) {
                    char next = (char)('a' + j);
                    if (node.containsKey(next)) {
                        if (node.get(next).isEnd()) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
                return node.containsKey(ch) && node.get(ch).isEnd();
            }
        }

        
        if (ch == '.') {
            for (int j = 0; j < 26; j++) {
                char next = (char)('a' + j);
                if (node.containsKey(next)) {
                    if (search(word, i + 1, node.get(next))) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            if (node.containsKey(ch)) {
                return search(word, i+1, node.get(ch));
            } else {
                return false;
            }
        }
    }
}

class TrieNode{
    // 字段 fields
    private TrieNode[] links;
    private final int N = 26;
    private boolean isEnd;

    public TrieNode() {
        this.links = new TrieNode[N];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end

