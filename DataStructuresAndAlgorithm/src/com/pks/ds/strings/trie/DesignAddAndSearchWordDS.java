package com.pks.ds.strings.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/design-add-and-search-words-data-structure/
 */
public class DesignAddAndSearchWordDS {


    static class WordDictionary {
        TrieNode trie;

        public WordDictionary() {
            trie = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode node = trie;
            for (char c : word.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new TrieNode());
                }
                node = node.children.get(c);
            }
        }

        public boolean search(String word, TrieNode node) {
            for (int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);
                if (!node.children.containsKey(ch)) {
                    // if the current character is '.'
                    // check all possible nodes at this level
                    if (ch == '.') {
                        for (char x : node.children.keySet()) {
                            TrieNode child = node.children.get(x);
                            if (search(word.substring(i + 1), child)) {
                                return true;
                            }
                        }
                    }
                    // if no nodes lead to answer
                    // or the current character != '.'
                    return false;
                } else {
                    // if the character is found
                    // go down to the next level in trie
                    node = node.children.get(ch);
                }
            }
            return node.word;
        }
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean word = false;

    }

}
