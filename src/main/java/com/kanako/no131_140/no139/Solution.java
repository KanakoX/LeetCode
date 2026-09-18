package com.kanako.no131_140.no139;

import java.util.List;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for (String word : wordDict) trie.insert(word);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            if (!dp[i]) continue;
            TrieNode node = trie.root;
            for (int j = i; j < s.length(); j++) {
                int idx = s.charAt(j) - 'a';
                if (node.children[idx] == null) break;
                node = node.children[idx];
                if (node.isWord) dp[j + 1] = true;
            }
        }
        return dp[s.length()];
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
    }

    class Trie {
        TrieNode root = new TrieNode();

        void insert(String word) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (cur.children[index] == null) {
                    cur.children[index] = new TrieNode();
                }
                cur = cur.children[index];
            }
            cur.isWord = true;
        }

        TrieNode find(String word) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (cur.children[index] == null) return null;
                cur = cur.children[index];
            }
            return cur;
        }

        boolean search(String word) {
            TrieNode node = find(word);
            return node != null && node.isWord;
        }

        boolean startsWith(String prefix) {
            return find(prefix) != null;
        }
    }
}
